package BL.squares;

import BL.squares.luckcards.BLuckCardOne;
import BL.squares.luckcards.BLuckCardTwo;
import BL.squares.luckcards.BLuckCards;
import DAL.DPlayer;

import java.util.ArrayList;

public class BLuckSquare extends BSquare{
    private final String SQUARE_TYPE = "LUCK_SQUARE";
    private ArrayList<BLuckCards> luckCards = new ArrayList<>();
    private int totalNumberCard = 2;

    public BLuckSquare(){
        initLuckCards();
    }

    private void initLuckCards(){
        luckCards.add(new BLuckCardOne());
        luckCards.add(new BLuckCardTwo());
    }

    @Override
    public void performOnLand(DPlayer player) {
        int temp = (int) (Math.random() * totalNumberCard);
        luckCards.get(temp).performForCard(player);
    }

    @Override
    public String getSQUARE_TYPE() {
        return this.SQUARE_TYPE;
    }
}
