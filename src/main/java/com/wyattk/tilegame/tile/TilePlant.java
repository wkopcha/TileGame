package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.util.FireState;
import com.wyattk.tilegame.util.GameRandom;
import com.wyattk.tilegame.util.Position;
import com.wyattk.tilegame.world.World;

public abstract class TilePlant extends TileFlammable{
    protected static final float CHANCE_TO_REGROW = 0.00002f;
    protected static final float CHANCE_TO_CONVERT = 0.2f;

    public TilePlant(Position position){
        super(position);
    }

    protected void regrow() {
        World world = getPosition().getWorld();
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                if (!(x == 1 && y == 1) && spreadPlantLife(getPosition().getX() - 1 + x, getPosition().getY() - 1 + y, world)) {
                    if(GameRandom.coinFlip(CHANCE_TO_CONVERT))
                        world.putTile(
                                Registry.getTileInstance(world.getTile(getPosition().getX() - 1 + x, getPosition().getY() - 1 + y).getId())));
                    setFireState(FireState.NONE);
                    setVariant("");
                    return;
                }
    }

    protected boolean spreadPlantLife(int x, int y, World world){
        return world.getTile(x, y) instanceof TilePlant
                &&
                world.getTile(x, y).getFireState() == FireState.NONE
                &&
                GameRandom.coinFlip(CHANCE_TO_REGROW);
    }



    @Override
    public void tick(){
        super.tick();
        if(getFireState() == FireState.BURNT)
            regrow();
    }
}
