package misc;

import java.awt.Graphics2D;

/**
 * All implements classes define a method for how they draw to the screen
 * @author abraham
 *
 */
public interface Renderable {
	/**
	 * how to draw to the screen, using Graphics2D object g
	 * @param g Graphics2D used to draw to screen
	 */
	public void render(Graphics2D g);
	
}
