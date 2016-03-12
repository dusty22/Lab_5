package misc;

import java.io.Serializable;
/**
 * models a vector for describing either position or velocity
 * @author abrah
 *
 */
public class Vector implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x,y,z;
	
	/**
	 * creates a 2d vector
	 * @param x
	 * @param y
	 */
	public Vector(double x,double y){
		this.x=x;
		this.y=y;
		this.z=0;
	}
	
	/**
	 * creates a 3d vector
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector(double x,double y,double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	/**
	 * get the x comp of this vector
	 * @return
	 */
	public double getX(){
		return x;
	}
	/**
	 * gets the y comp of this vector
	 * @return
	 */
	public double getY(){
		return y;
	}
	/**
	 * gets the z comp of this vector
	 * @return
	 */
	public double getZ(){
		return z;
	}
	
	/**
	 * sets the x comp of this vecotr
	 * @param x
	 */
	public void setX(double x){
		this.x=x;
	}
	/**
	 * sets the y comp of this vector
	 * @param y
	 */
	public void setY(double y){
		this.y=y;
	}
	/**
	 * sets the z comp of this vector
	 * @param z
	 */
	public void setZ(double z){
		this.z=z;
	}
	
	/**
	 * adds the given vector to this vector by vector addition
	 * @param a
	 */
	public void add(Vector a){
		x+=a.x;
		y+=a.y;
		z+=a.z;
	}
	

}
