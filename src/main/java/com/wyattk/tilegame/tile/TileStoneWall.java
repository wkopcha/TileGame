package com.wyattk.tilegame.tile;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.gui.inventory.GuiInventory;
import com.wyattk.tilegame.material.MaterialPick;
import com.wyattk.tilegame.material.MaterialStone;
import com.wyattk.tilegame.material.MaterialTool;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class TileStoneWall extends Tile {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.TILE, "stonewall");

    public TileStoneWall(Position position){
        super(position);
        setId(ID);
        getTileVoter()
                .add(TileStoneWall.ID, 0.845f)
                .add(TileCaveFloor.ID, 0.15f)
                .add(TileGem.ID, 0.005f);

        apply();
    }

    @Override
    public boolean canGenOnLevel(int level){
        return level % 5 != 0;
    }

    @Override
    public boolean isHabitable(Entity e){
        return false;
    }

    @Override
    public void harvest(){
        if(Game.WORLD.getPlayer().getInventory().getSelected().getMaterialId().equals(MaterialPick.ID)){
            if(getVariant().equals(""))
                setVariant("broken");
            else if(getVariant().equals("broken")) {
                Game.WORLD.putTile(getPosition().getX(), getPosition().getY(), new TileCaveFloor(getPosition()));
                Game.WORLD.getPlayer().getInventory().giveMaterial(new MaterialStone(), 1);
                ((MaterialTool) Game.WORLD.getPlayer().getInventory().getSelected().getMaterial()).tickDurability();
            }
        }
    }
}
