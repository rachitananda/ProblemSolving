package com.problem.solving.sorting;

import com.problem.solving.BaseProblem;
import com.problem.solving.ds.tree.heap.MaxHeap;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/heap-sort/
 * https://www.youtube.com/watch?v=2DmK_H7IdTo
 * @author rachita
 *Why array based representation for Binary Heap?
Since a Binary Heap is a Complete Binary Tree, it can be easily represented as array and array based representation is space efficient. If the parent node is stored at index I, the left child can be calculated by 2 * I + 1 and right child by 2 * I + 2 (assuming the indexing starts at 0).

Heap Sort Algorithm for sorting in increasing order:
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.

Time complexity of heapify is O(nLogn). Time complexity of createAndBuildHeap() is O(n)
and overall time complexity of Heap Sort is O(nLogn).
 */
public class HeapSort  extends BaseProblem{



    @Override
    public void execute() {
        MaxHeap maxHeap = new MaxHeap();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter arr size");
        int n = in.nextInt();
        System.out.println("Enter array");
        for (int i = 0; i <n ; i++) {
            maxHeap.add(in.nextInt());
        }
        in.close();
        maxHeap.print();
        System.out.println("\nsorted array");

        for(int i = n-1; i >= 2 ; i-- )
        {
            maxHeap.swap(0,i);
            maxHeap.size--;
            maxHeap.heapifyDownAfterExtractRoot();

        }
        System.out.println("\nsorted array FINAL");
        maxHeap.printTillCapacity();
        //TODO need to improve on this - need to use this https://www.hackerearth.com/practice/notes/heaps-and-priority-queues/
    }
}
