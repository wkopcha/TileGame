package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileMountain extends Tile{

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "mountain");

    public TileMountain(Position position){
        super(position);
        setId(ID);
        getTileVoter()
                .add(TileWater.ID, 0.02f)
                .add(TileMountain.ID, 0.28f)
                .add(TileTree.ID, 0.40f)
                .add(TilePlains.ID, 0.30f);

        apply();
    }

    @Override
    public boolean isHabitable(Entity e){
        return false;
    }
}
