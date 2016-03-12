package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import enemies.Pollutant;
import misc.Point;
import misc.Util;

/**
 * Bubble is the model class for the bubbles that the Fish fires in the PollutionGame
 * @author abraham
 *
 */
public class Bubble extends Character{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3339567082395475772L;
	private static BufferedImage bubble;
	private double xVel,yVel;
	private double scale=1.0;
	private double angle=0.0;
	private double scaleVel;
	private int index;
	
	
	/**
	 * Creates a bubbles
	 */
	public Bubble(){
		super(0,0);
		loadRes();
		
	}

	/**
	 * loads resources for this class
	 */
	private void loadRes(){
		if(bubble==null){
			try {
				bubble =Util.loadImage("/BubbleSortOfTransparent.png",200,200, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * implements onTick() from character
	 */
	@Override
	public void onTick() {	
		
		floatToTop();
		xPos+=xVel;
		yPos+=yVel;
		
		if(scale>0.2){
			scaleVel-=.01;
		}
		
		if(scaleVel<=0){
			scaleVel=0;
		}
		scale+=scaleVel;
		
		
		
		
		
	}
	
	/**
	 * @param g renders the graphics
	 */
	@Override
	public void render(Graphics2D g){
		g.translate((xPos), yPos);
		g.rotate(angle);
		g.drawImage(bubble,0,0,-(int)(200*scale),-(int)(200*scale), null);
//		g.setColor(Color.BLACK);
//		g.drawRect(-250, -250, 250, 250);
//		g.setColor(Color.RED);
//		g.fillRect(-20, -20, 20, 20);
		
		g.rotate(-angle);
		g.translate(-xPos, -yPos);
		
		//g.drawOval((int)getCenterPoint().x, (int)getCenterPoint().y, 10, 10);
		
		
	}
	
	
	/**
	 * causes this bubble to go from the fish
	 * 
	 */
	public void shootFromFish(double xPos,double yPos,double angle,double crabX,double crabY){
		this.xVel=3*Math.cos(angle-Math.PI/2f-.2);
		this.yVel=1*Math.sin(angle-Math.PI/2f);
		this.angle=angle;
		double dx=xPos-(crabX);
		double dy=yPos-(crabY);
		double polarR=Math.sqrt(dx*dx+dy*dy)+20;
		this.xPos=crabX+polarR*Math.cos(Math.PI/2f-angle);
		this.yPos=crabY-polarR*Math.sin(Math.PI/2f-angle);
		scale=0.2;
		scaleVel=.14;
	}
	
	/**
	 * causes the bubble to float to the top after it surrounds pollution
	 */
	public void floatToTop(){
		if(yVel>-7){
			yVel-=.1;
		}
	}
	
	
	public Point centerPoint=new Point(0,0);
	/**
	 * calculates and returns the center point of this bubble at its current angle and position
	 * @return a Point 
	 */
	public Point getCenterPoint(){
		centerPoint.x=xPos-176.77*Math.cos(angle+Math.PI/4.0);
		centerPoint.y=yPos-176.77*Math.sin(angle+Math.PI/4.0);
		return centerPoint;
	}
	
	
	
	
	/**
	 * used for bookeeping
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * used for bookeeping
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * not implemented
	 */
	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}
	
	private ArrayList<Pollutant> attachedPollutants=new ArrayList<Pollutant>();
	/**
	 * adds another pollutant to this bubble.
	 * @param p
	 */
	public void addAttachedPollutant(Pollutant p){
			attachedPollutants.add(p);
		
	}
	/**
	 * gets the attached pollutant
	 * @return
	 */
	public ArrayList<Pollutant> getAttachedPollutants() {
		return attachedPollutants;
	}
	
	private boolean hasPollutant=false;
	/**
	 * returns true if ths bubble has a pollutant in it
	 * @return
	 */
	public boolean hasPollutant(){
		return hasPollutant;
	}
	
	/**
	 * resets this bubble
	 */
	public void reset(){
		hasPollutant=false;
		attachedPollutants.clear();
	}
	
	
}
