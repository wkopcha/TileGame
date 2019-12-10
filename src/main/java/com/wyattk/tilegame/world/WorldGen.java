package com.wyattk.tilegame.world;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.tile.Tile;
import com.wyattk.tilegame.tile.TileNull;
import com.wyattk.tilegame.util.ErrorLog;
import com.wyattk.tilegame.util.GameRandom;
import com.wyattk.tilegame.util.Position;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

public class WorldGen {

    public static Tile[][] genWorld(Tile[][] tiles, int level, World world){
        if(tiles == null || tiles.length <= 0 || tiles[0].length <= 0) return tiles;

        //System.out.println("GEN WORLD ("+tiles.length+","+tiles[0].length+")");

        int repetitions = (int) Math.ceil(Math.min(tiles.length, tiles[0].length) / 2.0);
        for(int a=0; a<repetitions; a++)
            tiles = genEdges(genCorners(tiles, level, a, world), level, a, world);

        return tiles;
    }

    private static Tile[][] genCorners(Tile[][] tiles, int level, int offset, World world){
        if(tiles == null) return null;
        tiles[offset][offset] = genTile(offset,offset,level,world);
        tiles[tiles.length - 1 - offset][offset] = genTile(tiles.length - 1 - offset, offset, level, world);
        tiles[offset][tiles[0].length - 1 - offset] = genTile(offset, tiles[0].length - 1 - offset, level, world);
        tiles[tiles.length - 1 - offset][tiles[0].length - 1 - offset] = genTile(tiles.length - 1 - offset, tiles[0].length - 1 - offset, level, world);
        return tiles;
    }

    private static Tile[][] genEdges(Tile[][] tiles, int level, int offset, World world){
        if(tiles == null) return null;
        for(int a=0; a<(tiles.length - 2) / 2; a++){
            tiles[1 + offset + a][offset] = genTile(1 + offset + a, offset, level, world);
            tiles[tiles.length - 2 - offset - a][offset] = genTile(tiles.length - 2 - offset - a, offset, level, world);
            tiles[1 + offset + a][tiles[0].length - 1 - offset] = genTile(1 + offset + a, tiles[0].length - 1 - offset, level, world);
            tiles[tiles.length - 2 - offset - a][tiles[0].length - 1 - offset] = genTile(tiles.length - 2 - offset - a, tiles[0].length - 1 - offset, level, world);
        }

        for(int a=0; a<(tiles[0].length - 2) / 2; a++){
            tiles[offset][1 + offset + a] = genTile(offset,1 + offset + a, level, world);
            tiles[offset][tiles[0].length - 2 - offset - a] = genTile(offset, tiles[0].length - 2 - offset - a, level, world);
            tiles[tiles.length - 1 - offset][1 + offset + a] = genTile(tiles.length - 1 - offset, 1 + offset + a, level, world);
            tiles[tiles.length - 1 - offset][tiles[0].length - 2 - offset - a] = genTile(tiles.length - 1 - offset, tiles[0].length - 2 - offset - a, level, world);
        }

        return tiles;
    }


    /**
     * Creates a random tile from the registry
     * @param x is the x position of the tile
     * @param y is the y position of the tile
     * @return a randomly generated tile at (x,y) of a Null tile if there was an error
     */
    public static Tile genTile(int x,int y,int level,World world) {
        try {
            //Create array list to hold ids
            ArrayList<String> idsToChoose = new ArrayList<>();

            //Add voted tiles from surrounding 8 tiles
            String vote;
            for(int a=0; a<3; a++)
                for(int b=0; b<3; b++)
                    if(!(a == 1 && b == 1)) {
                        vote = world.getTile(x - 1 + a, y - 1 + b, level).getTileVote();
                        if(!vote.equals(Reference.GAME_ID+".tile.null"))
                            idsToChoose.add(vote);
                    }

            Tile t;

            //Choose randomly from list
            if(idsToChoose.size() <= 0)
                t = randomTile(x,y,level,world);
            else {
                String chosenId = idsToChoose.get(GameRandom.getInt(0, idsToChoose.size()));

                if (chosenId.equals(Reference.GAME_ID + ".tile.null"))
                    t = randomTile(x, y, level, world);
                else
                    t = Registry.fetchTileById(chosenId).getDeclaredConstructor(Position.class).newInstance(new Position(x, y, level, world));
            }

            if(t.canGenOnLevel(level))
                return t;

            return genTile(x,y,level,world);

        }catch(Exception e){
            ErrorLog.log("TILEGEN", e);
            return new TileNull(new Position(x,y,level,world));
        }
    }

    private static Tile randomTile(int x, int y, int level, World world) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return Registry.TILES.get(GameRandom.getInt(0,Registry.TILES.size())).getObjectClass().getDeclaredConstructor(Position.class).newInstance(new Position(x,y,level,world));
    }

    /**
     * Creates a random tile from the registry
     * @param x is the x position of the tile
     * @param y is the y position of the tile
     * @return a randomly generated tile at (x,y) of a Null tile if there was an error
     */
    @Deprecated
    public static Tile oldGenTile(int x,int y,int level,World world) {
        try {
            return Registry.TILES.get(GameRandom.getInt(0,Registry.TILES.size())).getObjectClass().getDeclaredConstructor(Position.class).newInstance(new Position(x,y,level,world));

        }catch(Exception e){
            System.out.println(e.toString());
            System.out.println(Arrays.toString(e.getStackTrace()));
            return new TileNull(new Position(x,y,level,world));
        }
    }
}
