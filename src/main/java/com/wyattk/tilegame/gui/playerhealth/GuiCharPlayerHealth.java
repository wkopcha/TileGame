package com.wyattk.tilegame.gui.playerhealth;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.gui.GuiChar;

public class GuiCharPlayerHealth implements GuiChar {
    private static final TextCharacter FULL_HEART = new TextCharacter(Symbols.HEART, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, SGR.BOLD);
    private static final TextCharacter HALF_HEART = new TextCharacter(Symbols.HEART, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, SGR.BOLD, SGR.BLINK);
    private static final TextCharacter NO_HEART = new TextCharacter(' ', TextColor.ANSI.RED, TextColor.ANSI.DEFAULT);

    private int healthDuo;

    public  GuiCharPlayerHealth(int healthDuo){
        super();
        this.healthDuo = healthDuo;
    }

    @Override
    public TextCharacter getCharacter() {
        if(Game.WORLD.getPlayer().getHealth() >= healthDuo * 2)
            return FULL_HEART;
        if(Game.WORLD.getPlayer().getHealth() == healthDuo * 2 - 1)
            return HALF_HEART;
        return NO_HEART;
    }
}
