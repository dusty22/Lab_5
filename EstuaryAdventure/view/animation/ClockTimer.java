package animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.Point;
import misc.Renderable;
import misc.Tickable;
import misc.Util;
/**
 * clock timer is a class that handles the counting down/up throughout the game, and also defines how to draw
 * the clock to the screen. *** It assumes onTick() is being called at 60Hz!***
 * @author abrah
 *
 */
public class ClockTimer implements Tickable,Renderable{

	private double timer = 61.0;
	private BufferedImage image;
	private double initialAngle;
	private double handAngle;
	
	private boolean smooth=false;
	
	private Point centerPoint = new Point(168,147);
	private boolean countUp=false;
	private int xPos,yPos;
	/**
	 * creates the clock timer
	 * @param xPos the x position
	 * @param yPos the y position
	 */
	public ClockTimer(int xPos,int yPos){
		this.xPos=xPos;
		this.yPos=yPos;
		loadRes();
		initialAngle=-Math.PI/18f;
	}
	
	/**
	 * loads resources need for the clock
	 */
	private void loadRes(){
		try {
			image = Util.loadImage("/Clock.png",300,300, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * draws this clock using the given graphics ojbect
	 */
	@Override
	public void render(Graphics2D g) {
		g.translate(xPos+centerPoint.x, yPos+centerPoint.y);
		g.rotate(initialAngle);
		
		g.drawImage(image, (int)-centerPoint.x, (int)-centerPoint.y,null);
		
		g.rotate(handAngle);
		g.setColor(Color.BLACK);
		g.fillRoundRect(-5, -70, 10, 70, 10, 10);
		
		g.rotate(-handAngle);
		
		g.rotate(-initialAngle);
		g.translate(-xPos-centerPoint.x, -yPos-centerPoint.y);
		
	}
	
	private boolean going=true;
	
	/**
	 * pauses this clock
	 */
	public void pause(){
		going=false;
	}
	/**
	 * causes this clock to run.  by default, it starts running
	 */
	public void run(){
		going=true;
	}

	/**
	 * implements on tick
	 */
	@Override
	public void onTick() {
		if(going){
			if(!countUp)
				timer-=1/60.0;
			else{
				timer+=1/60.0;
			}
		}
		if(smooth)
			handAngle+=2*Math.PI/(60*60);
		else{
			if(!countUp)
				handAngle=(1-((int)(timer))/60.0)*(2*Math.PI);
			else{
				handAngle=-(1-((int)(timer))/60.0)*(2*Math.PI);
			}
		}
	}
	
	/**
	 * sets the clock to the given value
	 * @param d
	 */
	public void setTimer(double d){
		this.timer=d;
	}
	/**
	 * gets the value of the clock now
	 * @return
	 */
	public double getTimer(){
		return timer;
	}
	/**
	 * tells this clock to start at 0 and count up if true
	 * @param countUp
	 */
	public void setCountUp(boolean countUp) {
		this.countUp = countUp;
		if(countUp)
			timer=0;
	}
	/**
	 * sets the graphical tilt angle of this clock
	 * @param initialAngle
	 */
	public void setInitialAngle(double initialAngle) {
		this.initialAngle = initialAngle;
	}

}
