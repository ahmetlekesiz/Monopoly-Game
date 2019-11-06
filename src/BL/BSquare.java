package BL;

import DAL.DPlayer;

public class BSquare {
    private int Id;
    private final String SQUARE_TYPE = "NONE";

    public void performOnLand(DPlayer player){
        player.setLocation(this.Id);
    };

    public String getSQUARE_TYPE() {
        return SQUARE_TYPE;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public BSquare(){

    }
}
