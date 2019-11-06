package DAL;

import BL.BDice;

public class DPlayer {
    private int balance, cycleCounter, totalDiceValue, roundValue;
    private boolean bankruptFlag;
    private BDice playerDice;
    private Piece.PIECE_TYPE piece_type;

    public DPlayer(Piece.PIECE_TYPE piece_type) {
        playerDice = new BDice();
        this.piece_type = piece_type;
    }

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

    public boolean isBankruptFlag() {
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
