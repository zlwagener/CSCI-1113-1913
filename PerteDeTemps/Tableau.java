//Zach Wagener, wagen118
public class Tableau{

		private Pile[] tableau;
		
		public Tableau() {
		tableau = new Pile[13];
		
		for (int i = 0; i < 13; i++) {
			tableau[i] = new Pile();
		}
		
		Deck deck = new Deck();
		deck.shuffle();
		for(int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
			tableau[i].add(deck.deal());
			}
		}
	}
		public void play() {
			int pileMarker = 0;
			Pile p = tableau[0];
			Card c1 = p.draw();
			System.out.println("Got " + c1 + " from pile " + pileMarker + ".");
			while (true) {
			if(p.isEmpty()) {
				for (int i = 0; i < 13; i++) {
					if(!tableau[i].isEmpty()) {
						System.out.println("Pile " + pileMarker + " is empty! You lose!");
						return;
					}
				}
					
						System.out.println("You Win!");
						return;

					
				
			}
			
			Card c2 = p.draw();
			System.out.println("Got " + c2 + " from pile " + pileMarker + ".");

			if(c1.getSuit()==c2.getSuit()) {
				p = tableau[c1.getRank()];
				pileMarker = c1.getRank();
			}
			else {
				p = tableau[c2.getRank()];
				pileMarker = c2.getRank();
			}
			c1 = c2;
			}
	}
}
