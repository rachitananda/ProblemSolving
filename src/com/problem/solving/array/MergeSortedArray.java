package com.problem.solving.array;

/**
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 * Next problem - https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
 */
public class MergeSortedArray {

    static int array1[] = {1, 5, 9, 10, 15, 20};
    static int array2[] = {2, 3, 8, 13};

    static int arr1[] = {2};
    static int arr2[] = {3, 10};

    public static void main(String[] args) {

      /*  Scanner in = new Scanner(System.in);
        System.out.println("Enter Size of arr1:");
        int n1 = in.nextInt();
        System.out.println("Enter  arr1:");
        int arr1[] = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = in.nextInt();
        }
        System.out.println("Enter Size of arr2:");
        int n2 = in.nextInt();
        System.out.println("Enter  arr2:");

        int arr2[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = in.nextInt();
        }
        in.close();*/


        mergeSortedArray(array1, array2);

    }

    public static void mergeSortedArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = n1 - 1;
        int j = n2 - 1;

        // int temp = arr1[i];
        int last = arr1[i];
        while (j >= 0) {

            if (arr2[j] > arr1[i]) {
                //rotate arr 1 ahead
                for (int k = n1 - 1; k >= i + 1; k--) {
                    arr1[k] = arr1[k - 1];
                }
                //swap
                if (i != n1 - 1) {
                    arr1[i + 1] = arr2[j];
                    arr2[j] = last;
                }
                j--;
                last = arr1[n1 - 1];
            }
            if (i > 0) {
                i--;
            }
        }

        print(arr1, arr2);

    }


    static private void print(int a[], int b[]) {

        System.out.println("Merged array\n");

        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i] + " ");
        }
    }

}
