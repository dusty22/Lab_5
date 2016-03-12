package enemies;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import characters.Fish;
import misc.Util;

/**
 * The Net class is used to model nets
 * @author abraham
 *
 */
public class Net extends Enemy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4749836762438935190L;
	/**
	 * BIGNET is a big, commercial fisherman type of net
	 */
	public static int BIGNET = 0;
	/**
	 * LILNET is a small, single person sized net
	 */
	public static int LILNET = 1;
	
	/**
	 * stores which type the Net is, either BIGNET or LILNET
	 */
	private int type; 
	
	private ArrayList<Fish> attachedFish;
	private boolean up,down;
	
	private static BufferedImage lilNet=null;
	private static BufferedImage lilNetUnderlay=null;
	/**
	 * The constructor for net must accept and initial x,y and type
	 * If the type is not Net.BIGNET or Net.LILNET, it will default to Net.LILNET
	 * @param xPos the initial x position of the Net
	 * @param yPos the initial y position of the Net
	 * @param type the type of the Net
	 */
	public Net(double xPos, double yPos,int type){
		super(xPos,yPos);
		this.type = type;
		loadRes();
		up=false;
		down=true;
		attachedFish = new ArrayList<Fish>();
	}
	
	/**
	 * loads initial net images
	 */
	public void loadRes(){
		try {
			if(lilNet==null)
				lilNet = Util.loadImage("/net.png", this);
			if(lilNetUnderlay==null)
				lilNetUnderlay = Util.loadImage("/netoverlay.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * implements act() from enemy
	 */
	@Override
	public void act() {
		moveUpAndDown();
		xPos-=6;
			
		for(Fish f: attachedFish){
			f.setX(xPos+250+Math.random()*200);
			f.setY(yPos+950+Math.random()*100);
			//f.setAngle(Math.random()*2*Math.PI);
		}
		
	}
	/**
	 * renders net image
	 */
	public void render(Graphics2D g){
		g.drawImage(lilNetUnderlay, (int)xPos+200,(int) yPos+10,600,1300, null);
		g.setColor(Color.YELLOW);
		g.fillRect((int)xPos+113+200, -1000, 30, (int) (1955+yPos));
		
		for(Fish f: attachedFish){
			f.render(g);
		}
		
	}
	/**
	 * renders net image
	 * @param g the graphics to use to draw
	 */
	public void render2(Graphics2D g) {
		g.drawImage(lilNet, (int)xPos+200,(int) yPos,600,1300, null);
	}
	
	/**
	 * causes the net to move randomly in the y direction on the screen
	 */
	public void moveUpAndDown(){
		if(yPos<-2000){
			up = false;
			down = true;
		}
		else if(yPos>-700){
			up=true;
			down=false;
		}
		
		if(up){
			yPos-=8;
		}
		else if(down){
			yPos+=8;
		}
		
		
	}
	
	/**
	 * 
	 * @return the type of the net.  Either Net.BIGNET or Net.LILNET
	 */
	public int getType(){
		return type;
	}

	/**
	 * detects collison between fish and net
	 */
	public boolean isIn(Fish f){
		return (f.getX()>xPos+200 && f.getX()<xPos+300 &&
				f.getY() > yPos+850 && f.getY()<yPos+1200);
	}
	/**
	 * add fish to net
	 */
	public void addAttachedFish(Fish f){
		attachedFish.add(f);
	}
	
	/**
	 * removes fish from net
	 */
	public void removeAttachedFish(){
		attachedFish.clear();
	}
}
