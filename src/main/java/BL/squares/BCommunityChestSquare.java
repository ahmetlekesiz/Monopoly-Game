package BL.squares;

import BL.BTerminal;
import BL.squares.communitychestcards.*;
import DAL.DPlayer;

import java.util.ArrayList;

public class BCommunityChestSquare extends BSquare {
    private final String SQUARE_TYPE = "COMMUNITY_SQUARE";
    private ArrayList<BCommunityCards> communityChestCards = new ArrayList<>();
    private int totalNumberCard = 17;
    private BTerminal bTerminal = new BTerminal();


    public BCommunityChestSquare(PropertyType propertyType) {
        this.pType = propertyType;
        initCommunityCards();
    }

    private void initCommunityCards(){
        communityChestCards.add(new BCommunityCardOne());
        communityChestCards.add(new BCommunityCardTwo());
        communityChestCards.add(new BCommunityCardThree());
        communityChestCards.add(new BCommunityCardFour());
        communityChestCards.add(new BCommunityCardFive());
        communityChestCards.add(new BCommunityCardSix());
        communityChestCards.add(new BCommunityCardSeven());
        communityChestCards.add(new BCommunityCardEigth());
        communityChestCards.add(new BCommunityCardNine());
        communityChestCards.add(new BCommunityCardTen());
        communityChestCards.add(new BCommunityCardEleven());
        communityChestCards.add(new BCommunityCardTwelve());
        communityChestCards.add(new BCommunityCardThirteen());
        communityChestCards.add(new BCommunityCardFourteen());
        communityChestCards.add(new BCommunityCardFifteen());
        communityChestCards.add(new BCommunityCardSixteen());
        communityChestCards.add(new BCommunityCardSeventeen());
    }

    @Override
    public void performOnLand(DPlayer player) {
        int temp = (int) (Math.random() * totalNumberCard);
        bTerminal.printCard(communityChestCards.get(temp).setCARD_INFO());
        communityChestCards.get(temp).performForCard(player);
    }

    @Override
    public String getSQUARE_TYPE() {
        return this.SQUARE_TYPE;
    }
}
