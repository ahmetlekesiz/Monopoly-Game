package BL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import DAL.DPlayer;
import DAL.Instruction;
import DAL.Piece;

public class BMonopolyGame implements BGameObserver {

    private static BMonopolyGame monopolyGameInstance = new BMonopolyGame();
    private ArrayList<BPlayer> players;
    private BBoard boardInstance;

    public BMonopolyGame() {
        players = new ArrayList<>();
        boardInstance = BBoard.getInstance();
    }

    public static BMonopolyGame getInstance() {
        return monopolyGameInstance;
    }
    public void startGame(Instruction gameInstructions){
        initPlayersByLettingThemRollingDiceandPutInList(gameInstructions);
    }

    private void initPlayersByLettingThemRollingDiceandPutInList(Instruction gameInstructions) {
        int counter = (int)gameInstructions.countOfPlayers;

        while(counter != 0){
            players.add(new BPlayer(new DPlayer(Piece.PIECE_TYPE.BATTLESHIP,(int)gameInstructions.startMoney)));
            counter--;
        }

        for (BPlayer player : players) {
            player.rollDice();
        }

        //Sorting player list by theirs currentDiceVal properties by decrementing order.
        players.sort((p1, p2) -> {
            if (p1.getDPlayer().getCurrentDiceVal() == p2.getDPlayer().getCurrentDiceVal())
                return 0;
            return p1.getDPlayer().getCurrentDiceVal() > p2.getDPlayer().getCurrentDiceVal() ? -1 : 1;
        });
        //After sorting players the piece types are setting.
        for(int i=0;i<players.size();i++){
            players.get(i).getDPlayer().setPiece_type(Piece.PIECE_TYPE.values()[i]);
        }


    }


    @Override
    public void listen() {
        if (players.size() != 1) {
            startTurn();
        }
    }

    private void startTurn() {
        for (BPlayer currentPlayer : players) {
            if (!currentPlayer.getDPlayer().isBankrupted()) {
                currentPlayer.getDPlayer().getPlayerDice().rollDice();
            }
        }
    }

}
