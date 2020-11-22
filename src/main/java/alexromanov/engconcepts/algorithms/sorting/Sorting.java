package alexromanov.engconcepts.algorithms.sorting;

import java.util.Arrays;

public class Sorting {
    public static int[] bubbleSort(int[] arr){
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

    public static int[] selectionSort(int[] arr){
        int temp;
        int min = arr[0];
        int mix = 0;
        for (int i = 0; i < arr.length - 1; i++){
            min = arr[i + 1];
            mix = i + 1;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < min){
                    min = arr[j];
                    mix = j;
                }
            }
            if (arr[i] > min){
                temp = arr[i];
                arr[i] = arr[mix];
                arr[mix] = temp;
            }
        }
        return arr;
    }
}
