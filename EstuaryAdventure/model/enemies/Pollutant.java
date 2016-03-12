package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import characters.Bubble;
import misc.Point;
import misc.Util;
import misc.Vector;

/**
 * The Pollutant class is used to model different types of pollutants
 * @author abraham
 *
 */
public class Pollutant extends Enemy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7101253794644730026L;
	// Forms of Pollutants
	/**
	 * constant for oil
	 */
	public static final int OIL = 0;
	public static final int OIL_ANIMATION = -1;
	/**
	 * constant for sewage
	 */
	public static final int SEWAGE = 1;
	/**
	 * constant for fertilizer
	 */
	public static final int FERTILIZER = 2;

	/**
	 * stores the type of Pollutant.  Either Pollutant.OIL, Pollutant.SEWAGE, or Pollutant.FERTILIZER
	 */
	private int type;
	private Vector position,velocity;
	private double angle;
	private double rotationSpeed;
	private static BufferedImage fertilizer,sewage,oil,oil2;
	private boolean out=false;
	
	private boolean fixedToBubble=false;
	private Bubble cleanMe;
	private double initVx,initVy;
	private int index;
	
	/**
	 * creates a new pollutant
	 * @param initialPosition the initial position
	 * @param velocity the velecity
	 * @param rotationSpeed the rotational speed
	 * @param type thet type
	 */
	public Pollutant(Vector initialPosition,Vector velocity,double rotationSpeed,int type){
		super(initialPosition.getX(),initialPosition.getY());
		this.type = type;
		this.position = initialPosition;
		this.velocity = velocity;
		initVx=velocity.getX();
		initVy=velocity.getY();
		
		this.rotationSpeed=rotationSpeed;
		loadRes();
	}
	/**
	 * returens whether or not this pullutant is showing on the screen
	 * @return
	 */
	public boolean getOut(){
		return out;
	}
	/**
	 * loads resources for this class
	 */
	private void loadRes(){
		if(type==FERTILIZER && fertilizer==null){
			try {
				fertilizer=Util.loadImage("/fertilizer.png", this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(type == OIL && oil==null){
			try {
				oil=Util.loadImage("/oilspill.png", this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(type == OIL_ANIMATION && oil2==null){
			try {
				oil2=Util.loadImage("/oilspillANIMATION.png", this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(type == SEWAGE && sewage==null){
			try {
				sewage=Util.loadImage("/sewage.png", this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *  Implements act() from Enemy 
	 */
	
	@Override
	public void act() {
		if(!fixedToBubble)
			floatDown();
		else if (fixedToBubble){
			Point bcenter=cleanMe.getCenterPoint();
			Point pcenter=this.getCenterPoint();
			velocity.setX((bcenter.x-pcenter.x)/30.0);
			velocity.setY((bcenter.y-pcenter.y)/5.0);
			position.add(velocity);
		}
		
	}
	/**
	 *  defines the the way in which the pollutant floats down from the top of the screen
	 * 
	 */
	public void floatDown(){
		position.add(velocity);
		if(out && position.getX()>Util.getDISTANCE_TO_EDGE()+150){
			position.setX(xPos);
			position.setY(yPos);
			out=false;
		}else if (out && position.getX()<-Util.getDISTANCE_TO_EDGE()-150){
			position.setX(xPos);
			position.setY(yPos);
			out=false;
		}
		else if(out &&position.getY()<-1150){
			position.setX(xPos);
			position.setY(yPos);
			out=false;
		}
		else if(out && position.getY()>1150){
			position.setX(xPos);
			position.setY(yPos);
			out=false;
		}else{
			out=true;
		}
		angle+=rotationSpeed;
	}
	
	
	/**
	 * renders graphics
	 */
	public void render(Graphics2D g){
		
		g.translate(position.getX(),position.getY());
		g.rotate(angle);
		
		if(type==FERTILIZER){
			g.drawImage(fertilizer, 0,0, null);
		}else if(type==OIL){
			g.drawImage(oil, 0,0, null);
		}else if (type==OIL_ANIMATION){
			g.drawImage(oil2, 0, 0, null);
		}
		else if(type==SEWAGE){
			g.drawImage(sewage, 0,0, null);
		}
//		g.setColor(Color.BLACK);
//		g.drawRect(0, 0, 150, 150);
//		g.setColor(Color.RED);
//		g.fillRect(0, 0, 10, 10);
		
		g.rotate(-angle);	
		g.translate(-position.getX(), -position.getY());
		
		//g.setColor(Color.RED);
		//g.fillOval((int)getCenterPoint().x, (int)getCenterPoint().y, 20, 20);
		
		
	}
	
	

	public Point centerPoint=new Point(0,0);
	/**
	 * gets the center point of this pullantant in its current state
	 * @return 
	 */
	public Point getCenterPoint(){
		centerPoint.x=position.getX()+106.07*Math.cos(angle+Math.PI/4.0);
		centerPoint.y=position.getY()+106.07*Math.sin(angle+Math.PI/4.0);
		return centerPoint;
	}
	
	/**
	 * 
	 * @return the type of this Pollutant
	 */
	public int getType(){
		return type;
	}
	
	/**
	 * used for bookeeping
	 */
	public int getIndex(){
		return index;
	}

	/**
	 * used for bookkeeping
	 */
	public void setIndex(int i){
		this.index = i;
	}
	
	/**
	 * fixes this pollutant to the given bubbble b
	 * @param b the bubble to fix to
	 */
	public void fixToBubble(Bubble b){
		cleanMe=b;
		fixedToBubble=true;
		
	}
	
	
	private double dx,dy;
	/**
	 * returns true if the pollutant is in the given bubble
	 * @param b the bubble
	 * @return true or false
	 */
	public boolean isIn(Bubble b){
		Point bubbleCenter=b.getCenterPoint();
		Point pollutantCenter= this.getCenterPoint();
		dx = bubbleCenter.x-pollutantCenter.x;
		dy=bubbleCenter.y-pollutantCenter.y;
		return (Math.sqrt(dx*dx+dy*dy)<165);
		
	}
	
	/**
	 * returns if this pollutant is in a bubble
	 * @return
	 */
	public boolean isInBubble(){
		return fixedToBubble;
	}
	/**
	 * resets this bubble
	 */
	public void reset(){
		fixedToBubble=false;
		cleanMe=null;
		position.setX(xPos);
		position.setY(yPos);
		velocity.setX(initVx);
		velocity.setY(initVy);
		out=false;
		
	}
}
