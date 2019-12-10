package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.util.FireState;
import com.wyattk.tilegame.util.GameRandom;
import com.wyattk.tilegame.util.Position;
import com.wyattk.tilegame.world.World;

public abstract class TileFlammable extends Tile{

    protected static final int MIN_BURN_TIME_REQUIRED = 180;
    protected static final float CHANCE_TO_BURN = 0.007f;

    public TileFlammable(Position position){
        super(position);
    }

    /**
     * Ticks fire for the tile
     */
    protected void tickFire(){
        if(getFireState() != FireState.BURNT) {
            if (getBurnTime() < getMaxBurnTime())
                setBurnTime(getBurnTime() + 1);
            else {
                setFireState(getFireState().tick());
                if (getNextState().getFireState() == FireState.BURNT){
                    setVariant("burnt");
                }
            }
        }
    }

    /**
     * Potentially spreads fire to this tile
     */
    protected void spreadFire(){
        World worldIn = getPosition().getWorld();
        if(spreadFireFromTile(getPosition().getX() + 1, getPosition().getY(), worldIn))
            setOnFire();
        else if(spreadFireFromTile(getPosition().getX() - 1, getPosition().getY(), worldIn))
            setOnFire();
        else if(spreadFireFromTile(getPosition().getX(), getPosition().getY() + 1, worldIn))
            setOnFire();
        else if(spreadFireFromTile(getPosition().getX(), getPosition().getY() - 1, worldIn))
            setOnFire();
    }

    /**
     * @param x is the x coordinate of the tile
     * @param y is the y coordinate of the tile
     * @param world is the world the tile is in
     * @return whether fire should spread from this tile
     */
    protected boolean spreadFireFromTile(int x, int y, World world){
        return world.getTile(x, y).getFireState() == FireState.BURNING
                &&
                world.getTile(x, y).getBurnTime() >= MIN_BURN_TIME_REQUIRED
                &&
                GameRandom.coinFlip(CHANCE_TO_BURN);
    }



    @Override
    public void setOnFire(){
        if(getFireState() != FireState.BURNT){
            setBurnTime(0);
            setFireState(FireState.BURNING);
            setVariant("burning");
        }
    }

    @Override
    public void tick(){
        super.tick();
        if(getFireState() == FireState.BURNING)
            tickFire();
        if(getFireState() == FireState.NONE)
            spreadFire();
    }
}
