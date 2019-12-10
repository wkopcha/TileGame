package com.wyattk.tilegame.keybind;

import com.googlecode.lanterna.input.KeyType;

public class Keybind {

    private KeyType keyType;
    private Character character;
    private Command method;

    public Keybind(KeyType keyType, Command method){
        this.method = method;
        character = null;
        this.keyType = keyType;
    }

    public Keybind(Character character, Command method){
        this.method = method;
        this.character = character;
        this.keyType = KeyType.Character;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public Character getCharacter() {
        return character;
    }

    public void call(){
        method.call();
    }
}
