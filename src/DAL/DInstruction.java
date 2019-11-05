package DAL;

public class DInstruction {

    public long countOfPlayers, startMoney, countOfTaxSquares, priceOfTaxSquares, priceOfGoSquare;

    private static DInstruction instance;

    public DInstruction(long countOfPlayers, long startMoney, long countOfTaxSquares, long priceOfTaxSquares, long priceOfGoSquare) {
        this.countOfPlayers = countOfPlayers;
        this.startMoney = startMoney;
        this.countOfTaxSquares = countOfTaxSquares;
        this.priceOfTaxSquares = priceOfTaxSquares;
        this.priceOfGoSquare = priceOfGoSquare;
    }

    public static DInstruction getInstance() {
        return instance;
    }

    public static DInstruction getInstance(long countOfPlayers, long startMoney, long countOfTaxSquares,
                                           long priceOfTaxSquares, long priceOfGoSquare) {
        if (instance == null) {
            instance = new DInstruction(countOfPlayers, startMoney, countOfTaxSquares,
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
