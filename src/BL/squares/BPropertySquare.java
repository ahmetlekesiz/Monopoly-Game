package BL.squares;

import BL.BPlayer;
import DAL.DPlayer;

public class BPropertySquare extends BSquare {
    private String name;
    private final String SQUARE_TYPE = "PROPERTY_SQUARE";

    public BPropertySquare(String name, PropertyType type, int rent, int price){
        this.pType = type;
        this.name = name;
        this.rent = rent;
        this.price = price;
    }

    @Override
    public void performOnLand(DPlayer player) {
        if(this.getOwnerOfSquare() != null){
            getRent(this.getOwnerOfSquare().getDPlayer(), player);
        }
    }

    public void getRent(DPlayer owner, DPlayer renter){
        int initialBalance = renter.getBalance();
        renter.setBalance(renter.getBalance() - this.getRent());
        if(renter.getBalance() < 0){
            owner.setBalance(owner.getBalance() + initialBalance);
        }else{
            owner.setBalance(owner.getBalance() + this.getRent());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSQUARE_TYPE() {
        return this.getSQUARE_TYPE();
    }
}
