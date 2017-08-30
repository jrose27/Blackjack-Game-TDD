package blackjack_game_tdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author John Rose Apr 23, 2017
 */
public class DeckOfCards {

	private Card[] deck;
	private int number_of_cards = 52;

	/**
	 * Constructor creates a deck of cards the size specified in number of cards
	 * variable
	 * 
	 */
	public DeckOfCards() {

		deck = new Card[number_of_cards];
		int card_index = 0;

		// Create for loop for each suit
		for (int s = 0; s < 4; s++) {

			// Create for loop for each number
			for (int n = 1; n < 14; n++) {

				deck[card_index] = new Card(Suit.values()[s], n);
				card_index++;

			} // Closes number for loop
		} // Close suit for loop
	}

	/**
	 * int
	 * 
	 * @return
	 */
	public int sizeOfDeck() {
		return deck.length;
	}

	/**
	 * void Test method in a separate main DefaultGameTester
	 */
	public void printDeck() {

		for (int i = 0; i < number_of_cards; i++) {
			System.out.println(deck[i]);
		}
	}

	/**
	 * void
	 */
	public void shuffleDeck() {

		List<Card> temp_list = Arrays.asList(deck);
		Collections.shuffle(temp_list);
	}

	/**
	 * @return the deck Method gets the deck of cards
	 */
	public Card[] getDeck() {
		return deck;
	}

	/**
	 * Card
	 * 
	 * @return the top card of the deck and shifts all the cards left in the
	 *         deck to the left.
	 * 
	 */
	public Card dealNextCard() {

		// Get top card
		Card top_card = this.deck[0];

		// Shift the deck to next card
		for (int c = 1; c < this.number_of_cards; c++) {

			this.deck[c - 1] = this.deck[c];
		}

		this.deck[this.number_of_cards - 1] = null;

		// Decrement number of cards in deck
		this.number_of_cards--;

		return top_card;
	}
	
	/**
	 * @param cards
	 * Method returns a new deck
	 */
	public DeckOfCards resetDeck() {
		
		return new DeckOfCards();
	}	
}
