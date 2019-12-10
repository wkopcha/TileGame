package com.wyattk.tilegame.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;

import java.util.HashMap;
import java.util.Map;

public class GuiStaticChar implements GuiChar{

    public static final GuiStaticChar EMPTY = new GuiStaticChar(
            new TextCharacter(' ', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT)
    );
    public static final GuiStaticChar PLAYER = new GuiStaticChar(
            new TextCharacter('@', TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, SGR.BOLD)
    );
    public static final GuiStaticChar BORDER_CORNER_TOP_LEFT = new GuiStaticChar(
            new TextCharacter(Symbols.DOUBLE_LINE_TOP_LEFT_CORNER)
    );
    public static final GuiStaticChar BORDER_CORNER_TOP_RIGHT = new GuiStaticChar(
            new TextCharacter(Symbols.DOUBLE_LINE_TOP_RIGHT_CORNER)
    );
    public static final GuiStaticChar BORDER_CORNER_BOTTOM_LEFT = new GuiStaticChar(
            new TextCharacter(Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER)
    );
    public static final GuiStaticChar BORDER_CORNER_BOTTOM_RIGHT = new GuiStaticChar(
            new TextCharacter(Symbols.DOUBLE_LINE_BOTTOM_RIGHT_CORNER)
    );
    public static final GuiStaticChar BORDER_VERTICAL = new GuiStaticChar(
            new TextCharacter(Symbols.DOUBLE_LINE_VERTICAL)
    );
    public static final GuiStaticChar BORDER_HORIZONTAL = new GuiStaticChar(
            new TextCharacter(Symbols.DOUBLE_LINE_HORIZONTAL)
    );
    public static final GuiStaticChar DENSE_BOX = new GuiStaticChar(
            new TextCharacter(Symbols.BLOCK_DENSE)
    );
    public static final GuiStaticChar SOLID_BOX = new GuiStaticChar(
            new TextCharacter(Symbols.BLOCK_SOLID)
    );
    public static final GuiStaticChar MIDDLE_BOX = new GuiStaticChar(
            new TextCharacter(Symbols.BLOCK_MIDDLE)
    );
    public static final GuiStaticChar SPARSE_BOX = new GuiStaticChar(
            new TextCharacter(Symbols.BLOCK_SPARSE)
    );

    public static final GuiStaticChar[] NUMBERS = {
            new GuiStaticChar(new TextCharacter('0')),
            new GuiStaticChar(new TextCharacter('1')),
            new GuiStaticChar(new TextCharacter('2')),
            new GuiStaticChar(new TextCharacter('3')),
            new GuiStaticChar(new TextCharacter('4')),
            new GuiStaticChar(new TextCharacter('5')),
            new GuiStaticChar(new TextCharacter('6')),
            new GuiStaticChar(new TextCharacter('7')),
            new GuiStaticChar(new TextCharacter('8')),
            new GuiStaticChar(new TextCharacter('9'))
    };

    public static final HashMap<Character, GuiStaticChar> CHARACTERS = new HashMap<Character, GuiStaticChar>(){{
        put('a',new GuiStaticChar(new TextCharacter('a', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('b',new GuiStaticChar(new TextCharacter('b', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('c',new GuiStaticChar(new TextCharacter('c', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('d',new GuiStaticChar(new TextCharacter('d', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('e',new GuiStaticChar(new TextCharacter('e', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('f',new GuiStaticChar(new TextCharacter('f', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('g',new GuiStaticChar(new TextCharacter('g', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('h',new GuiStaticChar(new TextCharacter('h', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('i',new GuiStaticChar(new TextCharacter('i', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('j',new GuiStaticChar(new TextCharacter('j', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('k',new GuiStaticChar(new TextCharacter('k', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('l',new GuiStaticChar(new TextCharacter('l', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('m',new GuiStaticChar(new TextCharacter('m', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('n',new GuiStaticChar(new TextCharacter('n', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('o',new GuiStaticChar(new TextCharacter('o', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('p',new GuiStaticChar(new TextCharacter('p', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('q',new GuiStaticChar(new TextCharacter('q', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('r',new GuiStaticChar(new TextCharacter('r', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('s',new GuiStaticChar(new TextCharacter('s', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('t',new GuiStaticChar(new TextCharacter('t', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('u',new GuiStaticChar(new TextCharacter('u', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('v',new GuiStaticChar(new TextCharacter('v', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('w',new GuiStaticChar(new TextCharacter('w', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('x',new GuiStaticChar(new TextCharacter('x', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('y',new GuiStaticChar(new TextCharacter('y', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('z',new GuiStaticChar(new TextCharacter('z', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('A',new GuiStaticChar(new TextCharacter('A', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('B',new GuiStaticChar(new TextCharacter('B', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('C',new GuiStaticChar(new TextCharacter('C', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('D',new GuiStaticChar(new TextCharacter('D', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('E',new GuiStaticChar(new TextCharacter('E', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('F',new GuiStaticChar(new TextCharacter('F', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('G',new GuiStaticChar(new TextCharacter('G', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('H',new GuiStaticChar(new TextCharacter('H', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('I',new GuiStaticChar(new TextCharacter('I', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('J',new GuiStaticChar(new TextCharacter('J', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('K',new GuiStaticChar(new TextCharacter('K', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('L',new GuiStaticChar(new TextCharacter('L', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('M',new GuiStaticChar(new TextCharacter('M', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('N',new GuiStaticChar(new TextCharacter('N', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('O',new GuiStaticChar(new TextCharacter('O', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('P',new GuiStaticChar(new TextCharacter('P', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('Q',new GuiStaticChar(new TextCharacter('Q', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('R',new GuiStaticChar(new TextCharacter('R', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('S',new GuiStaticChar(new TextCharacter('S', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('T',new GuiStaticChar(new TextCharacter('T', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('U',new GuiStaticChar(new TextCharacter('U', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('V',new GuiStaticChar(new TextCharacter('V', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('W',new GuiStaticChar(new TextCharacter('W', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('X',new GuiStaticChar(new TextCharacter('X', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('Y',new GuiStaticChar(new TextCharacter('Y', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('Z',new GuiStaticChar(new TextCharacter('Z', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('0',new GuiStaticChar(new TextCharacter('0', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('1',new GuiStaticChar(new TextCharacter('1', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('2',new GuiStaticChar(new TextCharacter('2', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('3',new GuiStaticChar(new TextCharacter('3', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('4',new GuiStaticChar(new TextCharacter('4', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('5',new GuiStaticChar(new TextCharacter('5', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('6',new GuiStaticChar(new TextCharacter('6', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('7',new GuiStaticChar(new TextCharacter('7', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('8',new GuiStaticChar(new TextCharacter('8', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('9',new GuiStaticChar(new TextCharacter('9', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
        put('|',new GuiStaticChar(new TextCharacter('|', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD)));
    }};


    private TextCharacter character;

    public GuiStaticChar(TextCharacter character){
        this.character = character;
    }

    public TextCharacter getCharacter(){
        return character;
    }
}
