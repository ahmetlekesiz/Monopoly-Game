package BL;

import java.util.ArrayList;

import DAL.DPlayer;
import DAL.DInstruction;
import DAL.DPiece;

public class BMonopolyGame implements BGameObserver {

    private static BMonopolyGame monopolyGameInstance = new BMonopolyGame();
    private ArrayList<BPlayer> players;
    private BBoard boardInstance;

    public BMonopolyGame() {
        players = new ArrayList<>();
    }

    public static BMonopolyGame getInstance() {
        return monopolyGameInstance;
    }
    public void startGame(DInstruction gameInstructions){
        initPlayersByLettingThemRollingDiceandPutInList(gameInstructions);
        boardInstance=BBoard.getInstance((int)gameInstructions.countOfTaxSquares);
        int counter = 0;
        while(counter < 20){
            listen();
            counter++;
        }
    }

    private void initPlayersByLettingThemRollingDiceandPutInList(DInstruction gameInstructions) {
        int counter = (int)gameInstructions.countOfPlayers;

        while(counter != 0){
            players.add(new BPlayer(new DPlayer(DPiece.PIECE_TYPE.BATTLESHIP,(int)gameInstructions.startMoney)));
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
            players.get(i).getDPlayer().setPiece_type(DPiece.PIECE_TYPE.values()[i]);
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
                currentPlayer.rollDice();
                performActions(boardInstance,currentPlayer);
                currentPlayer.checkPlayer(currentPlayer.getDPlayer().getCurrentDiceVal(),boardInstance.getSquares()[currentPlayer.getDPlayer().getLocation()]);
            }
        }
    }

    private void performActions(BBoard instance,BPlayer player){
        instance.getSquares()[player.getDPlayer().getLocation()].performOnLand(player.getDPlayer());
    }

}
