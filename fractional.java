
import java.util.*;

class fractional {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] profit = new int[n];
        double[] ratio = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weight[i] = sc.nextInt();

            System.out.print("Enter profit of item " + (i + 1) + ": ");
            profit[i] = sc.nextInt();

            ratio[i] = (double) profit[i] / weight[i];
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sort items by profit/weight ratio
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (ratio[i] < ratio[j]) {

                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    int t = weight[i];
                    weight[i] = weight[j];
                    weight[j] = t;

                    t = profit[i];
                    profit[i] = profit[j];
                    profit[j] = t;
                }
            }
        }

        double totalProfit = 0;

        // Select items greedily
        for (int i = 0; i < n; i++) {

            if (weight[i] <= capacity) {

                totalProfit += profit[i];
                capacity -= weight[i];

            } else {

                totalProfit += ratio[i] * capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);

        sc.close();
    }
}
