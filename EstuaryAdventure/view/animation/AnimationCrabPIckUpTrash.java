package animation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import characters.Character;
import enemies.Trash;
import misc.Util;

/**
 * animation to show the crab picking up trash before the second game
 * @author abrah
 *
 */
public class AnimationCrabPIckUpTrash extends Character{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2918553662290310728L;	
	
	private SpriteSheet sprites;
	private SpriteSheet keyboard;
	private int keyNumTop=1;
	
	private int spriteNum=1;
	private int spriteTime=0;
	
	private Trash attachedTrash;
	private boolean isHoldingTrash;
	private boolean drawPowerBar=false;
	private boolean leftPressed,rightPressed,upPressed,downPressed=false;
	
	private BufferedImage greenArrow;
	private Color barColor=Color.GREEN;
	
	
	private int barLength;
	
	private double yVel;
	private boolean jump,reachedVertex2=false;
	private double lastScale,scale;
	private double lastY;
	
	
	
	/**
	 * creates this animation
	 */
	public AnimationCrabPIckUpTrash() {
		super(-100, -500);
		loadRes();
		trash2.setScale(1);
	
		
	}
	
	/**
	 * loads the crab image used to represent the Crab character
	 */
	private void loadRes(){
		BufferedImage crabs = null;
		BufferedImage keyboards = null;
		try {
			crabs = Util.loadImage("/crabsprite(150x150)ANIMATION.png", this);
			keyboards=Util.loadImage("/Keyboard.png", this);
			greenArrow = Util.loadImage("/greenarrow.png", this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sprites = new SpriteSheet(crabs, 1, 4, 150, 150);
		keyboard = new SpriteSheet(keyboards, 1, 7, 150, 150);
		
		
	}
	

	/**
	 * onTick is called 60 times per second and controls the movement of the Crab
	 */
	public void onTick(){
		executeAnimationSequence();
		if(leftPressed){
			if(spriteNum==1){
				spriteNum=3;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			xPos-=10;
			xPos=xPos<-Util.getDISTANCE_TO_EDGE()+5?-Util.getDISTANCE_TO_EDGE()+5:xPos;
			if(yPos<-490 && xPos < 725 && xPos>370){
				xPos+=10*(yPos+1000)/2000.0;
			}
		}
		if(rightPressed){
			if(spriteNum==1){
				spriteNum=2;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			xPos+=10;
			xPos=xPos>Util.getDISTANCE_TO_EDGE()-400*((1000+yPos)/1000.0)?Util.getDISTANCE_TO_EDGE()-400*((1000+yPos)/1000.0):xPos;
			
			if(yPos<-490 && xPos > 230 && xPos<370){
				xPos-=10*(yPos+1000)/2000.0;
			}
		
		}
		if(upPressed){
			if(spriteNum==1){
				spriteNum=2;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			yPos-=6*(yPos+800)/1500.0;
			xPos+=.5;
			
			if(yPos<-490 && xPos>250 && xPos<725){
				yPos+=6*(yPos+800)/1500.0;
				xPos-=.5;
			}
		}
		if(downPressed){
			if(spriteNum==1){
				spriteNum=3;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			yPos+=6*(yPos+1000)/1500.0;
			xPos-=.5;
			
		}
		
		if(leftPressed||rightPressed||upPressed||downPressed)
			spriteTime++;
		else
			spriteTime=0;
		
		holdTrash();
		if(isThrowingTrash){
			throwAttachedTrash();
		}
		if(spacePressed && isHoldingTrash){
			accumulateTime();
		}
		if(drawPowerBar){
			calculateBarLength();
		}
		
		
		
		for(Trash t : previouslyThrownTrash){
			
		}
		
		scale=400;
		if(jump){
			drawPowerBar=false;
			yPos+=yVel;
			yVel+=5;
			scale=lastScale;
			if(Math.abs(yVel)<3){
				reachedVertex2=true;
			}
			
			
			if (reachedVertex2 &&  lastY<yPos){
				yPos=lastY;
				jump=false;
				reachedVertex2=true;
				spriteNum=1;
			}
			
		}
		

		
	}
	
	private Trash trash2 = new Trash(135,-600,Trash.BOTTLE);
	private static final int MOVE_TOWARDS_TRASH_LEFT=0;
	private static final int MOVE_TOWARDS_TRASH_RIGHT=1;
	private static final int WIDE_EYES=2;
	private int state=MOVE_TOWARDS_TRASH_LEFT;
	private int waitTime=0;
	/**
	 * executes the animation sequence
	 */
	public void executeAnimationSequence() {
		if(state==MOVE_TOWARDS_TRASH_LEFT){
			
			if(waitTime>60){
				leftPressed=true;
				keyNumTop=2;
			}else{
				keyNumTop=1;
				waitTime++;
			}
			if(xPos<-600){
				state=MOVE_TOWARDS_TRASH_RIGHT;
				leftPressed=false;
				spriteNum=1;

			}
			
		}
		else if(state==MOVE_TOWARDS_TRASH_RIGHT){
			rightPressed=true;
			keyNumTop=5;
			if(xPos>100){
				if(attachedTrash==null){
					attachedTrash=trash2;
					state=MOVE_TOWARDS_TRASH_LEFT;
				}
				else{ attachedTrash=null;
					trash2.setY(trash2.getY()+230);
					state=WIDE_EYES;
					keyNumTop=1;
				
				}
				holdTrash();
				isHoldingTrash=true;
				rightPressed=false;
				waitTime=0;
				
				
				
				
			}
			
		}else if (state==WIDE_EYES){
			spriteNum=4;
			if(waitTime>60){
				state=MOVE_TOWARDS_TRASH_LEFT;
				spriteNum=1;
			}else{
				waitTime++;
			}
		}
		
		
	}

	public void accumulateTime(){
		
			if(timeSpacePressed==-1){
				timeSpacePressed=System.nanoTime();
				lastTime=timeSpacePressed;
				spaceReleased=false;
				drawPowerBar=true;
				timeHeld=0;
			}else{
				if(up && timeHeld>NANOS_MAX){
					up=false;
				}else if (!up && timeHeld<=NANOS_MAX/5.0){
					up=true;
				}
				if(up)
					timeHeld+=(System.nanoTime()-lastTime);
				else
					timeHeld-=(System.nanoTime()-lastTime);
				lastTime=System.nanoTime();
				
			}
			if(spaceReleased){
				spacePressed=false;
				if(isHoldingTrash){
					setPowerByTimePressed();
					isThrowingTrash=true;
					spacePressed=false;
					spaceReleased=false;
					drawPowerBar=false;
					timeSpacePressed=-1;
					timeHeld=0;
					up=true;
					
				}
			}
		
	}
	
	private void holdTrash(){
		if(isHoldingTrash && attachedTrash!=null){
			if(attachedTrash.getType()==Trash.SODA_CAN ){
				attachedTrash.setX(xPos+110+yPos/12.0);
				attachedTrash.setY(yPos-100-yPos/12.0);
			}
			if(attachedTrash.getType()==Trash.BANANA ){
				attachedTrash.setX(xPos+50+yPos/12.0);
				attachedTrash.setY(yPos-50-yPos/12.0);
			}
			if(attachedTrash.getType()==Trash.ROPE ){
				attachedTrash.setX(xPos+30+yPos/9.0);
				attachedTrash.setY(yPos-240-yPos/4.0);
			}
			if(attachedTrash.getType()==Trash.MILK_JUG ){
				attachedTrash.setX(xPos+yPos/25.0);
				attachedTrash.setY(yPos-230-yPos/4.0);
			}
			if(attachedTrash.getType()==Trash.BOTTLE ){
				attachedTrash.setX(xPos+100);
				attachedTrash.setY(yPos-230);
			}
			if(attachedTrash.getType()==Trash.SHOPPING_BAG ){
				attachedTrash.setX(xPos+50+yPos/20.0);
				attachedTrash.setY(yPos-240-yPos/4.5);
			}
			attachedTrash.act();
		}
	}
	
	
	private void calculateBarLength(){
		barLength=(int)((400+yPos/2.5)*
				(timeHeld/NANOS_MAX));
	}
	
	
	
	
	private double yPosArrow=630;
	private double yVelArrow=0;
	private double yAccArrow=3;
	private boolean down=true;
	/**
	 * @param g renders the graphics
	 */
	@Override
	public void render(Graphics2D g){
		
		for(Trash t: previouslyThrownTrash){
			t.render(g);
		}
		
		if(drawPowerBar){
			g.setColor(barColor);
			g.fillRoundRect((int)xPos,(int)( yPos+400+yPos/2.5+10),barLength+40,(int)( 10*(1+(yPos+500)/500)), 50, 50);
			g.setColor(Color.RED);
			g.setStroke(new BasicStroke((float) (8*(1+(yPos+500)/500))));
			g.drawRect((int)(xPos+(400+yPos/2.5)*.6), (int)( yPos+400+yPos/2.5+5), (int)((400+yPos/2.5)*0.2),(int)(18*(1+(yPos+500)/500)));
			g.drawImage(greenArrow, 530, (int)yPosArrow, null);
			yVelArrow+=yAccArrow;
			yPosArrow+=yVelArrow;
			if(down &&yPosArrow>650){
				yAccArrow=-yAccArrow;
				down=false;
			}else if (!down && yPosArrow<650){
				yAccArrow=-yAccArrow;
				down=true;
			}
		}
		
		renderThrownTrash(g);
		trash2.render(g);
		
		g.drawImage(keyboard.getSprite(1, keyNumTop), -Util.getDISTANCE_TO_EDGE()+400,-500,500,500,null);
		
	
		
		
	}
	
	private void renderThrownTrash(Graphics2D g){
		g.drawImage(sprites.getSprite(1, spriteNum), (int)xPos, (int)yPos, (int)(scale),(int)( scale),null);
		if(( isThrowingTrash|| isHoldingTrash) && attachedTrash!=null){
			attachedTrash.setScale(1);
			attachedTrash.render(g);
		}
		
		//g.drawLine(-1000, (int)lowestYThrowingTrash, 1000,(int)lowestYThrowingTrash);
		
		
		
	}
	
	
	private boolean isThrowingTrash=false;
	private boolean calculatedTrajecory=false;
	private boolean reachedVertex=false;
	private ArrayList<Trash> previouslyThrownTrash = new ArrayList<Trash>();
	/**
	 * implements Crab throwing object trash
	 */
	public void throwAttachedTrash(){
		
		if(!calculatedTrajecory)
			calculateTrajectory();
		
		attachedTrash.setX(attachedTrash.getX()+Vx);
		attachedTrash.setY(attachedTrash.getY()-Vy);
		Vy-=gravity;
		attachedTrash.act();
		if(reachedVertex==false && Math.abs(Math.abs(Vy)-gravity)<=gravity){
			reachedVertex=true;
		}
		
		
		
		if(reachedVertex && attachedTrash.getY()>150){
			isThrowingTrash=false;
			isHoldingTrash=false;
			calculatedTrajecory=false;
			attachedTrash.setBeingThrown(false);
			previouslyThrownTrash.add(attachedTrash);
			attachedTrash.setAngle(0);
			attachedTrash=null;
			reachedVertex=false;
			spriteNum=1;
		
		}
		
	}
	
	
	private int gravity=3;
	private double trashX=Util.getDISTANCE_TO_EDGE()-330;
	private double trashY=500;
	private double Vy;
	private double Vx;
	private double power=1.0;//1.0 is optimal
	private void calculateTrajectory(){
		double Xinit=attachedTrash.getX();
		double Yinit=attachedTrash.getY();
		Vy=power*Math.sqrt(2*gravity*(Yinit+400));
		double Tt = ((Vy/gravity)+(Math.sqrt((800+2*trashY)/gravity)));
		Vx = power*(trashX-Xinit)/Tt;
		calculatedTrajecory=true;
		isHoldingTrash=false;
		attachedTrash.setBeingThrown(true);
		lastY=yPos;
		lastScale=scale;
		yVel=-.09*power*scale;
		spriteNum=4;
		jump=true;
		
		
		
		
	}
	
	private boolean up=true;
	private long timeHeld=0;
	private boolean spacePressed,spaceReleased=false;
	private long lastTime;
	private long timeSpacePressed=-1;
	private static final double NANOS_MAX=500000000;
	private static final double POWER_MAX=1.2;
	
	/**
	 * sets the power of the throw according to time space bar is pressed
	 */
	private void setPowerByTimePressed(){
		
		double percetange = timeHeld/NANOS_MAX;
		if(percetange>.8){
			power=POWER_MAX;
		}else if (percetange>.6){
			power=1.0;//Optimal
		}else if (percetange > .4){
			power=0.8;
		}
		else if (percetange > .2){
			power=0.6;
		}
		else if (percetange > 0){
			power=0.4;
		}
			
		
	}
	
	
	private double buffer=150;
	public boolean isTouchingTrash(Trash t){
		if(isHoldingTrash || isThrowingTrash){
			return false;
		}
		switch(t.getType()){
			case Trash.BANANA: buffer=150*t.getScale();break;
			case Trash.SODA_CAN: buffer=200*t.getScale();break;
			case Trash.BOTTLE:buffer=180*t.getScale();break;
			case Trash.MILK_JUG: buffer=300*t.getScale();break;
			case Trash.SHOPPING_BAG:buffer=250*t.getScale();break;
			case Trash.ROPE: buffer=300*t.getScale();break;
			default: buffer=150;
		}
		return(xPos+400+yPos/2.5-buffer>t.getX() && yPos+400+yPos/2-buffer>t.getY()
				&& xPos+buffer<t.getX()+t.getWidth() && yPos+buffer<t.getY()+t.getHeight());

		
	}
	
	
	
	public boolean isHoldingTrash(){
		return isHoldingTrash;
	}
	public boolean isThrowingTrash() {
		return isThrowingTrash;
	}
	public void setIsHoldingTrash(boolean b){
		this.isHoldingTrash=b;
		if(b==false){
			attachedTrash=null;
		}
	}
	public void holdTrash(Trash t){
		attachedTrash=t;
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

	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}



	

}
