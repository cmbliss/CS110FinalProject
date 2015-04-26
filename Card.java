/*Assignment 5
Caitlin Bliss
Card Game*/

public class Card
{
//initiallize variables
      public final static int SPADES = 0;
      public final static int HEARTS = 1;
      public final static int DIAMONDS = 2;
      public final static int CLUBS = 3;
      public final static int ACE = 1; 
      public final static int JACK = 11; 
      public final static int QUEEN = 12; 
      public final static int KING = 13; 
      private final int suit; 
      private final int rank;
//method for the rank and suit
      public Card(int therank, int theSuit) 
      {
         rank = therank;
         suit = theSuit;
      }
//method for the suit
//using @return 
      public int getSuit() 
      {
         return suit;
      }
//method to get the rank value
//using @return
      public int getValue() 
      {
         return rank;
      }
//turn the suits into strings method
//using a switch statement and @return
   public String getSuitAsString() 
      {
         switch ( suit ) 
         {
         case SPADES: return "Spades";
         
         case HEARTS: return "Hearts";
         
         case DIAMONDS: return "Diamonds";
         
         case CLUBS: return "Clubs";
         
         default: return "??";
         }
      }
//get the rank value as a string
//using a switch statement and @return
      public String getValueAsString() 
      {
         switch ( rank ) 
         {
            case 1: return "Ace";
            
            case 2: return "2";
           
            case 3: return "3";
           
            case 4: return "4";
           
            case 5: return "5";
           
            case 6: return "6";
           
            case 7: return "7";
           
            case 8: return "8";
           
            case 9: return "9";
           
            case 10: return "10";
           
            case 11: return "Jack";
           
            case 12: return "Queen";
           
            case 13: return "King";
           
            default: return "??";
         }
      }
//method for the suit and rank to string
//using @return
      public String toString() 
      {
         return getValueAsString() + " of " + getSuitAsString();
      }
} 