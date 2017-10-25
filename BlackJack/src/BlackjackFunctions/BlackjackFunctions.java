package BlackjackFunctions;

import java.util.*;

public class BlackjackFunctions 

{
    
    private static Random random = new Random();                                
    private static int bet=0,playerSum=0, playerSumSplit,dealerSum=0;
    private static ArrayList<String> dealerHand=new ArrayList<>();
    private static ArrayList<String> playerHand=new ArrayList<>();
    private static ArrayList<String> playerHandSplit=new ArrayList<>();
    private static ArrayList<Integer> drawList=new ArrayList<>();
    private static int  drawNumber, aceCountPlayer, aceCountPlayerSplit, aceCountDealer,reducedAcesDealer,reducedAcesPlayer, reducedAcesPlayerSplit, faceCard;
    private static ArrayList<Integer> encryptedHand=new ArrayList<>();
    private static ArrayList<String> decryptedHand=new ArrayList<>();
    private static ArrayList<Integer> runSum=new ArrayList<>();
    private static boolean roundOver=false, softHandDealer,softHandPlayer,softHandPlayerSplit,split=false,secondHand=false;
    
    protected static void DrawList()                                            //COMPLETED: Creates an array containing each individual card based on the number of decks.
    
    {
        
        List<Integer> cardsInDeck = Arrays.asList(4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks,4*BlackjackSetup.decks);
    
        for (int j=0;j<cardsInDeck.size();j++)
      
        {
            for (int i=0;i<cardsInDeck.get(j);i++)
        
            {
            
                drawList.add(j);
            
            }
       
        }
        
    }   
    
    protected static void Bet()
    
    {
        
        BlackjackFunctions.ReshuffleCards();
        
        secondHand=false;
        split=false;
        faceCard=0;
        roundOver=false;
        dealerSum=0;
        playerSum=0;
        playerSumSplit=0;
        dealerHand.clear();
        playerHand.clear();
        playerHandSplit.clear();
        aceCountDealer=0;
        aceCountPlayer=0;
        aceCountPlayerSplit=0;
        reducedAcesDealer=0;
        reducedAcesPlayer=0;
        reducedAcesPlayerSplit=0;
        
        System.out.println("Cash Left: "+ BlackjackSetup.startingCash);
        System.out.print("Place Your Bet: ");
        BlackjackSetup.response=BlackjackSetup.reader.nextInt();
        bet=BlackjackSetup.response;
        System.out.println("_________________________________________________");
        BlackjackFunctions.DealCards();
        System.out.println("Dealer's Upcard: " + dealerHand.get(0));
        System.out.println("Player's Hand: " + playerHand.get(0)+" "+playerHand.get(1));
       
        if (playerSum==21 && dealerSum!=21 && roundOver==false)                 //Player wins Blackjack at the start.
        
        {   
            
            System.out.println("Blackjack! You Win!");
            System.out.println("Dealer's Hand: " + dealerHand.get(0)+" "+dealerHand.get(1));
            BlackjackSetup.startingCash+=(1.5*bet);
            roundOver=true;
            
        }
        
        else if (playerSum==21 && dealerSum==21 && roundOver==false)            //Push at the start
        
        {
            
            System.out.println("Push!");
            System.out.println("Dealer's Hand: " + dealerHand.get(0)+" "+dealerHand.get(1));
            roundOver=true;
       
        }
      
        else if (playerSum!=21 && dealerSum==21 && "A".equals(dealerHand.get(0)) && roundOver==false) //Dealer wins blackjack start with A upcard
       
        {
            System.out.print("Take Insurance?([0]=yes/[1]=no)");
            BlackjackSetup.response=BlackjackSetup.reader.nextInt();
                
                if (BlackjackSetup.response==0)
                
                {
                  
                    bet=0;
                
                }
            System.out.println("Checking Dealer for Blackjack...");
            System.out.println("Dealer Blackjack! You Lose!");
            System.out.println("Dealer's Hand: " + dealerHand.get(0)+" "+dealerHand.get(1));
            BlackjackSetup.startingCash-=bet;
            roundOver=true;
       
        }
        
        else if (playerSum!=21 && dealerSum!=21 && roundOver==false)            //No starting Blackjack
       
        {
           
            if ("A".equals(dealerHand.get(0)))                                  //Dealer "A" upcard safe no blackjack     
          
            {
                
                System.out.print("Take Insurance?([0]=yes/[1]=no)");
                BlackjackSetup.response=BlackjackSetup.reader.nextInt();
                
                if (BlackjackSetup.response==0)
                
                {
                  
                    BlackjackSetup.startingCash=BlackjackSetup.startingCash-(bet/2);
                    bet=bet/2;
                
                }
               
                System.out.println("Checking Dealer for Blackjack...");
                System.out.println("No Blackjack!");
           
            }
          
            BlackjackFunctions.PlayerChoice();
            
        }
       
        BlackjackFunctions.Bet();
  
    }
    
    private static void DealCards()                  
    
    {

        for (int i=0;i<4;i++)
       
        {
            
        drawNumber = random.nextInt(drawList.size());
        encryptedHand.add(drawList.get(drawNumber));
        drawList.remove(drawNumber);
        
        switch (encryptedHand.get(i))
        {
            case 0: decryptedHand.add("A");
                    runSum.add(11);
                    break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                   decryptedHand.add(String.valueOf(encryptedHand.get(i)+1));
                   runSum.add(encryptedHand.get(i)+1);
                   break;
            case 10:decryptedHand.add("J");
                    runSum.add(10);
                    if (i==2 || i==0)
                    {
                    faceCard+=1;
                    }
                    break;
            case 11:decryptedHand.add("Q");
                    runSum.add(10);
                    if (i==2 || i==0)
                    {
                    faceCard+=1;
                    }
                    break;
            case 12:decryptedHand.add("K");
                    runSum.add(10);
                    if (i==2 || i==0)
                    {
                    faceCard+=1;
                    }
                    break; 
        }
        
        }
        
        playerHand.add(decryptedHand.get(0));
        dealerHand.add(decryptedHand.get(1));
        playerHand.add(decryptedHand.get(2));
        dealerHand.add(decryptedHand.get(3));
        playerSum=runSum.get(0) + runSum.get(2);
        dealerSum=runSum.get(1) + runSum.get(3);
        
        runSum.clear();
        encryptedHand.clear();
        decryptedHand.clear();
        
    }
    
    private static void PlayerChoice() 
    
    {
        
        System.out.println();
        System.out.println("[1]: Hit");
        System.out.println("[2]: Stand");
        if (BlackjackSetup.startingCash>=(bet*2))
        {
            
            System.out.println("[3]: Double Down");

        }
        if (playerHand.get(0).equals(playerHand.get(1)) || faceCard==2)
       
        {
            
            System.out.println("[4]: Split");
            
        }
        
        BlackjackSetup.response=BlackjackSetup.reader.nextInt();
        
        switch (BlackjackSetup.response)
            
        {
            case 1:BlackjackFunctions.Hit(0,playerSum,playerHand);
                   break;
            case 2:BlackjackFunctions.Stand(playerSum);
                   break;
            case 3:BlackjackFunctions.bet+=bet;
                   BlackjackFunctions.Hit(0,playerSum,playerHand);
                   BlackjackFunctions.Stand(playerSum);
                   break;
            case 4:split=true;
                   BlackjackFunctions.SplitHand(0);
                   BlackjackFunctions.SplitHand(1);
                   break;
            
        }
    }
  
    private static void SplitHand(int x) 
    
    {
     
        if (x==0)
            
        {
            
            playerHandSplit.add(playerHand.get(1));
            playerHand.remove(1);
            playerSum=(playerSum/2);
            playerSumSplit=playerSum;
            BlackjackFunctions.DrawCard(0);
            BlackjackFunctions.DrawCard(2);
            
        }
        
        if (x==1) //First Hand
        {

            System.out.println("First Hand: " + Arrays.toString(playerHand.toArray()));
            System.out.println("Second Hand: " + Arrays.toString(playerHandSplit.toArray()));
            System.out.println("First Hand Options: ");
            System.out.println("[1]: Hit");
            System.out.println("[2]: Stand");
        
            if (BlackjackSetup.startingCash>=(bet*2))
        
            {
            
                System.out.println("[3]: Double Down");

            }   
   
            BlackjackSetup.response=BlackjackSetup.reader.nextInt();
        
            switch (BlackjackSetup.response)
            
            {
                case 1:BlackjackFunctions.Hit(0,playerSum,playerHand);
                       break;
                case 2:split=false;
                       secondHand=true;
                       BlackjackFunctions.SplitHand(2);
                       break;
                case 3:split=false;
                       secondHand=true;
                       BlackjackFunctions.bet+=bet;
                       BlackjackFunctions.Hit(0,playerSum,playerHand);
                       BlackjackFunctions.SplitHand(2);
                       break; 
            }
            
        }
        
        if (x==2) 
        {
            System.out.println("First Hand: " + Arrays.toString(playerHand.toArray()));
            System.out.println("Second Hand: " + Arrays.toString(playerHandSplit.toArray()));
            System.out.println("Second Hand Options: ");
            System.out.println("[1]: Hit");
            System.out.println("[2]: Stand");
            if (BlackjackSetup.startingCash>=(bet*2))
        
            {
            
                System.out.println("[3]: Double Down");

            }   
   
            BlackjackSetup.response=BlackjackSetup.reader.nextInt();
        
            switch (BlackjackSetup.response)
            
            {
                case 1:BlackjackFunctions.Hit(2,playerSumSplit,playerHandSplit);
                       break;
                case 2:BlackjackFunctions.Stand(playerSum);
                       BlackjackFunctions.Stand(playerSumSplit);
                       break;
                case 3:BlackjackFunctions.bet+=bet;
                       BlackjackFunctions.Hit(2,playerSumSplit,playerHandSplit);
                       BlackjackFunctions.Stand(playerSum);
                       BlackjackFunctions.Stand(playerSumSplit);
                       break;
            }
        }
        
        
        
        
        
        
        
        
    }
    
    
    private static void Hit(int x, int playerSum,ArrayList playerHand)
    
    {
       
        faceCard=0;
        BlackjackFunctions.DrawCard(x);
        BlackjackFunctions.AceCheck();
        System.out.println("You Drew: " + playerHand.get(playerHand.size()-1));
        
        if (roundOver==false && playerSum>21)
       
        {
            
            BlackjackSetup.startingCash-=bet;
            if (split==false && secondHand==false)
            
            {
                roundOver=true;
                System.out.println("Player Busts!");
                System.out.println("Dealer's Hand: " + Arrays.toString(dealerHand.toArray()));
                System.out.println("Player's Hand: " + Arrays.toString(playerHand.toArray()));
                System.out.println("_________________________________________________");
                
            }
            
            
            
            if (split==true && secondHand==false)
            {
                System.out.println("First Hand Busts!");
                BlackjackSetup.startingCash-=bet;
                BlackjackFunctions.SplitHand(2);
                System.out.println("Player's Hand: " + Arrays.toString(playerHand.toArray()));
                System.out.println("_________________________________________________");
                split=false;
            }
            else if (split==false && secondHand==true)
                    {
                        System.out.println("Second Hand Busts!");
                        BlackjackSetup.startingCash-=bet;
                        System.out.println("Player's Hand: " + Arrays.toString(playerHand.toArray()));
                        System.out.println("Dealer's Hand: " + Arrays.toString(dealerHand.toArray()));
                        System.out.println("_________________________________________________");
                    }
            
        }
        
        else if (roundOver==false && playerSum<=21 && BlackjackSetup.response!=3 && split==false && secondHand==false)
        
        {
            
            BlackjackFunctions.PlayerChoice();
            
        }
        
        if (split==true && secondHand==false && playerSum<=21)
        {
            BlackjackFunctions.SplitHand(1);
        }
        
        else if (split==false && secondHand==true && playerSum<=21)
        {
            BlackjackFunctions.SplitHand(2);
        }
        
  
    }
    
    
    
    
    
    
    private static void Stand(int playerSum)
    
    {
        BlackjackFunctions.AceCheck();
        System.out.println("_________________________________________________");
      
        if (dealerSum>=17 && roundOver==false)                                  //Dealer stands as well
       
        {
           
            System.out.println("Dealer's Hand: " + Arrays.toString(dealerHand.toArray()));
            System.out.println("Player's Hand: " + Arrays.toString(playerHand.toArray())); 
            System.out.println("_________________________________________________");
            
            if (dealerSum>playerSum && dealerSum<=21 && roundOver==false)       //Dealer as a greater pat then the player
           
            {
                System.out.println("Dealer Wins!");
                BlackjackSetup.startingCash-=bet;
                roundOver=true;
                
            }
          
            else if (dealerSum==playerSum && roundOver==false)                                      //Push, equal pats.
           
            {
                 
                System.out.println("Push!");
                roundOver=true;
          
            }
            
            else if (dealerSum<playerSum && roundOver==false)                                       //Player has a higher pat
          
            {
              
                System.out.println("You Win!");
                BlackjackSetup.startingCash+=bet;
                roundOver=true;
                
            }
            
            else if (dealerSum>21 && roundOver==false)                                                   //Dealer busts
          
            {
                
                System.out.println("Dealer Busts!");
                BlackjackSetup.startingCash+=bet;
                roundOver=true;
          
            }
       
        }
        
        if (dealerSum<17 && roundOver==false)
       
        {
           
            System.out.println("Dealer's Hand: " + dealerHand.get(0)+" "+dealerHand.get(1));
            
            while (dealerSum<17)
                    
            {
           
            BlackjackFunctions.DrawCard(1);
            System.out.println("Dealer Draws: " + dealerHand.get(dealerHand.size()-1));
                   
            }
            
            BlackjackFunctions.AceCheck();
            BlackjackFunctions.Stand(playerSum);
        
        }  
    }
   
    private static void DrawCard(int x)                                          //Draws card and passes it to either the player or dealer based on int.
   
    {
        
        drawNumber = random.nextInt(drawList.size());
        encryptedHand.add(drawList.get(drawNumber));
        drawList.remove(drawNumber);
       
        switch (encryptedHand.get(0))
       
        {
            case 0: decryptedHand.add("A");
                    runSum.add(11);
                    break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                   decryptedHand.add(String.valueOf(encryptedHand.get(0)+1));
                   runSum.add(encryptedHand.get(0)+1);
                   break;
            case 10:decryptedHand.add("J");
                    runSum.add(10);
                    break;
            case 11:decryptedHand.add("Q");
                    runSum.add(10);
                    break;
            case 12:decryptedHand.add("K");
                    runSum.add(10);
                    break; 
       
        }

        if (x==0)
        
        {
            
            playerHand.add(decryptedHand.get(0));
            playerSum+=runSum.get(0);
            runSum.clear();
            encryptedHand.clear();
            decryptedHand.clear();
            
        }
        
        else if (x==1)
       
        {
            dealerHand.add(decryptedHand.get(0));
            dealerSum+=runSum.get(0);
            runSum.clear();
            encryptedHand.clear();
            decryptedHand.clear();
            
        }
        
        else if (x==2)
            
        {
            
            playerHandSplit.add(decryptedHand.get(0));
            playerSumSplit+=runSum.get(0);
            runSum.clear();
            encryptedHand.clear();
            decryptedHand.clear();
            
        }
        
    }  
    
    private static void AceCheck()
    
    {
        
        aceCountPlayer=Collections.frequency(playerHand,"A");
        aceCountPlayerSplit=Collections.frequency(playerHandSplit,"A");
        aceCountDealer=Collections.frequency(dealerHand,"A");
        softHandPlayer=aceCountPlayer>reducedAcesPlayer;
        softHandPlayerSplit=aceCountPlayerSplit>reducedAcesPlayerSplit;
        softHandDealer = aceCountDealer>reducedAcesDealer;
        
        
        if (dealerSum>21 && softHandDealer==true && roundOver==false)
        
        {
           
            dealerSum-=10;
            reducedAcesDealer+=1;
            
        }
        
        if (playerSum>21 && softHandPlayer==true && roundOver==false)
     
        {
            
            playerSum-=10;
            reducedAcesPlayer+=1;
            
        }
        
        if (playerSumSplit>21 && softHandPlayerSplit==true && roundOver==false)
     
        {
            
            playerSumSplit-=10;
            reducedAcesPlayerSplit+=1;
            
        }
        
        
        
    }
    
    private static void ReshuffleCards() 
    
    {
        
        int z = random.nextInt(15)+10;
        
        if (drawList.size()<=(z))
        
        {
            
            System.out.println("Deck out. Continue with new deck or retire?");
            System.out.println("[1]: Continue");
            System.out.println("[2]: Retire");
            BlackjackSetup.response=BlackjackSetup.reader.nextInt();
            
            if (BlackjackSetup.response==1)
          
            {
                
                drawList.clear();
                BlackjackFunctions.DrawList();
                
            }
            
            else if (BlackjackSetup.response==2)
            
            {
                
                
                
            }
            
        }
        
    }
    
}
