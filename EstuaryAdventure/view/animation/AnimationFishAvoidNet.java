package animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import enemies.Hook;
import misc.Renderable;
import misc.Tickable;
import misc.Util;

/**
 * animation that defines to show the fish avoiding the net before the first game
 * @author abrah
 *
 */
public class AnimationFishAvoidNet implements Tickable,Renderable {

	private AnimationFish animationFish;
	private AnimationFish animationFish2;
	private AnimationFish animationFish3;
	private AnimationHook hook;
	
	private SpriteSheet keyboard;
	private int keyNum=1;

	/**
	 * creates this animation
	 */
	public AnimationFishAvoidNet() {
		int baseX=200;
		int baseY=200;
		animationFish = new AnimationFish(100+baseX, -100+baseY, 0, 3);
		animationFish2 = new AnimationFish(250+baseX, baseY, 0, 0);
		animationFish3 = new AnimationFish(50+baseX, 50+baseY, 0, 5);
		hook = new AnimationHook(Util.getDISTANCE_TO_EDGE()-800, -1500, Hook.DOUBLE_2);
		
		BufferedImage keyboards = null;
		try {
			keyboards=Util.loadImage("/Keyboard.png", this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		keyboard = new SpriteSheet(keyboards, 1, 7, 150, 150);
	}
	
	/**
	 * draws this animation using the given graphics ojbect
	 */
	@Override
	public void render(Graphics2D g) {
		animationFish.render(g);
		animationFish2.render(g);
		animationFish3.render(g);
		hook.render(g);
		g.drawImage(keyboard.getSprite(1, keyNum),-250,400,500,500,null);

		
	}
	
	
	private int state=WAIT_0;
	private static final int WAIT_0=-1;
	private static final int MOVE_RIGHT=0;
	private static final int WAIT_HERE=5;
	private static final int MOVE_LEFT=2;
	//private static final int WAIT_1=1;
	private static final int MOVE_UP=3;
	private static final int MOVE_DOWN=4;
	private static final int WAIT_3=6;
	private static final int WAIT_4=7;
	private long timer=0;
	
	/**
	 * state machine
	 */
	@Override
	public void onTick() {
		
		if(state==WAIT_0){
			animationFish.stop();
			animationFish2.stop();
			animationFish3.stop();
			keyNum=1;
			if(timer>60){state=MOVE_RIGHT;timer=0;
			animationFish.stop();
			animationFish2.stop();
			animationFish3.stop();}
		}else if (state==MOVE_RIGHT){
			keyNum=5;
			if(animationFish.getX()<450){
				animationFish.moveRight();
				animationFish2.moveRight();
				animationFish3.moveRight();
			}else{
				timer=0;
				state=WAIT_HERE;
			}
		}
		if(state==WAIT_HERE){
			keyNum=1;
			animationFish.stop();
			animationFish2.stop();
			animationFish3.stop();
			if(timer>60){state=MOVE_LEFT;timer=0;
			}
		}
		if (state==MOVE_LEFT){
			keyNum=2;
			if(animationFish.getX()>350){
				animationFish.moveLeft();
				animationFish2.moveLeft();
				animationFish3.moveLeft();
			}else{
				timer=0;
				state=WAIT_3;
			}
		}if(state==WAIT_3){
			keyNum=1;
			animationFish.stop();
			animationFish2.stop();
			animationFish3.stop();
			if(timer>60){state=MOVE_UP;timer=0;
			}
		}else if (state==MOVE_UP){
			keyNum=3;
			if(animationFish.getY()>-400){
				animationFish.moveUp();
				animationFish2.moveUp();
				animationFish3.moveUp();
			}else{
				timer=0;
				state=WAIT_4;
			}
		}
		if(state==WAIT_4){
			keyNum=1;
			animationFish.stop();
			animationFish2.stop();
			animationFish3.stop();
			if(timer>60){state=MOVE_DOWN;timer=0;
			}
		}
		else if (state==MOVE_DOWN){
			keyNum=4;
			if(animationFish.getY()<-300){
				animationFish.moveDown();
				animationFish2.moveDown();
				animationFish3.moveDown();
			}else{
				timer=0;
				state=WAIT_0;
			}
		}
		timer++;
		
		animationFish.onTick();
		animationFish2.onTick();
		animationFish3.onTick();
		hook.onTick();
		
		
	}
	

}
