//Zach Wagener, wagen118
public class Pile {

	private class Layer {
		private Card card;
		private Layer next;
	
	public Layer(Card card, Layer next) {
		this.card = card;
		this.next = next;
	}
	}
	private Layer top;
	
	public Pile() {
		top = null;
	}
	public void add(Card card) {
		top = new Layer(card, top);
	}
	public Card draw() {
		if(isEmpty()) {
			throw new IllegalStateException("Pile is Empty!");
		}
		else  {
		Layer temp = top;
		top = top.next;
		return temp.card;
		}
	}
	public boolean isEmpty() {
		return top == null;
	}
	
}
