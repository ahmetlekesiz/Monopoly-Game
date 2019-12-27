package main.java.BL.squares;

import main.java.BL.BTerminal;
import main.java.BL.squares.luckcards.*;
import main.java.DAL.DPlayer;

import java.util.ArrayList;

public class BLuckSquare extends BSquare {
    private final String SQUARE_TYPE = "LUCK_SQUARE";
    private ArrayList<BLuckCards> luckCards = new ArrayList<>();
    private int totalNumberCard = 16;
    private BTerminal bTerminal = new BTerminal();

    public BLuckSquare(PropertyType propertyType) {
        this.pType = propertyType;
        initLuckCards();
    }

    private void initLuckCards(){
        luckCards.add(new BLuckCardOne());
        luckCards.add(new BLuckCardTwo());
        luckCards.add(new BLuckCardThree());
        luckCards.add(new BLuckCardFour());
        luckCards.add(new BLuckCardFive());
        luckCards.add(new BLuckCardSix());
        luckCards.add(new BLuckCardSeven());
        luckCards.add(new BLuckCardEigth());
        luckCards.add(new BLuckCardNine());
        luckCards.add(new BLuckCardTen());
        luckCards.add(new BLuckCardEleven());
        luckCards.add(new BLuckCardTwelve());
        luckCards.add(new BLuckCardThirteen());
        luckCards.add(new BLuckCardFourteen());
        luckCards.add(new BLuckCardFifteen());
        luckCards.add(new BLuckCardSixteen());
    }

    @Override
    public void performOnLand(DPlayer player) {
        int temp = (int) (Math.random() * totalNumberCard);
        bTerminal.printCard(luckCards.get(temp).setCARD_INFO());
        luckCards.get(temp).performForCard(player);
    }

    @Override
    public String getSQUARE_TYPE() {
        return this.SQUARE_TYPE;
    }
}
