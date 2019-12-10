package com.wyattk.tilegame.material;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class MaterialBoat extends Material {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.MATERIAL, "boat");

    public MaterialBoat(){
        super(ID, "boat");
    }
}
