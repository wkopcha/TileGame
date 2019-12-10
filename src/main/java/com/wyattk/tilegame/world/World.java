package com.wyattk.tilegame.world;

import com.wyattk.tilegame.entity.EntityLiving;
import com.wyattk.tilegame.entity.EntityNull;
import com.wyattk.tilegame.entity.player.Player;
import com.wyattk.tilegame.gui.Gui;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.tile.Tile;
import com.wyattk.tilegame.tile.TileNull;
import com.wyattk.tilegame.tile.TileStairsUp;
import com.wyattk.tilegame.util.GameRandom;
import com.wyattk.tilegame.util.Position;

import java.util.ArrayList;
import java.util.Arrays;

public class World {
    private static final int NUM_INIT_ENTITIES = 5;

    private Tile tileNull = new TileNull(new Position(-1,-1, -1,this));

    private ArrayList<Tile[][]> world;
    private ArrayList<EntityLiving> entities;
    private ArrayList<Gui> guis;
    private Player player;

    /**
     * Creates the world the game is set in, with randomly generated tiles
     * @param xSize is the x size of the world
     * @param ySize is the y size of the world
     */
    public World(int xSize,int ySize){
        world = new ArrayList<>();
        world.add(new Tile[xSize][ySize]);
        world.set(0, WorldGen.genWorld(world.get(0), 0,this)); //new Tile[xSize][ySize];
        entities = new ArrayList<>();
        guis = new ArrayList<>();
        for(int x=0; x<Registry.GUIS.size(); x++) {
            try {
                guis.add(Registry.GUIS.get(x).getObjectClass().newInstance());
            }catch(Exception e){
                System.out.println("GUI ERROR");
                System.out.println(e.toString());
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }

        for(int x=0; x<NUM_INIT_ENTITIES; x++)
            spawnEntity(0);
    }

    /**
     * @param x is the x position of the tile
     * @param y is the y position of the tile
     * @param level is the level of the tile
     * @return the tile at (x, y)
     */
    public Tile getTile(int x, int y, int level){
        if(level < world.size() && x < world.get(level).length && x >= 0 && y < world.get(level)[x].length && y >= 0 && world.get(level)[x][y] != null)
            return world.get(level)[x][y];
        else
            return tileNull;
    }

    public Tile getTile(int x, int y){
        if(x < world.get(getPlayer().getPosition().getLevel()).length && x >= 0 && y < world.get(getPlayer().getPosition().getLevel())[x].length && y >= 0 && world.get(getPlayer().getPosition().getLevel())[x][y] != null)
            return world.get(getPlayer().getPosition().getLevel())[x][y];
        else
            return tileNull;
    }

    public void putTile(int x,int y,Tile tile){
        if(x < world.get(getPlayer().getPosition().getLevel()).length && x >= 0 && y < world.get(getPlayer().getPosition().getLevel())[x].length && y >= 0)
            world.get(getPlayer().getPosition().getLevel())[x][y] = tile;
    }

    public void putTile(int x,int y,int level,Tile tile){
        if(x < world.get(level).length && x >= 0 && y < world.get(level)[x].length && y >= 0)
            world.get(level)[x][y] = tile;
    }

    public int getLevelsGen(){
        return world.size();
    }

    public void genNextLevel(){
        world.add(new Tile[getMaxX()][getMaxY()]);
        world.set(world.size() - 1, WorldGen.genWorld(world.get(world.size() - 1), world.size()-1, this));
        putTile(
                getPlayer().getPosition().getX(),
                getPlayer().getPosition().getY(),
                world.size() - 1,
                new TileStairsUp(new Position(
                        getPlayer().getPosition().getX(),
                        getPlayer().getPosition().getY(),
                        world.size() - 1,
                        this
                ))
        );
    }

    /**
     * @return the largest x bound for the world
     */
    public int getMaxX(){
        return world.get(0).length;
    }

    /**
     * @return the largest y bound for the world
     */
    public int getMaxY(){
        return (world.get(0).length > 0 ? world.get(0)[0].length : 0);
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public ArrayList<Gui> getGuis(){
        return guis;
    }

    public Gui getGui(String guiId){
        for(Gui gui: guis)
            if(gui.getId().equals(guiId))
                return gui;
        return null;
    }

    public Position getClearTile(int level){
        Tile out;
        do{
            out = getTile(GameRandom.getInt(0,getMaxX()), GameRandom.getInt(0,getMaxY()), level);
        }while(!out.isHabitable(EntityNull.NULL));

        return out.getPosition().copy();
    }

    public void spawnEntity(int level){
        try {
            entities.add(Registry.ENTITIES.get(GameRandom.getInt(0, Registry.ENTITIES.size())).getObjectClass().getDeclaredConstructor(Position.class).newInstance(getClearTile(level)));
        }catch(Exception e){
            System.out.println("SPAWN ERROR");
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }

    public boolean isEntityOn(int x, int y,int level){
        for(EntityLiving entity: entities)
            if(x == entity.getPosition().getX() && y == entity.getPosition().getY() && level == entity.getPosition().getLevel())
                return true;
        return false;
    }

    public boolean isPlayerOn(int x, int y, int level){
        return x == player.getPosition().getX() && y == player.getPosition().getY() && level == player.getPosition().getLevel();
    }

    public ArrayList<EntityLiving> getEntities(){
        return entities;
    }

    /**
     * Change then update all tiles
     */
    public void tick(){
        for (Tile[] tiles: world.get(getPlayer().getPosition().getLevel()))
            for (Tile tile: tiles)
                tile.tick();

        for (EntityLiving entity: entities)
            if(entity.getPosition().getLevel() == getPlayer().getPosition().getLevel())
                entity.tick();

        player.tick();

        for (Gui gui: guis)
            gui.tick();

        for (Tile[] tiles: world.get(getPlayer().getPosition().getLevel()))
            for (Tile tile: tiles)
                tile.apply();
    }

    /**
     * @return the string grid representation of the world
     */
    public String toString(){
        StringBuilder o = new StringBuilder("");
        for (int y=0; y<world.get(getPlayer().getPosition().getLevel())[0].length; y++) {
            for (int x=0; x<world.get(getPlayer().getPosition().getLevel()).length; x++)
                o.append(world.get(getPlayer().getPosition().getLevel())[x][y]);
            o.append("\n");
        }
        return o.toString();
    }
}
