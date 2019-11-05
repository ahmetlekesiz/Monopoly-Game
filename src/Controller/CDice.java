package Controller;

import BL.BDice;

public class CDice {

    public int[] rollDice(){
        return new BDice().rollDice();
    }
}
