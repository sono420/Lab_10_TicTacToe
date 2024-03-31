import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X"; // X starts the game

    public static void main(String[] args) {
        clearBoard();
        boolean playAgain;
        Scanner scanner = new Scanner(System.in);

        do {
            playGame(scanner);
            playAgain = getYNConfirm(scanner, "Do you want to play again? (Y/N)");
        } while (playAgain);

        System.out.println("Thanks for playing Tic Tac Toe!");
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        boolean gameEnd = false;

        display();

        while (!gameEnd) {
            int rowMove = getRangedInt(scanner, "Enter the row (1-3) for your move:", 1, 3);
            int colMove = getRangedInt(scanner, "Enter the column (1-3) for your move:", 1, 3);

            rowMove--; // Convert to 0-based index
            colMove--; // Convert to 0-based index

            if (isValidMove(rowMove, colMove)) {
                board[rowMove][colMove] = currentPlayer;
                display();

                if (isWin(currentPlayer)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnd = true;
                } else if (isTie()) {
                    System.out.println("It's a tie!");
                    gameEnd = true;
                } else {
                    currentPlayer = currentPlayer.equals("X") ? "O" : "X"; // Switch player
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("-------------");
        for (int i = 0; i < ROW; i++) {
            System.out.print("| ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagnalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagnalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false; // There's an empty cell, so the game is not a tie
                }
            }
        }
        return true; // All cells are filled, game is a tie
    }

    private static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int userInput;
        do {
            System.out.print("\n" + prompt + ": ");
            while (!console.hasNextInt()) {
                console.next(); // clear trash input
                System.out.println("Invalid input. Please enter a valid integer.");
                System.out.print(prompt + ": ");
            }
            userInput = console.nextInt();
            console.nextLine();// clear the newline character
        } while (userInput < low || userInput > high);
        return userInput;
    }

    private static boolean getYNConfirm(Scanner console, String prompt) {
        String userInput;
        boolean validInput;
        do {
            System.out.print("\n" + prompt + ": ");
            userInput = console.nextLine().toUpperCase();
            validInput = userInput.equals("Y") || userInput.equals("N");
            if (!validInput) {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");//final output after game end
            }
        } while (!validInput);
        return userInput.equals("Y");
    }
}
