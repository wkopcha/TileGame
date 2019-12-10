package com.wyattk.tilegame.gui.playerhealth;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.gui.Gui;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Window;

public class GuiPlayerHealth extends Gui {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.GUI, "playerhealth");

    private static final int
            HEART_COL = 15,
            HEART_ROW = 1,
            X_OFFSET = Game.X_SIZE + Window.X_SCREEN_OFFSET * 2,
            Y_OFFSET = Window.Y_SCREEN_OFFSET;

    public GuiPlayerHealth(){
        super(HEART_COL,HEART_ROW,X_OFFSET,Y_OFFSET,ID);

        GuiChar[][] display = new GuiChar[HEART_COL][HEART_ROW];
        for(int x=0; x<HEART_COL; x++)
            for (int y = 0; y < HEART_ROW; y++)
                display[x][y] = new GuiCharPlayerHealth(1 + x + y * HEART_COL);


        setDisplay(display);
    }
}
