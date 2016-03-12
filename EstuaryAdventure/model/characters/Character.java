package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import misc.Renderable;
import misc.Tickable;


/**
 * Character is an abstract class that provides basic implementation for all characters to be contolled by
 * the user. 
 * It implements listener interfaces.
 * @author abraham
 * 
 */
public abstract class Character implements KeyListener,MouseListener,MouseMotionListener,Serializable,Tickable,Renderable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6777058852530701862L;
	protected double xPos,yPos;	// the x and y position of the Character on the screen
	 
	/**
	 * Creates a character with initial x,y and default health
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public Character(double xPos,double yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/** move the character a certain amount dx and a certain amount dy
	 * @param dx the amount to move in the x direction
	 * @param dy the amount to move in the y direction
	 */
	public abstract void move(double dx,double dy);
	
	
	/**
	 * called 60 times/second in the main Game loop.  This is where all updates that occur based 
	 * on time will go. For Characters, it may not be used. Updates that occur as a result of user action should be put in the listener 
	 * methods. 
	 */
	public void onTick(){};
	
	/**
	 * defines the method for rendering to the screen
	 */
	public abstract void render(Graphics2D g);
	
	
	/** returns the xPos double value of the Character
	 * @return x Position
	 */
	public double getX(){		
		return xPos;
	}
	
	/**
	 * returns the yPos double value of the Character
	 * @return y Position
	 */
	public double getY(){
		return yPos;
	} 
	
	/**
	 * returns the X position int value of Character
	 * @return x Position (int)
	 */
	public int getXInt(){
		return (int)xPos;
	}
	
	/**
	 * returns the Y position int value of Character
	 * @return y Position (int)
	 */
	public int getYInt(){
		return (int)yPos;
	}
	
	
	/**
	 * sets the X position of Character 
	 * @param x is the initial x position of Character
	 */
	public void setX(double x){
		this.xPos=x;
	}
	
	/**
	 * sets the Y position of Character
	 * @param y is the intital y position of Character
	 */
	public void setY(double y){
		this.yPos=y;
	}
	
}
