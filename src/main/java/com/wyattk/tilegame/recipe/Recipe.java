package com.wyattk.tilegame.recipe;

import com.wyattk.tilegame.material.MaterialStack;

public abstract class Recipe {

    private String id,product;
    private MaterialStack[] ingredients;

    public Recipe(String recipeId, MaterialStack[] ingredients, String productId){
        this.id = recipeId;
        this.ingredients = ingredients;
        this.product = productId;
    }

    public String getRecipeId(){
        return id;
    }

    public MaterialStack[] getIngredients(){
        return ingredients;
    }

    public String getProductId(){
        return product;
    }
}
