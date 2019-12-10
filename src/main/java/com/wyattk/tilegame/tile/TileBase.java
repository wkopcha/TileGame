package com.wyattk.tilegame.tile;

import com.googlecode.lanterna.TextCharacter;
import com.wyattk.tilegame.entity.Entity;
import com.wyattk.tilegame.registry.Registry;
import com.wyattk.tilegame.util.FireState;
import com.wyattk.tilegame.util.Position;

public abstract class TileBase {
    private Position position;
    private String id;
    private String variant;

    //Fire state variables
    private FireState fireState;
    private int burnTime;
    private int maxBurnTime;


    /**
     * The constructor for the abstract superclass Tile
     * id is an immutable id for the tile
     * @param position is the position of the tile
     */
    public TileBase(Position position){
        this.position = position;
        this.id = TileNull.ID;
        this.variant = "";

        this.fireState = FireState.NONE;
        this.burnTime = 0;
        this.maxBurnTime = 1;
    }



    //GETTERS
    /**
     * @return the position for either changing or reading
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return the type id of the tile
     */
    public String getId() {
        return id;
    }

    /**
     * @return the variant of the tile id
     */
    public String getVariant() {
        return variant;
    }

    /**
     * @return the full type with variant attached
     */
    public String getFullType(){
        return id + (!variant.equals("") ? ":"+variant : "");
    }

    /**
     * @return if the tile is on fire
     */
    public boolean isOnFire(){
        return fireState == FireState.BURNING;
    }

    /**
     * @return the fire state of the tile
     */
    public FireState getFireState(){
        return fireState;
    }

    /**
     * @return how long the tile has burned
     */
    public int getBurnTime(){
        return burnTime;
    }

    /**
     * @return how long the tile can burn until it is burnt
     */
    public int getMaxBurnTime(){
        return maxBurnTime;
    }

    /**
     * @return if the tile can support a player
     */
    public boolean isHabitable(Entity e){
        return true;
    }



    //PROTECTED TILE SETTERS
    /**
     * Set the type of tile the tile is
     * @param id is the id of the tile type
     */
    protected void setId(String id){
        this.id = id;
    }

    /**
     * Sets the tile type variant
     * @param variant is the variant of the tile type
     */
    protected void setVariant(String variant){
        this.variant = variant;
    }

    /**
     * Set the fire state of the tile
     * @param fireState is the fire state of the tile
     */
    protected void setFireState(FireState fireState){
        this.fireState = fireState;
    }

    /**
     * Set the burn time counter
     * @param burnTime the new burn time
     */
    protected void setBurnTime(int burnTime){
        this.burnTime = burnTime;
    }

    /**
     * Sets how long it takes to burn the tile
     * @param maxBurnTime is how long it takes to burn the tile
     */
    protected void setMaxBurnTime(int maxBurnTime){
        this.maxBurnTime = maxBurnTime;
    }



    //PUBLIC INTERFACES
    /**
     * Lights the tile on fire if possible
     */
    public void setOnFire(){}


    /**
     * @return the essential tile data as a string
     */
    public String getInfoString(){
        return position+": "+getFullType();
    }

    /**
     * @return the tile icon using the map in Reference.TILEMAP
     */
    public String toString(){
        return ""+ Registry.ICONMAP.get(getFullType()).getCharacter();
    }

    /**
     * @return the tile icon using the map in Reference.TILEMAP
     */
    public TextCharacter getDisplay(){
        return Registry.ICONMAP.get(getFullType());
    }
}
