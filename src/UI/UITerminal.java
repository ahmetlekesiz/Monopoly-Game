package UI;

import BL.BPlayer;
import Controller.CInstruction;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *  <h>UITerminal</h>
 *
 *  <p>UITerminal is the class to print all data of Monopoly Game.</p>
 *
 * @author Salih ÖZYURT
 * @version 1.0
 */

public class UITerminal {

    /**
     * <p>The method prints json file that we decide all properties of Monopoly Game. </p>
     * @return void
     */
    public void printCurrentJSONFile() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("PROPERTIES OF THE GAME");
        System.out.println("---------------------------------------------------------------------");
        System.out.println(CInstruction.getDInstruction());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("MONOPOLY GAME");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("git deneme");
    }

    /**
     * <p>The method prints data of players berofe roll dice.</p>
     *
     * @param bPlayer We use the parameter to reach data of players.
     * @return void
     */
    public void printBeforeRollDice(BPlayer bPlayer) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Player Type :" + bPlayer.getDPlayer().getPieceType());
        System.out.println("Player Turn Counter :" + bPlayer.getDPlayer().getPieceType().getValue());
        System.out.println("Player Cycle Counter :" + bPlayer.getDPlayer().getCycleCounter());
        System.out.println("Location Square :" + bPlayer.getDPlayer().getLocation());
        System.out.println("Player Current Balance :" + bPlayer.getDPlayer().getBalance());
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * <p>The method prints dice face and total dice values after current player roll dice.</p>
     *
     * @param diceValues The parameter contains dice values.
     * @return void
     */
    public void printDicesFaces(int[] diceValues){
        System.out.println("Rolling Dice : " + diceValues[0] + "+" + diceValues[1] + "=" + (diceValues[0] + diceValues[1]));
    }

    /**
     * <p>The method prints location where current player is in</p>
     *
     * @param squareLocation The parameter contains square type name such as TAX, GO or REGULAR.
     * @return void
     */
    public void printLocationType(String squareLocation){
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Square Type :" + squareLocation);
    }

    /**
     * <p>The method prints data of players after roll dice.</p>
     *
     * @param bPlayer We use the parameter to reach data of players.
     * @return void
     */
    public void printAfterRollDice(BPlayer bPlayer){
        System.out.println("Player Location :" + bPlayer.getDPlayer().getLocation());
        System.out.println("Player Balance After Rolling Dice :" + bPlayer.getDPlayer().getBalance());
        System.out.println("---------------------------------------------------------------------");
    }


    /**
     * <p>The method prints data of winner player.</p>
     *
     * @param bPlayer We use the parameter to reach data of winner player.
     * @return void
     */
    public void printWinnerPlayer(BPlayer bPlayer){
        System.out.println("*************************************************************************");
        System.out.println("GAME OVER!!!");
        System.out.println("*************************************************************************");
        System.out.println("WINNER PLAYER!!!");
        System.out.println("*************************************************************************");
        System.out.println("Player Name :" + bPlayer.getDPlayer().getPieceType());
        System.out.println("Player Location :" + bPlayer.getDPlayer().getLocation());
        System.out.println("Player Balance :" + bPlayer.getDPlayer().getBalance());
        System.out.println("*************************************************************************");
    }

    /**
     * <p>In the method, we sort the eliminated players for balance and print data of the players.</p>
     *
     * @param eliminatedList We use the parameter to reach data of eliminated players. The arraylist includes eliminated players.
     * @return void
     */
    public void printGameOver(ArrayList eliminatedList){
        System.out.println("ELIMINATED PLAYERS!!!");
        System.out.println("*************************************************************************");
        for (Iterator<BPlayer> iterator = eliminatedList.iterator(); iterator.hasNext();) {
            BPlayer eliminatedPlayer = iterator.next();
            System.out.println("Player Name :" + eliminatedPlayer.getDPlayer().getPieceType());
            System.out.println("Player Location :" + eliminatedPlayer.getDPlayer().getLocation());
            System.out.println("Player Balance :" + eliminatedPlayer.getDPlayer().getBalance());
            System.out.println("*************************************************************************");
        }
    }
}