package misc;
/**
 * Defines one method, onTick();
 * @author abraham
 *
 */
public interface Tickable {
	/**
	 * implementing interfaces must provide a method for updating at 60Hz
	 */
	public void onTick();
}
