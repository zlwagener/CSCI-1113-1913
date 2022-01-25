
//  CARD. A playing card from a standard deck but not a joker. You can't extend
//  this class because it's FINAL. You can't modify its instances.

final class Card
{

//  RANK NAME. Printable names of card ranks.

  private static final String [] rankName =
  {
    "ace",       //   0
    "two",       //   1
    "three",     //   2
    "four",      //   3
    "five",      //   4
    "six",       //   5
    "seven",     //   6
    "eight",     //   7
    "nine",      //   8
    "ten",       //   9
    "jack",      //  10
    "queen",     //  11
    "king"       //  12
  };

//  SUIT NAME. Printable names of card suits.

  private static final String [] suitName =
  {
    "clubs",     //  0
    "diamonds",  //  1
    "hearts",    //  2
    "spades"     //  3
  };

  private int rank;  //  Rank of this CARD, between 0 and 12.
  private int suit;  //  Suit of this CARD, between 0 and 3.

//  CARD. Constructor. Make a new CARD, with a given RANK and SUIT.

  public Card(int rank, int suit)
  {
    if (0 <= rank && rank <= 12 && 0 <= suit && suit <= 3)
    {
      this.rank = rank;
      this.suit = suit;
    }
    else
    {
      throw new IllegalArgumentException("Illegal rank or suit.");
    }
  }

//  GET RANK. Return the RANK of this CARD.

  public int getRank()
  {
    return rank;
  }

//  GET SUIT. Return the SUIT of this CARD.

  public int getSuit()
  {
    return suit;
  }

//  TO STRING. Return a STRING that describes this CARD. For printing only!

  public String toString()
  {
    return rankName[rank] + " (" + rank + ") of " + suitName[suit];
  }
}
