package DAL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class DJSONReader {

    private JSONObject currentJSONObject;

    public DJSONReader(String JSONFileName) {
        try {
            currentJSONObject = (JSONObject) new JSONParser().parse(new FileReader(JSONFileName));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public Object getValueUsingKey(String key) {
        return currentJSONObject.get(key);
    }

    public void initInstructionObject() {
        DInstruction.getInstance(
                (Long) getValueUsingKey("countOfPlayers"),
                (Long) getValueUsingKey("startMoney"),
                (Long) getValueUsingKey("countOfTaxSquare"),
                (Long) getValueUsingKey("priceOfTaxSquare"),
                (Long) getValueUsingKey("priceOfGoSquare")
        );
    }
}
