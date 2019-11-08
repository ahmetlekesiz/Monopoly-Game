package BL;

import DAL.DInstruction;

import java.util.ArrayList;

/**
 * <h>BBoard</h>
 *
 * <p>Board class in Business Layer. Creating squares by getting the number of them from Instruction. Then creating an Array List
 * of Squares and filling it. </p>
 *
 * @author Ahmet LEKESİZ
 * @version 1.0
 */
public class BBoard {

    private static final int SQUARE_NUMBER = 40;
    private BSquare[] squares;
    private static BBoard boardInstance;
    private DInstruction instructionInstance;
    private int countOfTaxSquares;

    private BBoard() {
        instructionInstance = DInstruction.getInstance();
        squares = new BSquare[SQUARE_NUMBER];
        countOfTaxSquares = (int) instructionInstance.countOfTaxSquares;
        initSquares();
    }
    /**
     *<p>Create an ArrayList of Squares.
     *Generate random location of taxSquares and declare the ArrayList.</p>
     *
     * @return void
     */
    private void initSquares() {
        ArrayList<Integer> taxSquareLocations = new ArrayList<>();
        int temp;
        for(int i = 0; i < countOfTaxSquares; i++){
            temp = (int) (Math.random() * SQUARE_NUMBER);
            while(taxSquareLocations.contains(temp) ){
                temp = (int) (Math.random() * SQUARE_NUMBER);
            }
            taxSquareLocations.add(temp);
        }

        for (int i = 0; i < SQUARE_NUMBER; ++i) {
            squares[i] = new BRegularSquare();
        }
        for(int i = 0; i < countOfTaxSquares; i++) {
            squares[taxSquareLocations.get(i)] = new BTaxSquare();
        }
        squares[0] = new BGoSquare();
    }

    public BSquare[] getSquares() {
        return squares;
    }

    public static BBoard getInstance() {
        if(boardInstance == null){
            boardInstance = new BBoard();
        }
        return boardInstance;
    }

}