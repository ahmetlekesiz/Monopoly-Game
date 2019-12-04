package BL;


import DAL.DPlayer;

import java.util.HashMap;

public class BJailSquare extends BSquare{

    private HashMap<DPlayer, Integer> jailRecords;
    private final int JAIL_PRICE = 25;

    public BJailSquare() {
        jailRecords = new HashMap<>();
    }

    @Override
    public void performOnLand(DPlayer player) {
        jailRecords.put(player, 0);
        player.setArrested(true);
    }

    public void scanJailRecords() {
        for (DPlayer currentPlayer: jailRecords.keySet()) {
            int stayCount = jailRecords.get(currentPlayer);
            if (stayCount < 3) {
                int[] currentDiceValues = currentPlayer.getPlayerDice().rollDice();
                if (currentDiceValues[0] == currentDiceValues[1]) {
                    currentPlayer.setArrested(false);
                }
                jailRecords.put(currentPlayer, ++stayCount);
            } else {
                currentPlayer.setBalance(currentPlayer.getBalance() - JAIL_PRICE);
                currentPlayer.setArrested(false);
            }
        }
    }

    @Override
    public String getSQUARE_TYPE() {
        return null;
    }
}
