package com.wyattk.tilegame.entity.player;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.tile.TileWater;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Position;

public class Player extends Entity {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.ENTITY, "player");

    private PlayerInventory inventory;

    public Player(Position position){
        super(position);
        setId(ID);
        setFullHealth(10);
        initHealth();
        setDamageCooldownMax(200);

        inventory = new PlayerInventory();
    }

    @Override
    public void move(int xChange, int yChange){
        super.move(xChange,yChange);
        if(Game.WORLD.getTile(getPosition().getX(),getPosition().getY()).getId().equals(TileWater.ID))
            setVariant("boat");
        else
            setVariant("");
    }

    public PlayerInventory getInventory(){
        return inventory;
    }

    public boolean moveLevel(int levelChange){
        if(getPosition().getLevel() + levelChange < 0) return false;
        boolean genNewLevel = false;
        if(Game.WORLD.getLevelsGen() <= getPosition().getLevel() + levelChange){
            Game.WORLD.genNextLevel();
            genNewLevel = true;
        }

        getPosition().setLevel(getPosition().getLevel() + levelChange);
        return genNewLevel;
    }

}
