package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import animation.SpriteSheet;
import misc.Util;

/**
 * TheHuman is a class for modeling the human in the Crab Save game. It is called "TheHuman" for reasons
 * no one can explain. The existence of its name is utterly inexplicable, from a certain point of view. Q.E.D.
 * @author abraham
 *
 */
public class TheHuman extends Enemy{
	
	private SpriteSheet human;
	private int spriteNum=1;
	/**
	 * 
	 */
	private static final long serialVersionUID = -410465131603543966L;
	private boolean hasFish;
	private BufferedImage greenArrow;
	private long timer=0;
	private double angle=0;
	private boolean noFishInBag=false;
	private BufferedImage go,noFish;
	
	/**
	 * Creates a human with an initial x and y
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public TheHuman(double xPos,double yPos){
		super(xPos,yPos);
		loadRes();
		
	}
	
	/**
	 * loads resources used for the human
	 */
	private void loadRes(){
		BufferedImage pic = null;
		
		try {
			pic = Util.loadImage("/HumanPicFish.png", this);
			greenArrow = Util.loadImage("/greenarrowflipped.png",150,150, this);
			go = Util.loadImage("/GO.png", this);
			noFish=Util.loadImage("/HumanNoFish.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		human = new SpriteSheet(pic, 1, 2, 300, 200);
		
	}

	private long lastTime=0;
	/**
	 * implements act() from enemy
	 */
	@Override
	public void act() {	
		if(timer>70)
			walk();
		
		if(outOfScreen()){
			if(lastTime==0)
				lastTime=timer;
			
		}
		
		
		letGoOfFishIfAttackedByCrab();
		
		timer++;
	}
	
	private double xPosArrow=xPos+200;
	private double yPosArrow=-500;
	private double yVelArrow=0;
	private double yAccArrow=3;
	private boolean down=true;
	/**
	 * renders graphics
	 */
	public void render(Graphics2D g){
		g.drawImage(human.getSprite(1, spriteNum), (int)xPos, (int)yPos,400,600, null);
		if(outOfScreen() && timer-lastTime<60){
			g.drawImage(go, -500, -100,800,400, null);
		}
		
		if(!outOfScreen()){
			g.drawImage(greenArrow, (int)(xPos+200), (int)yPosArrow, null);
			yVelArrow+=yAccArrow;
			yPosArrow+=yVelArrow;
			if(down &&yPosArrow>-450){
				yAccArrow=-yAccArrow;
				down=false;
			}else if (!down && yPosArrow<-450){
				yAccArrow=-yAccArrow;
				down=true;
			}
		}
	}
	/**
	 * renders with a x pos shift
	 * @param g
	 * @param screenPos
	 */
	public void render(Graphics2D g,double screenPos){
		g.translate(xPos+screenPos+200, yPos+300);
		g.rotate(angle);
		if(!noFishInBag)
			g.drawImage(human.getSprite(1, spriteNum), -200, -300,400,600, null);
		else
			g.drawImage(noFish, -200, -300,400,600, null);
		g.rotate(-angle);
		g.translate(-xPos-screenPos-200, -yPos-300);
		
		if(outOfScreen() && timer-lastTime<60){
			g.drawImage(go, -500, -100,800,400, null);
		}
		if(!outOfScreen()){
			g.drawImage(greenArrow, (int)(xPos+200+screenPos), (int)yPosArrow, null);
			yVelArrow+=yAccArrow;
			yPosArrow+=yVelArrow;
			if(down &&yPosArrow>-450){
				yAccArrow=-yAccArrow;
				down=false;
			}else if (!down && yPosArrow<-450){
				yAccArrow=-yAccArrow;
				down=true;
			}
		}
	}
	/**
	 * performs  a check to see if it is attacked by the crab.  It then will let got of the fish
	 */
	public void letGoOfFishIfAttackedByCrab(){
		
	}
	
	/**
	 * defines the walking behavior of the human
	 */
	public void walk(){
		if(xPos<Util.getDISTANCE_TO_EDGE()+500){
			xPos+=10;
			if(timer%6==0){
				if(spriteNum==1){spriteNum=2;}
				else if (spriteNum==2){spriteNum=1;}
			}
		}
	}
	
	/**
	 * 
	 * @return whether or not TheHuman has the fish
	 */
	public boolean hasFish(){
		return hasFish;
	}
	/**
	 * gets angle
	 * @return the angle
	 */
	public double getAngle() {
		return angle;
	}
	/**
	 * sets the angle
	 * @param angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	/**
	 * returns whethor or not it is outofscreen
	 * @return
	 */
	public boolean outOfScreen(){
		return xPos>=Util.getDISTANCE_TO_EDGE();
	}
	/**
	 * sets the nofisninbag boolean
	 * @param noFishInBag
	 */
	public void setNoFishInBag(boolean noFishInBag) {
		this.noFishInBag = noFishInBag;
	}
	/**
	 * gets the no fish in bag boolean
	 * @return 
	 */
	public boolean getNoFishInBag(){
		return this.noFishInBag;
	}
}
