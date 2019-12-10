package com.wyattk.tilegame.recipe;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.material.MaterialKindling;
import com.wyattk.tilegame.material.MaterialStack;
import com.wyattk.tilegame.material.MaterialWood;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class RecipeKindling extends Recipe {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.RECIPE, "kindling");
    private static final MaterialStack[] INGREDIENTS = new MaterialStack[]{
            new MaterialStack(new MaterialWood(), 1)
    };

    public RecipeKindling(){
        super(ID, INGREDIENTS, MaterialKindling.ID);
    }
}
