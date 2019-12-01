package BL.squares;

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


    public  abstract void performOnLand(DPlayer player);

    public abstract String getSQUARE_TYPE();
}
