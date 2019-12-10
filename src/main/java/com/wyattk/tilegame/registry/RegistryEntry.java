package com.wyattk.tilegame.registry;

public class RegistryEntry<T> {

    private Class<? extends T> objectClass;
    private String id;

    public RegistryEntry(String id, Class<? extends T> objectClass){
        this.objectClass = objectClass;
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public Class<? extends T> getObjectClass(){
        return objectClass;
    }
}
