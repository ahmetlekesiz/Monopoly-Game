package BL;

import java.util.ArrayList;
import java.util.Iterator;

import DAL.DPlayer;
import DAL.DInstruction;
import DAL.DPiece;

/***
 *BMonopolyGame is MonopolyGame class in Business Layer. Main rules
 * of the game implemented in this class.
 *
 * @author Ahmet Lekesiz
 * @version 1.0
 * @since 11.
 */
public class BMonopolyGame implements BGameObserver {

    private static BMonopolyGame monopolyGameInstance = new BMonopolyGame();
    private ArrayList<BPlayer> players;
    private BBoard boardInstance;
    private BTerminal bTerminal = new BTerminal();
    private boolean isFirstRound;
    private ArrayList<Integer> diceSumOfPlayers = new ArrayList<Integer>();

    private BMonopolyGame() {
        players = new ArrayList<>();
        boardInstance = BBoard.getInstance();
    }

    public static BMonopolyGame getInstance() {
        return monopolyGameInstance;
    }

    /**
     *<p>Takes initial data of the game and passing it into initPlayersByLettingThemRollingDiceAndPutInList method
     *for creating players and putting them into a list.</p>
     * <p>Listen method runs to watch the player.
     * This method runs until just one player left.</p>
     *
     * @param gameInstructions A DInstruction object which is contain initial data for game.
     * @return void
     */
    public void startGame(DInstruction gameInstructions){
        initPlayersByLettingThemRollingDiceAndPutInList(gameInstructions);

        int counter = 0;
        while(counter<30) {
            listen();
            counter++;
        }
    }

    private void initPlayersByLettingThemRollingDiceAndPutInList(DInstruction gameInstructions) {
        int counter = (int) gameInstructions.countOfPlayers;
        int diceSum;

        while(counter != 0){
            players.add(new BPlayer(new DPlayer(DPiece.PIECE_TYPE.BATTLESHIP, (int) gameInstructions.startMoney)));
            counter--;
        }

        //Rolling dice for each players.
        for (BPlayer player : players) {
            diceSum = player.rollDice();
            //Checking if the diceSum same with other players.
            while(checkIfDiceSumExist(diceSumOfPlayers, diceSum)){
                diceSum = player.rollDice();
            }
            diceSumOfPlayers.add(diceSum);
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

    /**
     *<p>Returns true if diceSum exist before, returns false if diceSum
     * does not exist in the list.</p>
     *
     * @param diceSumOfPlayers list of diceSum for each players in the game.
     * @param diceSum integer value of dice sum of current player.
     * @return boolean
     */
    private boolean checkIfDiceSumExist(ArrayList<Integer> diceSumOfPlayers, int diceSum){
        for (int i = 0; i < diceSumOfPlayers.size() ; i++) {
            if(diceSumOfPlayers.get(i).equals(diceSum)){
                return true;
            }
        }
        return false;
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
                bTerminal.printBeforeRollDice(currentPlayer.getDPlayer());

                currentPlayer.rollDice();
                currentPlayer.checkAndUpdatePlayer(currentPlayer.getDPlayer().getCurrentDiceVal(),
                        boardInstance.getSquares()[currentPlayer.getDPlayer().getLocation()], isFirstRound);

               //printDetails(currentPlayer);

                bTerminal.printLocationType(boardInstance.getSquares()[currentPlayer.getDPlayer().getLocation()].getSQUARE_TYPE());
                bTerminal.printAfterRollDice(currentPlayer.getDPlayer());

                if (currentPlayer.getDPlayer().isBankrupted()) {
                    iterator.remove();
                }
            }
        }
    }

    private void printDetails(BPlayer player){
        System.out.println(player.getDPlayer().getPiece_type()+":\nBalance: "+player.getDPlayer().getBalance()+"\n" +
                " Location: "+player.getDPlayer().getLocation()+"\nCurrent Dice Value: "+player.getDPlayer().getCurrentDiceVal());
    }
}
