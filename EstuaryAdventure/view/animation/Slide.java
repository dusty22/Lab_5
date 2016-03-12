package animation;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import main.EstuaryAdventureMain;
import misc.RectBounds;
import misc.Util;
/**
 * models a slide used in animations
 * @author abrah
 *
 */
public class Slide implements MouseListener,MouseMotionListener {

	
	private BufferedImage image;
	private double time;
	private long timeDisplayed=0;
	private java.awt.Color color;
	
	private static final int TYPE_COLOR=0;
	private static final int TYPE_IMAGE=1;
	private boolean finalSlide=false;
	private boolean paused=false;
	private final int type;
	
	private boolean fadedIn;
	private double fade_time_in = 60.0;
	private double fade_time_out=60.0;
	private float alpha=0f;
	
	private boolean fadeIn=true;
	private boolean fadeOut=true;
	private static BufferedImage selectedStart=null;
	private boolean showSelectedStart=false;
	private double timeBlackAfterFadeOut=10.0;
	private String imageString;
	
	private boolean fadeEverything=false;
	/**
	 * creates a slide that will display an image
	 * @param image SCALE the image before you put it in here please
	 * @param time in seconds
	 */
	public Slide(String image,double time){
		this.imageString = image;
		this.time=time*60;
		type=TYPE_IMAGE;
		
	}
	
	
	private boolean loaded=false;
	/**
	 * loads this slides resources
	 */
	public void load(){
		if(!loaded){
			try {
				this.image=Util.loadImage(imageString,Util.getCANVAS_WIDTH_SCALED(),Util.getCANVAS_HEIGHT_SCALED(), this);
				loaded=true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * creates a slide that will display an image
	 * @param image SCALE the image before you put it in here please
	 * @param time in seconds
	 */
	public Slide(BufferedImage image,double time){
		this.image=image;
		this.time=time*60;
		type=TYPE_IMAGE;
	}
	
	/**
	 * creates a slide that shows only one color, specified by the color parameter
	 * @param color in java.awt
	 * @param time in seconds
	 */
	public Slide(java.awt.Color color,double time){
		this.color = color;
		this.time = time*60;
		type=TYPE_COLOR;
	}
	
	
	/**
	 * displays this slide to the graphics2d g, and returns true after it has been displayed for its time
	 * you can only display once.  If you want to display again, you must call reset() on a slide.
	 * However, if you call this function after it returns false, it will still draw to the screen. But it returned false so you 
	 * would know not to call it anymore.
	 * @param g the graphcis to be used for drawing
	 * @return true if it has displayed for its amount of time, false otherwise
	 */
	public boolean display(Graphics2D g){
		g.setComposite(AlphaComposite.getInstance(
	            AlphaComposite.SRC_OVER, alpha));
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
	    if(type==TYPE_IMAGE){
			g.drawImage(image, -Util.getDISTANCE_TO_EDGE(),-1000,null);
		}
		else if (type==TYPE_COLOR){
			g.setColor(color);
			g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), Util.getCANVAS_HEIGHT_SCALED());
		}
	    if(fadedIn && finalSlide){
	    	EstuaryAdventureMain.showMenuCursor();
	    }
	    
	    
	    if(fadeIn && !fadedIn){
	    	alpha+=1/fade_time_in;
	    	if(alpha>=1.0){
	    		alpha=1.0f;
	    		fadedIn=true;
	    	}
	    }
	    
	    else if (fadeOut && timeDisplayed >= time-fade_time_out){
	    	if(finalSlide){
	    		paused=true;
	    	}else{
		    	alpha-=1/fade_time_out;
		    	if(alpha<=0){
		    		alpha=0f;
		    	}
	    	}
	    }
	    
	    if(!paused)
	    	timeDisplayed++;
	    
	    if(showSelectedStart && fadedIn){
	    	g.drawImage(selectedStart, 1000, 520,800,500, null);
	    }
	    
	    if(!fadeEverything && (!fadeEveryThingOut || timeDisplayed < time-fade_time_out) ){
		    g.setComposite(AlphaComposite.getInstance(
		            AlphaComposite.SRC_OVER, 1.0f));
	    }
		return (timeDisplayed>=time+timeBlackAfterFadeOut);
		
	}
	
	
	/**
	 * resets the timer on this slide.  Don't use it really
	 */
	public void reset(){
		timeDisplayed=0;
	}
	/**
	 * causes everything drawn after this to fade also
	 * @param fadeEverything
	 */
	public void setFadeEverything(boolean fadeEverything) {
		this.fadeEverything = fadeEverything;
	}
	
	private boolean fadeEveryThingOut=false;
	/**
	 * causes everything drawn after to to fade also, if fading out
	 * @param fadeEveryThing
	 */
	public void setFadeEveryThingOut(boolean fadeEveryThing) {
		this.fadeEveryThingOut = fadeEveryThing;
	}
	/**
	 * sets how long a black screen is displayed between slides
	 * @param timeBlackAfterFadeOut
	 */
	public void setTimeBlackAfterFadeOut(double timeBlackAfterFadeOut) {
		this.timeBlackAfterFadeOut = timeBlackAfterFadeOut;
	}
	
	/**
	 * sets fade time 
	 * @param d in secondds
	 */
	public void setFadeInTime(double d ){	
		this.fade_time_in=d*60.0;
		if(fade_time_in==0){
			fadeIn=false;
		}
	}
	
	/**
	 * sets the fade out time in seconds
	 * @param d in seconds
	 */
	public void setFadeOutTime(double d){
		this.fade_time_out=d*60.0;
		if(fade_time_out==0){
			fadeOut=false;
		}
	}
	/**
	 * declares this slide as the final slide, so that it will wait for user input to continue the the game
	 * @param finalSlide
	 */
	public void setFinalSlide(boolean finalSlide) {
		this.finalSlide = finalSlide;
		try {
			selectedStart = Util.loadImage("/Game1AnimationInstructionSlide(selected).png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * returns true if this slide is the final slide
	 * @return
	 */
	public boolean isFinalSlide() {
		return finalSlide;
	}
	/**
	 * sets whether or not this slide fades in
	 * @param fadeIn
	 */
	public void setFadeIn(boolean fadeIn) {
		this.fadeIn = fadeIn;
		alpha=1f;
	}
	/**
	 * sets whether or not this slide fades out
	 * @param fadeOut
	 */
	public void setFadeOut(boolean fadeOut) {
		this.fadeOut = fadeOut;
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		if(Util.isInBox(e, new RectBounds(1200, 800, 1000, 1000))){
			showSelectedStart=true;
		}else
			showSelectedStart=false;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(Util.isInBox(e, new RectBounds(1200, 800, 1000, 1000))){
				finalSlide=false;
				paused=false;
		}
		
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
