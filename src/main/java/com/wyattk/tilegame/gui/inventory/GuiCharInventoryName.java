package com.wyattk.tilegame.gui.inventory;

import com.googlecode.lanterna.TextCharacter;
import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.gui.GuiStaticChar;

public class GuiCharInventoryName implements GuiChar {

    private int slot, position;

    public GuiCharInventoryName(int slot, int position){
        this.slot = slot;
        this.position = position;
    }

    public TextCharacter getCharacter(){
        String matId = Game.WORLD.getPlayer().getInventory().getStackAt(slot).getMaterial().getName();
        if(position >= matId.length() || position < 0)
            return GuiStaticChar.EMPTY.getCharacter();
        return GuiStaticChar.CHARACTERS.get(matId.charAt(position)).getCharacter();
    }
}
