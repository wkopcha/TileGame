package com.wyattk.tilegame.gui.movement;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.gui.Gui;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.gui.GuiStaticChar;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Window;

public class GuiMovement extends Gui {
    private static final int WIDTH = 3, HEIGHT = 3;
    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.GUI, "movement");

    public GuiMovement(){

        super(WIDTH, HEIGHT, Game.X_SIZE + Window.X_SCREEN_OFFSET * 2 + 16, Window.Y_SCREEN_OFFSET, ID);

        setDisplay(new GuiChar[][]{
                {GuiStaticChar.BORDER_CORNER_TOP_LEFT, new GuiCharMovement(0,-1), GuiStaticChar.BORDER_CORNER_TOP_RIGHT},
                {new GuiCharMovement(-1,0), GuiStaticChar.PLAYER, new GuiCharMovement(1,0)},
                {GuiStaticChar.BORDER_CORNER_BOTTOM_LEFT, new GuiCharMovement(0,1), GuiStaticChar.BORDER_CORNER_BOTTOM_RIGHT}
        }, true);
    }
}
