package com.wyattk.tilegame.material;

import com.wyattk.tilegame.Game;

public abstract class MaterialTool extends Material {

    private int maxDur, dur;
    private static final int DEFAULT_MAX_DUR = 10;

    public MaterialTool(String id, String name){
        super(id,name);
        dur = DEFAULT_MAX_DUR;
        maxDur = DEFAULT_MAX_DUR;
        allowIndividualStack();
    }

    public MaterialTool(String id, String name, int maxDurability){
        super(id,name);
        dur = maxDurability;
        maxDur = maxDurability;
        allowIndividualStack();
    }

    protected void setMaxDurability(int maxDurability){
        maxDur = maxDurability;
    }

    protected void setDurability(int durability){
        dur = durability;
    }

    public int getDurability(){
        return dur;
    }

    public int getMaxDurability(){
        return maxDur;
    }

    public void tickDurability(){
        dur -= 1;
        if(dur <= 0)
            Game.WORLD.getPlayer().getInventory().takeMaterialExact(this, 1);
    }
}
