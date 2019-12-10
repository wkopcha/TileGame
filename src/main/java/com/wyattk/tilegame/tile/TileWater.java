package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.entity.player.Player;
import com.wyattk.tilegame.gui.inventory.GuiInventory;
import com.wyattk.tilegame.material.MaterialBoat;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileWater extends Tile {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "water");

    public TileWater(Position position){
        super(position);
        setId(ID);
        getTileVoter()
                .add(TileTree.ID, 0.05f)
                .add(TileWater.ID, 0.80f)
                .add(TileBeach.ID, 0.10f)
                .add(TilePlains.ID, 0.05f)

                .add(TileCaveFloor.ID, 0.10f);

        apply();
    }

    @Override
    public boolean isHabitable(Entity e){
        return e.getId().equals(Player.ID) && Game.WORLD.getPlayer().getInventory().getSelected().getMaterialId().equals(MaterialBoat.ID);
    }

    @Override
    public boolean canGenOnLevel(int level){
        return level % 5 == 0 || level % 3 == 0;
    }
}
