package alexromanov.engconcepts.algorithms.sorting;

import java.util.Arrays;

public class Bubble {
    public static int[] sort(int[] arr){
        int unsortedUntilIndex = arr.length - 1;
        boolean sorted = false;
        int temp;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < unsortedUntilIndex; i++){
                if (arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
                System.out.println(Arrays.toString(arr));
            }
            unsortedUntilIndex--;
        }
        return arr;
    }
}
