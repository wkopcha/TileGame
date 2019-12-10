package com.wyattk.tilegame.entity;

import com.googlecode.lanterna.TextCharacter;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.util.Position;

public abstract class Entity {
    private Position position;
    private String id, variant;
    private int fullHealth, health;
    private boolean isDead;

    private int damageCooldown, damageCooldownMax;

    public Entity(Position position){
        this.position = position;
        this.id = EntityNull.ID;
        this.variant = "";
        this.health = 1;
        this.fullHealth = 1;
        this.isDead = false;
        this.damageCooldown = 0;
        this.damageCooldownMax = 100;
    }

    protected void setId(String id){
        this.id = id;
    }

    protected void setVariant(String variant){
        this.variant = variant;
    }

    protected void setFullHealth(int fullHealth){
        this.fullHealth = fullHealth;
    }

    protected void setHealth(int health){
        this.health = health;
    }

    protected void initHealth(){
        this.health = this.fullHealth;
    }

    protected void setDamageCooldown(int damageCooldown){
        this.damageCooldown = damageCooldown;
    }

    protected void setDamageCooldownMax(int damageCooldownMax){
        this.damageCooldownMax = damageCooldownMax;
    }

    public Position getPosition() {
        return position;
    }

    public String getId(){
        return id;
    }

    public String getVariant(){
        return variant;
    }

    public String getFullId(){
        return getId() + (getVariant().equals("") ? "" : ":"+getVariant());
    }

    public int getHealth(){
        return health;
    }

    public int getFullHealth(){
        return fullHealth;
    }

    public int getDamageCooldownLeft(){
        return damageCooldown;
    }

    public int getDamageCooldownMax(){
        return damageCooldownMax;
    }

    public boolean canTakeDamage(){
        return getDamageCooldownLeft() <= 0;
    }

    public boolean isDead(){
        return isDead;
    }

    public void kill(){
        this.isDead = true;
    }

    public void revive(){
        this.isDead = false;
    }

    public void move(int xChange, int yChange){
        if(!getPosition().getWorld().getTile(getPosition().getX() + xChange, getPosition().getY() + yChange).isHabitable(this)) return;
        if(getPosition().getWorld().isEntityOn(getPosition().getX() + xChange, getPosition().getY() + yChange, getPosition().getLevel())) return;
        if(getPosition().getWorld().isPlayerOn(getPosition().getX() + xChange, getPosition().getY() + yChange, getPosition().getLevel())) return;
        getPosition().setX(getPosition().getX() + xChange);
        getPosition().setY(getPosition().getY() + yChange);
    }

    public void tick(){
        if(getPosition().getWorld().getTile(getPosition().getX(), getPosition().getY()).isOnFire())
            damage(1);
        if(!canTakeDamage())
            setDamageCooldown(getDamageCooldownLeft() - 1);
    }

    public void damage(int damage){
        if(!canTakeDamage()) return;
        setHealth(getHealth() - damage);
        setDamageCooldown(getDamageCooldownMax());
        if(getHealth() <= 0)
            kill();
    }

    public String toString(){
        return ""+Registry.ICONMAP.get(getFullId()).getCharacter();
    }

    public TextCharacter getIcon(){
        return Registry.ICONMAP.get(getFullId());
    }

}
