package BL;

import DAL.DPlayer;

public class BPropertySquare extends BSquare {
    private final String SQUARE_TYPE = "PROPERTY_SQUARE";

    public BPropertySquare(PropertyType type){
        this.pType = type;
    }

    @Override
    public void performOnLand(DPlayer player) {

    }

    @Override
    public String getSQUARE_TYPE() {
        return this.getSQUARE_TYPE();
    }
}
