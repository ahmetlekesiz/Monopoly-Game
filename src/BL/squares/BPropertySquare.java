package BL.squares;

import DAL.DPlayer;

public class BPropertySquare extends BSquare {
    private String name;
    private final String SQUARE_TYPE = "PROPERTY_SQUARE";

    public BPropertySquare(String name, PropertyType type, int rent, int price){
        this.pType = type;
        this.name = name;
        this.setRent(rent);
        this.setPrice(price);
    }

    @Override
    public void performOnLand(DPlayer player) {
        if(this.getOwnerOfSquare() != null){
            getRent(this.getOwnerOfSquare().getDPlayer(), player);
        }
    }

    public void getRent(DPlayer owner, DPlayer renter){
        renter.setBalance(renter.getBalance() - this.getRent());
        owner.setBalance(owner.getBalance() + this.getRent());
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSQUARE_TYPE() {
        return this.SQUARE_TYPE;
    }
}
