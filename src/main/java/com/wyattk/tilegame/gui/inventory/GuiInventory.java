package com.wyattk.tilegame.gui.inventory;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.gui.Gui;
import com.wyattk.tilegame.gui.GuiChar;
import com.wyattk.tilegame.gui.GuiStaticChar;
import com.wyattk.tilegame.gui.crafting.GuiCharCraft;
import com.wyattk.tilegame.gui.crafting.GuiCharCraftSelect;
import com.wyattk.tilegame.material.Material;
import com.wyattk.tilegame.material.MaterialNull;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;
import com.wyattk.tilegame.util.Window;

public class GuiInventory extends Gui {

    public static final int
            WIDTH = 10,
            HEIGHT = 10,
            X_OFFSET = Game.X_SIZE + Window.X_SCREEN_OFFSET * 2,
            Y_OFFSET = Window.Y_SCREEN_OFFSET + 2;

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.GUI, "inventory");

    int selected;

    public GuiInventory(){
        super(WIDTH, HEIGHT, X_OFFSET, Y_OFFSET, ID);

        GuiChar[][] display = new GuiChar[WIDTH][HEIGHT];

        for(int x=0; x<HEIGHT; x++) {
            display[0][x] = new GuiCharInventoryCount(x,1);
            display[1][x] = new GuiCharInventoryCount(x,0);
            display[2][x] = new GuiCharInventorySelect(x, x==0);
            display[3][x] = new GuiCharInventoryName(x,0);
            display[4][x] = new GuiCharInventoryName(x,1);
            display[5][x] = new GuiCharInventoryName(x,2);
            display[6][x] = new GuiCharInventoryName(x,3);
            display[7][x] = new GuiCharInventoryName(x,4);
            display[8][x] = new GuiCharInventoryName(x,5);
            display[9][x] = new GuiCharInventoryName(x,6);
        }

        selected = 0;

        setDisplay(display);
    }

    public void moveSelection(boolean up){
        GuiChar[][] display = getDisplay();
        boolean shift = false;
        /*if((up ? selected-1 < 0 : selected+1 >= display[0].length)){
            if((up ? ((GuiCharCraftSelect)display[0][0]).getSlot() == 0 : ((GuiCharCraftSelect)display[0][HEIGHT-1]).getSlot() >= Registry.RECIPES.size() - 1))
                return;

            int modif = (up ? -1 : 1);

            for(int x=0; x<display[0].length; x++) {
                ((GuiCharCraftSelect) display[0][x]).modifSlot(modif);
                for (int y = 1; y < display.length; y++)
                    ((GuiCharCraft) display[y][x]).modifSlot(modif);
            }
            shift = true;
        }*/
        if((up ? selected-1 < 0 : selected+1 >= display[0].length))
            return;

        for(int x=0; x<display[2].length; x++)
            if(((GuiCharInventorySelect) display[2][x]).isSelected())
                ((GuiCharInventorySelect) display[2][x]).deselect();

        //if(!shift)
            selected += (up ? -1 : 1);
        ((GuiCharInventorySelect) display[2][selected]).select();
    }

    public Material getSelected(){
        for(int x=0; x<getDisplay().length; x++)
            if(((GuiCharInventorySelect) getDisplay()[2][x]).isSelected())
                return Game.WORLD.getPlayer().getInventory().getStackAt(x).getMaterial();
        return new MaterialNull();
    }

    public int getSelectedSlot(){
        return selected;
    }
}
