package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardOne extends BLuckCards{
    private final String CARD_INFO = "You have won a crossword competition. Collect $100";

    @Override
    public void performForCard(DPlayer dPlayer) {
        dPlayer.setBalance(dPlayer.getBalance()+100);
    }

    @Override
    public String getCARD_INFO() {
        return this.CARD_INFO;
    }
}
