//Zach Wagener, wagen118
import java.util.Random;
class Deck {

private Card[] deck;
private int count;

Random r = new Random();

public Deck() {
		deck =  new Card[52];
		count = 52;
		int counter = 0;
		for(int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
			deck[counter] = new Card(i, j);
			counter++;
			}
		}
	}

public boolean isFull() {
	return count >= deck.length-1;
}
public boolean isEmpty() {
	return count == 0;
}
public Card deal() {
	if(isEmpty()) {
		throw new IllegalStateException("No cards left!");
	}
	else {
		count--;
		return deck[count]; 
			}
	}
public void shuffle() {
	if (!isFull()) {
		throw new IllegalStateException("Can't shuffle a deck that isn't full!");
	}
	else {
		for (int i = deck.length-1; i > 0; i--) {
		int j = Math.abs(r.nextInt()) % i;
		Card temp = deck[j];
		deck[j] = deck[i];
		deck[i] = temp;
		}
	}
	}
}
