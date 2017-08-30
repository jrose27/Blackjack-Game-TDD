package blackjack_game_tdd;

/**
 * This class is to test all methods that return void.
 * 
 * @author John Rose
 * Apr 23, 2017
 */
public class VoidMethodTester {

	/**
	 * void
	 * @param args
	 */
	public static void main(String[] args) {
		
		Player test_player = new Player("Player", 1000);
		Player test_dealer = new Player("Dealer", 10000);
		
		// Create deck of cards
		DeckOfCards test_deck = new DeckOfCards();
		
		// Print deck of cards
		System.out.println("This is the print deck test:");
		test_deck.printDeck();
		System.out.println();
		
		// Print shuffled deck of cards
		System.out.println("Deck printed after shuffle:");
		test_deck.shuffleDeck();
		test_deck.printDeck();
		System.out.println();
		
		// Deal cards of the shuffled deck
		System.out.println("This is the deal next card test:");
		System.out.println("This is the top card in the deck after shuffle --> " + test_deck.dealNextCard());
		System.out.println("This is the next card in the deck --> " + test_deck.dealNextCard());
		System.out.println();
		
		// Deal player two cards
		test_player.addCard(test_deck.dealNextCard());
		test_player.addCard(test_deck.dealNextCard());
		
		
		// Deal dealer two cards
		test_dealer.addCard(test_deck.dealNextCard());
		test_dealer.addCard(test_deck.dealNextCard());
		
	
		// Test Player hand is printing
		System.out.println("This is the print hand test:");
		test_player.printHand(true);
		// Test Dealer hand is printing
		test_dealer.printHand(false);
		
		// Test reset player's hand
		System.out.println("Reset player's hand test:");
		System.out.println("Before reset.");
		test_player.printHand(true);
		
		test_player.resetPlayerHand();
		
		System.out.println();
		System.out.println("After reset:");
		test_player.printHand(true);
		
	}

}
