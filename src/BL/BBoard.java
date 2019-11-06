package BL;

import DAL.DInstruction;
import com.sun.org.apache.bcel.internal.generic.Instruction;

public class BBoard {

    private static final int SQUARE_NUMBER = 40;
    private BSquare[] squares;
    private static BBoard boardInstance;
    private DInstruction instructionInstance;
    private int turnCounter;

    private BBoard(int numOfTaxSquares) {
        instructionInstance = DInstruction.getInstance();
        squares = new BSquare[SQUARE_NUMBER];
        initSquares(numOfTaxSquares);
    }

    private void initSquares(int numOfTaxSquares) {
        int[] taxSquereLocations = new int[numOfTaxSquares];
        int temp;
        //crating random locations
        for(int i = 0; i < numOfTaxSquares; i++){
            temp =(int) ((Math.random() * SQUARE_NUMBER-1) + 2);
            taxSquereLocations[i] = temp;
        }

        //intilazing with regular  squeres
        for (int i = 0; i < SQUARE_NUMBER; ++i) {
            squares[i] = new BRegularSquare(i);
        }

        for(int i = 0; i < numOfTaxSquares; i++)
            squares[taxSquereLocations[i]] = new BTaxSquare(i);

    }

    public static BBoard getInstance(int numOfTaxSquares) {
        if(boardInstance == null){
            boardInstance = new BBoard(numOfTaxSquares);
        }
        return boardInstance;
    }
}