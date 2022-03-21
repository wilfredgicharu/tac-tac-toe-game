import java.util.Scanner;

class Main {

    //this is the main class where all the other classes are called
    //also other functions are being called in this class
    public static void main(String[] args) {

        //the board for the tic tac toe game
        char[][] board = new char[3][3];

        //board initialization
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        //Create a Scanner and ask the players for their names
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, Let's have a play, its Tic Tac Toe!");
        System.out.print("Whats the name of Player 1 ");
        String p1 = in.nextLine();
        System.out.print("Whats the name of Player 2 ");
        String p2 = in.nextLine();

        //In order to keep track of which player has the next turn,
        // create a boolean that is true when it's Player 1, and false when it is Player 2.
        boolean player1 = true;

        //In the while loop, utilize the gameEnded boolean as a condition.
        boolean gameEnded = false;
        while(!gameEnded) {

            //Drawing the board function
            drawingBoard(board);

            //Displaying who's turn it is to play
            if(player1) {
                System.out.println(p1 + "'s Turn (x):");
            } else {
                System.out.println(p2 + "'s Turn (o):");
            }

            //Create a char variable that stores either 'x' or 'o' based on what player's turn it is
            char c = '-';
            if(player1) {
                c = 'x';
            } else {
                c = 'o';
            }

            //We'll use row and column variables to represent the positions on our board.
            int row = 0;
            int col = 0;

            //Row and column variables are used to represent indices on our board.
            while(true) {

                //Ask the user where they wish to set their x or o in relation to the rest of the UI elements.
                System.out.print("Enter a row number (0, 1, or 2): ");
                row = in.nextInt();
                System.out.print("Enter a column number (0, 1, or 2): ");
                col = in.nextInt();

                //the if to check the 0 and x
                if(row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the bounds of the board! Try again.");

                    //checking whether the position is empty
                } else if(board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");

                    //If the location is valid, exit the while loop
                } else {
                    break;
                }

            }

            //setting the row and col on the board
            board[row][col] = c;

            //Determining the winner
            if(playerHasWon(board) == 'x') {
                System.out.println(p1 + " has won!");
                gameEnded = true;
            } else if(playerHasWon(board) == 'o') {
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else {

                //If neither player has won, check to see if there has been a tie (if the board is full)
                if(boardIsFull(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    //If player1 is true, make it false, and vice versa; this way, the players alternate each turn
                    player1 = !player1;
                }

            }

        }

        //Drawing the board after the game ends
        drawingBoard(board);

    }

    //drawing the board of the tic tac toe
    public static void drawingBoard(char[][] board) {
        System.out.println("Board:");
        for(int i = 0; i < 3; i++) {
            //The inner for loop prints out each row of the board
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            //separating each line
            System.out.println();
        }
    }

    //Make a function to see if someone has won and return the winning char
    public static char playerHasWon(char[][] board) {

        //Check each row
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        //column check
        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        //Checking the boards diagonals
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }

        //when nobody wins
        return ' ';

    }

    //Build an function for determining whether or not a game board has been completed.
    public static boolean boardIsFull(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
