package alexromanov.engconcepts.datastructures.array.ediotasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTasks {
    /**
     * Removes number divisible by 2 from array of integers
     * @param input (array of integers)
     * @return - array of odd integers
     */
    public int[] removeEvenNumbersWithStream(int[] input){
        List<Integer> filtered = Arrays.stream(input).boxed().filter(e -> e % 2 != 0).collect(Collectors.toList());
        return filtered.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] removeEvenNumbers(int[] input){
        int num = 0;
        for (int value : input) {
            if (value % 2 != 0) {
                num++;
            }
        }
        int[] result = new int[num];
        num = 0;
        for (int value : input) {
            if (value % 2 != 0) {
                result[num] = value;
                num++;
            }
        }
        return result;
    }

    public int[] mergeArrays(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int i = 0,j = 0;
        int c = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] <= arr2[j]){
                result[c] = arr1[i];
                i++;
            } else {
                result[c] = arr2[j];
                j++;
            }
            c++;
        }
        if (i < arr1.length){
            for (; i < arr1.length; i++){
                result[c] = arr1[i];
                c++;
            }
        }
        if (j < arr2.length){
            for (; j < arr2.length; j++){
                result[c] = arr2[j];
                c++;
            }
        }
        return result;
    }
}
