package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
/**
 * class for modeling the behavoir of the menu screen
 * @author abrah
 *
 */
public class MenuScreen implements Tickable,Renderable,MouseListener,MouseMotionListener,KeyListener,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7530214348178987192L;
	private boolean isDone;
	private final RectBounds startButton = new RectBounds(800, -1000, 1000, 600);
	private final Font titleFont = new Font("default",Font.BOLD,200);
	private BufferedImage background,startGlow;
	private boolean overStart=false;
	
	/**
	 * creates the menu screen
	 */
	public MenuScreen(){
		isDone = false;
		loadRes();
	}
	
	/**
	 * loads the resources needs for this menus screen
	 */
	public void loadRes(){
		try {
			background = Util.loadImage("/menuScreen.png", this);
			startGlow=Util.loadImage("/menuScreen-startglow.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * defines how to render this menu screen
	 */
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.drawImage(background,-Util.getDISTANCE_TO_EDGE(),-1000,Util.getCANVAS_WIDTH_SCALED(),2000,null);
		//g.drawRect(startButton.getX(), startButton.getY(), startButton.getXLength(), startButton.getYLength());
		
		if(overStart){
			g.drawImage(startGlow, 500, -1500, 2000, 2000, null);
		}
		
	}

	/**
	 * does nothing for the menu screen
	 */
	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * returns whether or not the menu screen is done, and that the game should 
	 * move on to the next state
	 * @return
	 */
	public boolean isDone(){
		return isDone;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Util.isInBox(e, startButton)){
			isDone = true;
		}
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(Util.isInBox(e, startButton)){
			overStart = true;
		}else 
			overStart=false;
		
	}

}
