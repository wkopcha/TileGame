package com.wyattk.tilegame;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;

public class Reference {
    public static final String GAME_ID = "tilegame";

    public static final TextColor COLOR_FIRE = new TextColor.RGB(255,150,0);

    public static final TextCharacter CHAR_FIRE = new TextCharacter('&', COLOR_FIRE, TextColor.ANSI.DEFAULT, SGR.BOLD);
}
