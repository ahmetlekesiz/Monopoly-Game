package BL;

import DAL.DPlayer;

/**
 * <h>BSquare</h>
 *
 * <p>The abstract class is prototype for other square class such as Tax Square, Regular Square and Go Square.</p>
 *
 * @author Salih ÖZYURT
 * @version 1.0
 */
//Pembe + turuncu + kırmızı + sarı + yeşil + turkuaz + mavi + kahverengi (property renkleri), Tax squareler renksiz
public abstract class BSquare {
    public  PropertyType pType;
    public  abstract void performOnLand(DPlayer player);

    public abstract String getSQUARE_TYPE();
}
