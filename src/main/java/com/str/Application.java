package com.str;

import com.str.action.Exec;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
                           // 0  1  2 ->3   4  5  6<- 7  8   9
        int[] arr = new int[]{5, 7, 10, 15, 2, 4, 11, 7, 1 , 5};

        new Exec().go(arr);
        
        int[] arr2 = new int[] {6, 9, 1, 0, 5};
        
        new Exec().go(arr2);
        
        int [] arr3 = new int[] {14, 2, 15};
        
        new Exec().go(arr3);
    }


}
