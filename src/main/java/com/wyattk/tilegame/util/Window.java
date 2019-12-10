package com.wyattk.tilegame.util;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.entity.EntityLiving;
import com.wyattk.tilegame.gui.Gui;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.tile.Tile;
import com.wyattk.tilegame.world.World;

import java.io.IOException;

public class Window{
    public static final int Y_SCREEN_OFFSET = 2;
    public static final int X_SCREEN_OFFSET = 2 * Y_SCREEN_OFFSET;

    private static Screen screen;
    private int xGameSpace, yGameSpace;

    public Window(int xGameSpace, int yGameSpace) throws IOException {
        screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
        screen.setCursorPosition(null);
        this.xGameSpace = xGameSpace;
        this.yGameSpace = yGameSpace;

        drawWorldBorder();

        apply();
    }

    /**
     * Print the world in the world container
     * @param world is the world to be printed
     */
    public void displayWorld(World world){
        for(int y=0; y<yGameSpace; y++)
            for(int x=0; x<xGameSpace; x++)
                setTile(x + X_SCREEN_OFFSET,y + Y_SCREEN_OFFSET, world.getTile(x,y));
    }

    public void displayEntity(Entity entity){
        if(entity.getPosition().getLevel() == Game.WORLD.getPlayer().getPosition().getLevel())
            screen.setCharacter(X_SCREEN_OFFSET + entity.getPosition().getX(), Y_SCREEN_OFFSET + entity.getPosition().getY(), entity.getIcon());
    }

    public void displayEntities(World world){
        for(EntityLiving entity: world.getEntities())
            displayEntity(entity);
    }

    public void displayGui(Gui gui){
        if(!gui.shouldDisplay()) return;
        GuiChar[][] display = gui.getDisplay();
        if(display.length <= 0 || display[0].length <= 0) return;
        for(int y=0; y<gui.getHeight(); y++)
            for(int x=0; x<gui.getWidth(); x++) {
                screen.setCharacter(gui.getXOffset() + x, gui.getYOffset() + y, display[x][y].getCharacter());
            }
    }

    public void displayGuis(World world){
        for(Gui gui : world.getGuis())
            displayGui(gui);
    }

    /**
     * Draws the border around the world display area
     */
    private void drawWorldBorder(){
        //SIDES
        TextCharacter c = new TextCharacter(Symbols.DOUBLE_LINE_HORIZONTAL, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT);
        for(int x=0; x<xGameSpace; x++) {
            screen.setCharacter(x + X_SCREEN_OFFSET, Y_SCREEN_OFFSET - 1, c);
            screen.setCharacter(x + X_SCREEN_OFFSET, Y_SCREEN_OFFSET + yGameSpace, c);
        }
        c = new TextCharacter(Symbols.DOUBLE_LINE_VERTICAL, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT);
        for(int y=0; y<yGameSpace; y++) {
            screen.setCharacter(X_SCREEN_OFFSET - 1, y + Y_SCREEN_OFFSET, c);
            screen.setCharacter(X_SCREEN_OFFSET + xGameSpace, y + Y_SCREEN_OFFSET, c);
        }

        //CORNERS
        screen.setCharacter(X_SCREEN_OFFSET - 1, Y_SCREEN_OFFSET - 1, new TextCharacter(Symbols.DOUBLE_LINE_TOP_LEFT_CORNER));
        screen.setCharacter(X_SCREEN_OFFSET + xGameSpace, Y_SCREEN_OFFSET - 1, new TextCharacter(Symbols.DOUBLE_LINE_TOP_RIGHT_CORNER));
        screen.setCharacter(X_SCREEN_OFFSET - 1, Y_SCREEN_OFFSET + yGameSpace, new TextCharacter(Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER));
        screen.setCharacter(X_SCREEN_OFFSET + xGameSpace, Y_SCREEN_OFFSET + yGameSpace, new TextCharacter(Symbols.DOUBLE_LINE_BOTTOM_RIGHT_CORNER));
    }

    /**
     * Sets the character at x, y to the character for tile
     * @param x is the x coordinate of the character
     * @param y is the y coordinate of the character
     * @param tile is the tile to print
     */
    public void setTile(int x, int y, Tile tile){
        screen.setCharacter(x,y,tile.getDisplay());
    }

    /**
     * Updates the screen to see changed characters
     * @throws IOException
     */
    public void apply() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.stopScreen();
    }

    public KeyStroke pollKey() throws IOException {
        return screen.pollInput();
    }

    public String getInput() throws IOException {
        KeyStroke key = screen.pollInput();
        if(key == null) return "";
        KeyType type = key.getKeyType();
        switch(type){
            case Character:
                return ""+key.getCharacter();
            case ArrowDown:
                return "_DOWN";
            case ArrowRight:
                return "_RIGHT";
            case ArrowLeft:
                return "_LEFT";
            case ArrowUp:
                return "_UP";
        }
        return "_NULL";
    }
}
