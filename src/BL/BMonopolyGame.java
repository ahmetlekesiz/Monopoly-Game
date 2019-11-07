package BL;

import java.util.ArrayList;
import java.util.Iterator;

import Controller.CMonopolyGame;
import DAL.DPlayer;
import DAL.DInstruction;
import DAL.DPiece;
import UI.UITerminal;

public class BMonopolyGame implements BGameObserver {

    private static BMonopolyGame monopolyGameInstance = new BMonopolyGame();
    private ArrayList<BPlayer> players;
    private BBoard boardInstance;
    private UITerminal UITerminalInstance;
    private boolean isFirstRound;

    private BMonopolyGame() {
        players = new ArrayList<>();
        boardInstance = BBoard.getInstance();
        UITerminalInstance = CMonopolyGame.getInstance().UITerminal;
    }

    public static BMonopolyGame getInstance() {
        return monopolyGameInstance;
    }

    public void startGame(DInstruction gameInstructions){
        initPlayersByLettingThemRollingDiceAndPutInList(gameInstructions);

        int counter = 0;
        while(counter < 20) {
            listen();
            counter++;
        }
    }

    private void initPlayersByLettingThemRollingDiceAndPutInList(DInstruction gameInstructions) {
        int counter = (int) gameInstructions.countOfPlayers;
        while(counter != 0){
            players.add(new BPlayer(new DPlayer(DPiece.PIECE_TYPE.BATTLESHIP, (int) gameInstructions.startMoney)));
            counter--;
        }
        for (BPlayer player : players) {
            player.rollDice();
        }
        //Sorting player list by theirs currentDiceVal properties by decrementing order.
        players.sort((firstPlayer, secondPlayer) -> {
            if (firstPlayer.getDPlayer().getCurrentDiceVal() == secondPlayer.getDPlayer().getCurrentDiceVal())
                return 0;
            return firstPlayer.getDPlayer().getCurrentDiceVal() > secondPlayer.getDPlayer().getCurrentDiceVal() ? -1 : 1;
        });
        //After sorting players the piece types are setting.
        for(int i = 0; i < players.size(); i++){
            players.get(i).getDPlayer().setPiece_type(DPiece.PIECE_TYPE.values()[i]);
        }
    }

    @Override
    public void listen() {
        isFirstRound = true;
        if (players.size() != 1) {
            startTurn();
            if (isFirstRound) isFirstRound = false;
        }
    }

    private void startTurn() {
        for (Iterator<BPlayer> iterator = players.iterator(); iterator.hasNext();) {
            BPlayer currentPlayer = iterator.next();

            if (!currentPlayer.getDPlayer().isBankrupted()) {
                UITerminalInstance.printBeforeRollDice(currentPlayer.getDPlayer());

                currentPlayer.rollDice();
                currentPlayer.checkAndUpdatePlayer(currentPlayer.getDPlayer().getCurrentDiceVal(),
                        boardInstance.getSquares()[currentPlayer.getDPlayer().getLocation()], isFirstRound);

                UITerminalInstance.printAfterRollDice(currentPlayer.getDPlayer());

                if (currentPlayer.getDPlayer().isBankrupted()) {
                    iterator.remove();
                }
                //printDetails(currentPlayer);
            }
        }
    }

    private void printDetails(BPlayer player){
        System.out.println(player.getDPlayer().getPiece_type()+":\nBalance: "+player.getDPlayer().getBalance()+"\n" +
                " Location: "+player.getDPlayer().getLocation()+"\nCurrent Dice Value: "+player.getDPlayer().getCurrentDiceVal());
    }
}
