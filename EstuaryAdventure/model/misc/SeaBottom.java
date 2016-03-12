package misc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

/**
 * models the seaBottom in the Overfishing game.
 * @author abraham
 *
 */
public class SeaBottom implements Renderable,Tickable,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1098311585570336867L;
	private int xPos=-Util.getDISTANCE_TO_EDGE();;
	private int xPos2 = Util.getDISTANCE_TO_EDGE()*3-30;
	
	
	private ArbitraryLine line1,line2;
	
	private static BufferedImage seaFloor;
	
	private static final int[] points = {0,250,180,224,292,136,428,144,636,384,912,300,1084,176,1184,180,1300,244,1544,204,1616,172,1732,180,1876,368,2020,376,2372,256,2512,272,2716,340,2880,292,2968,260,3000,250};
	/**
	 * makes a new SeaBottom
	 */
	public SeaBottom(){
		loadRes();
		line1=new ArbitraryLine(points, Util.getDISTANCE_TO_EDGE()/750.0,750.0/500.0, 180);
		line2=new ArbitraryLine(points, Util.getDISTANCE_TO_EDGE()/750.0,750.0/500.0, 180);
		
	}
	
	/**
	 * loads the resources needed for the the sea bottom
	 */
	private void loadRes(){
		try {
			seaFloor = Util.loadImage("/sea floor.png", this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * defines the updating at 60Hz for the sea bottom
	 */
	@Override
	public void onTick() {
		xPos-=6;
		xPos2-=6;
		if(xPos<=-5*Util.getDISTANCE_TO_EDGE()){
			xPos=xPos2+(Util.getDISTANCE_TO_EDGE()*4-30);
			
		}
		else if(xPos2<=-Util.getDISTANCE_TO_EDGE() * 5){
			xPos2=xPos+Util.getDISTANCE_TO_EDGE()*4-30;
			
		}
		
		line1.setX(xPos);
		line2.setX(xPos2);
		
	}

	/**
	 * defines how to draw the sea Bottom
	 */
	@Override
	public void render(Graphics2D g) {
		g.drawImage(seaFloor, xPos,250,Util.getDISTANCE_TO_EDGE()*4,750,null);
		g.drawImage(seaFloor, xPos2, 250, Util.getDISTANCE_TO_EDGE()*4, 750, null);
		//line1.testRender(g);
		//line2.testRender(g);
	}
	
	
	/**
	 * reutrns true if the sea bottom and the Charcter c have collided
	 * @param c the character
	 * @return boolean true or false
	 */
	public boolean isIn(characters.Character c){
		
		return line1.isBelowLine(c.getX(), c.getY()) || line2.isBelowLine(c.getX(), c.getY());
	}
	

}
