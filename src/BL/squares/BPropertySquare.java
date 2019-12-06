package BL.squares;

import BL.BPlayer;
import BL.BTerminal;
import DAL.DPlayer;

public class BPropertySquare extends BSquare {
    private String name;
    private final String SQUARE_TYPE = "PROPERTY_SQUARE";
    private BTerminal bTerminal = new BTerminal();

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
        if (renter == owner) return;
        bTerminal.printRentProcess(renter , this);
        renter.setBalance(renter.getBalance() - this.rent);
        owner.setBalance(owner.getBalance() + this.rent);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSQUARE_TYPE() {
        return this.SQUARE_TYPE;
    }
}
