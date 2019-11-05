package DAL;

public class Instruction {

    public long countOfPlayers, startMoney, countOfTaxSquares, priceOfTaxSquares, priceOfGoSquare;

    private static Instruction instance;

    public Instruction(long countOfPlayers, long startMoney, long countOfTaxSquares, long priceOfTaxSquares, long priceOfGoSquare) {
        this.countOfPlayers = countOfPlayers;
        this.startMoney = startMoney;
        this.countOfTaxSquares = countOfTaxSquares;
        this.priceOfTaxSquares = priceOfTaxSquares;
        this.priceOfGoSquare = priceOfGoSquare;
    }

    public static Instruction getInstance() {
        return instance;
    }

    public static Instruction getInstance(long countOfPlayers, long startMoney, long countOfTaxSquares,
                                          long priceOfTaxSquares, long priceOfGoSquare) {
        if (instance == null) {
            instance = new Instruction(countOfPlayers, startMoney, countOfTaxSquares,
                    priceOfTaxSquares, priceOfGoSquare);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "countOfPlayers: " + countOfPlayers + "\nstartMoney: " + startMoney + "\ncountOfTaxSquares: "
                + countOfTaxSquares + "\npriceOfTaxSquares: " + priceOfTaxSquares + "\npriceOfGoSquare: " + priceOfGoSquare;
    }
}
