package BL;

public interface BPlayerObserver {

    void checkAndUpdatePlayer(int currentDiceValue, BSquare currentSquare, boolean isFirstRound);
}
