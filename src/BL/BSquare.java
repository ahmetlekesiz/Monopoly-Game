package BL;

import DAL.DPlayer;

public abstract class BSquare {
    private int Id;
    private final String SQUARE_TYPE = "NONE";

    public abstract void performOnLand(DPlayer player);

    public String getSQUARE_TYPE() {
        return SQUARE_TYPE;
    }
}
