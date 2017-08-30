package blackjack_game_tdd;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author John Rose
 * Apr 26, 2017
 */

public class PlayerTester {

	
	private Player test_player;
	
	@Before
	public void setup() {
		test_player = new Player("Tester", 1000);
	}
	
	/**
	 * void
	 * @throws Exception
	 * Test a Player object is created and is not null
	 */
	@Test
	public void testPlayerCreated() throws Exception {
		assertNotNull(test_player);
	}
	
	/**
	 * void
	 * @throws Exception
	 * Test getPalyerName method returns player name 
	 * player name = "Tester"
	 */
	@Test
	public void testGetName() throws Exception {
		assertEquals("Tester", test_player.getPlayerName());
	}
	 /**
	 * @throws Exception
	 * 
	 * Test is to confirm get player hand method works
	 * for a full hand of 10 cards.
	 * Array should stay seperate from other tests
	 */
	@Test
	 public void testGetPlayerHand() throws Exception {
		 
		Card c1 = new Card(Suit.Heart, 1); //Ace
		 Card c2 = new Card(Suit.Heart, 2);
		 Card c3 = new Card(Suit.Heart, 3);
		 Card c4 = new Card(Suit.Heart, 4);
		 Card c5 = new Card(Suit.Heart, 5);
		 Card c6 = new Card(Suit.Heart, 6);
		 Card c7 = new Card(Suit.Heart, 7);
		 Card c8 = new Card(Suit.Heart, 8);
		 Card c9 = new Card(Suit.Heart, 9);
		 Card c10 = new Card(Suit.Heart, 10);
		 
		 Card[] test_hand = new Card[10];
		 test_hand[0] = c1;
		 test_hand[1] = c2;
		 test_hand[2] = c3;
		 test_hand[3] = c4;
		 test_hand[4] = c5;
		 test_hand[5] = c6;
		 test_hand[6] = c7;
		 test_hand[7] = c8;
		 test_hand[8] = c9;
		 test_hand[9] = c10;
		 
		 test_player.addCard(c1);
		 test_player.addCard(c2);
		 test_player.addCard(c3);
		 test_player.addCard(c4);
		 test_player.addCard(c5);
		 test_player.addCard(c6);
		 test_player.addCard(c7);
		 test_player.addCard(c8);
		 test_player.addCard(c9);
		 test_player.addCard(c10);
		 
		 assertArrayEquals(test_hand, test_player.getPlayerHand());
	 }
	 
	
	/**
	 * @throws Exception
	 * Test to see if get card method retrieves a single card form
	 * player hand array.
	 */
	@Test
	public void testGetCard() throws Exception {
	
		// Player is created with a hand of 10 cards
		Player test = new Player("Tester2", 100);
		
		Card c1 = new Card(Suit.Diamond, 13);
		Card c2 = new Card(Suit.Diamond, 11);
		// Add a card to player hand
		
		test.addCard(c1);
		test.addCard(c2);
		
		assertEquals(c1, test.getCard(0));
	}
	
	/**
	 * void
	 * @throws Exception
	 * Test getPurse method returns player purse 
	 */
	@Test
	public void testGetMoney() throws Exception {
		assertEquals(1000, test_player.getPlayerMoney());
	}
	
	/**
	 * void
	 * @throws Exception
	 * Test to see if player hand is created with a size of 10
	 */
	@Test
	public void testPlayerHasHand() throws Exception {
		
		assertEquals(10, test_player.getPlayerHand().length);
	}
	
	/**
	 * void
	 * @throws Exception
	 * Test to see if two player objects are created and unique
	 */
	@Test
	public void testDealerAndPlayerCreated() throws Exception {
		Player test_dealer = new Player("Dealer", 10000);
		
		assertNotSame(test_dealer, test_player);
	}
	
	/**
	 * void
	 * @throws Exception
	 * Test to see if a card is added to the players hand array
	 */
	@Test
	public void testAddCardToPlayersHand() throws Exception {
		
		Card temp_card = new Card(Suit.Spade, 13);
		
		test_player.addCard(temp_card);
		
		assertEquals(temp_card, test_player.getPlayerHand()[0]);
	}
	
	/**
	 * void
	 * @throws Exception
	 * Test to see if sum of hand method works
	 */
	@Test
	public void testSumOfHand() throws Exception {
		
		Card temp_card = new Card(Suit.Spade, 5);
		Card temp_card_2 = new Card(Suit.Spade, 7);
		
		test_player.addCard(temp_card);
		test_player.addCard(temp_card_2);
		
		assertEquals(12, test_player.sumOfHand());
	}
	
	
	
	/**
	 * void
	 * @throws Exception
	 * Test to see if the Aces are handled properly with a hand less than or 
	 * to 10.
	 */
	@Test
	public void testsumOfHandAces21() throws Exception {
		
		Card temp_card = new Card(Suit.Heart, 1); // Ace of Heart
		Card temp_card_2 = new Card(Suit.Spade, 13); // King of Spade
		
		test_player.addCard(temp_card);
		test_player.addCard(temp_card_2);
		
		assertEquals(21, test_player.sumOfHand());
	}
	
	/**
	 * @throws Exception
	 * Test to see if aces are handled correctly when a hand 
	 * is greater than 10.
	 */
	@Test
	public void testSumOfHandAcesWithGreaterThan10() throws Exception {
		
		Card c1 = new Card(Suit.Heart, 1); // Ace of Heart
		Card c2 = new Card(Suit.Spade, 1); // Ace of Spade
		
		test_player.addCard(c1);
		test_player.addCard(c2);
		
		// Two Aces should equal 12
		assertEquals(12, test_player.sumOfHand());
	}
}
