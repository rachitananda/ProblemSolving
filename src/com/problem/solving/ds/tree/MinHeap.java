package com.problem.solving.ds.tree;

public class MinHeap extends BinaryHeap  {

    /**
     * called after poll(delete root)
     */
    @Override
   public void heapifyDown() {

        //start from root
        int index= 0;
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
   public void heapifyUp() {
        //last item
        int index= size-1;
        while(hasParent(index) && parent(index)> items[index]){
            //min heap property not satisfied , parent > item
            swap(getParentIndex(index),index);
            index= getParentIndex(index);//heapifyUp from this parent item

        }
    }


}
