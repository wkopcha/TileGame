package com.wyattk.tilegame.material;

import com.wyattk.tilegame.Reference;
import com.wyattk.tilegame.util.IdBuilder;
import com.wyattk.tilegame.util.IdType;

public class MaterialStone extends Material {

    public static final String ID = IdBuilder.id(Reference.GAME_ID, IdType.MATERIAL, "stone");

    public MaterialStone(){
        super(ID, "stone");
    }
}
