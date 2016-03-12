package animation;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import animation.SpriteSheet;
import characters.Character;
import misc.ArbitraryLine;
import misc.Util;
/**
 * an editing game 3 crab for animation purposes
 * @author abrah
 *
 */
public class AnimationGame3Crab extends Character{

	
	private SpriteSheet sprites;
	private boolean leftPressed,rightPressed,upPressed;
	private boolean spacePressed;
	private long squeezeTimer=0;
	private boolean squeezingFish=false;
	private int spriteCol=1;
	private int spriteRow=1;
	private int spriteTime=0;
	//private ArbitraryLine seaFloor;
	private double angle=0;
	private double slope=0;
	private boolean jump=false;
	private double yVel=0;;
	
	private double initialYPos;
	
	
	private boolean isHoldingFish=false;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8431818079245300953L;

	public AnimationGame3Crab(double xPos,int yPos) {
		super(xPos, yPos);
		initialYPos=yPos;
		loadRes();
		
	}
	/**
	 * loads the crag image used to represent the Crab character
	 */
	private void loadRes(){
		BufferedImage crabs = null;
		try {
			crabs = Util.loadImage("/crabsprite(150x150)game3ANIMATION.png", this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sprites = new SpriteSheet(crabs, 2, 3, 150, 150);
		
	}
	
	
	private boolean reachedVertex=false;
	public void onTick(){
		//slope=seaFloor.getSlopeAt(xPos+150)/1.5;
		//System.out.println(slope);
		if(!jump){
			if(leftPressed){
				if(!isHoldingFish){
					if(spriteCol==1){
						spriteCol=3;
					}
					if(spriteTime>=6){
						spriteTime=0;
						if(spriteCol==2){spriteCol=3;}
						else if (spriteCol==3){spriteCol=2;}
					}
					if(slope>.5)
						xPos-=3;
					else
						xPos-=5;
				}else{
					if(slope>.5)
						xPos-=1;
					else
						xPos-=1.5;
					//DO HOLDING WALKING HERE
				}
				
				xPos=xPos<-Util.getDISTANCE_TO_EDGE()-30?-Util.getDISTANCE_TO_EDGE()-30:xPos;
				//yPos=seaFloor.getYatXPos(xPos+150)-200;
			}
			
			if(rightPressed){
				if(!isHoldingFish){
					if(spriteCol==1){
						spriteCol=2;
					}
					if(spriteTime>=6){
						spriteTime=0;
						if(spriteCol==2){spriteCol=3;}
						else if (spriteCol==3){spriteCol=2;}
					}
					if(slope>.5)
						xPos+=3;
					else
						xPos+=5;
				}else{
					if(slope>.5)
						xPos+=1;
					else
						xPos+=1.5;
					//DO WALKING HERE
				}
				
				xPos=xPos>Util.getDISTANCE_TO_EDGE()-250?Util.getDISTANCE_TO_EDGE()-250:xPos;
				//yPos=seaFloor.getYatXPos(xPos+150)-200;
			}
			if(upPressed){
				jump=true;
				yVel=-50;
			}
			if(leftPressed||rightPressed)
				spriteTime++;
			else
				spriteTime=0;
			
			
			angle+=(slope-angle)/6f;
			
			
			if(spacePressed && !squeezingFish && isHoldingFish){
				squeezingFish=true;
				spriteRow=2;
				spriteCol=2;
				squeezeTimer=0;
				
			}else if(squeezeTimer>10 && isHoldingFish && !spacePressed){
				squeezingFish=false;
				spriteRow=2;
				spriteCol=1;
			}
			squeezeTimer++;
		}
		if(jump){
			yPos+=yVel;
			yVel+=5;
			if(Math.abs(yVel)<3){
				reachedVertex=true;
				isHoldingFish=!isHoldingFish;
				if(isHoldingFish){
					spriteRow=2;
					spriteCol=1;
				}else{
					spriteRow=1;
					spriteCol=1;
				}
			}
			
			
			if (reachedVertex && yPos>=initialYPos){///important for jumping   <<------
				//yPos=seaFloor.getYatXPos(xPos+150)-200;
				jump=false;
				reachedVertex=true;
			}
			
		}
		
	}
	
	public void stop(){
		leftPressed=false;
		rightPressed=false;
		upPressed=false;
		//spriteCol=1;
		//spriteRow=1;
		//rightReleased=true;
		//leftReleased=true;
	}
	public void pressSpace(){
		spacePressed=true;
	}
	public void releaseSpace(){
		spacePressed=false;
	}
	public void moveRight(){
		//rightReleased=false;
		//leftReleased=true;
		rightPressed=true;
		leftPressed=false;
		upPressed=false;
	}
	public void moveLeft(){
		//rightReleased=true;
		//leftReleased=false;
		rightPressed=false;
		leftPressed=true;
		upPressed=false;
		
	}
	public void pressUp(){
		rightPressed=false;
		leftPressed=false;
		upPressed=true;
		
	}
	public void jump(){
		if(xPos>-900){
			leftPressed=true;
			upPressed=false;
			if(isHoldingFish){
				upPressed=true;
			}
		}else{
			upPressed=true;
			leftPressed=false;
		}
	}
	@Override
	public void render(Graphics2D g) {
		g.translate(xPos+150,yPos+150);
		g.rotate(angle);
		g.drawImage(sprites.getSprite(spriteRow, spriteCol),-150, -150,300,300,null);
		
		g.rotate(-angle);
		g.translate(-xPos-150, -yPos-150);
		
	}

	
	public double getAngle(){
		return angle;
	}
	public ArbitraryLine getSeaFloor(){
		return null;
		
	}
	
	public boolean isHoldingFish(){
		return isHoldingFish;
	}
	
	public boolean isSqueezingFish(){
		return squeezingFish;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			leftPressed=true;
		}if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rightPressed=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			upPressed=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			spacePressed=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			spriteCol=1;
			leftPressed=false;
		}if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rightPressed=false;
			spriteCol=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			upPressed=false;
			spriteCol=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			spriteCol=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			spacePressed=false;
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

	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}

	

}
