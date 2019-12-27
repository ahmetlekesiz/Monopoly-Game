package main.java.BL.squares.communitychestcards;

import main.java.DAL.DPlayer;

public abstract class BCommunityCards {
    private String CARD_INFO;
    private int cardID;

    public abstract void performForCard(DPlayer dPlayer);

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String setCARD_INFO() {
        return CARD_INFO;
    }

    public void setCARD_INFO(String CARD_INFO) {
        this.CARD_INFO = CARD_INFO;
    }
}
