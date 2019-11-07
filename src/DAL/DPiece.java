package DAL;

public class DPiece {

    public enum PIECE_TYPE {
        DOG(0),
        TOP_HAT(1),
        BOOT(2),
        CAT(3),
        WHEELBARROW(4),
        RACING_CAR(5),
        BATTLESHIP(6),
        THIMBLE(7);

        private int value;

        PIECE_TYPE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
