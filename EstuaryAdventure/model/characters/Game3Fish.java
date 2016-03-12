package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import animation.SpriteSheet;
import misc.Util;

/**
 * fish for game 3
 * @author abrah
 *
 */
public class Game3Fish extends Character {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7090938780360351384L;

	private static SpriteSheet fish;
	private int spriteCol=1;
	private int spriteRow=1;
	private double angle=0;
	private Game3Crab crab;
	
	/**
	 * creates a fish for game 3
	 * @param crab the crab to follow
	 */
	public Game3Fish(Game3Crab crab) {
		super(crab.getX(), crab.getY()-100);
		this.crab=crab;
		loadRes();
	}

	/**
	 * loads image of fish
	 */
	private void loadRes(){
		if(fish==null){
			BufferedImage tmp=null;
			try {
					tmp = Util.loadImage("/Goldfish(game3).png", this);
					fish=new SpriteSheet(tmp,2,5,150,150);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private double slope;
	
	/**
	 * implements the onTick method
	 */
	public void onTick(){
		spriteRow=1;
		spriteCol=1;
		if(!crab.isHoldingFish()){
			xPos+=( (crab.getX()+50)-xPos)/30.0;
			yPos+=((crab.getY()-200)-yPos)/30.0;
			
	
			
			if(crab.getX()+50<xPos){
				swimLeft=true;
				swimRight=false;
			}else if (crab.getX()+50>xPos){
				swimRight=true;
				swimLeft=false;
				
			}
			else{
				swimRight=false;
				swimLeft=false;
			}
			
			swimSpeed=8-(int)(Math.abs( (crab.getX()+50)-xPos)/10.0);
			
			
			slope=(8-swimSpeed)*(crab.getSeaFloor().getSlopeAt(xPos+1)/(1.5*15));
			slope=slope>.2?.2:slope;
			swimSpeed=swimSpeed<2?2:swimSpeed;
			if(swimRight){
				angle+=(slope-angle)/15f;
				swimRight();
			}
			else if(swimLeft){
				angle+=(slope-angle)/15f;
				swimLeft();
			}
		}
		
		if(crab.isHoldingFish()){
			angle=crab.getAngle();
			xPos=crab.getX()+54;
			yPos=crab.getY()-100;
			if(!crab.isSqueezingFish()){
				spriteRow=2;
				spriteCol=4;
			}else{
				spriteRow=2;
				spriteCol=5;
			}
			
		}
		
		
		
		
	}
	
	private boolean forward;
	private boolean swimRight,swimLeft;
	private long limitSwim=0;
	private int swimSpeed=8;
	/**
	 * causes this fish to swim right
	 */
	private void swimRight(){
		spriteRow=1;
		if(limitSwim%swimSpeed==0 && swimSpeed<=7){
			if(spriteCol==1){
				if(forward){
					spriteCol=3;
					forward=false;
				}else{
					spriteCol=2;
					forward=true;
				}
			}
			else{
				spriteCol=1;
			}
		}
		limitSwim++;
		
	}
	/**
	 * causes the fish to swim left
	 */
	private void swimLeft(){
		spriteRow=2;
		if(limitSwim%swimSpeed==0 && swimSpeed<=7){
			if(spriteCol==1){
				if(forward){
					spriteCol=3;
					forward=false;
				}else{
					spriteCol=2;
					forward=true;
				}
			}
			else{
				spriteCol=1;
			}
		}
		limitSwim++;
		
	}
	/**
	 * defines rendering
	 */
	@Override
	public void render(Graphics2D g) {
		if(!crab.isHoldingFish()){
			g.translate(xPos+100, yPos+100);
			g.rotate(angle);
			g.drawImage(fish.getSprite(spriteRow, spriteCol),-100,-100,200,200,null);
			g.rotate(-angle);
			g.translate(-xPos-100, -yPos-100);
		}
		else{
			g.translate(crab.getX()+150, crab.getY()+150);
			g.rotate(angle);
			g.drawImage(fish.getSprite(spriteRow, spriteCol),(int)(xPos-crab.getX()-150),(int)(yPos-crab.getY()-150),200,200,null);
			g.rotate(-angle);
			g.translate(-crab.getX()-150, -crab.getY()-150);
			
		}
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
		// TODO Auto-generated method stub
		
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

	/**
	 * not implemented
	 */
	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}

	

}
