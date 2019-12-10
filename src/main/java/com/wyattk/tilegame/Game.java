package com.wyattk.tilegame;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.wyattk.tilegame.entity.player.Player;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.util.ErrorLog;
import com.wyattk.tilegame.util.Window;
import com.wyattk.tilegame.world.World;

import java.io.IOException;

public class Game {

    public static final int X_SIZE = 40;
    public static final int Y_SIZE = 20;
    public static final int TICKS_PER_SECOND = 200;

    public static World WORLD;
    public static Window WINDOW;

    public static boolean GAME_OVER;

    public static World init(String[] args){
        TileGame.init();

        if(args.length > 2)
            return new World(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        return new World(X_SIZE,Y_SIZE);
    }


    /**
     * The main method of the game
     * @param args is an array of parameters
     *             1 : world x size
     *             2 : world y size
     */
    public static void main(String[] args){
        WORLD = init(args);
        WORLD.setPlayer(new Player(WORLD.getClearTile(0)));
        GAME_OVER = false;

        System.out.println(WORLD);

        WINDOW = null;
        try {
            WINDOW = new Window(WORLD.getMaxX(), WORLD.getMaxY());
            gameLoop();
        }catch(Exception e){
            ErrorLog.log("GAME", e);
        }finally{
            endGame();
        }
    }

    public static void endGame(){
        if(WINDOW != null) {
            try {
                WINDOW.close();
            }catch(Exception e){
                ErrorLog.log("CLOSE", e);
            }
        }
    }

    public static void gameLoop() throws IOException, InterruptedException {
        KeyStroke input = null;
        Player player = WORLD.getPlayer();

        while(input == null || input.getKeyType() != KeyType.Escape) {
            Thread.sleep(1000 / TICKS_PER_SECOND);
            WINDOW.displayWorld(WORLD);
            WINDOW.displayEntities(WORLD);
            WINDOW.displayEntity(player);
            WINDOW.displayGuis(WORLD);



            WINDOW.apply();
            WORLD.tick();

            input = WINDOW.pollKey();
            if(input == null || GAME_OVER) continue;
            Registry.runKeybind(input);

        }
    }
}
