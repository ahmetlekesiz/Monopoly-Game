package BL;

import DAL.Piece;

public class BPlayer {

    private int balance, cycleCounter, totalDiceValue;
    private boolean bankruptFlag;
    private Piece.PIECE_TYPE piece_type;

    public BPlayer(int balance, int cycleCounter, int totalDiceValue, boolean bankruptFlag, Piece.PIECE_TYPE piece_type) {
        this.balance = balance;
        this.cycleCounter = cycleCounter;
        this.totalDiceValue = totalDiceValue;
        this.bankruptFlag = bankruptFlag;
        this.piece_type = piece_type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCycleCounter() {
        return cycleCounter;
    }

    public void setCycleCounter(int cycleCounter) {
        this.cycleCounter = cycleCounter;
    }

    public int getTotalDiceValue() {
        return totalDiceValue;
    }

    public void setTotalDiceValue(int totalDiceValue) {
        this.totalDiceValue = totalDiceValue;
    }

    public boolean isBankruptFlag() {
        return bankruptFlag;
    }

    public void setBankruptFlag(boolean bankruptFlag) {
        this.bankruptFlag = bankruptFlag;
    }

    public Piece.PIECE_TYPE getPiece_type() {
        return piece_type;
    }

    public void setPiece_type(Piece.PIECE_TYPE piece_type) {
        this.piece_type = piece_type;
    }

}
