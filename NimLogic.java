import java.util.Scanner;

public class NimLogic {
    
    public void run() {
        int playAgain = 1;
        boolean validInput ;
        int intPiecesRemoved = 0;
        String piecesRemoved;        
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();

        while (playAgain == 1) {
            Board.populate();
            int currentPlayer = 2;
            Player activePlayer;
            //The first player to play is chosen at random.
            /*Players take turns removing pieces from the pile. Players must take at least one piece but no more than half the size of the pile. 
            The last player to take a piece loses. The winner scores one point. */
            currentPlayer = (int)(Math.random() * 1) + 1;
            if (currentPlayer == 1){
                activePlayer = player1;
            }
            else{
                activePlayer = player2;
            }
            while(Board.getNumPieces() > 1) {
                System.out.print("It is now the player " + activePlayer.getName() + "'s turn. There are " + Board.getNumPieces() + " more pieces remaining.");

                validInput = false;
                while ( !validInput )
                {
                    System.out.println(" You may now remove a number between 1 and " + Board.getNumPieces() / 2);
                    piecesRemoved = sc.nextLine();
                    if ( (piecesRemoved.matches("[0-9]+")))
                    {
                        intPiecesRemoved = Integer.parseInt(piecesRemoved);
                        if (( intPiecesRemoved > 0 ) && ( intPiecesRemoved <= (Board.getNumPieces() / 2 )))
                        {
                            validInput = true;
                        }
                    }
                }

                //I haave to convert the users input to an int.
                //Then you remove the pieces
                Board.removePieces(intPiecesRemoved);
                if (currentPlayer == 1)
                {
                    currentPlayer = 2;
                    //set the active player
                    activePlayer = player2;
                }
                else
                {
                    currentPlayer = 1;
                    activePlayer = player1;
                }
                
            }
            activePlayer.addPoint();
            
            System.out.println("The player, " + activePlayer.getName() + " has won the round of nim. " + player1.getName() + " has " + player1.getPoints() + " and " + player2.getName() + " has " + player2.getPoints());
            System.out.println("If you want to play again, type 1. If you want to quit, type anything else but 1.");
            String playAgainStr;
            playAgainStr = sc.nextLine();
            playAgain = Integer.parseInt(playAgainStr);
            
        }
    }
}

