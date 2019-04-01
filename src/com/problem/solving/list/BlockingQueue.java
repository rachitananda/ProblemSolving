package com.problem.solving.list;

import com.problem.solving.BaseProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A blocking queue is a queue that blocks when you try to dequeue from it and the queue is empty, or if you try to
 * enqueue items to it and the queue is already full. A thread trying to dequeue from an empty queue is blocked until
 * some other thread inserts an item into the queue. A thread trying to enqueue an item in a full queue is blocked until
 * some other thread makes space in the queue, either by dequeuing one or more items or clearing the queue completely.
 */
public class BlockingQueue extends BaseProblem {

    Queue queue = new LinkedList();


    public synchronized void enqueue(Object object) {
        queue.add(object);
        notifyAll();
        System.out.println("enqueue");
        printQueue();


    }

    public synchronized void dequeue() {
        if (queue.isEmpty()) {
            try {
                System.out.println("wait for dequeue");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
            queue.remove();
            System.out.println("dequeue");
            printQueue();


    }

    private void printQueue() {
        for (Object obj : queue) {
            System.out.println(obj + " ");
        }
    }

    @Override
    public void execute() {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                dequeue();

            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                enqueue(new Integer(1));
                enqueue(new Integer(2));

            }
        });

        t1.start();
        t2.start();

    }


}
