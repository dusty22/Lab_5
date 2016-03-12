package misc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import games.Game;
/**
 * models the dialog box after each game is over
 * @author abrah
 *
 */
public class DialogBox implements Tickable,Renderable,Serializable,MouseListener,MouseMotionListener {
	
	private BufferedImage selectedButton,leftButton,rightButton,titleCaught,titleNiceJob,titleGreat;
	private boolean overRightButton,overLeftButton;
	private Game host;
	
	private String key1,info1,key2,info2,message,message2;
	private final Font keyFont = new Font("default",Font.BOLD,60);
	private final Font infoFont = new Font("default",Font.BOLD,60);
	private final Font messageFont = new Font("default",Font.ITALIC,60);
	
	private Color keyColor = Color.BLUE;
	private Color infoColor = Color.RED;
	private Color messageColor = new Color(39,135,32);
	private Stroke stroke = new BasicStroke(20);
	private Color bgColor= new Color(234,200,63);
	/**
	 * 
	 */
	private static final long serialVersionUID = 5904433052230976135L;

	public static final int TITLE_CAUGHT=0;
	public static final int TITLE_NICE_JOB=1;
	public static final int TITLE_GREAT=2;
	
	private int title;
	
	/**
	 * creates a dialog box
	 * @param host
	 */
	public DialogBox(Game host){
		this.host= host;
		loadRes();
		title=TITLE_CAUGHT;
	}
	/**
	 * loads resouces for the dialog box
	 */
	private void loadRes(){
		try {
			selectedButton = Util.loadImage("/selectedButtonOverlay.png",278,282,this);
			leftButton = Util.loadImage("/DialogBox-leftButton.png",294,280, this);
			rightButton = Util.loadImage("/DialogBox-rightButton.png",304,294, this);
			titleCaught = Util.loadImage("/title-caught.png",600,200, this);
			titleNiceJob = Util.loadImage("/title-goodjob.png",600,200, this);
			titleGreat = Util.loadImage("/title-great.png",600,200, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * defines how to render
	 */
	@Override
	public void render(Graphics2D g) {
		g.setColor(bgColor);
		
		g.fillRoundRect(-520, -650, 1100, 1100, 200, 200);
		g.setColor(Color.BLACK);
		g.setStroke(stroke);
		g.drawRoundRect(-520, -650, 1100, 1100, 200, 200);
		
		g.drawImage(leftButton,-270,100, null);
		g.drawImage(rightButton, 60, 100, null);
		
		if(overRightButton)
			g.drawImage(selectedButton,75,100,null);
		
		if(overLeftButton)
			g.drawImage(selectedButton, -270, 100, null);
		
		if(title==TITLE_CAUGHT){
			g.drawImage(titleCaught, -250, -600, null);
		}
		else if(title==TITLE_GREAT){
			g.drawImage(titleGreat, -250, -600, null);
		}else if(title==TITLE_NICE_JOB){
			g.drawImage(titleNiceJob, -295, -600, null);
		}
		g.setColor(keyColor);
		g.setFont(keyFont);
		if(key1!=null)
			g.drawString(key1, -490, -325);
		if(key2!=null)
			g.drawString(key2, -490, -190);
		g.setColor(infoColor);
		g.setFont(infoFont);
		if(info1!=null)
			Util.drawCenteredString(info1, 350, -325, g);
		if(info2!=null)
			Util.drawCenteredString(info2, 100, -190, g);
		
		g.setColor(messageColor);
		g.setFont(messageFont);
		if(message!=null)
			Util.drawCenteredString(message, 27, -60, g);
		if(message2!=null)
			Util.drawCenteredString(message2, 27, 40, g); 
		
		
		
	}
	/**
	 * implements on Tick
	 */
	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * sets the title for this dialog box, using one of the predifined contant ints in this class
	 * @param title
	 */
	public void setTitle(int title){
		this.title=title;
	}
	
	
	/**
	 * sets the label for the first piece of info
	 * @param key1
	 */
	public void setKey1(String key1) {
		if (this.key1==null)
			this.key1 = key1;
	}
	/**
	 * sets the message for the first piece of info
	 * @param info1
	 */
	public void setInfo1(String info1) {
		if (this.info1==null)
			this.info1 = info1;
	}
	/**
	 * sets the label for the second piece of info
	 * @param key2
	 */
	public void setKey2(String key2) {
		if(this.key2==null)
			this.key2 = key2;
	}
	/**
	 * sets the message for the second piece of info
	 * @param info2
	 */
	public void setInfo2(String info2) {
		if(this.info2==null)
			this.info2 = info2;
	}
	/**
	 * sets the first line of the message at the bottom of the dialog box
	 * @param message
	 */
	public void setMessageL1(String message) {
		if(this.message==null)
			this.message = message;
	}
	/**
	 * sets the second line of the message at hte botttom the of dialog box
	 * @param message2
	 */
	public void setMessageL2(String message2){
		if(this.message2==null){
			this.message2=message2;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private Point rightBCenter = new Point(180,240);
	private Point leftBCenter = new Point(-140,240);
	@Override
	public void mouseMoved(MouseEvent e) {
		if(Util.isInCircle(e, rightBCenter, 130)){
			overRightButton=true;
		}else
			overRightButton=false;
		
		if(Util.isInCircle(e, leftBCenter, 130)){
			overLeftButton=true;
		}else
			overLeftButton=false;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(overRightButton){
			host.setIsDone(true);
		}
		if(overLeftButton){
			host.sendStopSignal();
		}
		
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

}
