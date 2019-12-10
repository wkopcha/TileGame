package com.wyattk.tilegame.gui.gameover;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.gui.Gui;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.gui.GuiStaticChar;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Window;

public class GuiGameOver extends Gui {

    private static GuiStaticChar RED = new GuiStaticChar(new TextCharacter(' ', TextColor.ANSI.DEFAULT, TextColor.ANSI.RED));

    private static final int
            WIDTH = Game.X_SIZE,
            HEIGHT = Game.Y_SIZE,
            X_OFFSET = Window.X_SCREEN_OFFSET,
            Y_OFFSET = Window.Y_SCREEN_OFFSET;

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.GUI, "gameover");

    public GuiGameOver(){
        super(WIDTH, HEIGHT, X_OFFSET, Y_OFFSET, ID);
        initDisable();

        GuiChar[][] display = new GuiChar[WIDTH][HEIGHT];
        for(int x=0; x<display.length; x++)
            for(int y=0; y<display[0].length; y++)
                display[x][y] = RED;

        String endtext = "GAME OVER";
        for(int x=0; x<endtext.length(); x++)
            display[1 + x][1] = new GuiStaticChar(new TextCharacter(endtext.charAt(x), TextColor.ANSI.WHITE, TextColor.ANSI.RED, SGR.ITALIC, SGR.BOLD));

        setDisplay(display);
    }

    @Override
    public void tick(){
        if(Game.WORLD.getPlayer().isDead()) {
            if (!Game.GAME_OVER) Game.GAME_OVER = true;
            enable();
        }
    }
}
