package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileBeach extends Tile {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "beach");

    public TileBeach(Position position){
        super(position);
        setId(ID);
        getTileVoter()
                .add(TileWater.ID, 0.35f) //.3
                .add(TileBeach.ID, 0.3f) //.55
                .add(TileDesert.ID, 0.35f); //.15

        apply();
    }
}
