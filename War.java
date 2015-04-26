/*War for final project
Caitlin Bliss*/
   
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class War extends JFrame
{
   //Initalize Variables 
   private JButton button3; //Create buttons to play
   private ButtonListener listener; //Interprets buttons
   public boolean canPress = true; //if press button draw
   private ArrayList<Card> war = new ArrayList<Card>(); //Create an array of cards drawn from a war
   public JLabel button1, button2,button4,button5;//Create labels 
   public final int WINDOW_WIDTH = 900; //Initialize window dimensions 
   public final int WINDOW_HEIGHT = 500;
   Deck player, opponent; //Creates two objects from the Deck class
   Card playerCard, opponentCard; //Creates two objects from the card class
   javax.swing.Timer timer1, timer2;//Creates a timer using swing
   T1Listener t1Listener; //Creates an object from time 1 class
   T2Listener t2Listener; //Creates an object from time 2 class
 
   /*War creates a button and timer for main requirements*/
    public War()
   {
      listener = new ButtonListener();//Initalize button listener 
      t1Listener = new T1Listener(); //Initalize timer 1 listener
      t2Listener = new T2Listener(); //Initalize timer 2 listener 
      timer1 = new javax.swing.Timer(1000, t1Listener); //Creates a 1 sec pause 
      timer2 = new javax.swing.Timer(1000, t2Listener); //Creates a 1 sec pause 
      // game = new War();
      setTitle("The Game War");
      //Set size of window
      setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
      setBackground(Color.green);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add border layout 
      setLayout(new BorderLayout());
      
      //Player 1 card and label 
      ImageIcon back = new ImageIcon("back.jpg");
      button1 = new JLabel("Player 1",back,SwingConstants.CENTER);
      button1.setFont(new Font("Serif",Font.BOLD,20));
      //Opponent card and label
      button2 = new JLabel("Opponent",back,SwingConstants.CENTER);
      button2.setFont(new Font("Serif",Font.BOLD,20));
      //Draw button
      button3 = new JButton("Draw");
      button3.setFont(new Font("Serif",Font.BOLD,36));
      // Results label 
      button4 = new JLabel("Results:", SwingConstants.CENTER);
      button4.setFont(new Font("Serif",Font.BOLD,20));
      // Title label 
      button5 = new JLabel("The Game of War",SwingConstants.CENTER);
      button5.setFont(new Font("Serif",Font.ITALIC,48));
   
      //Calls ButtonListener object
      button3.addActionListener(listener);
      
      //Sets up gaming board 
      add(button1, BorderLayout.WEST);
      add(button2, BorderLayout.EAST);
      add(button3, BorderLayout.CENTER);
      add(button4, BorderLayout.SOUTH);
      add(button5, BorderLayout.NORTH);
      setVisible(true);
      
      //Create the player deck
      player = new Deck();
      //Create opponent deck 
      opponent = player.split();
   }
    
               
     
  //New War Border       
   public static void main(String[]args)
   {
      new War();
   }
  
  //ActionListerner Interface 
   public class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // If cannot press draw button return
         if(!canPress)
         {
            return;
         }
         
         canPress = false;
         //Try and catch statements to catch Interrupted Exception
         try
         {
            playRound();
         } 
         catch(InterruptedException err)
         {
         
         }
      }  
   }
      
   public void playRound() throws InterruptedException
   {
      //Opponent and player draw cards 
      playerCard = player.draw();
      opponentCard = opponent.draw();
      //Sets the cards drawn to the corresponding image 
      button1.setIcon(playerCard.getImage());
      button2.setIcon(opponentCard.getImage());
      
      //Test the cards to find a winner 
      if(playerCard.getRank() > opponentCard.getRank())
      {
         //Player wins
         
         //Collects both cards and adds to the bottom of deck
         player.add(playerCard);
         player.add(opponentCard);
         //Print results of the round 
         button4.setText("Results: Player 1 wins this round!");
         //Collects the additional cards if War occurred 
         int temp = war.size();
         for(int i = 0; i < temp; i++)
         {
            player.add(war.remove(0));
         }
           
      }
      if(playerCard.getRank() < opponentCard.getRank())
      {
         //Opponent wins
           
         //Collects both cards
         opponent.add(playerCard);
         opponent.add(opponentCard);
         //Displays results of the round 
         button4.setText("Results: Opponent wins this round!");
         //Collects the additional cards if War occurred 
         int temp = war.size();
         for(int i = 0; i < temp; i++)
         {
            opponent.add(war.remove(0));
         }
      }
      if(playerCard.getRank() == opponentCard.getRank())
      {
           // War
         button3.setText("War happening.");
           //Calls War method
         War(playerCard, opponentCard);
         return;
      }
         
      if(player.getSize() == 0)
      {
         // Player loses game
         button3.setText("Opponent Wins!");
         return;
      }
      if(opponent.getSize() == 0)
      {
         // Opponent loses game
         button3.setText("Player Wins!");
         return;
      }
     
     //Display current number of cards of each player 
      button1.setText("Player 1 - " + player.getSize());
      button2.setText("Opponent - " + opponent.getSize());
      button3.setText("Draw");
         
      canPress = true;
   }
      
    /**
      * War method 
      * @param Card pC The player's card
      * @param Card oC The opponent's card
      */
   private void War(Card pC, Card oC) throws InterruptedException 
   {
      war.add(pC); //Add player's car to war array
      war.add(oC); //Add opponent's card to war array 
         
      timer1.start(); //Start timer 1 (creates a pause)
   }   
    /** 
      * Creates a Timer 1 to begin a War this allows it to show 
      * the first card face down
      */  
   public class T1Listener implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) 
      {        
         //Each player draw card and display them face down  
         war.add(player.draw());
         war.add(player.draw());
         button1.setIcon(new ImageIcon("back.jpg"));
         button2.setIcon(new ImageIcon("back.jpg"));
            //Timer 1 stops and timer 2 begins 
         timer1.stop();
         timer2.start();
      }   
   }
      /*
       * Creates a timer 2 that creates a pause before the player and 
       * opponent draw the second card to face on top of the war pile 
       */
   public class T2Listener implements ActionListener {
        
      public void actionPerformed(ActionEvent e) {
         try{ 
            timer2.stop();
            playRound();
         } 
         catch(InterruptedException err) {
         }
      }
   }

}