package com.wyattk.tilegame.util;

public class IdBuilder {

    public static String id(String groupId, String type, String name){
        return groupId+"."+type+"."+name;
    }

    public static String id(String groupId, String type, String name, String variant){
        return groupId+"."+type+"."+name+(variant.equals("") ? "" : ":"+variant);
    }

    public static String id(String groupId, IdType type, String name){
        return groupId+"."+type+"."+name;
    }

    public static String id(String groupId, IdType type, String name, String variant){
        return groupId+"."+type+"."+name+(variant.equals("") ? "" : ":"+variant);
    }

    public static String id(String id, String variant){
        return id+(variant.equals("") ? "" : ":"+variant);
    }
}
