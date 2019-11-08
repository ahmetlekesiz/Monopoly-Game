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
 * @author Mücahit Tanacıoğlu
 * @version 1.0
 * @since 11.
 */
public class BMonopolyGame implements BGameObserver {

    private static BMonopolyGame monopolyGameInstance = new BMonopolyGame();
    private ArrayList<BPlayer> currentPlayers, eliminatedPlayers;
    private BBoard boardInstance;
    private BTerminal bTerminal = new BTerminal();
    private ArrayList<Integer> diceSumOfPlayers = new ArrayList<>();

    private BMonopolyGame() {
        currentPlayers = new ArrayList<>();
        boardInstance = BBoard.getInstance();
        eliminatedPlayers = new ArrayList<>();
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
        listen();
    }

    /**
     *<p>Takes initial data of the game and create players, after that to arrange order of players, makes them roll dice</p>
     * <p>Listen method runs to watch the player.
     * This method runs until just one player left.</p>
     *
     * @param gameInstructions A DInstruction object which is contain initial data for game.
     * @return void
     */

    private void initPlayersByLettingThemRollingDiceAndPutInList(DInstruction gameInstructions) {
        int counter = (int) gameInstructions.countOfPlayers;
        int diceSum;

        while(counter != 0){
            currentPlayers.add(new BPlayer(new DPlayer(DPiece.PIECE_TYPE.BATTLESHIP, (int) gameInstructions.startMoney)));
            counter--;
        }

        //Rolling dice for each players.
        for (BPlayer player : currentPlayers) {
            diceSum = player.rollDice();
            //Checking if the diceSum same with other players.
            while(checkIfDiceSumExist(diceSumOfPlayers, diceSum)){
                diceSum = player.rollDice();
            }
            diceSumOfPlayers.add(diceSum);
        }

        //Sorting player list by theirs currentDiceVal properties by decrementing order.
        currentPlayers.sort((firstPlayer, secondPlayer) -> {
            if (firstPlayer.getDPlayer().getCurrentDiceVal() == secondPlayer.getDPlayer().getCurrentDiceVal())
                return 0;
            return firstPlayer.getDPlayer().getCurrentDiceVal() > secondPlayer.getDPlayer().getCurrentDiceVal() ? -1 : 1;
        });
        //After sorting players the piece types are setting.
        for(int i = 0; i < currentPlayers.size(); i++){
            currentPlayers.get(i).getDPlayer().setPiece_type(DPiece.PIECE_TYPE.values()[i]);
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
    /**
     *<p>Starts game turn and if a player eliminated ,stores them.</p>
     * <p>Listen method runs to watch the player.
     * This method runs until just one player left.</p>
     *@return void
     */
    @Override
    public void listen() {
        while (currentPlayers.size() != 1) {
            startTurn();
        }
        eliminatedPlayers.sort((firstPlayer, secondPlayer) -> {
            if(firstPlayer.getDPlayer().getBalance() == secondPlayer.getDPlayer().getBalance()) return 0;
            return firstPlayer.getDPlayer().getBalance() > secondPlayer.getDPlayer().getBalance() ? -1 : 1;
        });
        bTerminal.printWinnerPlayer(currentPlayers.get(0).getDPlayer());
        bTerminal.printGameOver(eliminatedPlayers);
    }
    /**
     *<p>Each player plays their turn by their order, if player get bankrupt removes from list.</p>
     * <p>Listen method runs to watch the player.
     * This method runs until just one player left.</p>
     *@return void
     */
    private void startTurn() {
        for (Iterator<BPlayer> iterator = currentPlayers.iterator(); iterator.hasNext();) {
            BPlayer currentPlayer = iterator.next();
            if (!currentPlayer.getDPlayer().isBankrupted()) {
                bTerminal.printBeforeRollDice(currentPlayer.getDPlayer());

                currentPlayer.rollDice();

                currentPlayer.getDPlayer().setTotalDiceValue(currentPlayer.getDPlayer().getTotalDiceValue() +
                        currentPlayer.getDPlayer().getCurrentDiceVal());

                currentPlayer.checkAndUpdatePlayer(currentPlayer.getDPlayer().getCurrentDiceVal(),
                        boardInstance.getSquares()[currentPlayer.getDPlayer().getLocation()]);

                bTerminal.printLocationType(boardInstance.getSquares()[currentPlayer.getDPlayer().getLocation()].getSQUARE_TYPE());
                bTerminal.printAfterRollDice(currentPlayer.getDPlayer());

                if (currentPlayer.getDPlayer().isBankrupted()) {
                    eliminatedPlayers.add(currentPlayer);
                    iterator.remove();
                }
            }
        }
    }
}
