import java.util.Scanner;

public class Main_1 {
    public static int count = 0;

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
                count += n1 - i;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int N = sn.nextInt();

        for (int t = 0; t < N; t++) {
            int L = sn.nextInt();
            int[] arr = new int[L];

            for (int i = 0; i < L; i++) {
                arr[i] = sn.nextInt();
            }

            count = 0;
            mergeSort(arr, 0, L - 1);
            System.out.println("Optimal train swapping takes " + count + " swaps.");
        }

        sn.close();
    }
}

