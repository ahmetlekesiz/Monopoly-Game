package BL.squares.luckcards;

import DAL.DPlayer;

public class BLuckCardEigth extends BLuckCards {
    private DPlayer cardOwner;

    public BLuckCardEigth() {
        setCARD_INFO("Get out of Jail Free. This card may be kept until needed, or traded/sold.");
        setCardID(8);
    }

    @Override
    public void performForCard(DPlayer dPlayer) {
        setCardOwner(dPlayer);
    }

    public DPlayer getCardOwner(DPlayer dPlayer) {
        return dPlayer;
    }

    public void setCardOwner(DPlayer dPlayer) {
        this.cardOwner = dPlayer;
    }
}
