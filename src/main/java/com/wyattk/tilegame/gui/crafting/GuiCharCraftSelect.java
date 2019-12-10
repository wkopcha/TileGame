package com.wyattk.tilegame.gui.crafting;

import com.googlecode.lanterna.TextCharacter;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.gui.GuiStaticChar;

public class GuiCharCraftSelect implements GuiChar {

    private int slot;
    private boolean selected;

    public GuiCharCraftSelect(int slot, boolean selected){
        this.slot = slot;
        this.selected = selected;
    }

    public boolean isSelected(){
        return selected;
    }

    public void select(){
        selected = true;
    }

    public void deselect(){
        selected = false;
    }

    public void modifSlot(int modif){
        this.slot += modif;
    }

    public int getSlot(){
        return slot;
    }

    public TextCharacter getCharacter() {
        if(selected)
            return GuiStaticChar.SOLID_BOX.getCharacter();
        return GuiStaticChar.SPARSE_BOX.getCharacter();
    }
}
