package BL.squares;

import BL.BPlayer;
import DAL.DPlayer;

public class BPropertySquare extends BSquare {
    private final String SQUARE_TYPE = "PROPERTY_SQUARE";

    public BPropertySquare(PropertyType type){
        this.pType = type;
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

    @Override
    public String getSQUARE_TYPE() {
        return this.getSQUARE_TYPE();
    }
}
