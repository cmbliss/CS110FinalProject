/*Deck Class for final Project
Caitlin Bliss*/

import java.util.Random;
import java.util.*;

/*Creates a deck*/
 
public class Deck
{
   //Initialize Variables 
   public String suits[] = {"Spade","Heart","Club","Diamond"};
   private ArrayList<Card> cards;

	/*create and array to store cards*/
   public Deck()
	{
		cards = new ArrayList<Card>();
  		for(int i = 0; i <52; i++)
		{
			cards.add(new Card(i/13,i%13 +2));
		}
	}

	/*Shuffle cards*/
	 public void shuffle()
	{
		Collections.shuffle(cards);
	}

	/*Remove top card */
	 public Card draw()
	{
		if(cards.size() == 0) 
      {
         return null;
      }
      else
      {
         return cards.remove(0);
      }
   }
   /*Add card to the bottom*/ 
   public void add(Card n)
   {
      cards.add(n);
   }
   /*Size of deck @return Deck size*/ 
   public int getSize()
   {
      return cards.size();
   }
   /*Split the deck */
   public Deck split()
   {
      if(cards.size() != 52) 
      {
         return null;
      }
      else
      {
         shuffle();
         Deck output = new Deck();
         while(output.getSize() > 0) output.draw();
         for(int i = 0;i < 26; i++)
         {
            output.add(draw());
         }
         return output;
       }
   }
}   
