package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.Util;

/**
 * Trash is a class that models many different trash types
 * @author abraham
 *
 */
public class Trash extends Enemy {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2923480295498027702L;
	// Different Trash that will need to be picked up to clean Estuary 
	/**
	 * constant for Bananas
	 */
	public static final int BANANA =0;
	/**
	 * constant for Bottle
	 */
	public static final int BOTTLE =1;
	/**
	 * constant for soda cans
	 */
	public static final int SODA_CAN =2;
	/**
	 * constant for ropes
	 */
	public static final int ROPE =3;
	/**
	 * constant for shopping bags
	 */
	public static final int SHOPPING_BAG =4;
//	/**
//	 * constant for shopping cart
//	 */
//	public static final int SHOPPING_CART =5;
	
	public static final int MILK_JUG=5;
	/**
	 * stores the type of the Trash
	 */
	private int type;
	private double scale=1;
	
	private boolean beingThrown=false;
	private double angle=0;
	
	public static int getRandomType(){
		return (int) (Math.random()*6);
	}
	
	
	private static boolean loadedImages=false;
	private static BufferedImage banana,sodaCan,bottle,rope,shoppingBag,milkJug=null;
	/**
	 * the constructor for Trash initializes x,y,and type
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param type the initial type
	 */
	public Trash(double xPos,double yPos,int type){
		super(xPos,yPos);
		this.type = type;
		loadRes();
	}
	
	/**
	 * loads resources for his class
	 */
	private void loadRes(){
		if(!loadedImages){
			try{
				banana=Util.loadImage("/banana.png", this);
				sodaCan=Util.loadImage("/soda.png", this);
				bottle=Util.loadImage("/bottle.png", this);
				rope=Util.loadImage("/Rope.png", this);
				shoppingBag=Util.loadImage("/plasticbag.png",this);
				milkJug=Util.loadImage("/MilkGallon.png", this);
				
				
			}catch(IOException e){
				e.printStackTrace();
			}
			loadedImages=true;
		}
	}

	/**
	 * implements act() from Enemy
	 */
	@Override
	public void act() {
		// TODO Auto-generated method stub
		scale = (yPos+1000)/1000f;
		scale=scale<0.4?0.4:scale;
		
		if(xPos+getWidth()>Util.getDISTANCE_TO_EDGE()){
			xPos=Util.getDISTANCE_TO_EDGE()-getWidth();
		}
		if(beingThrown){
			if(xPos<575)
				angle+=.5;
			if(xPos>575){
				angle-=.5;
			}
		}
		
		
		
		
	}
	/**
	 * renders graphics
	 */
	public void render(Graphics2D g){

			g.translate(xPos+getWidth()/2f, yPos+getHeight()/2f);
			g.rotate(angle);
			switch(type){
				case BANANA: g.drawImage(banana, (int)(-getWidth()/2f), (int)(-getHeight()/2f),(int)(340*scale),(int)(200*scale), null);break;
				case SODA_CAN: g.drawImage(sodaCan,(int)( -getWidth()/2f),(int)( -getHeight()/2f),(int)(200*scale),(int)(250*scale), null);break;
				case BOTTLE: g.drawImage(bottle, (int)(-getWidth()/2f), (int)(-getHeight()/2f),(int)(200*scale),(int)(375*scale), null);break;
				case MILK_JUG: g.drawImage(milkJug, (int)(-getWidth()/2f), (int)(-getHeight()/2f),(int)(500*scale),(int)(500*scale), null);break;
				case SHOPPING_BAG: g.drawImage(shoppingBag, (int)(-getWidth()/2f),(int)( -getHeight()/2f),(int)(395*scale),(int)(450*scale), null);break;
				case ROPE: g.drawImage(rope, (int)(-getWidth()/2f), (int)(-getHeight()/2f),(int)(500*scale),(int)(500*scale), null);break;
			}
			g.rotate(-angle);
			g.translate(-xPos-getWidth()/2f, -yPos-getHeight()/2f);
			
		
		
	}
	
	/**
	 * renders screen shift 
 	 * @param g the graphics to draw
	 * @param screenPos
	 */
	public void render(Graphics2D g,double screenPos){

		g.translate(xPos+screenPos+getWidth()/2f, yPos+getHeight()/2f);
		g.rotate(angle);
		switch(type){
			case BANANA: g.drawImage(banana, (int)(-getWidth()/2f), (int)(-getHeight()/2f),(int)(340*scale),(int)(200*scale), null);break;
			case SODA_CAN: g.drawImage(sodaCan,(int)( -getWidth()/2f),(int)( -getHeight()/2f),(int)(200*scale),(int)(250*scale), null);break;
			case BOTTLE: g.drawImage(bottle, (int)(-getWidth()/2f), (int)(-getHeight()/2f),(int)(200*scale),(int)(375*scale), null);break;
			case MILK_JUG: g.drawImage(milkJug, (int)(-getWidth()/2f), (int)(-getHeight()/2f),(int)(500*scale),(int)(500*scale), null);break;
			case SHOPPING_BAG: g.drawImage(shoppingBag, (int)(-getWidth()/2f),(int)( -getHeight()/2f),(int)(395*scale),(int)(450*scale), null);break;
			case ROPE: g.drawImage(rope, (int)(-getWidth()/2f), (int)(-getHeight()/2f),(int)(500*scale),(int)(500*scale), null);break;
		}
		g.rotate(-angle);
		g.translate(-xPos-screenPos-getWidth()/2f, -yPos-getHeight()/2f);
		
	
	
}

	 /**
	  * 
	  * @return the type of the trash
	  */
	public int getType(){
		return type;
	}
	
	/**
	 * gets the width of this type of trash
	 * @return
	 */
	public double getWidth(){
		switch(type){
			case BANANA: return(340*scale);
			case SODA_CAN: return (200*scale);
			case BOTTLE: return(200*scale);
			case MILK_JUG: return(500*scale);
			case SHOPPING_BAG:return(395*scale);
			case ROPE: return(500*scale);
			default: return-1;
	}
	}
	
	/**
	 * sets whether it is being thrown
	 * @param b
	 */
	public void setBeingThrown(boolean b){
		this.beingThrown=b;
	}
	
	/**
	 * sets the scale of this trash
	 * @param d
	 */
	public void setScale(double d){
		this.scale =d;
	}
	
	/**
	 * gets the height of this trash
	 * @return
	 */
	public double getHeight(){
		switch(type){
			case BANANA: return(200*scale);
			case SODA_CAN: return(250*scale);
			case BOTTLE: return(375*scale);
			case MILK_JUG: return(500*scale);
			case SHOPPING_BAG: return(450*scale);
			case ROPE: return(500*scale);
			default:return -1;
	}
	}
	/**
	 * gets the scale of this trash
	 * @return
	 */
	public double getScale(){
		return scale;
	}
	
	/**
	 * sets the angle of this trash
	 * @param rads
	 */
	public void setAngle(double rads){
		this.angle=rads;
	}
	
	/**
	 * gets the angle of this trash
	 * @return
	 */
	public double getAngle(){
		return this.angle;
	}
	
	
}
