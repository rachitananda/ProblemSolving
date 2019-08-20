package com.problem.solving.array;

import java.util.*;

public class SortByFrequency {

    int[] arr = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
    int[] arr2 = {2, 5, 2, 8, 5, 6, 8, 8};

    public static void main(String args[]) {
        SortByFrequency problem = new SortByFrequency();
        problem.sortByFrequencyMap();
    }

    /**
     * Time Complexity : O(n Log n)
     * https://www.geeksforgeeks.org/sort-elements-by-frequency-set-5-using-java-map/
     * Given an integer array, sort the array according to the frequency of elements in decreasing order, if frequency
     * of two elements are same then sort in increasing order
     */
    private void sortByFrequencyMap() {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();

        for (int number : arr) {

            int count = hmap.getOrDefault(number, 0);
            hmap.put(number, count + 1);
            outputArray.add(number);


        }

        SortComparator sortComparator = new SortComparator(hmap);

        Collections.sort(outputArray, sortComparator);

        System.out.println("----OUTPUT---- ");
        for (Integer i : outputArray) {
            System.out.println(" " + i);
        }


    }


    class SortComparator implements Comparator<Integer> {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        public SortComparator(HashMap<Integer, Integer> hmap) {
            this.hmap = hmap;
        }

        @Override
        public int compare(Integer key1, Integer key2) {
            //ComparteTo
            //return 0 when equal
            //return -1 when o1<02
            //1 or value >0 when o1<o2

            //decending order of frequency (hence k2 comparte to k1)
            int freq = hmap.get(key2).compareTo(hmap.get(key1));

            if (freq == 0) {
                //becoz we need ascending order if   freq is equal
                return key1.compareTo(key2);
                //ascending order of value hence k1 compare to k2

            } else {
                return freq;
            }


        }
    }



}
