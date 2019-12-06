package BL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import BL.squares.BPropertySquare;
import DAL.DPlayer;
import DAL.DInstruction;
import DAL.DPiece;

/**
 * <p>BMonopolyGame is MonopolyGame class in Business Layer. Main rules
 * of the game implemented in this class.</p>
 *
 * @author Mücahit Tanacıoğlu
 * @version 1.0
 */
public class BMonopolyGame implements BGameObserver {

    private static BMonopolyGame monopolyGameInstance = new BMonopolyGame();
    private ArrayList<BL.BPlayer> currentPlayers, eliminatedPlayers;
    private BBoard boardInstance;
    private BTerminal bTerminal = new BTerminal();
    private ArrayList<Integer> diceSumOfPlayers = new ArrayList<>();

    public BMonopolyGame() {
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
            currentPlayers.add(new BL.BPlayer(new DPlayer(DPiece.PieceType.BATTLESHIP, (int) gameInstructions.startMoney)));
            counter--;
        }

        //Rolling dice for each players.
        for (BL.BPlayer player : currentPlayers) {
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
            currentPlayers.get(i).getDPlayer().setPieceType(DPiece.PieceType.values()[i]);
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
        bTerminal.printWinnerPlayer(currentPlayers.get(0));
        bTerminal.printGameOver(eliminatedPlayers);
    }
    /**
     *<p>Each player plays their turn by their order, if player get bankrupt removes from list.</p>
     * <p>Listen method runs to watch the player.
     * This method runs until just one player left.</p>
     *@return void
     */
    private void startTurn() {
        for (Iterator<BL.BPlayer> iterator = currentPlayers.iterator(); iterator.hasNext();) {
            BL.BPlayer currentPlayer = iterator.next();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!currentPlayer.getDPlayer().isBankrupted()) {
                bTerminal.printBeforeRollDice(currentPlayer);
                if (currentPlayer.getDPlayer().isArrested()) {
                    if (boardInstance.getJailSquares().get(0).getJailRecords().containsKey(currentPlayer.getDPlayer())) {
                        boardInstance.getJailSquares().get(0).scanPlayerRecord(currentPlayer.getDPlayer());
                    } else if (boardInstance.getJailSquares().get(1).getJailRecords().containsKey(currentPlayer.getDPlayer())) {
                        boardInstance.getJailSquares().get(1).scanPlayerRecord(currentPlayer.getDPlayer());
                    }
                }
                if (!currentPlayer.getDPlayer().isArrested()) {
                    currentPlayer.rollDice();
                    currentPlayer.getDPlayer().setTotalDiceValue(currentPlayer.getDPlayer().getTotalDiceValue() +
                            currentPlayer.getDPlayer().getCurrentDiceVal());
                    BL.squares.BSquare currentSquare = boardInstance.getSquares()[currentPlayer.getDPlayer().getLocation()];
                    currentPlayer.checkAndUpdatePlayer(currentPlayer.getDPlayer().getCurrentDiceVal(),
                            currentSquare);
                    //Calling buying function.
                    if(currentSquare.getOwnerOfSquare() == null &&
                            currentSquare.getSQUARE_TYPE().equals("PROPERTY_SQUARE") &&
                            currentPlayer.isAbleToBuy((BPropertySquare) currentSquare))
                    {
                        bTerminal.printBuyProcess(currentPlayer,currentSquare);
                        currentPlayer.buy((BPropertySquare) currentSquare);
                        currentSquare.setOwnerOfSquare(currentPlayer);
                    }
                    bTerminal.printAfterRollDice(currentPlayer, currentSquare);

                    if (currentPlayer.getDPlayer().isBankrupted()) {
                        eliminatedPlayers.add(currentPlayer);
                        iterator.remove();
                    }
                }
            }
        }
    }

    public ArrayList<BPlayer> getPlayers(){
        return this.currentPlayers;
    }

    public BTerminal getBTerminal() {
        return bTerminal;
    }
}
