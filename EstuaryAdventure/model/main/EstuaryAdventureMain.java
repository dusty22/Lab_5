package main;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;

import animation.CrabSaveAnimation;
import animation.OverfishingAnimation;
import animation.PollutionGameAnimation;
import games.CrabSaveGame;
import games.OverfishingGame;
import games.PollutionGame;
import mainView.EstuaryView;
import misc.GameState;
import misc.MenuScreen;
import misc.Tickable;
import misc.Util;
import scorekeeping.CrabSaveScore;
import scorekeeping.OverfishingScore;
import scorekeeping.PollutionScore;
import scorekeeping.ScoreKeeper;
import scorekeeping.StatsScreen;

/**
 * This main control structure of this game is very similar to an online 
 * tutorial series entitled "Java Game Development"  
 * This is because Abraham made a game a couple of years ago using these
 * tutorials for fun, and so our implementation ended up being very similar.
 * However, we made slight optimizations so that the rendering is more efficient.
 * @author Abraham McIlvaine
 *
 */
public class EstuaryAdventureMain implements Runnable,Tickable,KeyListener,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4347325551128251031L;
	private boolean running= false;
	private Thread thread;
	private EstuaryView view;
	private GameState state;
	private ScoreKeeper scoreKeeper = new ScoreKeeper();
		
	//Variables used to control updating frequency in run()
	private long lastTime,now;
	private final double ticksPerSecond = 60.0;
	private double nanosPerTick = 1000000000.0 / ticksPerSecond;
	private double deltaNs = 0;
	
	
	///////
	private MenuScreen menu;
	private OverfishingAnimation overfishingAnimation;
	private OverfishingGame overfishingGame;
	private CrabSaveAnimation crabSaveAnimation;
	private CrabSaveGame crabSaveGame;
	private PollutionGame pollutionGame;
	private PollutionGameAnimation pollutionGameAnimation;
	private StatsScreen stats;
	
	private static final BufferedImage blankImage = new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB);
	private static final Cursor blankCursor=
			Toolkit.getDefaultToolkit().createCustomCursor(blankImage, new java.awt.Point(0, 0), "blank cursor");
	
	
	
	private static BufferedImage menuCursorImage;
	private static Cursor menuCursor;
	/**
	 * creates the Main Game by calling init()
	 */
	public EstuaryAdventureMain(){
		init();
	}
	
	/**
	 * gets called in the constructor to initilize components
	 */
	private void init(){
		view = new EstuaryView();
		DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		view.setPreferredSize(new Dimension(dm.getWidth(), dm.getHeight()));
		state = GameState.MENU_SCREEN;
		view.addKeyListener(this);
		
		try {
			menuCursorImage=Util.loadImage("/menu-cursor3.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		menuCursor=Toolkit.getDefaultToolkit().createCustomCursor(menuCursorImage, new java.awt.Point(0,0), "menu cursor");
		
		
		
	}
	
	/**
	 * starts the main game loop on its own thread
	 */
	public synchronized void start() {
		if (!running) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	/**
	 * stops the main game loop
	 */
	public synchronized void stop(boolean exit) {
		if(exit){
			System.exit(0);
		}else{
			reset();
		}

	}

	/**
	 * implements run() from Runnable. gets called in start
	 */
	public void run() {
		view.requestFocus();
		lastTime = System.nanoTime();
		while (running) {
			now = System.nanoTime();
			deltaNs += (now - lastTime);
			lastTime = now;
			if (deltaNs >= nanosPerTick) {
				onTick();
				deltaNs -= nanosPerTick;// possible set it to 0 alternatively,
				updateView();			// depending on certain factors
			}
			
			

		}
		

	}
	
	/**
	 * gets called at 60Hz in the main game loop
	 */
	@Override
	public void onTick(){
		if(state == GameState.MENU_SCREEN){
			if(menu == null){
				showMenuCursor();
				menu = new MenuScreen();
				view.addMouseListener(menu);
				view.addKeyListener(menu);
				view.addMouseMotionListener(menu);
				lastTime=System.nanoTime();
			}
			menu.onTick();
			if(menu.isDone()){
				state = GameState.OVERFISHING_GAME_ANIMATION;
				view.removeKeyListener(menu);
				view.removeMouseListener(menu);
				view.removeMouseMotionListener(menu);
				menu = null;
			}
			
		}
		else if (state == GameState.OVERFISHING_GAME_ANIMATION){
			if(overfishingAnimation==null){
				overfishingAnimation = new OverfishingAnimation();
				view.addMouseListener(overfishingAnimation);
				view.addKeyListener(overfishingAnimation);
				view.addMouseMotionListener(overfishingAnimation);
				hideCursor();
				lastTime=System.nanoTime();
			}
			overfishingAnimation.onTick();
			if(overfishingAnimation.isDone()){
				state = GameState.OVERFISHING_GAME;
				view.removeKeyListener(overfishingAnimation);
				view.removeMouseListener(overfishingAnimation);
				view.removeMouseMotionListener(overfishingAnimation);
				overfishingAnimation=null;
			}else if(overfishingAnimation.sentStopSignal()){
				state=GameState.MENU_SCREEN;
				view.removeKeyListener(overfishingAnimation);
				view.removeMouseListener(overfishingAnimation);
				view.removeMouseMotionListener(overfishingAnimation);
				overfishingAnimation=null;
				reset();
			}
			
			
		}
		else if (state == GameState.OVERFISHING_GAME){
			if(overfishingGame==null){
				overfishingGame = new OverfishingGame();
				view.addMouseListener(overfishingGame);
				view.addKeyListener(overfishingGame);
				view.addMouseMotionListener(overfishingGame);
				hideCursor();
				lastTime=System.nanoTime();
			}
			overfishingGame.onTick();
			if(overfishingGame.isDone()){
				
				scoreKeeper.addOverfishingScore((OverfishingScore) overfishingGame.getScore());
				
				state = GameState.CRAB_SAVE_GAME_ANIMATION;
				view.removeKeyListener(overfishingGame);
				view.removeMouseListener(overfishingGame);
				view.removeMouseMotionListener(overfishingGame);
				overfishingGame=null;
			}else if(overfishingGame.sentStopSignal()){
				state=GameState.MENU_SCREEN;
				view.removeKeyListener(overfishingGame);
				view.removeMouseListener(overfishingGame);
				view.removeMouseMotionListener(overfishingGame);
				overfishingGame=null;
				reset();
			}
			
			
		}
		else if (state == GameState.CRAB_SAVE_GAME_ANIMATION){
			if(crabSaveAnimation==null){
				crabSaveAnimation = new CrabSaveAnimation();
				view.addMouseListener(crabSaveAnimation);
				view.addKeyListener(crabSaveAnimation);
				view.addMouseMotionListener(crabSaveAnimation);
				hideCursor();
				lastTime=System.nanoTime();
			}
			crabSaveAnimation.onTick();
			if(crabSaveAnimation.isDone()){
				state = GameState.CRAB_SAVE_GAME;
				view.removeKeyListener(crabSaveAnimation);
				view.removeMouseListener(crabSaveAnimation);
				view.removeMouseMotionListener(crabSaveAnimation);
				crabSaveAnimation=null;
			}else if(crabSaveAnimation.sentStopSignal()){
				state=GameState.MENU_SCREEN;
				view.removeKeyListener(crabSaveAnimation);
				view.removeMouseListener(crabSaveAnimation);
				view.removeMouseMotionListener(crabSaveAnimation);
				crabSaveAnimation=null;
				reset();
			}
			
			
		}
		
		else if (state==GameState.CRAB_SAVE_GAME){
			if(crabSaveGame==null){
				crabSaveGame = new CrabSaveGame();
				view.addMouseListener(crabSaveGame);
				view.addKeyListener(crabSaveGame);
				view.addMouseMotionListener(crabSaveGame);
				hideCursor();
				lastTime=System.nanoTime();
			}
			crabSaveGame.onTick();
			if(crabSaveGame.isDone()){
				
				scoreKeeper.addCrabSaveScore((CrabSaveScore) crabSaveGame.getScore());
				state = GameState.POLLUTION_GAME_ANIMATION;
				view.removeKeyListener(crabSaveGame);
				view.removeMouseListener(crabSaveGame);
				view.removeMouseMotionListener(crabSaveGame);
				crabSaveGame=null;
			}else if(crabSaveGame.sentStopSignal()){
				state=GameState.MENU_SCREEN;
				view.removeKeyListener(crabSaveGame);
				view.removeMouseListener(crabSaveGame);
				view.removeMouseMotionListener(crabSaveGame);
				crabSaveGame=null;
				reset();
			}
		}
		else if (state==GameState.POLLUTION_GAME_ANIMATION){
			if(pollutionGameAnimation==null){
				pollutionGameAnimation = new PollutionGameAnimation();
				view.addMouseListener(pollutionGameAnimation);
				view.addKeyListener(pollutionGameAnimation);
				view.addMouseMotionListener(pollutionGameAnimation);
				lastTime=System.nanoTime();
				hideCursor();
			}
			pollutionGameAnimation.onTick();
			if(pollutionGameAnimation.isDone()){
				state = GameState.POLLUTION_GAME;
				view.removeKeyListener(pollutionGameAnimation);
				view.removeMouseListener(pollutionGameAnimation);
				view.removeMouseListener(pollutionGameAnimation);
				pollutionGameAnimation=null;
			}else if(pollutionGameAnimation.sentStopSignal()){
				state=GameState.MENU_SCREEN;
				view.removeKeyListener(pollutionGameAnimation);
				view.removeMouseListener(pollutionGameAnimation);
				view.removeMouseMotionListener(pollutionGameAnimation);
				pollutionGameAnimation=null;
				reset();
			}
		}
		else if (state==GameState.POLLUTION_GAME){
			if(pollutionGame==null){
				pollutionGame = new PollutionGame();
				view.addMouseListener(pollutionGame);
				view.addKeyListener(pollutionGame);
				view.addMouseMotionListener(pollutionGame);
				lastTime=System.nanoTime();
				hideCursor();
			}
			pollutionGame.onTick();
			if(pollutionGame.isDone()){
				scoreKeeper.addPollutionScore((PollutionScore) pollutionGame.getScore());
				state = GameState.SHOW_STATS;
				view.removeKeyListener(pollutionGame);
				view.removeMouseListener(pollutionGame);
				view.removeMouseListener(pollutionGame);
				pollutionGame=null;
			}else if(pollutionGame.sentStopSignal()){
				state=GameState.MENU_SCREEN;
				view.removeKeyListener(pollutionGame);
				view.removeMouseListener(pollutionGame);
				view.removeMouseMotionListener(pollutionGame);
				pollutionGame=null;
				reset();
			}
		}
		else if (state==GameState.SHOW_STATS){
			if(stats==null){
				stats = new StatsScreen(scoreKeeper);
				view.addMouseListener(stats);
				view.addKeyListener(stats);
				view.addMouseMotionListener(stats);
				lastTime=System.nanoTime();
				hideCursor();
			}
			stats.onTick();
			if(stats.isDone()){
				state = GameState.MENU_SCREEN;
				reset();
				view.removeKeyListener(stats);
				view.removeMouseListener(stats);
				view.removeMouseListener(stats);
				stats=null;
				showMenuCursor();
			}
		}
	}
	
	/**
	 * redraws the screen when an onTick() has occurred.  Gets called right after all tick
	 */
	private void updateView(){
		if(state==GameState.MENU_SCREEN && menu!=null){
			view.render(menu);	
			
		}
		else if (state ==GameState.OVERFISHING_GAME_ANIMATION && overfishingAnimation!=null){
			view.render(overfishingAnimation);
		}
		else if (state == GameState.OVERFISHING_GAME && overfishingGame!=null){
			view.render(overfishingGame);
			
		}
		else if (state==GameState.CRAB_SAVE_GAME_ANIMATION && crabSaveAnimation!=null){
			view.render(crabSaveAnimation);
		}
		else if (state==GameState.CRAB_SAVE_GAME && crabSaveGame!=null){
			view.render(crabSaveGame);
		}
		else if (state==GameState.POLLUTION_GAME_ANIMATION && pollutionGameAnimation!=null){
			view.render(pollutionGameAnimation);
		}
		else if (state==GameState.POLLUTION_GAME && pollutionGame!=null){
			view.render(pollutionGame);
		}
		else if (state==GameState.SHOW_STATS && stats!=null){
			view.render(stats);
		}
		
	}

	
	/**
	 * 
	 * @return whether or not the game is currently running
	 */
	public boolean isRunning() {
		return running;
	}
	
	/**
	 * hides the cursor
	 */
	public static void hideCursor(){
		if(frame==null){
			return;
		}
		frame.getContentPane().setCursor(blankCursor);
	}
	/**
	 * shows the cursor
	 */
	public static void showMenuCursor(){
		if(frame==null){
			return;
		}
		frame.getContentPane().setCursor(menuCursor);
	}
	
	/**
	 * resets the game for looping back to the main screen
	 */
	private void reset(){
		menu=null;
		overfishingAnimation=null;
		overfishingGame=null;
		crabSaveAnimation=null;
		crabSaveGame=null;
		pollutionGameAnimation=null;
		pollutionGame=null;
		
		
	}
	
	
	//WRITE TO FILE//
	
	private void saveToFile(){
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("store path here.  we didn't put one "
					+ "in because we have windows and linux users so they changed as neccesary"));
			out.writeObject(this);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	////////////////////
	/////MAIN FUNCTION//////
	
	private static JFrame frame;
	public static void main (String[]args){
		frame = new JFrame("Estuary Adventure!");
		EstuaryAdventureMain game = new EstuaryAdventureMain();
		frame.getContentPane().add(game.view);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setUndecorated(true);
		try {
			frame.setIconImage(Util.loadImage("/icon.png", game));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
		
		
		
	}
	
	
	private boolean sPressed,aPressed,mPressed,ctrlPressed;
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
			ctrlPressed=true;
		}
		if(ctrlPressed && e.getKeyCode()== KeyEvent.VK_1){
			state=GameState.OVERFISHING_GAME;
		}
		if(ctrlPressed && e.getKeyCode()== KeyEvent.VK_2){
			state=GameState.CRAB_SAVE_GAME;
		}
		if(ctrlPressed && e.getKeyCode()== KeyEvent.VK_3){
			state=GameState.POLLUTION_GAME;
		}
		if(ctrlPressed && e.getKeyCode()==KeyEvent.VK_S){
			state=GameState.SHOW_STATS;
		}
		
		if(e.getKeyCode()== KeyEvent.VK_S){
			sPressed=true;
		}
		if(e.getKeyCode()== KeyEvent.VK_A){
			aPressed=true;
		}
		if(e.getKeyCode()== KeyEvent.VK_M){
			mPressed=true;
		}
		
		if(sPressed&& aPressed && mPressed){
			System.exit(0);
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_S){
			sPressed=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_A){
			aPressed=false;
		}
		if(e.getKeyCode()== KeyEvent.VK_M){
			mPressed=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
			ctrlPressed=false;
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
