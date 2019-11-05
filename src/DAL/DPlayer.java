package DAL;

public class DPlayer {
    private String name;
    private int balance;
    private DPiece piece;

    public DPlayer(String name, int balance, DPiece piece) {
        this.name = name;
        this.balance = balance;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public DPiece getPiece() {
        return piece;
    }

    public void setPiece(DPiece piece) {
        this.piece = piece;
    }
}
