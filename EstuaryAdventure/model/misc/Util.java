package misc;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Static utility class for a lot of things related to the Games.  Stores
 * many contants related to the screen size to help with scaling throughout 
 * the game. 
 * Also contains methods for computing collisions, and loadingImages
 * @author abraham
 *
 */
public class Util {

	private static double SCALE_FACTOR =-1;
	private static double CANVAS_WIDTH_UNSCALED=-1;
	private static double CANVAS_HEIGHT_UNSCALED=-1;
	private static int DISTANCE_TO_EDGE=-1;
	private static int CANVAS_WIDTH_SCALED=-1;
	private static int CANVAS_HEIGHT_SCALED=2000;
	
	/**
	 * returns the scale factor used to scale the canvas
	 * @return the scale factor used to scale the canvas
	 */
	public static double getSCALE_FACTOR() {
		return SCALE_FACTOR;
	}
	/**
	 * returns the raw canvas width
	 * @return raw canvas width
	 */
	public static double getCANVAS_WIDTH_UNSCALED() {
		return CANVAS_WIDTH_UNSCALED;
	}
	/**
	 * returns the raw canvas height
	 * @return the raw canvas height
	 */
	public static double getCANVAS_HEIGHT_UNSCALED() {
		return CANVAS_HEIGHT_UNSCALED;
	}
	
	/**
	 * returns the extra distance to the edge lengthwise from a square screen
	 * @return the extra distance to the edge lengthwise from a square screen
	 */
	public static int getDISTANCE_TO_EDGE() {
		return DISTANCE_TO_EDGE;
	}
	/**
	 * returns the scaled canvas width
	 * @return the scaled canvas width
	 */
	public static int getCANVAS_WIDTH_SCALED() {
		return CANVAS_WIDTH_SCALED;
	}
	/**
	 * returns the scaled canvas height (always 2000)
	 * @return the scaled canvas height (always 2000)
	 */
	public static int getCANVAS_HEIGHT_SCALED() {
		return CANVAS_HEIGHT_SCALED;
	}
	
	/**
	 * calculates if the mouse event e is within a box, rb
	 * @param e	the mouse event
	 * @param rb a RectBounds object to describe the box in question
	 * @return true or false corresponding to yes or no
	 */
	public static boolean isInBox(MouseEvent e,RectBounds rb){
		int x = (int) ((e.getX()-CANVAS_WIDTH_UNSCALED/2.0)/SCALE_FACTOR);
		int y = (int) ((e.getY() - CANVAS_HEIGHT_UNSCALED/2.0)/SCALE_FACTOR);
		
		return (x >= rb.getX() && x<=rb.getX()+rb.getXLength() &&
				y>=rb.getY() && y <=rb.getY() + rb.getYLength());
			
	}
	
	/**
	 * returns true if the mouse event e is within a certain radius from a point. Scales accordingly
	 * @param e the mouse event
	 * @param center the center point
	 * @param radius the radius
	 * @return boolean as described
	 */
	public static boolean isInCircle(MouseEvent e, misc.Point center,double radius){
		int x = (int) ((e.getX()-CANVAS_WIDTH_UNSCALED/2.0)/SCALE_FACTOR);
		int y = (int) ((e.getY() - CANVAS_HEIGHT_UNSCALED/2.0)/SCALE_FACTOR);
		
		double dx= x-center.x;
		double dy =y-center.y;
		
		return (Math.sqrt(dx*dx+dy*dy)<=radius);
		
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * stores the canvas width in a variable.  Can only be called once. After 
	 * once, it does not change the data.
	 * @param width
	 */
	public static void setCanvasWidth(int width){
		if(CANVAS_WIDTH_UNSCALED==-1){
			CANVAS_WIDTH_UNSCALED = width;
		}
	}
	/**
	 * stores the canvas height in a variable.  Can only be called once. After 
	 * once, it does not change the data.
	 * @param height
	 */
	public static void setCanvasHeight(int height){
		if(CANVAS_HEIGHT_UNSCALED==-1)
			CANVAS_HEIGHT_UNSCALED=height;
	}
	
	/**
	 * stores the scale factor in a variable.  Can only be called once. After 
	 * once, it does not change the data.
	 * @param sf scale factor
	 */
	public static void setCurrentScaleFactor(double sf){
		if(SCALE_FACTOR ==-1){
			SCALE_FACTOR =sf;
		}
	}
	
	/**
	 * calculates and stores SCALED distance to the edge in a variable.  Can only be called once. After 
	 * once, it does not change the data.
	 * @param width
	 */
	public static void setDistanceToEdge(int width,int height){
		if(DISTANCE_TO_EDGE==-1){
			DISTANCE_TO_EDGE= (int) (( (double)(width) / (double)(height) )*1000.0);
			CANVAS_WIDTH_SCALED=2*DISTANCE_TO_EDGE;
		}
	}
	
	
	
	/**
	 * returns the extra Distance to add to 1000 to get to the edge of the horizontal screen
	 * @return the extra Distance to add to 1000 to get to the edge of the horizontal screen
	 */
	public static int getExtraDistance(){
		return DISTANCE_TO_EDGE -1000;
	}
	
	
	//////////////////////////////////////////////////////////
	private static int len;
	/**
	 * draws a string centered around the given x Position
	 * @param s the string to be drawn
	 * @param xPos the x Position
	 * @param yPos the y Position
	 * @param g2d the graphics ojbect to use to draw
	 */
	public static void drawCenteredString(String s, int xPos, int yPos,Graphics2D g2d){
		if(g2d.getFontMetrics()==null){
			len=10;
		}else{
			len = (int) g2d.getFontMetrics().stringWidth(s);
		}
		g2d.drawString(s, xPos-len/2, yPos);
	}
	
	/////////////////////////////////////////////////////////
	/**
	 * loads and returns a Buffered Image
	 * @param path the path in the res folder in the form "/path"
	 * @param host the class calling the method (use "this")
	 * @return the buffered Image
	 * @throws IOException
	 */
	public static BufferedImage loadImage(String path,Object host) throws IOException{
		return ImageIO.read(host.getClass().getResource(path));
	}
	
	/**
	 * loads and returns a Buffered Image, but pre-set SCALED width and height
	 * @param path path the path in the res folder in the form "/path"
	 * @param width SCALED width
	 * @param height SCALED height
	 * @param host host the class calling the method (use "this")
	 * @return the BufferedImage
	 * @throws IOException
	 */
	public static BufferedImage loadImage(String path,int width,int height,Object host) throws IOException{
		BufferedImage tmp = ImageIO.read(host.getClass().getResource(path));
		BufferedImage returnImage=new BufferedImage(width,height,tmp.getType());
		returnImage.createGraphics();
		Graphics2D g= (Graphics2D) returnImage.getGraphics();
		g.drawImage(tmp, 0,0,width, height, null);
		g.dispose();
		return returnImage;
		
		
	}
	
	/**
	 * resets the values in this class so they can be given new values if needed
	 */
	public static void reset(){
		DISTANCE_TO_EDGE=-1;
		CANVAS_HEIGHT_SCALED=-1;
		CANVAS_HEIGHT_UNSCALED=-1;
		CANVAS_WIDTH_SCALED=-1;
		CANVAS_WIDTH_UNSCALED=-1;
		DISTANCE_TO_EDGE=-1;
		SCALE_FACTOR=-1;
	}
	
	/**
	 * uses for testing purposes.
	 */
	public static void fakeDims(){
		DISTANCE_TO_EDGE=1000;
		CANVAS_HEIGHT_SCALED=1000;
		CANVAS_HEIGHT_UNSCALED=1000;
		CANVAS_WIDTH_SCALED=1000;
		CANVAS_WIDTH_UNSCALED=1000;
		DISTANCE_TO_EDGE=1000;
		SCALE_FACTOR=1;
	}
	
}
