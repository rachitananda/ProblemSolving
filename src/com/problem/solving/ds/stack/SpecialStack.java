package com.problem.solving.ds.stack;

/**
 * https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 */
public class SpecialStack {


    public static void main(String[] arh) {
        SpecialStack stack = new SpecialStack();
        System.out.println("is empty :" + stack.isEmpty());
        stack.push(18);
        stack.push(19);
        stack.push(29);
        stack.getMin();
        stack.push(15);
        stack.getMin();
        stack.print();
        stack.pop();
        stack.getMin();
        stack.print();

    }


    int MAX = 10;
    int[] stack;
    int[] minStack;

    int top ;
    int minTop;

    public SpecialStack() {
        top = -1;
        minTop=-1;
        stack = new int[MAX];
        minStack = new int[MAX];
        minStack[0] = Integer.MAX_VALUE;

    }

    private boolean isEmpty() {
        return top < 0;
    }

    private boolean isFull() {
        return top == MAX - 1;
    }


    private int pop() {

        if (isEmpty()) {
            return -1;
        }

        int item = stack[top--];
        minTop--;
        System.out.println("POP : " + item);

        return item;

    }

    private void push(int item) {
        if (isFull()) {
            System.out.println("OVERFLOW");
            return;
        }
        System.out.println("PUSH : " + item);
        //do get MIN before updating top value
        int min = getMin();
        stack[++top] = item;

        if (item < min) {
            minStack[++minTop] = item;
        } else {
            //retain existing
            minStack[++minTop] = min;
        }
    }

    private int getMin() {
        if (isEmpty()) {
            return Integer.MAX_VALUE;
        }
        int item = minStack[minTop];
        System.out.println("MIN : " + item);
        return item;

    }

    private void print() {
        System.out.println("---STACK---");
        for (int i = 0; i <= top; i++) {
            System.out.print(" " + stack[i]);
        }

    }

    private void printMin() {
        System.out.println("---STACK---");
        for (int i = 0; i <= minTop; i++) {
            System.out.print(" " + minStack[i]);
        }

    }


}
