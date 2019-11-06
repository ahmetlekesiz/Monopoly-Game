package BL;

import java.util.ArrayList;

public class BMonopolyGame {

    private static BMonopolyGame monopolyGameInstance = new BMonopolyGame();
    private ArrayList<BPlayer> players;
    private BBoard boardInstance;

    private BMonopolyGame() {
        players = new ArrayList<>();
        boardInstance = BBoard.getInstance();
    }

    public static BMonopolyGame getInstance() {
        return monopolyGameInstance;
    }

}
