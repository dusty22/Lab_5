package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import animation.SpriteSheet;
import misc.Util;

/**
 * Fish is a model class for the fish that the player controls
 * @author abraham
 *
 */
public class Fish extends Character {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1015644809982634515L;
	
	
	private boolean hasCollided;
	
	private double lag;
	
	private double lagC;
	
	private double xVel,yVel;
	
	private double lostGround;
	private boolean leftPressed,rightPressed,upPressed,downPressed;
	private boolean leftReleased,rightReleased=false;
	private static boolean keysReleasedAfterGetBack=true;
	
	private boolean stopCheating=false;
	private double angle,angleVel;
	
	private boolean captured=false;
	
	private static int next;
	private final int whichDeath=(++next%4);
	
	
	private double initialX;
	private static boolean getBack=false;
	private static boolean controllable=true;
	private long controlCounter=1000;
	
	private static SpriteSheet fish;
	private int spriteNum=(int) (Math.random()*3+1);
	
	/**
	 * Creates a fish with initial x,y and default health value
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public Fish(double xPos, double yPos,double lag) {
		super(xPos, yPos);
		loadRes();
		this.lag = lag;
		lagC=lag;
		this.initialX=xPos;
		forward=Math.random()>0.5?true:false;
		
	}
	
	/**
	 * How a fish is positioned on a hook when it dies
	 * @return whichDeath of fish 
	 */
	public int getWhichDeath(){
		return whichDeath;
	}
	
	/**
	 * loads image of fish
	 */
	public void loadRes(){
		if(fish==null){
			BufferedImage tmp=null;
			try {
					tmp = Util.loadImage("/Goldfish5x(150x150).png", this);
					fish=new SpriteSheet(tmp,1,5,150,150);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * onTick is called 60 times per second and determines how a fish moves
	 */
	@Override
	public void onTick(){
		if(!leftPressed && !rightPressed){
			keysReleasedAfterGetBack=true;
		}
		if(leftReleased && controllable){
			leftPressed = false;
			if(!rightPressed)
				lagC=lag;
			leftReleased=false;
		}
		
		if(rightReleased && controllable){
			rightPressed = false;
			if(!leftPressed)
				lagC=lag;
			rightReleased=false;
		}
		
		if(leftPressed && !rightPressed && !getBack && controllable && keysReleasedAfterGetBack){
			xVel=-5+lagC;
			lostGround-=lagC;
			swimSpeed=12;
			spriteNum=5;
		}
		else if(rightPressed && !leftPressed &&!getBack && controllable && keysReleasedAfterGetBack){
				xVel=5-lagC;
				lostGround+=lagC;
				swimSpeed=2;
				
		}else{
			if(lostGround>3){
				xVel=5;
				lostGround-=5;
			}
			else if(lostGround<-3){
				xVel=-5;
				lostGround+=5;
			}
				
		}
		if(upPressed && !getBack && controllable){
			yVel=-5;
			if(angle>-Math.PI/10.0f)
				angleVel=-.01;
			swimSpeed=2;
		}
		else if(downPressed && !stopCheating && !getBack && controllable){
			yVel=6;
			if(angle<Math.PI/10.0f)
				angleVel=.01;
			swimSpeed=3;
			
		}
		
		if(xPos<-(6f/7f)*Util.getDISTANCE_TO_EDGE()){
			getBack=true;
			leftPressed=false;
			rightPressed=false;
			leftReleased=true;;
			rightReleased=true;
			controllable=false;
			controlCounter=0;
			keysReleasedAfterGetBack=false;
			
			
		}
		if(xPos>(3f/4f)*Util.getDISTANCE_TO_EDGE()){
			getBack=true;
			leftPressed=false;
			rightPressed=false;
			rightReleased=true;
			leftReleased=true;
			controllable=false;
			controlCounter=0;
			keysReleasedAfterGetBack=false;
		
			
		}
		if(getBack){
			controlCounter=0;
			keysReleasedAfterGetBack=false;
			
		}
		
		if(Math.abs(xPos-initialX)<8 && (getBack)){
			xPos=initialX;
			getBack=false;	
		}
		if(controlCounter>90){
			controllable=true;
				
		}
		controlCounter++;
		
		
		if(getBack){
			xVel-=(xPos-initialX)/2000.0;
		}
		if(xVel<0){
			if(xVel<-10){xVel=-10;}
		}else if(xVel>0){
			if(xVel>10){xVel=10;}
		}
		
		
		
		xPos+=xVel;
		if(xVel>.15){
			xVel-=.15;
		}else if(xVel<-.15){
			xVel+=.15;
		}else
			xVel=0;
		if(rightPressed || leftPressed)
			lagC=lagC>0.1 ? lagC-0.1:0;
		
		yPos+=yVel;
		if(yVel>.15){
			yVel-=.15;
		}else if(yVel<-.15){
			yVel+=.15;
		}else
			yVel=0;
		
		angle+=angleVel;
		
		if(angle<-0.01){
			angleVel=.005;
		}
		else if(angle>0.01){
			angleVel=-.01;
		}else{
			angleVel=0;
			
		}
		
		swim();
		
	}
	
	private boolean forward;
	private long limitSwim=0;
	private int swimSpeed=4;
	/**
	 * handles the changing of the spriteNum for swimming animation
	 */
	private void swim(){
		if(limitSwim%swimSpeed==0 && swimSpeed<=7){
			if(spriteNum==1){
				if(forward){
					spriteNum=3;
					forward=false;
				}else{
					spriteNum=2;
					forward=true;
				}
			}
			else if(!leftPressed){
				spriteNum=1;
			}
		}
		limitSwim++;
		if(limitSwim%7==0 && swimSpeed!=6){
			if(swimSpeed>6){
				swimSpeed-=1;
			}if(swimSpeed<6){
				swimSpeed+=1;
			}
		}
		
	}
	/**
	 * @param g render 2D graphics of fish
	 */
	@Override
	public void render(Graphics2D g){
		g.translate(getX(), getY());
		g.rotate(angle);
		g.drawImage(fish.getSprite(1, spriteNum),0,0,200,200,null);
		g.rotate(-angle);
		g.translate(-getX(), -getY());
	}
	
	/**
	 * implements move according to how a fish moves
	 * @param dx the change in x 
	 * @param dy the change in y
	 */
	@Override
	public void move(double dx, double dy) {
		xPos+=dx;
		yPos+=dy;
		
	}
	
	/**
	 * returns if fish has collided with another object 
	 * @return hasCollided 
	 */
	public boolean hasCollided(){
		return hasCollided;
	}
	
	
	/**
	 * returns whether or not the game is controllable
	 * @return
	 */
	public boolean isControllable(){
		return controllable;
	}
	/**
	 * sees how a fish has collided, either with net or hook
	 * @param b sees by which a fish has been captured
	 */
	public void setCaptured(boolean b){
		this.captured=b;
		if(b==true){
			spriteNum=4;
		}
	}
	
	/**
	 * checks to see if a fish is captured
	 * @return captured if fish is captured
	 */
	public boolean isCaptured(){
		return captured;
	}
	
	/**
	 * prevents fish from going below sea floor level
	 * @param b boolean to set the stopCheating variable
	 */
	public void setStopCheating(boolean b){
		this.stopCheating = b;
	}
	
	/**
	 * sets the angle of the fish based on the direction that they are moving in
	 * @param rad double to set the angle of the fish
	 */
	public void setAngle(double rad){
		this.angle=rad;
	}
	
	/**
	 * increases teh angle of the fish if fish are going in particular direction for extended period of time
	 * @param rads double to increase the angle of fish
	 */
	public void increaseAngle(double rads){
		angle+=rads;
	}
	
	public static boolean getBack(){
		return getBack;
	}
	
	/////*** listeners ***///////
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if(!rightPressed)
				leftPressed = true;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(!leftPressed)
				rightPressed = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			if(!downPressed)
				upPressed = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			if(!upPressed)
				downPressed= true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			leftReleased=true;
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rightReleased=true;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			upPressed = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			downPressed= false;
		}
		
		
		
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
	



	
	
}
