package Controller;

import BL.BBoard;
import BL.squares.BSquare;
import DAL.DInstruction;
import DAL.DJSONReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

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
    }
}
