package animation;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
/**
 * defines the animation before the pollution game
 * @author abrah
 *
 */
public class PollutionGameAnimation extends Animation{

	/**
	 * 
	 */
	private ArrayList<Slide> slides;
	private static final long serialVersionUID = -4268209084988036700L;
	private int currentSlide=0;
	
	private AnimationBlowBubble blowBubble;
	/**
	 * creates this animation
	 */
	public PollutionGameAnimation(){
		blowBubble=new AnimationBlowBubble();
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * loads the slides needed
	 * @throws IOException
	 */
	private void init() throws IOException{
		slides=new ArrayList<Slide>();
		slides.add(new Slide("/Game3Animation1.png", 4){{
	
		}});
		slides.add(new Slide("/Game3Animation4.png",5));
		slides.add(new Slide("/Game3Animation2.png", 6){{
			//setFadeIn(false);
			setFadeOut(false);
		}});
		slides.add(new Slide("/Game3Animation3.png", 4){{
			setFadeIn(false);
		}});
		slides.add(new Slide("/Game3AnimationInstructionSlide.png", 4){{
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
			blowBubble.onTick();
		}
		
	}
	
	
	private boolean isOnFinalSlide(){
		return currentSlide==slides.size()-1;
	}
	
	
	private boolean onLastSlide=false;
	/**
	 * draws this animation to the screen
	 */
	@Override
	public void render(Graphics2D g) {
		if(isOnFinalSlide()){
			onLastSlide=true;
		}
		if(slides.get(currentSlide).display(g)){
			currentSlide++;
			if(currentSlide<slides.size())
				slides.get(currentSlide).load();
			
		}
		if(currentSlide>=slides.size()){
			setIsDone(true);
		}
		
		if(onLastSlide){
			blowBubble.render(g);
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
