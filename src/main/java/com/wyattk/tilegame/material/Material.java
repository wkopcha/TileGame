package com.wyattk.tilegame.material;

import com.wyattk.tilegame.Game;

public abstract class Material {
    private String id, name;
    private boolean allowIndividualStack;

    public Material(String id, String name){
        this.id = id;
        this.name = name;
        allowIndividualStack = false;
    }

    protected void setId(String id){
        this.id = id;
    }

    protected void setName(String name){
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void interact(int xChange, int yChange){
        Game.WORLD.getTile(Game.WORLD.getPlayer().getPosition().getX() + xChange, Game.WORLD.getPlayer().getPosition().getY() + yChange).harvest();
    }

    protected void allowIndividualStack(){
        allowIndividualStack = true;
    }

    protected void allowIndividualStack(boolean allowance){
        allowIndividualStack = allowance;
    }

    public boolean allowsIndividualStack(){
        return allowIndividualStack;
    }
}
