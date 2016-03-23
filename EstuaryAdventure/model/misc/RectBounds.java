package misc;

import java.io.Serializable;
/**
 * class for storing a rectangular region bounds
 * @author abrah
 *
 */
public class RectBounds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2844190309772266987L;
	private int x;
	private int y;
	private int xl;
	private int yl;
	
	/**
	 * creates the RectBounds with parameters
	 * @param x x position of left top corner
 	 * @param y y position of left top corner
	 * @param xLength the x length
	 * @param yLength the y length
	 */
	public RectBounds(int x, int y, int xLength, int yLength) {
		this.x = x;
		this.y = y;
		this.xl = xLength;
		this.yl = yLength;
	}

	/**
	 * get this rectBounds x pos
	 * @return
	 */
	public int getX() {
		return x;
	}
	/**
	 *get this rect bounds y pos 
	 * @return
	 */
	public int getY() {
		return y;
	}
	/**
	 * get this rect bounds x length
	 * @return
	 */
	public int getXLength() {
		return xl;
	}
	/**
	 * get this rect bounds y length
	 * @return
	 */
	public int getYLength() {
		return yl;
	}
	
	
	
	
	
}
