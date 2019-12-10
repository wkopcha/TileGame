package com.wyattk.tilegame.material;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class MaterialKindling extends Material {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.MATERIAL, "kindling");

    public MaterialKindling(){
        super(ID, "kindling");
    }

    @Override
    public void interact(int xChange, int yChange){
        Game.WORLD.getTile(Game.WORLD.getPlayer().getPosition().getX() + xChange, Game.WORLD.getPlayer().getPosition().getY() + yChange).setOnFire();
        Game.WORLD.getPlayer().getInventory().takeMaterial(this, 1);
    }
}
