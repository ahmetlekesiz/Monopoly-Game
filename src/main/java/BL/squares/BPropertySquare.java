package main.java.BL.squares;

import main.java.BL.BTerminal;
import main.java.DAL.DPlayer;

public class BPropertySquare extends BSquare {
    private String name;
    private final String SQUARE_TYPE = "PROPERTY_SQUARE";
    private BTerminal bTerminal = new BTerminal();
    private boolean hasHouse;
    private boolean hasHotel;

    public BPropertySquare(String name, PropertyType type, int rent, int price){
        this.pType = type;
        this.name = name;
        this.rent = rent;
        this.price = price;
        this.hasHouse = false;
        this.hasHotel = false;
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

    public boolean getHasHouse() {
        return hasHouse;
    }

    public void setHasHouse(boolean hasHouse) {
        this.hasHouse = hasHouse;
    }

    public boolean getHasHotel() {
        return hasHotel;
    }

    public void setHasHotel(boolean hasHotel) {
        this.hasHotel = hasHotel;
    }

    public void buildHouse(){
        setHasHouse(true);
        this.price = getHousePrice() + this.price;
        this.rent*=2;
    }

    public boolean buildHotel(){
        if (getHasHouse()){
            setHasHotel(true);
            this.price = getHotelPrice() + this.price;
            this.rent*=2;
            return true;
        }
        else
        {
            setHasHotel(false);
            return false;
        }
    }

    public int getHousePrice(){
        return getPrice()*2;
    }

    public int getHotelPrice(){
        return getPrice()*2;
    }
}
