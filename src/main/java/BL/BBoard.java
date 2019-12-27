package main.java.BL;

import BL.squares.*;
import BL.squares.BCommunityChestSquare;
import BL.squares.BGoSquare;
import BL.squares.BPropertySquare;
import BL.squares.BRegularSquare;
import BL.squares.BSquare;
import BL.squares.PropertyType;
import main.java.DAL.DInstruction;
import main.java.BL.squares.BJailSquare;
import main.java.Controller.Main;

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
    private ArrayList<BJailSquare> jailSquares;

    private BBoard() {
        instructionInstance = DInstruction.getInstance();
        squares = new BSquare[SQUARE_NUMBER];
        jailSquares = new ArrayList<>();
        initSquares();
    }
    /**
     *<p>Create an ArrayList of Squares.
     *Generate random location of taxSquares and declare the ArrayList.</p>
     *
     * @return void
     */
    private void initSquares() {
        ArrayList<String>[] map = DInstruction.getInstance().places;
        for (int i = 0; i < Main.PLACE_NUMBER; ++i) {
            if (map[i].size() == 2) {
                switch (map[i].get(0)) {
                    case "Go": {
                        squares[i] = new BGoSquare(PropertyType.values()[Integer.parseInt(map[i].get(1))]);
                        break;
                    }
                    case "Luck": {
                        squares[i] = new BL.squares.BLuckSquare(PropertyType.values()[Integer.parseInt(map[i].get(1))]);
                        break;
                    }
                    case "CommunityChest": {
                        squares[i] = new BCommunityChestSquare(PropertyType.values()[Integer.parseInt(map[i].get(1))]);
                        break;
                    }
                    case "Jail": {
                        squares[i] = new BJailSquare(PropertyType.values()[Integer.parseInt(map[i].get(1))]);
                        jailSquares.add((BJailSquare) squares[i]);
                        break;
                    }
                    case "Tax": {
                        squares[i] = new BL.squares.BTaxSquare(PropertyType.values()[Integer.parseInt(map[i].get(1))]);
                        break;
                    }
                    case "Regular":
                    case "Water Works":
                    case "Electric Company": {
                        squares[i] = new BRegularSquare(PropertyType.values()[Integer.parseInt(map[i].get(1))]);
                        break;
                    }
                    case "Ferry": squares[i] = new BRegularSquare(PropertyType.values()[Integer.parseInt(map[i].get(1))]);
                }
            } else {
                squares[i] = new BPropertySquare(map[i].get(0), PropertyType.values()[Integer.parseInt(map[i].get(1))],
                        Integer.parseInt(map[i].get(2)), Integer.parseInt(map[i].get(3)));
            }
        }
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

    public ArrayList<BJailSquare> getJailSquares() {
        return jailSquares;
    }
}