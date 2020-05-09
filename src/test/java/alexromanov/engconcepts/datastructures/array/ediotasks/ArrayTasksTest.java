package alexromanov.engconcepts.datastructures.array.ediotasks;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayTasksTest {
    private ArrayTasks arrayTasks;

    @Before
    public void beforeTest(){
        arrayTasks = new ArrayTasks();
    }

    @Test
    public void shouldRemoveEvenNumbers(){
        int[] input = new int[] {1,2,3,4,5};
        int[] result = arrayTasks.removeEvenNumbers(input);
        assertThat(result).hasSize(3);
        assertThat(result).containsExactly(1,3,5);
        assertThat(result).doesNotContain(2,4);
    }

    @Test
    public void shouldRemoveEventNumbersUsingStream(){
        int[] input = new int[] {1,2,3,4,5};
        int[] result = arrayTasks.removeEvenNumbersWithStream(input);
        assertThat(result).hasSize(3);
        assertThat(result).containsExactly(1,3,5);
        assertThat(result).doesNotContain(2,4);
    }

    @Test
    public void shouldMergeTwoArraysOfInts(){
        int[] arr1 = {1,3,4,5};
        int[] arr2 = {2,6,7,8};
        int[] result = arrayTasks.mergeArrays(arr1, arr2);
        assertThat(result).isNotEmpty();
        assertThat(result.length).isEqualTo(8);
        assertThat(result).containsSequence(1,2,3,4,5,6,7,8);
    }
}
