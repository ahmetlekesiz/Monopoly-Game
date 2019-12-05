package BL.squares.luckcards;

import BL.BMonopolyGame;
import BL.BPlayer;
import DAL.DInstruction;
import DAL.DPlayer;

import java.util.ArrayList;

public class BLuckCardFifteen extends BLuckCards {
    private final String CARD_INFO = "You have been elected Chairman of the Board. Pay each player $50. ";
    private ArrayList<BPlayer> otherPlayer;
    private BMonopolyGame playerArray;
    private DPlayer tempDPlayer;

    @Override
    public void performForCard(DPlayer dPlayer) {
        playerArray = new BMonopolyGame();
        otherPlayer = playerArray.getPlayers();
        int counter = (int) DInstruction.getInstance().countOfPlayers;
        while (counter != 0){
            tempDPlayer = otherPlayer.get(counter).getDPlayer();
            if (tempDPlayer != dPlayer){
                dPlayer.setBalance(dPlayer.getBalance() - 50);
                tempDPlayer.setBalance(tempDPlayer.getBalance() + 50);
            }
            counter--;
        }

    }

    @Override
    public String getCARD_INFO() {
        return this.CARD_INFO;
    }
}
