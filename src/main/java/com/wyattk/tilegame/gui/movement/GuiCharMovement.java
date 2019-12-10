package com.wyattk.tilegame.gui.movement;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.entity.player.Player;
import com.wyattk.tilegame.gui.GuiChar;

public class GuiCharMovement implements GuiChar {

    private static final TextCharacter NO_MOVE = new TextCharacter(' ', TextColor.ANSI.DEFAULT, TextColor.ANSI.RED);

    private int xOffset, yOffset;

    public GuiCharMovement(int xOffset, int yOffset){
        super();
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public TextCharacter getCharacter(){
        Player player = Game.WORLD.getPlayer();
        if(Game.WORLD.getTile(player.getPosition().getX() + xOffset, player.getPosition().getY() + yOffset).isHabitable(player))
            return Game.WORLD.getTile(player.getPosition().getX() + xOffset, player.getPosition().getY() + yOffset).getDisplay();
        return Game.WORLD.getTile(player.getPosition().getX() + xOffset, player.getPosition().getY() + yOffset).getDisplay()
                .withBackgroundColor(TextColor.ANSI.RED)
                .withForegroundColor(TextColor.ANSI.WHITE);
    }
}
