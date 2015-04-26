/**
  * The card class creates cards and sets Icon Images to each correspondinng rank and suit of
  * a card
  */ 
import javax.swing.*;

public class Card Final 
{
   //Initalize Values 
   private String[] suits = new String[]{"s","c","d","h"};
   public final int ACE =1;
   public final int JACK=11;
   public final int QUEEN=12;
   public final int KING=13;
   private int rank;
   private int suit;
   
   
   /*
    *Constructor 
    *@param suit The card's suit
    *@param rank The card's rank
    */
   public Card(int suit,int rank)
   {
      this.rank=rank; //Use this to overcome shadowing
      this.suit=suit;
   }
   /*
    * getSuit method
    * @return The card's suit
    */
   public int getSuit()
   {
      return suit;
   }     	
   /*
    * getRank method
    * @return The card's rank
    */   
   public int getRank()
   {
      return rank;
   }
  
  /*
   * getImage method 
   * @return New image icon based on rank and suit 
   */
  
   public ImageIcon getImage()
   {
      return new ImageIcon(rank + suits[suit] + ".jpg");
   }
 
 }          