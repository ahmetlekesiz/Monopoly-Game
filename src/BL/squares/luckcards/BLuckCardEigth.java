package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardEigth extends BLuckCards {
    private final String CARD_INFO = "Get out of Jail Free. This card may be kept until needed, or traded/sold.";
    private DPlayer cardOwner;

    @Override
    public void performForCard(DPlayer dPlayer) {
        setCardOwner(dPlayer);
    }

    @Override
    public String getCARD_INFO() {
        return this.CARD_INFO;
    }

    public DPlayer getCardOwner(DPlayer dPlayer) {
        return dPlayer;
    }

    public void setCardOwner(DPlayer dPlayer) {
        this.cardOwner = dPlayer;
    }
}
