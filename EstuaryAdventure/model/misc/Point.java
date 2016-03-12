package misc;

import java.io.Serializable;

/**
 * class for holding a point
 * @author abrah
 *
 */
public class Point implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3770617474989563318L;
	public double x;
	public double y;
	
	/**
	 * contructor for point.  stores the parameters in public variables for use later
	 * @param x
	 * @param y
	 */
	public Point(double x,double y){
		this.x = x;
		this.y=y;
	}
}

