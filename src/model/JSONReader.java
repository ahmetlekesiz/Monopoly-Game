package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONReader {

    private JSONObject currentJSONObject;

    public JSONReader(String JSONFileName) {
        try {
            currentJSONObject = (JSONObject) new JSONParser().parse(new FileReader(JSONFileName));
            initInstructionObject();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private Object getValueUsingKey(String key) {
        return currentJSONObject.get(key);
    }

    private void initInstructionObject() {
        Instruction.getInstance(
                (Integer) getValueUsingKey("countOfPlayers"),
                (Integer) getValueUsingKey("startMoney"),
                (Integer) getValueUsingKey("countOfTaxSquare"),
                (Integer) getValueUsingKey("priceOfTaxSquare"),
                (Integer) getValueUsingKey("priceOfGoSquare")
        );
    }
}
