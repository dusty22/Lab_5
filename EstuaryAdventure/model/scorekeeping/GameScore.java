package scorekeeping;
/**
 * class for defining what can be returned from the abstract method getScore() in game.  For organizational
 * purposes only
 * @author abrah
 *
 */
public abstract class GameScore {

	/**
	 * all games scores must be able to compute a calcualted score out of 100 based on game variables
	 * @return
	 */
	public abstract int getCalculatedScore();
}
