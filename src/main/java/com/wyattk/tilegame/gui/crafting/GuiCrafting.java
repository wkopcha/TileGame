package com.wyattk.tilegame.gui.crafting;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.gui.Gui;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.gui.inventory.GuiInventory;
import com.wyattk.tilegame.recipe.Recipe;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Window;

public class GuiCrafting extends Gui {

    public static final int
            WIDTH = 10,
            HEIGHT = 10,
            X_OFFSET = Game.X_SIZE + Window.X_SCREEN_OFFSET * 2 + GuiInventory.WIDTH - 2,
            Y_OFFSET = Window.Y_SCREEN_OFFSET + 3;

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.GUI, "crafting");

    private int selected, top;
    protected static Recipe[] ROWS;

    public GuiCrafting(){
        super(WIDTH, HEIGHT, X_OFFSET, Y_OFFSET, ID);

        GuiChar[][] display = new GuiChar[WIDTH][HEIGHT];

        ROWS = new Recipe[Registry.RECIPES.size()];
        for(int x=0; x<Registry.RECIPES.size(); x++)
            ROWS[x] = Registry.getRecipeInstance(Registry.RECIPES.get(x).getId());

        for(int x=0; x<display[0].length; x++) {
            display[0][x] = new GuiCharCraftSelect(x, x == 0);
            for (int y = 1; y < display.length; y++)
                display[y][x] = new GuiCharCraft(x, y - 1);
        }

        selected = 0;
        top = 0;

        setDisplay(display);
        initDisable();
    }

    public void moveSelection(boolean up){
        GuiChar[][] display = getDisplay();
        boolean shift = false;
        if((up ? selected-1 < 0 : selected+1 >= display[0].length)){
            if((up ? ((GuiCharCraftSelect)display[0][0]).getSlot() == 0 : ((GuiCharCraftSelect)display[0][HEIGHT-1]).getSlot() >= Registry.RECIPES.size() - 1))
                return;

            int modif = (up ? -1 : 1);

            for(int x=0; x<display[0].length; x++) {
                ((GuiCharCraftSelect) display[0][x]).modifSlot(modif);
                for (int y = 1; y < display.length; y++)
                    ((GuiCharCraft) display[y][x]).modifSlot(modif);
            }
            shift = true;
        }

        for(int x=0; x<display[0].length; x++)
            if(((GuiCharCraftSelect) display[0][x]).isSelected())
                ((GuiCharCraftSelect) display[0][x]).deselect();

        if(!shift)
            selected += (up ? -1 : 1);
        ((GuiCharCraftSelect) display[0][selected]).select();
    }

    public Recipe getSelectedRecipe(){
        GuiChar[][] display = getDisplay();

        for(int x=0; x<display[0].length; x++)
            if(((GuiCharCraftSelect) display[0][x]).isSelected() && ((GuiCharCraftSelect) display[0][x]).getSlot() < Registry.RECIPES.size())
                return Registry.getRecipeInstance(Registry.RECIPES.get(((GuiCharCraftSelect) display[0][x]).getSlot()).getId());
        return null;
    }
}
