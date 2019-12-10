package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileCaveFloor extends Tile {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "cavefloor");

    public TileCaveFloor(Position position){
        super(position);
        setId(ID);
        getTileVoter()
                .add(TileCaveFloor.ID, 0.85f)
                .add(TileStoneWall.ID, 0.15f);

        apply();
    }

    @Override
    public boolean canGenOnLevel(int level){
        return level % 5 != 0;
    }
}
