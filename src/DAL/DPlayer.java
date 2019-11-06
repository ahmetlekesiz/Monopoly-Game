package DAL;

import BL.BDice;

public class DPlayer {
    private int balance, cycleCounter, totalDiceValue, roundValue, currentDiceVal;
    private boolean bankruptFlag;
    private BDice playerDice;
    private DPiece.PIECE_TYPE piece_type;

    public DPlayer(DPiece.PIECE_TYPE piece_type, int balance) {
        playerDice = new BDice();
        this.piece_type = piece_type;
        this.balance = balance;
        this.cycleCounter=0;
        this.roundValue = 0;
        this.currentDiceVal = 0;
    }

    public int getCurrentDiceVal() { return currentDiceVal; }

    public void setCurrentDiceVal(int currentDiceVal) { this.currentDiceVal = currentDiceVal; }

    public void setPiece_type(DPiece.PIECE_TYPE piece_type) {this.piece_type = piece_type;}

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

    public DPiece.PIECE_TYPE getPiece_type() {
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
