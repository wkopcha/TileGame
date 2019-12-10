package com.wyattk.tilegame.recipe;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.material.MaterialBoat;
import com.wyattk.tilegame.material.MaterialStack;
import com.wyattk.tilegame.material.MaterialWood;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class RecipeBoat extends Recipe {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.RECIPE, "boat");

    private static final MaterialStack[] INGREDIENTS = new MaterialStack[]{
            new MaterialStack(new MaterialWood(), 3)
    };

    public RecipeBoat(){
        super(ID, INGREDIENTS, MaterialBoat.ID);
    }
}
