package Controller;

/**
 * <h>Main</h>
 *
 * <p>Main class of Monopoly Game. Creating controller object of Monopoly Game and getting instructions.
 * Then, starting game by using Monopoly Game object.</p>
 *
 * @author Ahmet LEKESİZ
 * @version 1.0
 */
public class Main {

    public static final String INSTRUCTION_FILENAME = "game.json";
    public static final Integer PLACE_NUMBER = 40;

    public static void main(String[] args) {
        CMonopolyGame monopolyGame = CMonopolyGame.getInstance(INSTRUCTION_FILENAME);
        monopolyGame.start();
        /*BJailSquare bJailSquare = new BJailSquare(PropertyType.NOCOLOR);
        BPlayer bPlayer = new BPlayer(new DPlayer(DPiece.PieceType.CAT, 1000));
        bJailSquare.performOnLand(bPlayer.getDPlayer());
        bJailSquare.scanJailRecords();
        bJailSquare.scanJailRecords();
        bJailSquare.scanJailRecords();
        bJailSquare.scanJailRecords();
        bJailSquare.scanJailRecords();
        System.out.println(bPlayer.getDPlayer().getBalance());*/
    }
}
