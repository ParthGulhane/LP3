
import java.util.*;

public class NQueens {

    static int N;

    // Check whether placing queen is safe
    static boolean isSafe(int board[][], int row, int col) {

        // Check upper column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (int i = row, j = col;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check upper-right diagonal
        for (int i = row, j = col;
             i >= 0 && j < N; i--, j++) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Backtracking function
    static boolean solveNQueens(int board[][], int row) {

        if (row == N)
            return true;

        for (int col = 0; col < N; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 1;

                if (solveNQueens(board, row + 1))
                    return true;

                // Backtracking
                board[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of queens: ");
        N = sc.nextInt();

        if (N <= 0) {
            System.out.println("Enter a positive number.");
            sc.close();
            return;
        }

        int board[][] = new int[N][N];

        // Place first queen at position (0,0)
        board[0][0] = 1;

        // Place remaining queens using backtracking
        if (solveNQueens(board, 1)) {

            System.out.println("Solution:");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("No solution exists");
        }

        sc.close();
    }
}
