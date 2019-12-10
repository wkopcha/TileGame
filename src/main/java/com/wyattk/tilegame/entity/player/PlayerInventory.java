package com.wyattk.tilegame.entity.player;

import com.wyattk.tilegame.Game;
import com.wyattk.tilegame.gui.inventory.GuiInventory;
import com.wyattk.tilegame.material.Material;
import com.wyattk.tilegame.material.MaterialStack;
import com.wyattk.tilegame.recipe.Recipe;
import com.wyattk.tilegame.registry.Registry;

import java.util.ArrayList;

public class PlayerInventory {

    private ArrayList<MaterialStack> materials;

    public PlayerInventory(){
        this.materials = new ArrayList<>();
    }

    public PlayerInventory(ArrayList<MaterialStack> materials){
        this.materials = materials;
    }



    public void giveMaterial(Material material, int amount){
        if(!material.allowsIndividualStack())
            for(MaterialStack s: materials)
                if(s.getMaterialId().equals(material.getId())) {
                    s.add(amount);
                    return;
                }
        materials.add(new MaterialStack(material, amount));
    }

    public void takeMaterial(Material material, int amount){
        int remove = 0;
        for(int x=0; x<materials.size(); x++)
            if(materials.get(x).getMaterialId().equals(material.getId())) {
                materials.get(x).remove(amount);
                if(materials.get(x).getAmount() > 0)
                    return;
                remove = x;
                break;
            }

        materials.remove(remove);
    }

    public void takeMaterialAt(int slot, int amount){
        if(amount >= materials.get(slot).getAmount())
            materials.remove(slot);
        else
            materials.get(slot).remove(amount);
    }

    public void takeMaterialExact(Material material, int amount){
        int remove = 0;
        for(int x=0; x<materials.size(); x++)
            if(materials.get(x).getMaterial() == material) {
                materials.get(x).remove(amount);
                if(materials.get(x).getAmount() > 0)
                    return;
                remove = x;
                break;
            }

        materials.remove(remove);
    }

    public MaterialStack getStackAt(int inventorySlot){
        if(inventorySlot >= materials.size() || inventorySlot < 0)
            return MaterialStack.NULL;
        return materials.get(inventorySlot);
    }

    public MaterialStack getStack(String materialId){
        int inventorySlot = -1;
        for(int x=0; x<materials.size(); x++)
            if(materials.get(x).getMaterialId().equals(materialId))
                inventorySlot = x;
        if(inventorySlot < 0)
            return MaterialStack.NULL;
        return materials.get(inventorySlot);
    }



    public boolean hasMaterial(String materialId){
        for(MaterialStack s: materials)
            if(s.getMaterialId().equals(materialId))
                return true;
        return false;
    }

    public boolean hasMaterial(String materialId, int amount){
        for(MaterialStack s: materials)
            if(s.getMaterialId().equals(materialId))
                return s.getAmount() >= amount;
        return false;
    }

    public MaterialStack getSelected(){
        if(((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).getSelectedSlot() >= materials.size() || ((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).getSelectedSlot() < 0) return MaterialStack.NULL;
        return materials.get(((GuiInventory) Game.WORLD.getGui(GuiInventory.ID)).getSelectedSlot());
    }



    public boolean canCraft(Recipe recipe){
        boolean good = true;
        for(MaterialStack s: recipe.getIngredients())
            good = good && hasMaterial(s.getMaterialId(), s.getAmount());
        return good;
    }

    public void craft(Recipe recipe){
        if(!canCraft(recipe)) return;
        Material mat = Registry.getMaterialInstance(recipe.getProductId());
        if(mat == null) return;

        giveMaterial(mat, 1);
        for(MaterialStack s: recipe.getIngredients())
            takeMaterial(s.getMaterial(), s.getAmount());
    }
}
