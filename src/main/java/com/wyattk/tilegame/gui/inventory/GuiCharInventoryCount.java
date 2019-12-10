package com.wyattk.tilegame.gui.inventory;

import com.googlecode.lanterna.TextCharacter;
import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.gui.GuiStaticChar;
import com.wyattk.tilegame.material.MaterialStack;

public class GuiCharInventoryCount implements GuiChar {

    private int slot, position;

    public GuiCharInventoryCount(int slot, int position){
        this.slot = slot;
        this.position = position;
    }

    public TextCharacter getCharacter(){
        MaterialStack s = Game.WORLD.getPlayer().getInventory().getStackAt(slot);
        return GuiStaticChar.NUMBERS[(int) (s.getAmount() / Math.pow(10, position)) % 10].getCharacter();
    }
}
