package alexromanov.engconcepts.educative.datastructures;

public class EducativeArrays {

    public static int[] removeEven(int[] arr) {
        int odd = 0;
        for (int k : arr) {
            if (k % 2 != 0) {
                odd++;
            }
        }

        int[] result = new int[odd];
        int resultIndex = 0;

        for (int j : arr) {
            if (j % 2 != 0) {
                result[resultIndex++] = j;
            }
        }

        return result;
    }
}
