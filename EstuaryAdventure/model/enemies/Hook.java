package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import animation.SpriteSheet;
import characters.Fish;
import misc.Util;

/**
 * the Hook class is used to model hooks
 * @author abraham
 *
 */
public class Hook extends Enemy {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4415134457991027093L;
	public static final int SINGLE=0;
	public static final int DOUBLE_1=1;
	public static final int DOUBLE_2=2;
	
	private static SpriteSheet hooks=null;
	
	private boolean up,down;
	
	private ArrayList<Fish> attachedFish;
	
	private int type;
	
	/**
	 * Creates a hook with initial x,y,and size
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param type the type of this hook
	 */
	public Hook(double xPos,double yPos,int type){
		super (xPos,yPos);
		this.type = type;
		up=false;
		down=true;
		loadRes();
		
		attachedFish=new ArrayList<Fish>();
	}

	/**
	 * load hook image
	 */
	private void loadRes(){
		if(hooks==null){
			BufferedImage hooks_tmp=null;
			try {
				hooks_tmp = Util.loadImage("/hooks-sprite(3)(250x700).png",this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hooks = new SpriteSheet(hooks_tmp, 1, 3, 750, 250);
		}
	}
	
	/**
	 * implements the act() method from Enemy
	 */
	@Override
	public void act() {
		moveUpAndDown();
		xPos-=6;
		
		for(Fish f : attachedFish){
			if(type==SINGLE){
				if(f.getWhichDeath()==0){
					f.setX(xPos+250);
					f.setY(yPos+1400);
					f.setAngle(-Math.PI/4f);
				}if(f.getWhichDeath()==1){
					f.setX(xPos+450);
					f.setY(yPos+1650);
					f.setAngle(-Math.PI/2f-Math.PI/8f);
				}
				if(f.getWhichDeath()==2){
					f.setX(xPos+720);
					f.setY(yPos+1300);
					f.setAngle(-Math.PI-Math.PI/7f);
				}
				if(f.getWhichDeath()==3){
					f.setX(xPos+360);
					f.setY(yPos+1200);
					f.setAngle(Math.PI/4f);
				}
				
			}
			if (type==DOUBLE_1){
				if(f.getWhichDeath()==0 || f.getWhichDeath()==1){
					if(f.getX()<xPos+300){
						f.setX(xPos+250);
						f.setY(yPos+1400);
						f.setAngle(-Math.PI/4f);
					}
					if(f.getX()>xPos+300){
						f.setX(xPos+550);
						f.setY(yPos+1300);
						f.setAngle(Math.PI/4f);
					}
				}
				if(f.getWhichDeath()==2 || f.getWhichDeath()==3){
					if(f.getX()<xPos+300){
						f.setX(xPos+220);
						f.setY(yPos+1150);
						f.setAngle(Math.PI/4f);
					}
					if(f.getX()>xPos+300){
						f.setX(xPos+750);
						f.setY(yPos+1275);
						f.setAngle(-5*Math.PI/4f);
					}
				}
			}
			if(type==DOUBLE_2){
				if(f.getWhichDeath()==0 || f.getWhichDeath()==1){
					if(f.getX()<xPos+300){
						f.setX(xPos+250);
						f.setY(yPos+1400);
						f.setAngle(-Math.PI/4f);
					}
					if(f.getX()>xPos+300){
						f.setX(xPos+550);
						f.setY(yPos+1300);
						f.setAngle(Math.PI/4f);
					}
				}
				if(f.getWhichDeath()==2 || f.getWhichDeath()==3){
					if(f.getX()<xPos+300){
						f.setX(xPos+220);
						f.setY(yPos+1150);
						f.setAngle(Math.PI/4f);
					}
					if(f.getX()>xPos+300){
						f.setX(xPos+750);
						f.setY(yPos+1275);
						f.setAngle(-5*Math.PI/4f);
					}
				}
			}
		}
		
		
	}
	/**
	 * render graphics
	 */
	@Override
	public void render(Graphics2D g){
		if(type==SINGLE){
			g.drawImage(hooks.getSprite(1, 1),(int)xPos,(int)yPos,800,1500,null);
		}
		else if (type==DOUBLE_1){
			g.drawImage(hooks.getSprite(1, 2),(int)xPos,(int)yPos,800,1500,null);
		}else if (type==DOUBLE_2){
			g.drawImage(hooks.getSprite(1, 3),(int)xPos,(int)yPos,800,1500,null);
		}
		
		for(Fish f: attachedFish){
			f.render(g);
		}
		
	}
	
	/**
	 * cause the hook to move randomly up and down on the screen
	 */
	private void moveUpAndDown(){
		if(yPos<-2000){
			up = false;
			down = true;
		}
		else if(yPos>-1000){
			up=true;
			down=false;
		}
		
		if(up){
			yPos-=8;
		}
		else if(down){
			yPos+=8;
		}
	}
	/**
	 * collision detection of fish and hook
	 */
	public boolean isIn(Fish fish){
		
		if(type==SINGLE){
			return(fish.getX()>xPos+200 && fish.getX()<xPos+400 &&
					fish.getY()>yPos+1200 && fish.getY()<yPos+1400);
		}
		
		if (type==DOUBLE_1){
			return(fish.getX()>xPos+100 && fish.getX()<xPos+500 &&
					fish.getY()>yPos+1200 && fish.getY()<yPos+1400);
		}
		if(type==DOUBLE_2){
			return(fish.getX()>xPos+100 && fish.getX()<xPos+500 &&
					fish.getY()>yPos+1200 && fish.getY()<yPos+1400);
		}
		
		return false;
	}
	
	/**
	 * add fish to hook
	 */
	public void addAttachedFish(Fish f){
		attachedFish.add(f);
	}
	/**
	 * remove fish from hook
	 */
	public void removeAttachedFish(){
		attachedFish.clear();
	}
	

	/**
	 * 
	 * @return the type of the hook
	 */
	public int getType(){
		return type;
	}
	
	
}
