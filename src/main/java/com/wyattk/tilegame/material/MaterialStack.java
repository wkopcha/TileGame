package com.wyattk.tilegame.material;

public class MaterialStack {

    public static final MaterialStack NULL = new MaterialStack(new MaterialNull());

    private String id;
    private int amount;
    private Material material;

    public MaterialStack(Material material){
        id = material.getId();
        this.material = material;
        amount = 0;
    }

    public MaterialStack(Material material, int amount){
        id = material.getId();
        this.material = material;
        this.amount = amount;
    }

    public void add(int amount){
        this.amount += amount;
    }

    public void remove(int amount){
        this.amount -= amount;
    }

    public void set(int amount){
        this.amount = amount;
    }

    public String getMaterialId(){
        return id;
    }

    public int getAmount(){
        return amount;
    }

    public Material getMaterial(){
        return material;
    }
}
