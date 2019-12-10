package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileGem extends Tile {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "gem");

    public TileGem(Position position){
        super(position);
        setId(ID);
        getTileVoter()
                .add(TileCaveFloor.ID, 0.001f)
                .add(TileStoneWall.ID, 0.89f)
                .add(TileWater.ID, 0.10f);

        apply();
    }

    @Override
    public boolean canGenOnLevel(int level){
        return level > 5 && level % 7 == 0;
    }

    @Override
    public boolean isHabitable(Entity e){
        return false;
    }
}
