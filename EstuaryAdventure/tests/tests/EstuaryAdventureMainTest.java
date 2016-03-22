package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.EstuaryAdventureMain;

public class EstuaryAdventureMainTest {

	@Test
	public void test() {
		EstuaryAdventureMain game = new EstuaryAdventureMain();

		game.init();
		game.start();
		game.stop(true);
		game.run();
		game.onTick();
		game.updateView();
	}

}
