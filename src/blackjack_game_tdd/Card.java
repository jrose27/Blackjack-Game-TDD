package blackjack_game_tdd;

import java.util.Comparator;

/**
 * @author John Rose Apr 23, 2017
 */
public class Card implements Comparable<Card>, Comparator<Card> {

	private int card_id_number;
	private Suit card_suit;

	/**
	 * @param input_suit
	 * @param input_id_number
	 * Constructor creates a card object with a suit and 
	 */
	public Card(Suit input_suit, int input_id_number) {

		this.card_suit = input_suit;
		this.card_id_number = input_id_number;
	}

	/**
	 * @return the card_id_number
	 */
	public int getCardIdNumber() {
		return card_id_number;
	}

	/**
	 * @return the card_suit
	 */
	public Suit getCardSuit() {
		return card_suit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		String card_id_string = "";

		switch (this.card_id_number) {

		case 1:
			card_id_string = "Ace";
			break;

		case 2:
			card_id_string = "Two";
			break;

		case 3:
			card_id_string = "Three";
			break;

		case 4:
			card_id_string = "Four";
			break;

		case 5:
			card_id_string = "Five";
			break;

		case 6:
			card_id_string = "Six";
			break;

		case 7:
			card_id_string = "Seven";
			break;

		case 8:
			card_id_string = "Eight";
			break;

		case 9:
			card_id_string = "Nine";
			break;

		case 10:
			card_id_string = "Ten";
			break;

		case 11:
			card_id_string = "Jack";
			break;

		case 12:
			card_id_string = "Queen";
			break;

		case 13:
			card_id_string = "King";

		}

		return card_id_string + " of " + card_suit.toString();
	}

	/*
	 * 	The Card class will need a compareTo, compare, and equals methods 
	 * 	in order to use aasertArrayEquals in the CardandDeck Test Class
	 */
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 */
	@Override
	public int compareTo(Card card) {
		
		if (card_id_number - card.getCardIdNumber() == 0) {
			
			return card_suit.ordinal() - card.getCardSuit().ordinal();
		}
		
		return card_id_number - card.getCardIdNumber();	
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Card c1, Card c2) {

		if (c1.getCardIdNumber() - c2.getCardIdNumber() == 0) {
			
			return c1.getCardSuit().ordinal() - c2.getCardSuit().ordinal();
		}
		
		return c1.getCardIdNumber()- c2.getCardIdNumber();	
	}
	
	// Has to implement so assertArrayEquals() will work
	public boolean equals(Object co) {
		if (card_id_number != ((Card) co).getCardIdNumber()) {
			
			return false;
		}
		else if(card_id_number != ((Card) co).getCardIdNumber()) {	
			return false;
		}
		return true;
		
	}

}
