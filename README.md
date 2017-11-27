# Console-Blackjack

A Java application that allows you to play Blackjack within the console with real custom deck simulation.  
Full in game features, programmed within 5 days. Slight debugging required on splitting cards and more features still to be added..
Here is a full sample run of the program:
___________________________________________________________________________________________ //Starts Below this line.
Welcome to Console Blackjack!

[1]: Start Game
[2]: Settings
[0]: Quit Game

2
_________________________________________________
Number of Decks: 6
Starting Cash: 1000

[1]: Back to Main Menu
[2]: Edit
[0]: Quit

2
_________________________________________________
Enter Amount of Decks: 1
Enter Starting Cash: 100
_________________________________________________
Number of Decks: 1
Starting Cash: 100

[1]: Back to Main Menu
[2]: Edit
[0]: Quit

1
_________________________________________________
Welcome to Console Blackjack!

[1]: Start Game
[2]: Settings
[0]: Quit Game

1
_________________________________________________
Cash Left: 100
[1]: Place Bet 
[2]: Game Stats 
[0]: Quit

1
_________________________________________________
Cash Left: 100
Place Your Bet: 10
_________________________________________________
Dealer's Upcard: 2
Player's Hand: 2 6

[1]: Hit
[2]: Stand
[3]: Double Down
1
You Drew: 7

[1]: Hit
[2]: Stand
[3]: Double Down
2
_________________________________________________
Dealer's Hand: 2 7
Dealer Draws: A
_________________________________________________
Dealer's Hand: [2, 7, A]
Player's Hand: [2, 6, 7]
_________________________________________________
Dealer Wins!
Cash Left: 90
Place Your Bet: 10
_________________________________________________
Dealer's Upcard: 8
Player's Hand: 9 10

[1]: Hit
[2]: Stand
[3]: Double Down
2
_________________________________________________
Dealer's Hand: 8 3
Dealer Draws: 4
Dealer Draws: 10
_________________________________________________
Dealer's Hand: [8, 3, 4, 10]
Player's Hand: [9, 10]
_________________________________________________
Dealer Busts!
Cash Left: 100
Place Your Bet: 20
_________________________________________________
Dealer's Upcard: 9
Player's Hand: 6 A

[1]: Hit
[2]: Stand
[3]: Double Down
3
You Drew: 5
_________________________________________________
Dealer's Hand: [9, 9]
Player's Hand: [6, A, 5]
_________________________________________________
Dealer Wins!
Cash Left: 60
Place Your Bet: 50
_________________________________________________
Dealer's Upcard: Q
Player's Hand: 2 8

[1]: Hit
[2]: Stand
1
You Drew: 7

[1]: Hit
[2]: Stand
2
_________________________________________________
Dealer's Hand: Q 4
Dealer Draws: J
_________________________________________________
Dealer's Hand: [Q, 4, J]
Player's Hand: [2, 8, 7]
_________________________________________________
Dealer Busts!
Cash Left: 110
Place Your Bet: 10
_________________________________________________
Dealer's Upcard: 8
Player's Hand: 4 3

[1]: Hit
[2]: Stand
[3]: Double Down
1
You Drew: Q

[1]: Hit
[2]: Stand
[3]: Double Down
1
You Drew: 5

[1]: Hit
[2]: Stand
[3]: Double Down
2
_________________________________________________
Dealer's Hand: 8 3
Dealer Draws: J
_________________________________________________
Dealer's Hand: [8, 3, J]
Player's Hand: [4, 3, Q, 5]
_________________________________________________
You Win!
Deck out. Continue with new deck or retire?
[1]: Continue
[2]: Retire
1
Cash Left: 120
Place Your Bet: 119
_________________________________________________
Dealer's Upcard: 6
Player's Hand: 10 2

[1]: Hit
[2]: Stand
2
_________________________________________________
Dealer's Hand: 6 7
Dealer Draws: 3
Dealer Draws: K
_________________________________________________
Dealer's Hand: [6, 7, 3, K]
Player's Hand: [10, 2]
_________________________________________________
Dealer Busts!
Cash Left: 239
____________________________________________________________________________________________________END OF SAMPLE RUN

Sample run of splitting feature:
____________________________________________________________________________________________________
Dealer's Upcard: 2
Player's Hand: Q J

[1]: Hit
[2]: Stand
[3]: Double Down
[4]: Split
4
First Hand: [Q, 8]
Second Hand: [J, 9]
First Hand Options: 
[1]: Hit
[2]: Stand
[3]: Double Down
2
First Hand: [Q, 8]
Second Hand: [J, 9]
Second Hand Options: 
[1]: Hit
[2]: Stand
[3]: Double Down
2
_________________________________________________
Dealer's Hand: 2 5
Dealer Draws: K
_________________________________________________
Dealer's Hand: [2, 5, K]
Player's Hand: [Q, 8]
_________________________________________________
You Win!
_________________________________________________
Cash Left: 239
Place Your Bet: 
____________________________________________________________________________________________________ END OF RUN

As you can see, the splitting features works correctly, however, only one hand will resolve in terms of cash while
the other hand will be discarded, once more time is available to me I will plan to fix this, I simply have no time.
