
import java.util.*;

class Job {
    char id;
    int deadline, profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job jobs[] = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter job ID, deadline and profit:");
            char id = sc.next().charAt(0);
            int d = sc.nextInt();
            int p = sc.nextInt();

            jobs[i] = new Job(id, d, p);
        }

        // Sort jobs according to profit (descending)
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;

        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        char result[] = new char[maxDeadline + 1];
        boolean slot[] = new boolean[maxDeadline + 1];

        int totalProfit = 0;

        // Schedule jobs in available slots
        for (int i = 0; i < n; i++) {

            for (int j = jobs[i].deadline; j > 0; j--) {

                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("\nScheduled Jobs:");

        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
            }
        }

        System.out.println("\nTotal Profit: " + totalProfit);

        sc.close();
    }
}
