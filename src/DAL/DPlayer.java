package DAL;

import BL.BDice;
import BL.BSquare;

public class DPlayer {
    private int balance, cycleCounter, totalDiceValue, roundValue, currentDiceVal;
    private boolean bankruptFlag;
    private BDice playerDice;
    private Piece.PIECE_TYPE piece_type;
    private BSquare location;
    public DPlayer(Piece.PIECE_TYPE piece_type,int balance) {
        playerDice = new BDice();
        this.piece_type = piece_type;
        this.balance = balance;
        this.cycleCounter=0;
        this.roundValue = 0;
        this.currentDiceVal = 0;
    }

    public int getCurrentDiceVal() { return currentDiceVal; }

    public void setCurrentDiceVal(int currentDiceVal) { this.currentDiceVal = currentDiceVal; }

    public void setPiece_type(Piece.PIECE_TYPE piece_type) {this.piece_type = piece_type;}

    public int getBalance() {
        return balance;
    }

    public int getCycleCounter() {
        return cycleCounter;
    }

    public int getTotalDiceValue() {
        return totalDiceValue;
    }

    public int getRoundValue() {
        return roundValue;
    }

    public BDice getPlayerDice() {return playerDice; }

    public boolean isBankrupted() {
        return bankruptFlag;
    }

    public Piece.PIECE_TYPE getPiece_type() {
        return piece_type;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCycleCounter(int cycleCounter) {
        this.cycleCounter = cycleCounter;
    }

    public void setTotalDiceValue(int totalDiceValue) {
        this.totalDiceValue = totalDiceValue;
    }

    public void setBankruptFlag(boolean bankruptFlag) {
        this.bankruptFlag = bankruptFlag;
    }

    public void setRoundValue(int roundValue) {
        this.roundValue = roundValue;
    }
}
