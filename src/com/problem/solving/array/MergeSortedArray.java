package com.problem.solving.array;

/**
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 * Next problem - https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
 */
public class MergeSortedArray {
    //TODO not working

    static int array1[] = {1, 5, 9, 10, 15, 20};
    static int array2[] = {2, 3, 8, 13};

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
    //TODO not working

    private static void mergeSortedArray1(int[] a, int[] b) {


        int last, key;
        int n1 = a.length;
        int n2 = b.length;
        for (int i = 0; i < b.length; i++) {//b array
            last = a[a.length - 1];
            key = b[i];
            int j = 0;
            boolean isFound = false;
//            if (b[i] > a[j]) {

            for (j = 0; j < a.length - 1 && b[i] > a[j]; j++) {
                a[j + 1] = a[j];
            }
//                    if(a[j]>key) {//bi
////                    a[j + 1] = a[j];
//                    if (!isFound) {
//                        a[j] = key;
//                        isFound = true;
//                    }
            if (last > b[i]) {
                b[i] = last;

            }


//            }
            System.out.println("i:" + i);
            print(a, b);


        }

        //merge n sort remaining 2nd array


    }

    static private void print(int a[], int b[]) {

        //print
        System.out.println("Merged array\n");

        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i] + " ");
        }

    }

    private static void mergeSortedArray(int[] arr1, int[] arr2) {

        int j = 0;
        int temp;
        int n2 = arr2.length;
        for (int i = 0; i < arr1.length; i++) {
            temp = arr1[i];
            if (j == n2 - 1) {
                break;
            }

            if (arr1[i] > arr2[j]) {
                //swap
                int x = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = x;
                j++;
            }
        }

        //merge n sort remaining 2nd array

        if (j > 0) {
            for (int i = j - 1; i < n2; i++) {

                if (j == n2) {
                    break;
                }

                temp = arr2[i];
                if (arr2[i] > arr2[j]) {

                    int x = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = x;
                    j++;
                } else {
                    break;
                }
            }
        }
        //print
        System.out.println("Merged array\n");

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(" " + arr1[i] + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(" " + arr2[i] + " ");
        }

    }
}
