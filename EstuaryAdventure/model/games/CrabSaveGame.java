package games;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import animation.ClockTimer;
import characters.Crab;
import enemies.TheHuman;
import enemies.Trash;
import main.EstuaryAdventureMain;
import misc.ArbitraryLine;
import misc.DialogBox;
import misc.SoundDoer;
import misc.TrashCan;
import misc.Util;
import scorekeeping.CrabSaveScore;
import scorekeeping.GameScore;

/**
 * Models the CrabSaveGame
 * @author abraham
 *
 */
public class CrabSaveGame extends Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1609844265788718695L;
	private ArrayList<Trash> trash;
	private TheHuman theHuman;
	private TrashCan trashCan;
	
	private boolean canPickUpTrash=true;
	private Crab crab;
	private Color sand = new Color(255,237,108);
	private Color sky = new Color(130,202,255);
	private BufferedImage sun,bg,bg2,pond,greenArrow,pond2,fish;
	
	private ArbitraryLine pondLine,skyLine;
	private boolean doneAnimationSequence1=false;
	private boolean doneAnimationSequence2=false;
	private TheHuman human;
	private SoundDoer soundDoer= new SoundDoer();
	
	private boolean donePlaying=false;
	private DialogBox dialogBox;
	
	private ClockTimer clock ;
	private Color timerColor=Color.RED;
	private final Font timerFont = new Font("default",Font.BOLD,200);
	
	private long dialogBoxWaiter=0;
	
	private boolean faded=false;
	/**
	 * calls the super constructor
	 */
	public CrabSaveGame(){
		super();
		loadRes();
		dialogBox=new DialogBox(this);
		soundDoer.loadClip("/game2song.wav");
		soundDoer.loadClip("/winsound.wav");
		clock= new ClockTimer(Util.getDISTANCE_TO_EDGE()-330, -990);
		clock.setInitialAngle(Math.PI/18f);
		clock.pause();
		//clock.setCountUp(true);
		screenPos=0;
		human = new TheHuman(400, -500);
		
		
		
	}
	/**
	 * gets called in the constructor to initialized components of the game
	 */
	public void init(){
		crab=new Crab(-Util.getDISTANCE_TO_EDGE()+100, 0,this);
		trashCan=new TrashCan(375, -930);
		int[]pts={0,148,110,80,176,58,374,126,546,164,678,140,822,64,978,64,1176,144,1294,134,1500,224};
		pondLine=new ArbitraryLine(pts, Util.getDISTANCE_TO_EDGE()/(1500/2f), 500f/330f, 500);
		pondLine.setX(-Util.getDISTANCE_TO_EDGE());
		int[]pts2={0,428,232,390,406,390,820,460,990,442,1246,338,1526,382,1826,418,1882,424,2000,406};
		skyLine=new ArbitraryLine(pts2, Util.getDISTANCE_TO_EDGE()/(2000/2f), 600f/800f, -850);
		skyLine.setX(-Util.getDISTANCE_TO_EDGE());
		
		trash=new ArrayList<Trash>();
		trash.add(new Trash(0, -300, Trash.BANANA));
		trash.add(new Trash(-900,-400,Trash.BOTTLE));
		trash.add(new Trash(500,0,Trash.ROPE));
		trash.add(new Trash(-1000,0,Trash.MILK_JUG));
		trash.add(new Trash(900,-400,Trash.SHOPPING_BAG));
		trash.add(new Trash(1000,500,Trash.SODA_CAN));
	}
	
	
	/**
	 * loads the resources needed
	 */
	private void loadRes(){
		try {
			sun = Util.loadImage("/sun.png", this);
			bg= Util.loadImage("/Game2Background(smaller).png",Util.getCANVAS_WIDTH_SCALED(),800, this);
			bg2= Util.loadImage("/Game2Background(smaller-flipped).png",Util.getCANVAS_WIDTH_SCALED(),800, this);
			pond = Util.loadImage("/game2water.png",Util.getCANVAS_WIDTH_SCALED(),500, this);
			pond2 = Util.loadImage("/game2water2.png",Util.getCANVAS_WIDTH_SCALED(),2000, this);
			greenArrow = Util.loadImage("/greenarrowright.png",150,150, this);
			fish = Util.loadImage("/goldfish.png",200,200, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * gets called 60 times/sec and handles updates to the game
	 */
	@Override
	public void onTick() {
		
		
		if(!doneAnimationSequence1){
			human.onTick();
			if(human.outOfScreen()){
				doneAnimationSequence1=true;
				soundDoer.playLoadedClip(0);
				clock.run();
			}
		}
		
		else{
			human.onTick();
		}
		if(!donePlaying){
			crab.onTick();
			if(!doingEndAnimation && pondLine.isBelowLine(crab.getX(), crab.getY()+400)){
				crab.setY(crab.getY()-6*(crab.getY()+1000)/1500.0);
				crab.setX(crab.getX()+.5);
				
			}
			if(!doingEndAnimation && skyLine.isAboveLine(crab.getX(), crab.getY())){
				crab.setY(crab.getY()+6*(crab.getY()+1000)/1500.0);
				crab.setX(crab.getX()-.5);
			}
			
			for(Trash t: trash){
				t.act();
			}
			
			if(canPickUpTrash)
				tellCrabToHoldTrash();
			clock.onTick();
			if(clock.getTimer()<=0){
				canPickUpTrash=false;
				clock.setTimer(0);
				clock.pause();
				if(!(crab.isHoldingTrash()|| crab.isThrowingTrash())){
					if(dialogBoxWaiter<30){
						dialogBoxWaiter++;
					}
					else if(!doneAnimationSequence2){
						doEndAnimation();
					}
					else{
						EstuaryAdventureMain.showMenuCursor();
						dialogBox.setTitle(DialogBox.TITLE_GREAT);
						dialogBox.setKey1("Trash Left: ");
						dialogBox.setInfo1(getNumTrash()+" pieces        ");
						dialogBox.setKey2("Your Time: ");
						dialogBox.setInfo2("      "+(60-(int)clock.getTimer())+"s");
						dialogBox.setMessageL1("Thanks for helping");
						dialogBox.setMessageL2("clean up the estuary!");
						donePlaying=true;
					}
				}
			}else if(getNumTrash()==0){
				clock.pause();
				if(dialogBoxWaiter<30){
					dialogBoxWaiter++;
				}else if(!doneAnimationSequence2){
					doEndAnimation();
				}
				else{
					EstuaryAdventureMain.showMenuCursor();
					dialogBox.setTitle(DialogBox.TITLE_GREAT);
					dialogBox.setKey1("Trash Left: ");
					dialogBox.setInfo1("0 pieces        ");
					dialogBox.setKey2("Your Time: ");
					dialogBox.setInfo2("      "+(60-(int)clock.getTimer())+"s");
					dialogBox.setMessageL1("Thanks for helping");
					dialogBox.setMessageL2("clean up the estuary!");
					donePlaying=true;
					
				}
			}
		}
		if(donePlaying){
			if(!faded){
				faded= soundDoer.fadeOutFast(0);
				if(faded && getNumTrash()==0){
					soundDoer.playLoadedClip(1);
				}
			}
		}
		
	}
	
	/**
	 * adds trash back if crab missed the throw
	 * @param t
	 */
	public void addBackTrash(Trash t){
		trash.add(t);
	}
	
	private double xPosArrow=Util.getDISTANCE_TO_EDGE()-300;
	private double yPosArrow=-250;
	private double xVelArrow=0;
	private double xAccArrow=3;
	private boolean right=true;
	private boolean doingEndAnimation=false;
	private static final int SHOW_ARROW=0;
	private static final int SLIDE_SCREEN=1;
	private static final int WAIT_FOR_CRAB_TO_ATTACK_FISH=2;
	private static final int ATTACK_HUMAN=3;
	private static final int FISH_FLY=4;
	private static final int CELEBRATE=5;
	private double screenPos=0;
	private double screenPosVel=0;
	private int state=SHOW_ARROW;
	private boolean slowDown=false;
	private long attackTimer=0;
	private double rotateVel=0;
	private double fishX;
	private double fishY;
	private double fishxVel=20;
	private double fishyVel=-150;
	private double fishAngle=0;
	private boolean crabControl=true;
	public void doEndAnimation(){
		doingEndAnimation=true;
		if(state==SHOW_ARROW&&crab.getX()<Util.getDISTANCE_TO_EDGE()-400){
			state=SHOW_ARROW;
			
			xVelArrow+=xAccArrow;
			xPosArrow+=xVelArrow;
			if(right &&xPosArrow>Util.getDISTANCE_TO_EDGE()-290){
				xAccArrow=-xAccArrow;
				right=false;
			}else if (!right && xPosArrow<Util.getDISTANCE_TO_EDGE()-290){
				xAccArrow=-xAccArrow;
				right=true;
			}
		}else if (state == SHOW_ARROW){
			state=SLIDE_SCREEN;
		}
		if(state==SLIDE_SCREEN){
			screenPos+=screenPosVel;
			if(!slowDown)
				screenPosVel-=3;
			else {screenPosVel+=3;
				if(screenPosVel>=0){
					screenPosVel=0;
					state=WAIT_FOR_CRAB_TO_ATTACK_FISH;
				}
			
			}
			if(screenPos<=-Util.getDISTANCE_TO_EDGE()/1.5){
				slowDown=true;
			}
			crab.setScreenPos(screenPos);
		}
		
		if(state==WAIT_FOR_CRAB_TO_ATTACK_FISH){
			if(crab.getX()>human.getX()-150){
				state=ATTACK_HUMAN;
			}
		}
		
		if(state==ATTACK_HUMAN){
			crabControl=false;
			crab.stopMoving();
			crab.setX(human.getX()+Math.random()*200-100);
			crab.setY(human.getY()+200+Math.random()*400-200);
			crab.setSpriteNum(4);
			attackTimer++;
			if(attackTimer>30 && human.getAngle()>-Math.PI/2f){
				crab.setX(-500);
				crab.setY(250);
				human.setAngle(human.getAngle()-rotateVel);
				rotateVel+=.8;
				
			}else if (attackTimer>31){
				state=FISH_FLY;
				attackTimer=0;
			}
		}
		
		if(state==FISH_FLY){
			crabControl=false;
			crab.stopMoving();
			human.setNoFishInBag(true);
			crabControl=false;
			
			if(fishY<300){
				fishX+=fishxVel;
				fishY+=fishyVel;
				
				fishyVel+=10;
				fishAngle+=1;
			}else{
				fishX+=fishxVel;
				fishY+=fishyVel;
				
				fishyVel-=80;
				fishAngle+=1;
			}
			
			if(fishY>600){
				fishAngle=0;
				state=CELEBRATE;
			}
		}
		if(state==CELEBRATE){
			crabControl=false;
			crab.stopMoving();
			if(attackTimer>60){
				doingEndAnimation=false;
				doneAnimationSequence2=true;
			}
			attackTimer++;
		}
	}
	/**
	 * tells the crab to hold the trash
	 */
	private void tellCrabToHoldTrash(){
		Iterator<Trash> i = trash.iterator();
		while(i.hasNext()){
			Trash t = i.next();
			if(crab.isTouchingTrash(t) && !crab.isHoldingTrash()){
				crab.holdTrash(t);
				crab.setIsHoldingTrash(true);
				i.remove();
			}
		}
	}
	
	/**
	 * draws the crabSaveGame
	 * @param g the graphcis to draw to
	 */
	public void render(Graphics2D g){
		
		g.setColor(sand);
		g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), 2000);
		g.setColor(sky);
		g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), 600);
		g.drawImage(bg,(int)(-Util.getDISTANCE_TO_EDGE()+screenPos),-1000,null);
		g.drawImage(bg2,(int)(Util.getDISTANCE_TO_EDGE()+screenPos),-1000,null);
		g.drawImage(sun, -Util.getDISTANCE_TO_EDGE()-400,-1600,1000,1300,null);
		g.drawImage(pond, (int)(screenPos-Util.getDISTANCE_TO_EDGE()), 500, null);
		if(doingEndAnimation || doneAnimationSequence2)
			g.drawImage(pond2, (int)(screenPos+Util.getDISTANCE_TO_EDGE()), -1000, null);
		trashCan.render(g,screenPos);
		
		
		crab.render(g,screenPos);
		trashCan.renderOverlay(g,screenPos);
		for(Trash t: trash){
			t.render(g,screenPos);
		}
		human.render(g,screenPos);
		crab.renderThrownTrash(g,screenPos);
		
		g.setColor(timerColor);
		g.setFont(timerFont);
		//Util.drawCenteredString(""+(int)timer, Util.getDISTANCE_TO_EDGE()-200, -800, g);
		
		clock.render(g);
		if(donePlaying){
			dialogBox.render(g);
			g.translate(fishX+100, fishY+100);
			g.rotate(fishAngle);
			g.drawImage(fish, -100, -100, null);
			g.rotate(-fishAngle);
			g.translate(-fishX-100, -fishY-100);
		}
		
		
		
		if(doingEndAnimation){
			if(state==SHOW_ARROW){
				g.drawImage(greenArrow, (int)xPosArrow, (int)yPosArrow, null);
			}
			if(state==FISH_FLY || state==CELEBRATE){
				g.translate(fishX+100, fishY+100);
				g.rotate(fishAngle);
				g.drawImage(fish, -100, -100, null);
				g.rotate(-fishAngle);
				g.translate(-fishX-100, -fishY-100);
			}
		}
		
		
		//pondLine.testRender(g); //GOOD
		//skyLine.testRender(g);  //GOOD
	}
	
	
	/**
	 * moves the Human
	 */
	public void moveHuman(){};
	/**
	 * removes Trash
	 * @param t the trash to remove
	 */
	public void removeTrash(Trash t){}


	/**
	 * 
	 * @return the number of Trash the user needs to clean up
	 */
	public int getNumTrash() {
		if(crab.isHoldingTrash() || crab.isThrowingTrash()){
			return trash.size()+1;
		}
		else return trash.size();
	}

	/**
	 * returns the score object of this game for the final screen
	 */
	@Override
	public GameScore getScore() {
		
		return new CrabSaveScore(getNumTrash(), clock.getTimer());
	}
	/**
	 * 
	 * @return the arrayList of all current Trash objects
	 */
	public ArrayList<Trash> getTrash() {
		return trash;
	}


	/**
	 * 
	 * @return the Human in the game
	 */
	public TheHuman getTheHuman() {
		return theHuman;
	};
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(doneAnimationSequence1 && crabControl)
			crab.keyPressed(arg0);
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		if(doneAnimationSequence1 && crabControl)
			crab.keyReleased(arg0);
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(donePlaying){
			dialogBox.mouseClicked(arg0);
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		if(donePlaying){
			dialogBox.mouseMoved(e);
		}
		
	}
	
}
