
import java.util.*;

public class BinomialCoefficient {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int dp[][] = new int[n + 1][k + 1];

        // Calculate binomial coefficient
        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= Math.min(i, k); j++) {

                // Base condition
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                }

                else {
                    dp[i][j] = dp[i - 1][j - 1]
                             + dp[i - 1][j];
                }
            }
        }

        System.out.println("Binomial Coefficient: " + dp[n][k]);

        sc.close();
    }
}
