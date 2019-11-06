package BL;

import DAL.Piece;

import java.util.ArrayList;

public class BMonopolyGame implements BGameObserver {

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

    @Override
    public void listen() {
        if (players.size() != 1) {
            startTurn();
        }
    }

    private void startTurn() {
        for (int i = 0; i < players.size(); ++i) {
            BPlayer currentPlayer = players.get(i);
            if (!currentPlayer.getDPlayer().isBankrupted()) {
                currentPlayer.getDPlayer().getPlayerDice().rollDice();
            }
        }
    }
}
