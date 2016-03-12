package animation;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import misc.Renderable;
import misc.Tickable;
/**
 * class to define behavoir of what the animations should have
 * @author abrah
 *
 */
public abstract class Animation implements Tickable,Renderable,Serializable,MouseListener,KeyListener,MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3771099594735929962L;
	private boolean sendSignal=false;
	private boolean isDone;
	
	/**
	 * returns true if the animation is done
	 * @return
	 */
	public boolean isDone(){
		return isDone;
	}
	/**
	 * sets the animation to be done or not done
	 * @param b
	 */
	public void setIsDone(boolean b){
		isDone=b;
	}
	/**
	 * causes the entire game to stop
	 */
	public void sendStopSignal(){
		sendSignal=true;
	}
	/**
	 * returns true if this animation has sent a stop signal.  small window of usability
	 * @return
	 */
	public boolean sentStopSignal(){
		return sendSignal;
	}
	
	
}
