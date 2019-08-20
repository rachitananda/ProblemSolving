package com.problem.solving.ds.map;

public class CustomHashMapImp {


    public static void main(String[] args){
        CustomHashMap<Integer,Integer> map=  new CustomHashMap<>(4);

        map.printMap();
        map.put(1,11);
        map.put(2,12);
        map.put(3,13);
        System.out.println("GET key 1:"+map.get(1));
        System.out.println("GET key 3:"+map.get(3));
        System.out.println("SIZE:"+map.getSize());

        map.put(10,110);
        map.printMap();
        map.put(20,120);
        map.printMap();
        map.put(30,130);
        System.out.println("SIZE:"+map.getSize());
        map.printMap();

        System.out.println("GET key 1:"+map.get(1));
        System.out.println("GET key 3:"+map.get(3));
        System.out.println("GET key 10:"+map.get(10));
        System.out.println("GET key 30:"+map.get(30));

        System.out.println("GET DELETED 30:"+map.remove(30));
        map.printMap();


    }
}
