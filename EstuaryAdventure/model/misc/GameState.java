package misc;

import java.io.Serializable;
/**
 * enum for characterizing the current game state
 * @author abrah
 *
 */
public enum GameState implements Serializable{
	MENU_SCREEN,
	OVERFISHING_GAME_ANIMATION,
	OVERFISHING_GAME,
	CRAB_SAVE_GAME_ANIMATION,
	CRAB_SAVE_GAME,
	POLLUTION_GAME_ANIMATION, 
	POLLUTION_GAME, 
	SHOW_STATS;
}
