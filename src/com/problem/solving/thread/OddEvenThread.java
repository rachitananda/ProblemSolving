package com.problem.solving.thread;

/**
 * https://java2blog.com/print-even-odd-numbers-threads-java/
 */
public class OddEvenThread {
    boolean odd;
    int count = 1;
    final int MAX = 20;

    public static void main(String args[]) {

        OddEvenThread problem = new OddEvenThread();
        problem.odd = true;

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                problem.printOdd();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                problem.printEven();
            }
        });

        t1.start();//even
        t2.start();//odd

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void printOdd() {


        while (count < MAX) {
            while (!odd) {
                //wait in while until odd is turned to odd again
                System.out.println("Checking odd loop");
                try {
                    System.out.println("ODD: waiting " + count);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("ODD Thread :" + count);
            count++;
            odd = false;
            notify();
        }


    }

    public synchronized void printEven() {

        while (count < MAX) {

            while (odd) {
                System.out.println("Checking even loop");
                //wait in while until odd is turned to even again
                try {
                    System.out.println("EVEN: waiting " + count);
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("EVEN Thread :" + count);
            count++;
            odd = true;
            notify();
        }
    }
}
