package BL;

import DAL.DPlayer;

public class BRegularSquare extends BSquare {

    private final String SQUARE_TYPE = "REGULAR_SQUARE";

    public BRegularSquare(int id){
        this.setId(id);
    }
    @Override
    public void performOnLand(DPlayer player) {
        player.setLocation(this.getId());
    }

}
