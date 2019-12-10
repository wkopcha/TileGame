package com.wyattk.tilegame.util;

import com.wyattk.tilegame.world.World;

public class Position {
    private int x, y, level;
    private World world;

    /**
     * Constructor for a mutable Position
     * @param x is the x coordinate of the position
     * @param y is the y coordinate of the position
     */
    public Position(int x,int y,int level,World world){
        this.x = x;
        this.y = y;
        this.level = level;

        this.world = world;
    }

    /**
     * @return the x coordinate of the position
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y coordinate of the position
     */
    public int getY() {
        return y;
    }

    public int getLevel(){
        return level;
    }

    /**
     * @return the world the position is in
     */
    public World getWorld(){
        return world;
    }


    /**
     * Sets the x coordinate to a new value
     * @param x is the new x coordinate of the position
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * Sets the y coordinate to a new value
     * @param y is the new y coordinate of the position
     */
    public void setY(int y){
        this.y = y;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public Position copy(){
        return new Position(getX(), getY(), getLevel(), getWorld());
    }


    public String toString(){
        return "("+x+","+y+","+level+")";
    }
}
