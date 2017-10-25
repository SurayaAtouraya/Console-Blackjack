package BlackjackFunctions;

import java.util.*; 

public class BlackjackSetup 

{
    
    public static int decks=6;
    public static int startingCash=1000;
    public static String[] args = {};
    public static Scanner reader = new Scanner(System.in);
    public static int response=0;
    
    public static void main(String[] arg)                                       
   
    {
        BlackjackSetup.MainMenu();
   
    }
    
    public static void MainMenu()                                               //PROGRAM STARTS HERE AFTER MAIN
    
    {
           
        System.out.println("Welcome to Console Blackjack!");
        System.out.println();
        System.out.println("[1]: Start Game");
        System.out.println("[2]: Settings");
        System.out.println("[0]: Quit Game");
        System.out.println("");
        response=reader.nextInt();
        System.out.println("_________________________________________________");
        
        switch (response) 
        
        {
            
            case 0: System.exit(0);
                    break;
            case 1: Blackjack.main(args);
                    break;
            case 2: Settings();
                    break;
        }     
    
    }
    
    public static void Settings()                                               //DISPLAYS NUMBER OF DECKS AND CASH, 
                                                                                //ASKS IF USER WOULD LIKE TO EDIT
    {
       
        System.out.println("Number of Decks: " + decks);
        System.out.println("Starting Cash: " + startingCash);
        System.out.println("");
        System.out.println("[1]: Back to Main Menu");
        System.out.println("[2]: Edit");
        System.out.println("[0]: Quit");
        System.out.println("");
        response=reader.nextInt();
        System.out.println("_________________________________________________");
        
        switch (response) 
        
        {
            
            case 0: System.exit(0);
                    break;
            case 1: BlackjackSetup.MainMenu();
                    break;
            case 2: BlackjackSetup.ChangeSettings();
                    break;
       
        }    
   
    }
    
    public static void ChangeSettings()                                         //USER IS PROMPTED TO CHANGE SETTINGS
    
    {
        
        System.out.print("Enter Amount of Decks: ");
        BlackjackSetup.decks=reader.nextInt();
        System.out.print("Enter Starting Cash: ");
        BlackjackSetup.startingCash=reader.nextInt();
        System.out.println("_________________________________________________");
        BlackjackSetup.Settings();
     
    }
    
}
