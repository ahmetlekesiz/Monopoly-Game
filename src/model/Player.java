package model;

public class Player {
    private String name;
    private int balance;
    private Piece piece;

    public Player(String name, int balance, Piece piece) {
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

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
