
import java.util.*;

public class QuickSortAnalysis {

    static Random random = new Random();

    // Partition for deterministic Quick Sort
    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Deterministic Quick Sort
    static void deterministicQuickSort(int arr[],
                                        int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            deterministicQuickSort(arr, low, pi - 1);
            deterministicQuickSort(arr, pi + 1, high);
        }
    }

    // Randomized Partition
    static int randomizedPartition(int arr[],
                                    int low, int high) {

        int randomIndex = low +
                random.nextInt(high - low + 1);

        int temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        return partition(arr, low, high);
    }

    // Randomized Quick Sort
    static void randomizedQuickSort(int arr[],
                                    int low, int high) {

        if (low < high) {

            int pi = randomizedPartition(arr, low, high);

            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int arr1[] = arr.clone();
        int arr2[] = arr.clone();

        // Deterministic Quick Sort
        deterministicQuickSort(arr1, 0, n - 1);

        // Randomized Quick Sort
        randomizedQuickSort(arr2, 0, n - 1);

        System.out.println("\nDeterministic Quick Sort:");
        System.out.println(Arrays.toString(arr1));

        System.out.println("\nRandomized Quick Sort:");
        System.out.println(Arrays.toString(arr2));

        sc.close();
    }
}


