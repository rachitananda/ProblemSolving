package com.problem.solving.string;

/**
 * https://www.geeksforgeeks.org/count-of-words-that-are-present-in-all-the-given-sentences/
 */
public class CommonWords {

    static String arr[] = {
            "there is a cow",
            "cow is our mother",
            "cow gives us milk and milk is sweet",
            "there is a boy who loves cow"};

    public static void main(String[] args) {

        CommonWords problem = new CommonWords();
        problem.getCommonWords(arr);

    }


    /**
     * 0(n^2)
     * @param arr
     */
    private void getCommonWords(String[] arr) {
        String[] words ;

        //find string that has most words
        int maxLengthIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length()>maxLengthIndex){
                maxLengthIndex=i;
            }
        }

        words = arr[maxLengthIndex].split("\\s+");//split by space
        int commonCount=0;
        for (String word:words) {
           boolean isPresent=true;
            for(int i = 0;i<arr.length;i++){
                if(!arr[i].contains(word)){
                    isPresent= false;
                }
            }
            if(isPresent){
                System.out.println(word);
                commonCount++;
            }
        }

        System.out.println("COUNT :"+commonCount);
    }
}
