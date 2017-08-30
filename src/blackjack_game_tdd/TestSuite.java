package blackjack_game_tdd;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author John Rose
 * Apr 28, 2017
 * 
 * Class is the test suite for the blackjack game it runs all the junit test classes in one go.
 * 
 */

@RunWith(Suite.class)
@Suite.SuiteClasses ({
	
	// Card and Deck Test Class
	CardAndDeckTester.class,
	
	// Player Test Class
	PlayerTester.class
	
})

public class TestSuite {

	// Class body stays empty it is just a place holder
	
}
