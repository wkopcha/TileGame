package com.wyattk.tilegame.entity;

import com.wyattk.tilegame.util.GameRandom;
import com.wyattk.tilegame.util.Position;

public abstract class EntityLiving extends Entity {

    private static final float CHANCE_TO_MOVE = 0.01f;

    public EntityLiving(Position position){
        super(position);
    }

    public void doAction(){
        if(!GameRandom.coinFlip(CHANCE_TO_MOVE)) return;
        if(GameRandom.coinFlip())
            move(GameRandom.getInt(0,3) - 1,0);
        else
            move(0,GameRandom.getInt(0,3) - 1);
    }

    @Override
    public void tick(){
        super.tick();
        if(!isDead())
            doAction();
    }

    @Override
    public void kill(){
        super.kill();
        setVariant("dead");
    }

    @Override
    public void revive(){
        super.revive();
        setVariant("");
    }
}
