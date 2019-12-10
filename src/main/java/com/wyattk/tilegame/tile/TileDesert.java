package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileDesert extends Tile{

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "desert");

    public TileDesert(Position position){
        super(position);
        setId(ID);
        getTileVoter()
                .add(TileBeach.ID, 0.145f)
                .add(TileDesert.ID, 0.85f)
                .add(TileDesertMountain.ID, 0.005f);

        apply();
    }
}
