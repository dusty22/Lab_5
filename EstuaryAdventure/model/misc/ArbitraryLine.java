package misc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * class for modeling an arbitrary line
 * @author abrah
 *
 */
public class ArbitraryLine implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1316185101345685629L;
	private ArrayList<Point> points;
	private ArrayList<Double> slopes;	
	
	
	private double xPos;
	
	/**
	 * xscale = Util*Distancetoedge/(picsize/4)
	 * @param pts
	 * @param xScale
	 * @param yOffset
	 */
	public ArbitraryLine(int[] pts,double xScale,double yScale,double yOffset){
		points=new ArrayList<Point>();
		
		int i=0;
		while(i<pts.length-1){
			points.add(new Point(pts[i]*xScale, pts[i+1]*yScale+yOffset));
			i+=2;
		}
		calculateSlopes();
		
		
	}
	/**
	 * xscale = Util*Distancetoedge/(picsize/4)
	 * @param pts
	 * @param xScale
	 * @param yOffset
	 */
	public ArbitraryLine(double[] pts,double xScale,double yScale,double yOffset){
		points=new ArrayList<Point>();
		
		int i=0;
		while(i<pts.length-1){
			points.add(new Point(pts[i]*xScale, pts[i+1]*yScale+yOffset));
			i+=2;
		}
		calculateSlopes();
		
		
	}
	
	/**
	 * simple contructor for a simple line
	 * @param p1
	 * @param p2
	 */
	public ArbitraryLine(Point p1,Point p2){
		points=new ArrayList<Point>();
		points.add(p1);
		points.add(p2);
		calculateSlopes();
	}
	
	/**
	 * positive slope is actually downward due to screen coordinates
	 */
	private void calculateSlopes(){
		slopes=new ArrayList<Double>();
		for(int i=0;i<points.size()-1;i++){
			slopes.add((points.get(i+1).y-points.get(i).y)/(points.get(i+1).x-points.get(i).x));
			//System.out.println(slopes.get(i));
		}
		
	}
	
	
	/**
	 * takes SCALED coordinates
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isBelowLine(double x, double y){
		int i=0;
		if(xPos+points.get(0).x>=x || x>=xPos+points.get(points.size()-1).x){
			return false;
		}
		while(xPos+points.get(++i).x<x){}
		return isBelowSlope(xPos+points.get(i).x,points.get(i).y, slopes.get(i-1), x, y);
	}
	
	
	/**
	 * takes SCALED coordinates.
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isAboveLine(double x,double y){
		return !isBelowLine(x,y);
	}
	
	
	/**
	 * takes SCALED coordinates.  Returns true if the given x and y are below an arbitrary line with given slope
	 * @param startx the start x of this slope section
	 * @param starty the start y of this slope section
	 * @param slope the slope 
	 * @param x	the x pos in question
	 * @param y the y pos in question
	 * @return true or false
	 */;
	private boolean isBelowSlope(double startx,double starty,double slope,double x,double y){
		return (y>(starty+slope*(x-startx)));
	
	}
	
	/**
	 * gets y at a certain x position
	 * @param startx
	 * @param starty
	 * @param slope
	 * @param x
	 * @return
	 */
	private int YAtX(double startx,double starty,double slope,double x){
		return (int) (starty+slope*(x-startx));
	}
	
	/**
	 * returns the y position at a certain x on this arbitrary line
	 * @param x
	 * @return
	 */
	public int getYatXPos(double x){
		
		int i=0;
		if(xPos+points.get(0).x>=x || x>=xPos+points.get(points.size()-1).x){
			return 0;
		}
		while(xPos+points.get(++i).x<x){}
		return YAtX(xPos+points.get(i).x,points.get(i).y, slopes.get(i-1), x);
	}
	/**
	 * sets the xPosition of this Arbitrary line (for moving lines)
	 * @param x
	 */
	public void setX(double x){
		this.xPos=x;
	}
	/**
	 * returns the slope at an x location
	 * @param x
	 * @return
	 */
	public double getSlopeAt(double x){
		int i=0;
		if(xPos+points.get(0).x>=x || x>=xPos+points.get(points.size()-1).x){
			return 0;
		}
		while(xPos+points.get(++i).x<x){}
		return slopes.get(i-1);
	}
	/**
	 * sets the y position of this moving line
	 * @param y
	 */
	public void setY(double y){
		//ya;
	}
	
	/**
	 * can be used for two point lines
	 * @param p1
	 * @param p2
	 */
	public void setPoints(Point p1,Point p2){
		points.clear();
		if(p1.x<p2.x){
			points.add(p1);
			points.add(p2);
		}else{
			points.add(p2);
			points.add(p1);
		}
		calculateSlopes();
	}
	
	/**
	 * uses for test rendering
	 * @param g
	 */
	public void testRender(Graphics2D g){
		int i=0;
		while(i<points.size()-1){
			g.setColor(Color.BLACK);
			g.drawLine((int)(xPos+points.get(i).x), (int)points.get(i).y, (int)(xPos+points.get(i+1).x), (int)points.get(i+1).y);
			i++;
		}
		
	}
	
	
	
	
	
	
	
	
}
