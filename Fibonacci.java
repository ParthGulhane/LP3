
import java.util.*;

public class Fibonacci {

    // Recursive method
    static int fibRecursive(int n) {
        if (n <= 1)
            return n;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // Non-recursive method
    static void fibNonRecursive(int n) {
        int a = 0, b = 1;

        System.out.print("Non-Recursive: ");

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        fibNonRecursive(n);

        System.out.print("Recursive: ");

        for (int i = 0; i < n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }

        sc.close();
    }
}
