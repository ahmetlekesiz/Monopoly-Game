package model;

public class Instruction {

    public int countOfPlayers, startMoney, countOfTaxSquares, priceOfTaxSquares, priceOfGoSquare;

    private static Instruction instance;

    public Instruction(int countOfPlayers, int startMoney, int countOfTaxSquares, int priceOfTaxSquares, int priceOfGoSquare) {
        this.countOfPlayers = countOfPlayers;
        this.startMoney = startMoney;
        this.countOfTaxSquares = countOfTaxSquares;
        this.priceOfTaxSquares = priceOfTaxSquares;
        this.priceOfGoSquare = priceOfGoSquare;
    }

    public static Instruction getInstance() {
        return instance;
    }

    public static Instruction getInstance(int countOfPlayers, int startMoney, int countOfTaxSquares,
                                          int priceOfTaxSquares, int priceOfGoSquare) {
        if (instance == null) {
            instance = new Instruction(countOfPlayers, startMoney, countOfTaxSquares,
                    priceOfTaxSquares, priceOfGoSquare);
        }
        return instance;
    }
}
