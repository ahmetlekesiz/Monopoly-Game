package BL.squares;

import BL.BPlayer;
import DAL.DPlayer;

/**
 * <h>BSquare</h>
 *
 * <p>The abstract class is prototype for other square class such as Tax Square, Regular Square and Go Square.</p>
 *
 * @author Salih ÖZYURT
 * @version 1.0
 */
public abstract class BSquare {
    PropertyType pType;
    private BPlayer ownerOfSquare = null;
    private int rent;
    private int price;

    public  abstract void performOnLand(DPlayer player);

    public abstract String getSQUARE_TYPE();

    public BPlayer getOwnerOfSquare() {
        return ownerOfSquare;
    }

    public void setOwnerOfSquare(BPlayer ownerOfSquare) {
        this.ownerOfSquare = ownerOfSquare;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
