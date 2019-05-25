package com.problem.solving.ds.tree;

public class MinHeap extends BinaryHeap  {

    /**
     *0(logn)
     * called after pollExtractRoot(delete root)
     */
    @Override
   public void heapifyDownAfterExtractRoor() {

        //start from root
        int index= 0;
//        heapifyDownWithoutRecursion();
      minHeapify(index);
    }

    public void minHeapify(int index)
    {
        if(hasLeftChild(index)) {
            //find the smallest/min of both childs
            int smallestChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallestChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallestChildIndex]) {

            } else {
                swap(smallestChildIndex, index);
            }
            minHeapify(smallestChildIndex);
        }


    }

   public void heapifyDownWithoutRecursion() {

       int index= 0;
       ///WORKS WELL- WITHOUT RECUSSION
       //will have right child if left child is there (heap follows complete tree property)
        while(hasLeftChild(index)){
            //find the smallest/min of both childs
            int smallestChildIndex= getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index)< leftChild(index)){
                smallestChildIndex =getRightChildIndex(index);
            }
            if (items[index]< items[smallestChildIndex]) {
                break;
            }else {
                swap(smallestChildIndex, index);
            }
            index=smallestChildIndex;

        }

   }

    /**
     * called after add (item added at last)
     */
    @Override
   public void heapifyUpAfterAddInHeap() {
        //last item
        int index= size-1;
        while(hasParent(index) && parent(index)> items[index]){
            //min heap property not satisfied , parent > item
            swap(getParentIndex(index),index);
            index= getParentIndex(index);//heapifyUpAfterAddInHeap from this parent item

        }
    }


}
