package com.wyattk.tilegame.gui.crafting;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.gui.GuiStaticChar;
import com.wyattk.tilegame.material.Material;
import com.wyattk.tilegame.recipe.Recipe;
import com.wyattk.tilegame.registry.Registry;

public class GuiCharCraft implements GuiChar {

    private int slot, position;

    public GuiCharCraft(int slot, int position){
        this.slot = slot;
        this.position = position;
    }

    public void modifSlot(int modif){
        this.slot += modif;
    }

    public TextCharacter getCharacter(){
        if(slot >= Registry.RECIPES.size()) return GuiStaticChar.EMPTY.getCharacter();

        Recipe recipe = Registry.getRecipeInstance(Registry.RECIPES.get(slot).getId());
        Material mat = Registry.getMaterialInstance(recipe.getProductId());

        if(mat == null || mat.getName().length() <= position) return GuiStaticChar.EMPTY.getCharacter();

        if(Game.WORLD.getPlayer().getInventory().canCraft(recipe))
            return GuiStaticChar.CHARACTERS.get(mat.getName().charAt(position)).getCharacter();
        return GuiStaticChar.CHARACTERS.get(mat.getName().charAt(position)).getCharacter().withForegroundColor(new TextColor.RGB(51,51,51));
    }
}
