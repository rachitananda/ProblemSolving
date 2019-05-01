package com.problem.solving.ds.tree;

public class MaxHeap extends BinaryHeap {

    //can be done recursively also
    @Override
  public  void heapifyDown() {

        //start from root
        int index= 0;
        //will have right child if left child is there (heap follows complete tree property)
        while(hasLeftChild(index)){
            //find the max of both childs
            int largestChildIndex= getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index)> leftChild(index)){
                largestChildIndex =getRightChildIndex(index);
            }
            if (items[index]> items[largestChildIndex]) {
                break;
            }else {
                swap(largestChildIndex, index);
            }
            index=largestChildIndex;

        }
    }




    @Override
    public void heapifyUp() {

        //last item
        int index= size-1;
        while(hasParent(index) && parent(index)< items[index]){
            //max heap property not satisfied , parent < item
            swap(getParentIndex(index),index);
            index= getParentIndex(index);//heapifyUp from this parent item

        }

    }
}
