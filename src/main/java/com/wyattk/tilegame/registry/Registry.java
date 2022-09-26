package com.wyattk.tilegame.registry;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.wyattk.tilegame.entity.EntityLiving;
import com.wyattk.tilegame.gui.Gui;
import com.wyattk.tilegame.keybind.Command;
import com.wyattk.tilegame.keybind.Keybind;
import com.wyattk.tilegame.material.Material;
import com.wyattk.tilegame.recipe.Recipe;
import com.wyattk.tilegame.recipe.RecipeNull;
import com.wyattk.tilegame.tile.Tile;
import com.wyattk.tilegame.util.ErrorLog;
import com.wyattk.tilegame.util.GameRandom;
import com.wyattk.tilegame.util.Position;

import java.util.ArrayList;
import java.util.HashMap;

public class Registry {
    public static HashMap<String, TextCharacter> ICONMAP = new HashMap<>();

    public static ArrayList<RegistryEntry<Tile>> TILES = new ArrayList<>();
    public static ArrayList<RegistryEntry<EntityLiving>> ENTITIES = new ArrayList<>();
    public static ArrayList<RegistryEntry<Gui>> GUIS = new ArrayList<>();
    public static ArrayList<RegistryEntry<Material>> MATERIALS = new ArrayList<>();
    public static ArrayList<RegistryEntry<Recipe>> RECIPES = new ArrayList<>();

    public static ArrayList<Keybind> KEYBINDS = new ArrayList<>();

    //Register
    /**
     * Registers a tile to the game systems
     * @param tileClass is the class that extends Tile that represents the tile being registered
     */
    public static void registerTile(String tileId, Class<? extends Tile> tileClass) {
        TILES.add(new RegistryEntry<>(tileId,tileClass));
    }

    public static void registerEntity(String entityId, Class<? extends EntityLiving> entityClass){
        ENTITIES.add(new RegistryEntry<>(entityId,entityClass));
    }

    public static void registerGui(String guiId, Class<? extends Gui> guiClass){
        GUIS.add(new RegistryEntry<>(guiId,guiClass));
    }

    public static void registerKeybind(Character character, Command method){
        KEYBINDS.add(new Keybind(character, method));
    }

    public static void registerKeybind(KeyType keyType, Command method){
        KEYBINDS.add(new Keybind(keyType, method));
    }

    public static void registerMaterial(String materialId, Class<? extends Material> materialClass){
        MATERIALS.add(new RegistryEntry<>(materialId,materialClass));
    }

    public static void registerRecipe(String recipeId, Class<? extends Recipe> recipeClass){
        RECIPES.add(new RegistryEntry<>(recipeId, recipeClass));
    }







    //MAPS
    /**
     * Register a single character icon to a tile id for display
     * @param id is the string id of the tile
     * @param icon is the character that the icon is represented by
     * @param textColor is the color of the character itself
     * @param backColor is the color of the background on the character
     */
    public static void registerIcon(String id, char icon, TextColor textColor, TextColor backColor){
        ICONMAP.putIfAbsent(id, new TextCharacter(icon, textColor, backColor));
    }

    /**
     * Register a single character icon to a tile id for display
     * @param id is the string id of the tile
     * @param icon is the character that the icon is represented by
     * @param textColor is the color of the character itself
     */
    public static void registerIcon(String id, char icon, TextColor textColor){
        ICONMAP.putIfAbsent(id, new TextCharacter(icon, textColor, TextColor.ANSI.DEFAULT));
    }

    /**
     * Register a single character icon to a tile id for display
     * @param id is the string id of the tile
     * @param icon is the character that the icon is represented by
     */
    public static void registerIcon(String id, char icon){
        ICONMAP.putIfAbsent(id, new TextCharacter(icon, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT));
    }

    /**
     * Register a single character icon to a tile id for display
     * @param id is the string id of the tile
     * @param icon is the text character instance that the icon is represented by
     */
    public static void registerIcon(String id, TextCharacter icon){
        ICONMAP.putIfAbsent(id, icon);
    }






    /**
     * Retrieve a tile class from the id given
     * @param tileId is the id of the tile
     * @return the tile with tileId
     */
    public static Class<? extends Tile> fetchTileById(String tileId){
        for(RegistryEntry<Tile> t: TILES)
            if(t.getId().equals(tileId))
                return t.getObjectClass();
        return TILES.get(GameRandom.getInt(0,TILES.size())).getObjectClass();
    }

    public static Class<? extends Material> fetchMaterialById(String materialId){
        for(RegistryEntry<Material> m: MATERIALS)
            if(m.getId().equals(materialId))
                return m.getObjectClass();
        return MATERIALS.get(GameRandom.getInt(0,MATERIALS.size())).getObjectClass();
    }

    public static Class<? extends Recipe> fetchRecipeById(String recipeId){
        for(RegistryEntry<Recipe> r: RECIPES)
            if(r.getId().equals(recipeId))
                return r.getObjectClass();
        return RECIPES.get(GameRandom.getInt(0,RECIPES.size())).getObjectClass();
    }


    public static Material getMaterialInstance(String materialId){
        try {
            return Registry.fetchMaterialById(materialId).newInstance();
        }catch(Exception e){
            ErrorLog.log("MATERIAL", e);
        }
        return null;
    }

    public static Recipe getRecipeInstance(String recipeId){
        try {
            return Registry.fetchRecipeById(recipeId).newInstance();
        }catch(Exception e){
            ErrorLog.log("RECIPE", e);
        }
        return new RecipeNull();
    }

    public static Tile getTileInstance(String tileId, Position position){
        try {
            return Registry.fetchTileById(tileId).getDeclaredConstructor(Position.class).newInstance(position);
        }catch(Exception e){
            ErrorLog.log("TILE", e);
        }
        return null;
    }





    public static void runKeybind(KeyStroke keyStroke){
        if(keyStroke.getKeyType() == KeyType.Character) {
            for (Keybind k : KEYBINDS)
                if (k.getCharacter() == keyStroke.getCharacter())
                    k.call();
        }
        else
            for(Keybind k: KEYBINDS)
                if(k.getKeyType() == keyStroke.getKeyType())
                    k.call();
    }
}
