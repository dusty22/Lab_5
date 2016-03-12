package mainView;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import misc.Renderable;
import misc.Util;
/**
 * Handles rendering the View for all games
 * @author abraham
 *
 */
public class EstuaryView extends Canvas{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4412289037175187075L;
	
	
	
	private static BufferStrategy bs;
	/**
	 * implements a triple buffer strategry for rendering the view
	 */
	public void render(Renderable r){
		bs = this.getBufferStrategy(); //creates triple buffer
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		storeScreenInfo();
		g.translate(getWidth()/2.0,getHeight()/2.0);
		g.scale(getHeight()/(2000.0), getHeight()/2000.0);
		////// DO RENDERING HERE///////
		
		r.render(g);
		
		///////////////////////////////
		
		
		g.dispose();//releases resources
		bs.show(); //shows next available buffer
		
	}
	
	
	/**
	 * stores screen info into the static util class for later use in all other classes
	 */
	public void storeScreenInfo(){
		Util.setDistanceToEdge(getWidth(), getHeight());
		Util.setCanvasHeight(getHeight());
		Util.setCanvasWidth(getWidth());
		Util.setCurrentScaleFactor(getHeight()/2000.0);
	}
	
	
	
	
}
