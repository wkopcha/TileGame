package com.wyattk.tilegame.recipe;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.material.MaterialPick;
import com.wyattk.tilegame.material.MaterialStack;
import com.wyattk.tilegame.material.MaterialWood;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class RecipePick extends Recipe {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.RECIPE, "pick");

    private static final MaterialStack[] INGREDIENTS = {
            new MaterialStack(new MaterialWood(), 3)
    };

    public RecipePick(){
        super(ID, INGREDIENTS, MaterialPick.ID);
    }
}
