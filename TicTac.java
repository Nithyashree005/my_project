import java.util.Scanner;
public class TicTac{
    public static void main(String[] args) {
        System.out.println("Welcome to tic tac toe!");
        Scanner s = new Scanner(System.in);
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        char player = 'X';
        boolean gameover = false;
        while (!gameover) {
            printboard(board);
            System.out.println("Player " + player + ", enter row and column (0 to 2):");
            int i = s.nextInt();
            int j = s.nextInt();

            if (i < 0 || i >= 3 || j < 0 || j >= 3) {
                System.out.println("Invalid position. Try again.");
                continue;
            }
            if (board[i][j] == ' ') {
                board[i][j] = player;

                if (won(board, player)) {
                    printboard(board);
                    System.out.println("Player " + player + " has won!");
                    gameover = true;
                } else if (isBoardFull(board)) {
                    printboard(board);
                    System.out.println("It's a draw!");
                    gameover = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // Switch player
                }
            } else {
                System.out.println("Cell already filled. Try again.");
            }
        }
    }
    public static boolean won(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Found an empty cell
                }
            }
        }
        return true;
    }
    public static void printboard(char[][] board) {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("--+---+--");
        }
    }
}
