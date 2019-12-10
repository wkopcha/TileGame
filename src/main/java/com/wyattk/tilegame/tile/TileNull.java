package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileNull extends Tile {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "null");

    /**
     * A tile representing nothing
     * @param position is the position of the tile
     */
    public TileNull(Position position){
        super(position);
        setId(ID);
        getTileVoter().add(TileNull.ID, 1);

        apply();
    }

    @Override
    public boolean isHabitable(Entity e){
        return false;
    }
}
