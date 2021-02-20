/**
 * Developer: Dennis Dao
 * Date: February 20, 2021
 * version 1.1
 * version 1.1 note: transfered from C version to Java version
 */

// Imports
import java.util.Scanner;

/**
 * Test the methods of TicTacToe class
 */
public class TicTacToeTester {
    public static void main(String args[]){
        // Variables
        int rows = 3, cols = 3;
        Boolean valid;
        TicTacToe game = new TicTacToe(rows, cols);
        String input;
        Scanner in = new Scanner(System.in);

        game.initializeBoard(rows, cols);
        // Game loop
        while(true){
            System.out.println("-----------------------------------------");
            System.out.println("Enter a command: ");
            System.out.println("P - print the tic-tac-toe board");
            System.out.println("C - create the board to add Xs and Os");
            System.out.println("T - test if the board is valid");
            System.out.println("W - predict a winning cell");
            System.out.println("D - determine the winning player");
            System.out.println("E - exit ");
            System.out.println("-----------------------------------------");
            input = in.next();

            // Print board
            if(input.toUpperCase().equals("P")){
                System.out.println(game.printBoard(rows, cols));
            }
            // Create board
            else if(input.toUpperCase().equals("C")){
                game.createBoard(rows, cols);
            }
            // Check validity of board
            else if(input.toUpperCase().equals("T")){
                valid = game.isValidBoard(rows, cols);
                if(valid){
                    System.out.println("The board is valid");
                }
                else{
                    System.out.println("The board is invalid");
                }
            }
            // List winning cells
            else if(input.toUpperCase().equals("W")){
                System.out.println(game.listWinningCells(rows, cols));
            }
            // Check winner
            else if(input.toUpperCase().equals("D")){
                System.out.println(game.whoIsTheWinner(rows, cols));
            }
            // Exit
            else if(input.toUpperCase().equals("E")){
                System.out.println("Exiting the Tic-Tac-Toe game");
                break;
            }
            // Invalid input
            else{
                System.out.println("Invalid input. Try again.");
            }
        }
        in.close();
    }    
}
