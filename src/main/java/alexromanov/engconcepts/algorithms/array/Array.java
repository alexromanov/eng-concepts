package alexromanov.engconcepts.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Array {

    public static int[] bubbleSort(int[] arr) {
        int unsortedUntilIndex = arr.length - 1;
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < unsortedUntilIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false;
                }
                System.out.println(Arrays.toString(arr));
            }
            unsortedUntilIndex--;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int temp;
        int min;
        int mix;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i + 1];
            mix = i + 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    mix = j;
                }
            }
            if (arr[i] > min) {
                temp = arr[i];
                arr[i] = arr[mix];
                arr[mix] = temp;
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        int temp;
        int pos;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            pos = i - 1;
            while (pos >= 0) {
                if (arr[pos] > temp) {
                    arr[pos + 1] = arr[pos];
                    pos--;
                } else { break; }
            }
            arr[pos + 1] = temp;
        }
        return arr;
    }

    public static Object[] intersection(int[] arr1, int[] arr2) {
        Set<Integer> res = new HashSet<>();
        for (int j : arr1) {
            for (int k : arr2) {
                if (j == k) {
                    res.add(j);
                }
            }
        }
        return res.toArray();
    }

    public static Integer[] intersectionSimple(Integer[] arr1, Integer[] arr2) {
        return Stream.of(arr1).filter(Arrays.asList(arr2)::contains).toArray(Integer[]::new);
    }

    public static Integer[] intersectionSet(Integer[] arr1, Integer[] arr2){
        return Stream.of(arr1).filter(Arrays.asList(arr2)::contains).distinct().toArray(Integer[]::new);
    }

    public static boolean twoSum(int[] arr, int n){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (i != j && arr[i] + arr[j] == n){
                    return true;
                }
            }
        }
        return false;
    }

    public static double averageOfEventNumbers(int[] nums){
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0){
                sum += nums[i];
                count++;
            }
        }
        return sum / count;
    }

    public static int[] arraySample(int[] nums){
        int mid = nums[(nums.length - 1) / 2];
        return new int[] {nums[0], mid, nums[nums.length - 1]};
    }
}
