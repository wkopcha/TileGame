package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.material.MaterialWood;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.util.ErrorLog;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileTree extends TilePlant {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "tree");

    /**
     * Creates a tree/forest tile
     * @param position is the position of the tile
     */
    public TileTree(Position position){
        super(position);
        setId(ID);
        setMaxBurnTime(350);
        getTileVoter()
                .add(TileTree.ID, 0.35f)
                .add(TilePlains.ID, 0.55f)
                .add(TileMountain.ID, 0.05f)
                .add(TileWater.ID, 0.05f);

        apply();
    }

    @Override
    public void harvest(){
        if(!getVariant().equals("")) return;

        setVariant("cut");
        Game.WORLD.getPlayer().getInventory().giveMaterial(Registry.getMaterialInstance(MaterialWood.ID), 1);
    }
}
