/**
 * Developer: Dennis Dao
 * Date: February 20, 2021
 * version 1.1
 * version 1.1 note: transfered from C version to Java version
 */

// Imports
import java.util.Scanner;

/**
 * Make a TicTacToe board class
 */
public class TicTacToe{
    // Instance variables
    private char[][] board;
    private Scanner in = new Scanner(System.in);

    /**
     * Default constructor
     * @param rows Rows of the board
     * @param cols Cols of the board
     */
    public TicTacToe(int rows, int cols){
        board = new char[rows][cols];
    }

    /**
     * Initialize the board
     * @param rows Rows of the board
     * @param cols Cols of the board
     */
    public void initializeBoard(int rows, int cols){
        int c = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                this.board[i][j] = (char)(c + '0');
                c++;
            }
        }
    }

    /**
     * Print the board
     * @param rows Rows of the board
     * @param cols Cols of the board
     * @return The board as a string
     */
    public String printBoard(int rows, int cols){
        String out = "-------------\n";
        for(int i = 0; i < rows; i++){
            out += "|";
            for(int j = 0; j < cols; j++){
                out += " " + this.board[i][j] + " |";
            }
            out += "\n-------------\n";
        }
        return out;
    }

    /**
     * Make a board (reinitializes every call) the user can enter values in
     * @param rows Rows of the board
     * @param cols Cols of the board
     */
    public void createBoard(int rows, int cols){
        int cell = 0;
        char input;

        this.initializeBoard(rows, cols);
        do{
            System.out.println(this.printBoard(rows, cols));
            System.out.println("Enter the number of the cell to insert an X or O or enter -1");
            // Read for proper input
            try{
                cell = Integer.parseInt(in.next());
            }
            catch (NumberFormatException exception){
                System.out.println("Invalid input");
                continue;
            }

            // Valid cell position
            if(cell > 0 && cell < 10){
                System.out.println("Input X or O");
                input = in.next().toUpperCase().charAt(0);
                
                int index = cell - 1;
                int row = index / 3;
                int col = index % 3;

                if(input == 'X' || input == 'O'){
                    if(board[row][col] != 'X' && board[row][col] != 'O'){
                        board[row][col] = input;
                    }
                    else{
                        System.out.println("That spot is taken");
                    }
                }
            }
        } while (cell != -1);
    }

    /**
     * Check if the board is valid
     * @param rows Rows of the board
     * @param cols Cols of the board
     * @return Truth value of whether the board is empty or not
     */
    public Boolean isValidBoard(int rows, int cols){
        int xCount = 0, oCount = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'X'){
                    xCount++;
                }
                else if(board[i][j] == 'O'){
                    oCount++;
                }
            }
        }

        // Nothing on the board
        if(xCount == 0 && oCount == 0){
            return true;
        }
        // Difference of Xs and Os
        if((xCount - oCount) == 0 || (xCount - oCount) == 1){
            return true;
        }
        else if((oCount - xCount) == 0 || (oCount - xCount) == 1){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * List possible winning cells
     * @param rows Rows of the board
     * @param cols Cols of the board
     * @return The list of winning cells as a string
     */
    public String listWinningCells(int rows, int cols){
        String out = "";
        if(isValidBoard(rows, cols)){
            // Rows
            for(int i = 0; i < rows; i++){
                // Left most cell
                if(board[i][1] == board [i][2] && board[i][0] != 'X' && board[i][0] != 'O'){
                    out += "Cell #" + (1+3*i) + " is a winning cell for " + board[i][1] + "\n";
                }
                // Middle cell
                if(board[i][0] == board [i][2] && board[i][1] != 'X' && board[i][1] != 'O'){
                    out += "Cell #" + (2+3*i) + " is a winning cell for " + board[i][0] + "\n";
                }
                // Right most cell
                if(board[i][0] == board [i][1] && board[i][2] != 'X' && board[i][2] != 'O'){
                    out += "Cell #" + (3+3*i) + " is a winning cell for " + board[i][1] + "\n";
                }
            }
            // Columns
            for(int j = 0; j < cols; j++){
                // Top cell
                if(board[1][j] == board [2][j] && board[0][j] != 'X' && board[0][j] != 'O'){
                    out += "Cell #" + (1+j) + " is a winning cell for " + board[1][j] + "\n";
                }
                // Middle cell
                if(board[0][j] == board [2][j] && board[1][j] != 'X' && board[1][j] != 'O'){
                    out += "Cell #" + (4+j) + " is a winning cell for " + board[2][j] + "\n";
                }
                // Bottom cell
                if(board[1][j] == board [0][j] && board[2][j] != 'X' && board[2][j] != 'O'){
                    out += "Cell #" + (7+j) + " is a winning cell for " + board[1][j] + "\n";
                }
            }
            // Diagonals
            // Top left
            if(board[1][1] == board [2][2] && board[0][0] != 'X' && board[0][0] != 'O'){
                out += "Cell #1 is a winning cell for " + board[1][1] + "\n";
            }
            // Bottom left
            if(board[1][1] == board [0][2] && board[2][0] != 'X' && board[2][0] != 'O'){
                out += "Cell #7 is a winning cell for " + board[1][1] + "\n";
            }
            // Top right
            if(board[1][1] == board [2][0] && board[0][2] != 'X' && board[0][2] != 'O'){
                out += "Cell #7 is a winning cell for " + board[1][1] + "\n";
            }
            // Bottom right
            if(board[0][0] == board [1][1] && board[2][2] != 'X' && board[2][2] != 'O'){
                out += "Cell #9 is a winning cell for " + board[1][1] + "\n";
            }
            // Centre for \
            if(board[0][0] == board [2][2] && board[1][1] != 'X' && board[1][1] != 'O'){
                out += "Cell #5 is a winning cell for " + board[2][2] + "\n";
            }
            // Centre for /
            if(board[2][0] == board [0][2] && board[1][1] != 'X' && board[1][1] != 'O'){
                out += "Cell #5 is a winning cell for " + board[0][2] + "\n";
            }
            return out;
        }
        else{
            return "No winning cells can be predicted. The board is invalid\n";
        }
    }

    /**
     * Recursively check for the winner
     * @param rows Rows of the board
     * @param cols Cols of the board
     * @return The winner as a string
     */
    public String whoIsTheWinner(int rows, int cols){
        String rowWinner;
        String colWinner;

        rowWinner = rowWin(rows);
        colWinner = colWin(cols);

        // Row
        if(!rowWinner.equals("F")){
            return "The winner is " + rowWinner + "\n";
        }
        // Column
        else if(!colWinner.equals("F")){
            return "The winner is " + colWinner + "\n";
        }
        // Diagonals
        else if(board[2][2] == board[1][1] &&  board[1][1] == board[0][0]){
            return "The winner is " + board[0][0] + "\n";
        }
        else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return "The winner is " + board[1][1] + "\n";
        }
        // No one
        else{
            return "The winner is no one\n";
        }
    }

    /**
     * Helper recursive function to check for winner in the rows
     * @param rows Rows of the board
     * @return A string based on whether or not there was a winner
     */
    public String rowWin(int rows){
        // Check if there is a row of the same 3 characters
        if(board[rows-1][0] == board[rows-1][1] && board[rows-1][1] == board [rows-1][2]){
            return Character.toString(board[rows-1][0]);
        }
        // Move to the next row by recalling the function
        else if(rows > 1){
            return rowWin(rows-1);
        }
        // Return F to signify no winners were found in the rows.
        else{
            return "F";
        }
    }

    /**
     * Helper recursive function to check for winner in the columns
     * @param cols Cols of the board
     * @return A string based on whether or not there was a winner
     */
    public String colWin(int cols){
        // Check if there is a column of the same 3 characters
        if(board[0][cols-1] == board[1][cols-1] && board[1][cols-1] == board [2][cols-1]){
            return Character.toString(board[0][cols-1]);
        }
        // Move to the next row by recalling the function
        else if(cols > 1){
            return colWin(cols-1);
        }
        // Return F to signify no winners were found in the rows.
        else{
            return "F";
        }
    }

}