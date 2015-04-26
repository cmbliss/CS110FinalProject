/*Card Class for final prject
Caitlin Bliss */ 
import javax.swing.*;

public class Card  
{
   //Initalize Values 
   private String[] suits = new String[]{"s","c","d","h"};
   public final int ACE =1;
   public final int JACK=11;
   public final int QUEEN=12;
   public final int KING=13;
   private int rank;
   private int suit;
   
   
   /*Card Constructor
    @param suit 
    @param rank */
   public Card(int suit,int rank)
   {
      this.rank=rank;
      this.suit=suit;
   }
   /*getSuit method @return The card's suit*/
   public int getSuit()
   {
      return suit;
   }     	
   /*getRank method @return the Card's rank*/
     
   public int getRank()
   {
      return rank;
   }
  
  /*getImage method @return New image icon */
  
   public ImageIcon getImage()
   {
      return new ImageIcon(rank + suits[suit] + ".jpg");
   }
 
 }          