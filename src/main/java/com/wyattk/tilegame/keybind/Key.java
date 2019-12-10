package com.wyattk.tilegame.keybind;

import com.googlecode.lanterna.input.KeyType;

public enum Key {
    A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,
    ARROW_UP,ARROW_DOWN,ARROW_LEFT,ARROW_RIGHT,
    ESCAPE,TAB,BACKSPACE,DELETE,END,HOME,ENTER,PAGE_UP,PAGE_DOWN,INSERT,
    F1,F2,F3,F4,F5,F6,F7,F8,F9,F10,F11,F12,F13,F14,F15,F16,F17,F18,F19,
    UNKNOWN;

    public Key toKey(KeyType keyType){
        switch(keyType){
            case ArrowUp: return ARROW_UP;
            case ArrowDown: return ARROW_DOWN;
            case ArrowLeft: return ARROW_LEFT;
            case ArrowRight: return ARROW_RIGHT;
            case Escape: return ESCAPE;
            case Tab: return TAB;
            case Backspace: return BACKSPACE;
            case Delete: return DELETE;
            case End: return END;
            case Home: return HOME;
            case Enter: return ENTER;
            case PageUp: return PAGE_UP;
            case PageDown: return PAGE_DOWN;
            case Insert: return INSERT;
            case F1: return F1;
            case F2: return F2;
            case F3: return F3;
            case F4: return F4;
            case F5: return F5;
            case F6: return F6;
            case F7: return F7;
            case F8: return F8;
            case F9: return F9;
            case F10: return F10;
            case F11: return F11;
            case F12: return F12;
            case F13: return F13;
            case F14: return F14;
            case F15: return F15;
            case F16: return F16;
            case F17: return F17;
            case F18: return F18;
            case F19: return F19;
            default: return UNKNOWN;
        }
    }

    public Key toKey(Character character){
        switch(Character.toLowerCase(character)){
            case 'a': return A;
            case 'b': return B;
            case 'c': return C;
            case 'd': return D;
            case 'e': return E;
            case 'f': return F;
            case 'g': return G;
            case 'h': return H;
            case 'i': return I;
            case 'j': return J;
            case 'k': return K;
            case 'l': return L;
            case 'm': return M;
            case 'n': return N;
            case 'o': return O;
            case 'p': return P;
            case 'q': return Q;
            case 'r': return R;
            case 's': return S;
            case 't': return T;
            case 'u': return U;
            case 'v': return V;
            case 'w': return W;
            case 'x': return X;
            case 'y': return Y;
            case 'z': return Z;
            default: return UNKNOWN;
        }
    }
}
