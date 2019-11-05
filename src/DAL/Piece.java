package DAL;

public class Piece {

    public enum PIECE_TYPE {
        DOG,
        TOP_HAT,
        BOOT,
        CAT,
        WHEELBARROW,
        RACING_CAR,
        BATTLESHIP,
        THIMBLE
    }

    private String type;

    public Piece(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
