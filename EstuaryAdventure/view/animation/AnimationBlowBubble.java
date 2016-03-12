package animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import characters.Bubble;
import enemies.Pollutant;
import misc.Renderable;
import misc.Tickable;
import misc.Util;
import misc.Vector;

/**
 * defines the behavoir of the instructive animation before the pollution game
 * @author abrah
 *
 */
public class AnimationBlowBubble implements Tickable,Renderable {

	private AnimationGame3Crab crab;
	private AnimationGame3Fish fish;
	private ArrayList<Pollutant> pollutants;
	private ArrayList<Bubble> bubbles;
	private ArrayList<Pollutant> pollutantBank;
	private ArrayList<Bubble> bubbleBank;
	private ArrayList<Integer> availablePollutants;
	private ArrayList<Integer> availableBubbles;
	public boolean spacePressed=false;
	public boolean spaceReleased=true;
	private SpriteSheet keyboard;
	private int keyNum=1;
	private int spaceNum=6;
	/**
	 * creates the new animation
	 */
	public AnimationBlowBubble() {
		
		crab=new AnimationGame3Crab(0, 100);
		fish = new AnimationGame3Fish(crab);
		
		pollutants= new ArrayList<Pollutant>();
		bubbles=new ArrayList<Bubble>();
		
		pollutantBank= new ArrayList<Pollutant>();
		bubbleBank=new ArrayList<Bubble>();
		
		availablePollutants= new ArrayList<Integer>();
		for(int i=0;i<30;i++){availablePollutants.add(i);}
		availableBubbles=new ArrayList<Integer>();
		for(int i=0;i<5;i++){availableBubbles.add(i);}
		
		producePollutants();
		produceBubbles();
		addInitialPollutants();
		loadRes();
	}
	/**
	 * loades the resources
	 */
	private void loadRes(){
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
	 * draws to the screen
	 */
	@Override
	public void render(Graphics2D g) {
		crab.render(g);
		fish.render(g);
		for(Pollutant p : pollutants){
			p.render(g);
		}
		for(Bubble b: bubbles){
			b.render(g);
		}
		g.drawImage(keyboard.getSprite(1, keyNum), -500,500,500,500,null);
		g.drawImage(keyboard.getSprite(1, spaceNum), 0,500,500,500,null);

		
	}
	private long timer=0;
	private int state=WAIT_0;
	private static final int WAIT_0=0;
	private static final int GRAB_FISH=1;
	private static final int WAIT_1=2;
	private static final int SHOOT_BUBBLE_1=3;
	private static final int WAIT_2=4;
	private static final int LET_FISH_GO=5;
	private static final int WAIT_3=6;
	private static final int MOVE_1=7;;
	private static final int WAIT_4=8;
	private int goToXPos=0;
	private int blowCount=0;
	/**
	 * implements on tick and controls the state of the animation. the animation is a looping 
	 * state machine
	 */
	@Override
	public void onTick() {
		
		if(state==WAIT_0){
			keyNum=1;
			spaceNum=6;
			if(timer>50){
				state=GRAB_FISH;
				
			}
			timer++;
		}else if (state==GRAB_FISH){
			keyNum=3;
			spaceNum=6;
			crab.pressUp();
			state=WAIT_1;
			timer=0;
		}else if (state==WAIT_1){
			crab.stop();
			if(timer>10){
				keyNum=1;
			}
			if(timer>50){
				state=SHOOT_BUBBLE_1;
				timer=0;
			}
			timer++;
		}else if (state==SHOOT_BUBBLE_1){
			spaceNum=7;
			crab.pressSpace();
			shootBubbleFromFish();
			blowCount++;
			state=WAIT_2;
			timer=0;
		}else if(state==WAIT_2){
			crab.releaseSpace();
			if(blowCount<3){
				if(timer>10){
					spaceNum=6;
				}
				if(timer>40)
					state=SHOOT_BUBBLE_1;
			}else{
				state=WAIT_4;
				blowCount=0;
			}
			timer++;
		}
		else if (state==WAIT_4){
			keyNum=1;
			if(timer>10){
				spaceNum=6;
			}
			if(timer>60){
				state=LET_FISH_GO;
				timer=0;
			}else{
				timer++;
			}
		}
		else if (state==LET_FISH_GO){
			keyNum=3;
			spaceNum=6;
			crab.pressUp();
			state=WAIT_3;
			timer=0;
		}
		else if (state==WAIT_3){
			crab.stop();
			if(timer>10){
				keyNum=1;
				spaceNum=6;
			}
			if(timer>60){
				state=MOVE_1;
				timer=0;
				goToXPos = (int)(Math.random()*1000-500);
			}else{
				timer++;
			}
		}
		else if (state==MOVE_1){
			if(Math.abs(crab.getX()-goToXPos)>20){
				if(crab.getX()<goToXPos){
					crab.moveRight();
					keyNum=5;
				}else{
					crab.moveLeft();
					keyNum=2;
				}
			}else{
				keyNum=1;
				crab.stop();
				state=WAIT_0;
				timer=0;
			}
		}
		
		
		for(Pollutant p : pollutants){
			p.act();
		}
		for(Bubble b: bubbles){
			b.onTick();
		}
		
		
//		if(crab.isHoldingFish()){
//			if(spacePressed && spaceReleased){
//				spaceReleased=false;
//				shootBubbleFromFish();
//			}
//		}
		
		removeOffScreenBubbles();
		checkForPollutantsInBubbles();
		
		crab.onTick();
		fish.onTick();
		
	}
	private void addInitialPollutants(){
		int i=0;
		while (i<10){
			int choose = (int) (Math.random()*availablePollutants.size());
			int index = availablePollutants.get(choose);
			availablePollutants.remove(choose);
			pollutantBank.get(index).setIndex(index);
			pollutants.add(pollutantBank.get(index));
			i++;
		}
		
	}
	
	private void producePollutants(){
		int i=0;
		while(i<30){
			switch(i%6){
				case 0:pollutantBank.add(new Pollutant(new Vector(-Util.getDISTANCE_TO_EDGE()-150, -1150),
						new Vector(3,1), .01, Pollutant.FERTILIZER));break;
				case 1:pollutantBank.add(new Pollutant(new Vector(-Util.getDISTANCE_TO_EDGE()-150, 250),
						new Vector(2,-1), .01, Pollutant.FERTILIZER));break;
				
				case 2: pollutantBank.add(new Pollutant(new Vector(Util.getDISTANCE_TO_EDGE()+150, 0),
						new Vector(-5,-1), .01, Pollutant.OIL_ANIMATION));break;
				case 3:pollutantBank.add(new Pollutant(new Vector(-Util.getDISTANCE_TO_EDGE()-150, 250),
						new Vector(5,-1), .01, Pollutant.OIL_ANIMATION));break;
				case 4: pollutantBank.add(new Pollutant(new Vector(500,-1150),
						new Vector(-2,1), .01, Pollutant.SEWAGE));break;
				case 5: pollutantBank.add(new Pollutant(new Vector(-Util.getDISTANCE_TO_EDGE()-150, -500),
						new Vector(4,0), .01, Pollutant.SEWAGE));break;
				default:break;
			}
			i++;
		}
		
		
	}
	private void checkForPollutantsInBubbles(){
		for(Pollutant p : pollutants){
			for(Bubble b : bubbles){
				if(p.isIn(b) && b.getAttachedPollutants().size()<3 && !p.isInBubble()){
					p.fixToBubble(b);
					b.addAttachedPollutant(p);
				}
			}
		}
	}
	private void shootBubbleFromFish(){
		if(availableBubbles.size()==0){
			return;
		}
		Bubble b = bubbleBank.get(availableBubbles.get(0));
		b.setIndex(availableBubbles.get(0));
		availableBubbles.remove(0);
		b.reset();
		b.shootFromFish((fish.getX()+150), (fish.getY()+55), crab.getAngle(),crab.getX()+150,crab.getY()+150);
		bubbles.add(b);
		
	}
	
	private void removeOffScreenBubbles(){
		Iterator<Bubble> i = bubbles.iterator();
		while(i.hasNext()){
			Bubble b=i.next();
			if(b.getY()<-1200){
				availableBubbles.add(b.getIndex());
				i.remove();
				for(Pollutant p: b.getAttachedPollutants()){
					p.reset();
					//numRemoved++;
				}
				b.reset();
				
			}
		}
	}
	
	/**
	 * produces bubbles for the bubble bank
	 */
	private void produceBubbles(){
		int i=0;
		while(i<5){
			bubbleBank.add(new Bubble());
			i++;
		}
	}

}
