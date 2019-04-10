package com.problem.solving.ds.list;

import com.problem.solving.BaseProblem;
import com.problem.solving.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArrayList Implementation
 */
public class MyArrayList extends BaseProblem {
    private Object[] list;
    private int actualSize = 0;

    public MyArrayList() {
        list = new Object[10];
    }

    public int size() {
        return actualSize;
    }

    public Object get(int index) {
        if (index < actualSize) {
            return list[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Object remove(int index) {
        if (index < actualSize) {
            Object obj = list[index];
            list[index] = null;
            while (index < actualSize) {
                list[index] = list[++index];
                list[index] = null;
            }
            actualSize--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public void add(Object object) {

        if (  list.length -actualSize < 5) {
            increaseSize();
        }

            list[actualSize++] = object;


    }

    private void increaseSize() {
        list = Arrays.copyOf(list, list.length * 2);
    }

    @Override
    public void execute() {

        MyArrayList list = new MyArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(4));
        list.add(new Integer(5));
        list.add(new Integer(6));
        list.add(new Integer(7));
        list.add(new Integer(8));
        list.add(new Integer(9));
        list.add(new Integer(10));
        list.add(new Integer(11));
        list.add(new Integer(12));
        printList(list);
        System.out.println("Size"+list.size());
        list.remove(1);
        System.out.println("get at index 1 "+list.get(1));
        printList(list);
    }

    private void printList(MyArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }


}
