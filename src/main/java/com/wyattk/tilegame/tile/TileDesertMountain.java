package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileDesertMountain extends Tile {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "desertmountain");

    public TileDesertMountain(Position position){
        super(position);
        setId(ID);
        getTileVoter()
                .add(TileDesert.ID, 1);

        apply();
    }

    @Override
    public boolean isHabitable(Entity e){
        return false;
    }
}
