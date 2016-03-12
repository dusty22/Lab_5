package animation;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * defines the model of the crab save animation before the second game
 * @author abrah
 *
 */
public class CrabSaveAnimation extends Animation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7197410829940008609L;
	private ArrayList<Slide> slides;
	private int currentSlide=0;
	
	private AnimationCrabThrowTrash throwAnimation = new AnimationCrabThrowTrash();
	private AnimationCrabPIckUpTrash pickUpAnimation = new AnimationCrabPIckUpTrash();
	
	/**
	 * creates the animation
	 */
	public CrabSaveAnimation() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * loads specific Slides needed for the slide show
	 * @throws IOException
	 */
	private void init() throws IOException{
		slides=new ArrayList<Slide>();
		//slides.add(new Slide("/Black.png", 1));
		slides.add(new Slide("/Game2AnimationSlide1.png", 5));
		slides.add(new Slide("/Game2AnimationSlide2.png", 5));
		slides.add(new Slide("/Game2AnimationInstructionSlide1.png", 5));
		slides.add(new Slide("/Game2AnimationSlide3.png", 5));
		slides.add(new Slide("/Game2AnimationInstructionSlide2.png", 5));
		slides.add(new Slide("/Game2AnimationInstructionSlide3.png", 4){{
			setFinalSlide(true);
			setFadeEverything(true);
		}});
		
		slides.get(0).load();
		
		
	}
	/**
	 * implements on tick
	 */
	@Override
	public void onTick() {
		if(isOnFinalSlide()){
			throwAnimation.onTick();
			pickUpAnimation.onTick();
		}
		
	}
	/**
	 * returns true if the animation is on the final slide
	 * @return
	 */
	private boolean isOnFinalSlide(){
		return currentSlide==slides.size()-1;
	}
	
	private boolean onFinalSlide=false;
	/**
	 * draws the graphcis using given parameter
	 */
	@Override
	public void render(Graphics2D g) {
		if(isOnFinalSlide()){
			onFinalSlide=true;
		}
		if(slides.get(currentSlide).display(g)){
			currentSlide++;
			if(currentSlide<slides.size())
				slides.get(currentSlide).load();
			
		}
		if(currentSlide>=slides.size()){
			setIsDone(true);
		}
		
		if(onFinalSlide){
			throwAnimation.render(g);
			pickUpAnimation.render(g);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(currentSlide==slides.size()-1){
			slides.get(slides.size()-1).mouseClicked(arg0);
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
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if(currentSlide==slides.size()-1){
			slides.get(slides.size()-1).mouseMoved(arg0);
		}
		
		
	}

}
