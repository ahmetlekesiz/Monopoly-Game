package BL;

public class BDice {

    public int[] rollDice() {
        int[] diceArray = new int[2];
        double randomDouble = (Math.random() * 6) + 1;
        diceArray[0] = (int) randomDouble;
        randomDouble = (Math.random() * 6) + 1;
        diceArray[1] = (int) randomDouble;
        return diceArray;
    }
}
