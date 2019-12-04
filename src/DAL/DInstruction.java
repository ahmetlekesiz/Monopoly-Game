package DAL;

/**
 * DInstruction Singleton class represents a data block for instructions of the game given in JSON File.
 * @author Muhammed Bera Koç
 * @version 1.0
 */
public class DInstruction {

    public long countOfPlayers, startMoney, countOfTaxSquares, priceOfTaxSquares, priceOfGoSquare, priceOfJailSquare;

    private static DInstruction instance;

    /**
     * <p>Constructor takes number of arguments and assigns it to the object.</p>
     *
     * @param countOfPlayers
     * @param startMoney
     * @param countOfTaxSquares
     * @param priceOfTaxSquares
     * @param priceOfGoSquare
     * @param priceOfJailSquare
     */
    private DInstruction(long countOfPlayers, long startMoney, long countOfTaxSquares, long priceOfTaxSquares, long priceOfGoSquare, long priceOfJailSquare) {
        this.countOfPlayers = countOfPlayers;
        this.startMoney = startMoney;
        this.countOfTaxSquares = countOfTaxSquares;
        this.priceOfTaxSquares = priceOfTaxSquares;
        this.priceOfGoSquare = priceOfGoSquare;
        this.priceOfJailSquare = priceOfJailSquare;
    }

    /**
     * Method to obtain Singleton object.
     *
     * @return DInstruction
     */
    public static DInstruction getInstance() {
        return instance;
    }

    public static DInstruction getInstance(long countOfPlayers, long startMoney, long countOfTaxSquares,
                                           long priceOfTaxSquares, long priceOfGoSquare, long priceOfJailSquare) {
        if (instance == null) {
            instance = new DInstruction(countOfPlayers, startMoney, countOfTaxSquares,
                    priceOfTaxSquares, priceOfGoSquare, priceOfJailSquare);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "countOfPlayers: " + countOfPlayers + "\nstartMoney: " + startMoney + "\ncountOfTaxSquares: "
                + countOfTaxSquares + "\npriceOfTaxSquares: " + priceOfTaxSquares + "\npriceOfGoSquare: " + priceOfGoSquare
                + "\npriceOfJailSquare:" + priceOfJailSquare;
    }
}
