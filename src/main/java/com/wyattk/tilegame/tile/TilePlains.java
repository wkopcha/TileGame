package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.*;
import com.wyattk.tilegame.world.World;

public class TilePlains extends TilePlant {
    private static final int MIN_TIME_FOR_BURN = 130;

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "plains");

    /**
     * Creates a plains tile
     * @param position is the position of the tile
     */
    public TilePlains(Position position){
        super(position);
        setId(ID);
        setMaxBurnTime(250);
        getTileVoter()
                .add(TileTree.ID,0.35f)
                .add(TilePlains.ID, 0.55f)
                .add(TileMountain.ID, 0.05f)
                .add(TileWater.ID, 0.05f);

        apply();
    }

    @Override
    protected boolean spreadFireFromTile(int x, int y, World world){
        return world != null
                &&
                world.getTile(x, y).getFireState() == FireState.BURNING
                &&
                world.getTile(x, y).getBurnTime() >= MIN_TIME_FOR_BURN
                &&
                GameRandom.coinFlip(0.02f);
    }

    @Override
    public boolean canGenOnLevel(int level){
        return level % 5 == 0;
    }
}
