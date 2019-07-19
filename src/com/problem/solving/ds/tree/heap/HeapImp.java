package com.problem.solving.ds.tree.heap;

import com.problem.solving.BaseProblem;

import java.util.Scanner;

public class HeapImp extends BaseProblem {
    @Override
    public void execute() {

        minHeapExample();
//        maxHeapExample();
    }

    static void maxHeapExample() {
        System.out.println("Enter MAX heap array SIZE");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Enter MAX heap array");
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < n; i++) {
            maxHeap.add(in.nextInt());
        }
        System.out.println("max heap created");
        maxHeap.print();
        in.close();
        int item = maxHeap.pollExtractRoot();
        System.out.println("\nPOLL");
        maxHeap.print();

    }


    static void minHeapExample() {

        System.out.println("Enter MIN heap array SIZE");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Enter MIN heap array");
        MinHeap minHeap = new MinHeap();
        for (int i = 0; i < n; i++) {
            minHeap.add(in.nextInt());
        }
        System.out.println("min heap created");
        minHeap.print();
//        minHeap.add(in.nextInt());
        in.close();
//        minHeap.print();
        int min = minHeap.pollExtractRoot();
        System.out.println("\nPOLL" + min);
        minHeap.print();
    }
}
