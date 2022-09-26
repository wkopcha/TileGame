package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.util.FireState;
import com.wyattk.tilegame.util.Position;
import com.wyattk.tilegame.util.TileVoter;

public abstract class Tile extends TileBase{

    private TileBuffer nextState;
    private TileVoter tileVoter;

    private static int[] DEFAULT_LEVELS = new int[]{0};

    /**
     * Creates a new tile
     * @param position is the position of the tile
     */
    public Tile(Position position){
        super(position);
        nextState = new TileBuffer(position);
        tileVoter = new TileVoter();
    }

    //TILE SPECIFIC

    /**
     * Changes the next state of the tile
     */
    public void tick(){}

    /**
     * Applies changes from the next state to the current state
     */
    public void apply(){
        super.setId(nextState.getId());
        super.setVariant(nextState.getVariant());

        super.setMaxBurnTime(nextState.getMaxBurnTime());
        super.setBurnTime(nextState.getBurnTime());
        super.setFireState(nextState.getFireState());
    }

    protected TileVoter getTileVoter(){
        return tileVoter;
    }

    protected TileBuffer getNextState(){
        return nextState;
    }

    public boolean canGenOnLevel(int level){
        return level == 0;
    }

    public void putTile(String tileId){
        setId(tileId);
    }

    /**
     * @return the id of what the tile wants its neighbors to be
     */
    public String getTileVote(){
        return tileVoter.getTileVote();
    }

    public void harvest(){}

    //MODIFIED VERSIONS OF SET

    /**
     * Set the type of tile the tile is
     * @param id is the id of the tile type
     */
    @Override
    protected void setId(String id){
        nextState.setId(id);
    }

    /**
     * Sets the tile type variant
     * @param variant is the variant of the tile type
     */
    @Override
    protected void setVariant(String variant){
        nextState.setVariant(variant);
    }

    /**
     * Set the fire state of the tile
     * @param fireState is the fire state of the tile
     */
    @Override
    protected void setFireState(FireState fireState){
        nextState.setFireState(fireState);
    }

    /**
     * Set the burn time counter
     * @param burnTime the new burn time
     */
    @Override
    protected void setBurnTime(int burnTime){
        nextState.setBurnTime(burnTime);
    }

    /**
     * Sets how long it takes to burn the tile
     * @param maxBurnTime is how long it takes to burn the tile
     */
    @Override
    protected void setMaxBurnTime(int maxBurnTime){
        nextState.setMaxBurnTime(maxBurnTime);
    }

}
