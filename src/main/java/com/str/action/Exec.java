
package com.str.action;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Exec {

    // 0  1  2 ->3   4  5  6<- 7  8   9
    //int[] arr = new int[]{5, 7, 10, 15, 2, 4, 11, 7, 1 , 5};
    public int go(int[] arr) {

        Integer summ = fromArr(arr, 0);

        System.out.println(Arrays.toString(arr));
        System.out.println(">>> Summ " + summ);

        return summ;
    }

    private Integer fromArr(int[] arr, Integer summ) {

//        System.out.println(Arrays.toString(arr));
        if (arr.length <= 2) {
            return summ;
        }

        int max1 = IntStream.of(arr).summaryStatistics().getMax();
        Integer ind1 = IntStream.of(arr).boxed().collect(Collectors.toList()).indexOf(max1);

        // ----------------------------------
        arr[ind1] = -1;
        int max2R = IntStream.of(arr).summaryStatistics().getMax();
        Integer ind2 = Arrays.stream(arr).boxed().collect(Collectors.toList()).indexOf(max2R);
        arr[ind1] = max1; // magic
        Integer maxMaxInd = Math.max(ind1, ind2);
        Integer minMaxInd = Math.min(ind1, ind2);

//        System.out.println(String.format(">>> Max Index1: %d", maxMaxInd));
//        System.out.println(String.format(">>> Max Index2: %d", minMaxInd));
        int[] forCountArr = Arrays.copyOfRange(arr, minMaxInd + 1, maxMaxInd);

//        System.out.println(">> " + Arrays.toString(forCountArr));;
        Integer sAllSquare = (forCountArr.length) * Math.min(max1, max2R);
        Integer sFullingSq = Arrays.stream(forCountArr).sum();

//        System.out.println(">> All " + sAllSquare);
//        System.out.println(">> Only Full " + sFullingSq);
        int diffW = sAllSquare - sFullingSq;
//        System.out.println(">>>> Diff " + diffW);
        int[] arrLeft = Arrays.copyOfRange(arr, 0, minMaxInd + 1);
        int[] arrRight = Arrays.copyOfRange(arr, maxMaxInd, arr.length);

//        System.out.println("Right: " + Arrays.toString(arrRight));
//        System.out.println("Left : " + Arrays.toString(arrLeft));
//        int[] arr1 = IntStream.of(arrLeft).skip(maxMaxInd).toArray();//boxed().collect(Collectors.toList()).toArray(new Integer[4]);
//        System.out.println(">> New Arr = " + Arrays.toString(arr1));
        return fromArr(arrLeft, summ + diffW) + fromArr(arrRight, 0);
    }

}
