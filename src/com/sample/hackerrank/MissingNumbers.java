package com.sample.hackerrank;

import java.util.*;
import java.util.stream.Collectors;

class MissingNumbers {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static void main(String[] args) {
        List  arr = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        List brr = Arrays.asList(203 ,204 ,204 ,205 ,206 ,207 ,205 ,208 ,203 ,206 ,205 ,206 ,204);
        System.out.println(missingNumbers(arr, brr));
    }
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here

        Map<Integer, Integer> counterMap = new HashMap<>();
        brr.forEach(b -> counterMap.put(b, (counterMap.getOrDefault(b, 0) + 1) ));

        arr.forEach(a -> counterMap.put(a, (counterMap.getOrDefault(a, 0) - 1) ));

        return counterMap.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey()).collect(Collectors.toList());

//        Collections.sort(arr);
//        System.out.println(arr);
//
//        Collections.sort(brr);
//        System.out.println(brr);
//        int j = 0;
//
//        List<Integer> missing = new ArrayList<>();
//
//        for(int i=0; i<brr.size(); i++) {
//            System.out.println(j);
//            System.out.println(brr.get(i));
//            System.out.println(arr.get(j));
//            if(j >= arr.size() || !brr.get(i).equals(arr.get(j))) {
//                System.out.println("Adding: "+ brr.get(i));
//                missing.add(brr.get(i));
//                System.out.println("-------------");
//            } else if(j < arr.size())
//                j++;
//
//        }

        //return missing;
    }

}

