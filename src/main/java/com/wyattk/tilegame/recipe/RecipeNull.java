package com.wyattk.tilegame.recipe;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.material.MaterialNull;
import com.wyattk.tilegame.material.MaterialStack;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class RecipeNull extends Recipe {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.RECIPE, "null");
    private static final MaterialStack[] INGREDIENTS = new MaterialStack[0];

    public RecipeNull(){
        super(ID, INGREDIENTS, MaterialNull.ID);
    }
}
