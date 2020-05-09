package alexromanov.engconcepts.datastructures.array.ediotasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskSolver {
    /**
     * Removes number divisible by 2 from array of integers
     * @param input (array of integers)
     * @return - array of odd integers
     */
    public static int[] removeEvenNumbersWithStream(int[] input){
        List<Integer> filtered = Arrays.stream(input).boxed().filter(e -> e % 2 != 0).collect(Collectors.toList());
        return filtered.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] removeEvenNumbers(int[] input){
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
}
