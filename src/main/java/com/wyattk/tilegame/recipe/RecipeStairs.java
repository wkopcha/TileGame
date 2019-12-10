package com.wyattk.tilegame.recipe;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.material.MaterialStack;
import com.wyattk.tilegame.material.MaterialStair;
import com.wyattk.tilegame.material.MaterialWood;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class RecipeStairs extends Recipe {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.RECIPE, "stairs");

    private static final MaterialStack[] INGREDIENTS = new MaterialStack[]{
            new MaterialStack(new MaterialWood(), 5)
    };

    public RecipeStairs(){
        super(ID, INGREDIENTS, MaterialStair.ID);
    }
}
