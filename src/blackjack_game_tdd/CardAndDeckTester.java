package blackjack_game_tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author John Rose Apr 23, 2017
 */
public class CardAndDeckTester {

	private Card[] test_deck;

	private DeckOfCards real_deck;

	@Before
	public void setup() {

		// Create a deck from DeckOfCards class
		real_deck = new DeckOfCards();

		// Create a non shuffled deck of cards to test against
		test_deck = new Card[52];

		// Hearts
		test_deck[0] = new Card(Suit.Heart, 1);
		test_deck[1] = new Card(Suit.Heart, 2);
		test_deck[2] = new Card(Suit.Heart, 3);
		test_deck[3] = new Card(Suit.Heart, 4);
		test_deck[4] = new Card(Suit.Heart, 5);
		test_deck[5] = new Card(Suit.Heart, 6);
		test_deck[6] = new Card(Suit.Heart, 7);
		test_deck[7] = new Card(Suit.Heart, 8);
		test_deck[8] = new Card(Suit.Heart, 9);
		test_deck[9] = new Card(Suit.Heart, 10);
		test_deck[10] = new Card(Suit.Heart, 11);
		test_deck[11] = new Card(Suit.Heart, 12);
		test_deck[12] = new Card(Suit.Heart, 13);

		// Spades
		test_deck[13] = new Card(Suit.Spade, 1);
		test_deck[14] = new Card(Suit.Spade, 2);
		test_deck[15] = new Card(Suit.Spade, 3);
		test_deck[16] = new Card(Suit.Spade, 4);
		test_deck[17] = new Card(Suit.Spade, 5);
		test_deck[18] = new Card(Suit.Spade, 6);
		test_deck[19] = new Card(Suit.Spade, 7);
		test_deck[20] = new Card(Suit.Spade, 8);
		test_deck[21] = new Card(Suit.Spade, 9);
		test_deck[22] = new Card(Suit.Spade, 10);
		test_deck[23] = new Card(Suit.Spade, 11);
		test_deck[24] = new Card(Suit.Spade, 12);
		test_deck[25] = new Card(Suit.Spade, 13);

		// Diamonds
		test_deck[26] = new Card(Suit.Diamond, 1);
		test_deck[27] = new Card(Suit.Diamond, 2);
		test_deck[28] = new Card(Suit.Diamond, 3);
		test_deck[29] = new Card(Suit.Diamond, 4);
		test_deck[30] = new Card(Suit.Diamond, 5);
		test_deck[31] = new Card(Suit.Diamond, 6);
		test_deck[32] = new Card(Suit.Diamond, 7);
		test_deck[33] = new Card(Suit.Diamond, 8);
		test_deck[34] = new Card(Suit.Diamond, 9);
		test_deck[35] = new Card(Suit.Diamond, 10);
		test_deck[36] = new Card(Suit.Diamond, 11);
		test_deck[37] = new Card(Suit.Diamond, 12);
		test_deck[38] = new Card(Suit.Diamond, 13);

		// Clubs
		test_deck[39] = new Card(Suit.Club, 1);
		test_deck[40] = new Card(Suit.Club, 2);
		test_deck[41] = new Card(Suit.Club, 3);
		test_deck[42] = new Card(Suit.Club, 4);
		test_deck[43] = new Card(Suit.Club, 5);
		test_deck[44] = new Card(Suit.Club, 6);
		test_deck[45] = new Card(Suit.Club, 7);
		test_deck[46] = new Card(Suit.Club, 8);
		test_deck[47] = new Card(Suit.Club, 9);
		test_deck[48] = new Card(Suit.Club, 10);
		test_deck[49] = new Card(Suit.Club, 11);
		test_deck[50] = new Card(Suit.Club, 12);
		test_deck[51] = new Card(Suit.Club, 13);

	}

	/**
	 * void
	 * 
	 * @throws Exception
	 * Test to make sure a card object is created and not null
	 */
	@Test
	public void testToCreateCardCreated() throws Exception {

		// should return the Ace of Club
		assertNotNull(new Card(Suit.Club, 1));
	}

	/**
	 * @throws Exception
	 * Test to see if get card id method works Test id number should
	 * be 11
	 */
	@Test
	public void testGetCardIdNumber() throws Exception {
		assertEquals(11, test_deck[49].getCardIdNumber());
	}

	/**
	 * @throws Exception
	 * Test to see if the get suit method works Test suit should be Club.
	 */
	@Test
	public void testGetCardSuit() throws Exception {
		assertEquals(Suit.Club, test_deck[50].getCardSuit());
	}

	/**
	 * @throws Exception
	 * Test verifies to string method delivers the right message
	 * Message should be "(Suit) of (Id Number)" Example: Ace of Club
	 */
	@Test
	public void testCardToString() throws Exception {

		assertEquals("Ace of Club", test_deck[39].toString());
	}

	/**
	 * void
	 * 
	 * @throws Exception
	 * Test is to see if a deck was created with 52 cards.
	 * 
	 */
	@Test
	public void testSizeOfDeck() throws Exception {
		assertEquals(52, real_deck.sizeOfDeck());
	}

	/**
	 * void
	 * 
	 * @throws Exception
	 * Test to see if top card is dealt Deck has not been shuffled
	 * so top card should be Ace of Hearts
	 */
	@Test
	public void testDealNextCard() throws Exception {

		assertEquals(test_deck[0], real_deck.dealNextCard());
	}

	/**
	 * void
	 * 
	 * @throws Exception
	 * Test to see if deal next card method deals three consecutive
	 * cards
	 */
	@Test
	public void testDealNextThreeCards() throws Exception {
		real_deck.dealNextCard(); // 0
		real_deck.dealNextCard(); // 1
		assertEquals(test_deck[2], real_deck.dealNextCard());

	}

	/**
	 * void
	 * 
	 * @throws Exception
	 * Test compares a card array to the array created in
	 * DeckOfCards class
	 */
	@Test
	public void testgetDeck() throws Exception {
		assertArrayEquals(test_deck, real_deck.getDeck());
	}

	/**
	 * void
	 * 
	 * @throws Exception
	 * Test compares unshuffled deck to a shuffled deck
	 */
	@Test
	public void testShuffleDeck() throws Exception {

		real_deck.shuffleDeck();
		assertNotSame(test_deck, real_deck.getDeck());
	}

	/**
	 * void
	 * 
	 * @throws Exception
	 * Test compares unshuffled deck to a deck shuffled twice to
	 * make sure shuffle does not shuffle back
	 */
	@Test
	public void testShuffleDeckTwice() throws Exception {

		real_deck.shuffleDeck();
		real_deck.shuffleDeck();
		assertNotSame(test_deck, real_deck.getDeck());
	}

	/**
	 * @throws Exception
	 * 
	 * Test confirms compare to method works two of the same cards
	 * are compared
	 */
	@Test
	public void testCompareTo() throws Exception {

		assertEquals(0, test_deck[0].compareTo(test_deck[0]));
	}

	/**
	 * @throws Exception
	 * Test confirms compare method works
	 */
	@Test
	public void testCompare() throws Exception {

		assertEquals(0, test_deck[0].compare(test_deck[0], test_deck[0]));
	}

	/**
	 * @throws Exception
	 * Test confirms equals method in Card works for false
	 */
	@Test
	public void equalsFalse() throws Exception {
		assertEquals(false, test_deck[0].equals(test_deck[1]));
	}

	/**
	 * @throws Exception
	 * Test confirms equals method in Card works for true
	 */
	@Test
	public void equalsTrue() throws Exception {

		boolean temp = test_deck[0].equals(test_deck[0]);

		assertEquals("Method should return true --> " + temp, true, temp);
	}
}
