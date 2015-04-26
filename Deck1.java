/**
 * Representation of a Deck of cards.  
 * Initialized to a standard 52 card deck. 
 *
 * @author Jackie Horton
 */

import java.util.Random;
public class Deck1 
{
   /** 
   *  Number of cards in standard deck {@value #CARDS_IN_DECK}
   **/
   public final static int CARDS_IN_DECK = 52;

   /** The collection of Cards */
   private CardFinal [] deck;
   /** Current number of Cards in Deck */
   private int ct;
   
   /**
    * Constructs a regular 52-card deck.  Initially, the cards
    * are in a sorted order.  The shuffle() method can be called to
    * randomize the order.  
    */
   public Deck1()
   {
      freshDeck();
   }
   /**
    * Create a new collection of 52 cards, in sorted order
    */
   public void freshDeck()
   {
      deck = new CardFinal[CARDS_IN_DECK];
      for (int r = CardFinal.ACE; r<=CardFinal.KING;r++)
      {
         for (int s=CardFinal.SPADES;s<=CardFinal.CLUBS;s++)
         {
            deck[ct]=new CardFinal(r,s);
            ct = ct + 1;
         }
      }
     
   
   }
   /** 
     * Remove and return the top Card on the Deck
     * @return A reference to a Card that was top on the Deck
     */
   public CardFinal dealCard()
   {
      ct--;
      return deck[ct];
   }
   /** 
     * Return current number of Cards in Deck
     * @return number of Cards in Deck
     */
   public int cardsRemaining()
   {  
      return ct;
   }
   /** 
     * Randomize the order of Cards in Deck
     */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < ct; i++)
      {
         randNum = r.nextInt(ct);
         temp = deck[i];
         deck[i]=deck[randNum];
         deck[randNum]=temp;
      }
   }
   /** 
     * Determine if Deck is empty
     * @return true if there are no more cards, false otherwise
     */
   public boolean isEmpty()
   {
      return (cardsRemaining() == 0);
   }

   public static void main(String [] args) 
   {
      Deck deck = new Deck();
      deck.shuffle();
      int i = 0;
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());
      deck.freshDeck();
      System.out.println("************");
      i = 0;
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());

   }
}
