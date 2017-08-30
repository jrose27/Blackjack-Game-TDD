package blackjack_game_tdd;
/**
 * @author John Rose Apr 26, 2017
 */
public class Player {

	private String player_name;

	private Card[] player_hand = new Card[10];

	private int number_cards = 0;

	private int player_money;

	/**
	 * @param input_name
	 * @param input_player_money
	 * Player is initialized with an empty hand
	 */
	public Player(String input_name, int input_player_money) {
		this.player_name = input_name;
		this.player_money = input_player_money;
	}

	/**
	 * @return the player_name
	 */
	public String getPlayerName() {
		return player_name;
	}

	/**
	 * @return the entire player_hand as an array 
	 */
	public Card[] getPlayerHand() {
		return player_hand;
	}

	/**
	 * @param c
	 * @return a single card from the players_hand array
	 */
	public Card getCard(int c) {
		
		return this.player_hand[c];
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPlayerMoney() {
		return player_money;
	}

	/**
	 * void
	 * 
	 * @param input_card
	 * Method adds a card to a player's hand and returns true if player hand is less then 21
	 * 
	 */
	public boolean addCard(Card input_card) {
		
		this.player_hand[this.number_cards] = input_card;
		number_cards++;
		
		return (this.sumOfHand() <= 21);
	}
	

	/**
	 * void
	 * 
	 * @param show_all_cards
	 * Test for this method is in the VoidMethodTester class.
	 * 
	 */
	public void printHand(boolean show_all_cards) {

		System.out.println("This is " + player_name + "'s hand:");

		for (int i = 0; i < player_hand.length; i++) {

			// Check if value in player hand is null
			if (player_hand[i] == null) {
				continue;
			}

			// Dealer's hand
			if (i == 0 && !show_all_cards) {

				System.out.println(" [hidden]\n" + player_hand[i]);

			} else if (show_all_cards) {

				// Player's hand
				System.out.println(player_hand[i]);
			}
		} // Closes for loop
		System.out.println();
	}

	/**
	 * int
	 * 
	 * @return the sum of a players hand
	 */
	public int sumOfHand() {

		int hand_total = 0;
		int num_aces = 0;

		Card c;
		
		for (int i = 0; i < player_hand.length; i++) {
			
			// Check if value in player hand is null
			// The null pointer exception is killing me
			if (player_hand[i] == null) {
				continue;
			}
			
			c = player_hand[i];
			
			switch (c.getCardIdNumber()) {

			case 1: // Ace
				num_aces++;
				break;
			case 2:
				hand_total += 2;
				break;
			case 3:
				hand_total += 3;
				break;
			case 4:
				hand_total += 4;
				break;
			case 5:
				hand_total += 5;
				break;
			case 6:
				hand_total += 6;
				break;
			case 7:
				hand_total += 7;
				break;
			case 8:
				hand_total += 8;
				break;
			case 9:
				hand_total += 9;
				break;
			case 10:
				hand_total += 10;
				break;
			case 11: // Jack
				hand_total += 10;
				break;
			case 12: // Queen
				hand_total += 10;
				break;
			case 13: // King
				hand_total += 10;
			} // Closes switch statement
		} // Close for  loop

		// Handle aces
		for (int a = 0; a < num_aces; a++) {
			if (hand_total > 10) {
				hand_total += 1;
			} else {
				hand_total += 11;
			}
		}
		return hand_total;
	}
	
	/**
	 * void
	 * Method resets the player's hand
	 */
	public void resetPlayerHand() {
		for (int i = 0; i < 10; i++) {
			this.player_hand[i] = null;
		}
		number_cards = 0;
	}

}
