package alexromanov.engconcepts.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingTest {
    @Test
    public void shouldSortUsingBubbleSort(){
        int[] arr = {3,5,1,2,8};
        assertThat(Sorting.bubbleSort(arr)).isEqualTo(new int[] {1,2,3,5,8});
    }

    @Test
    public void shouldSortUsingSelectionSort() {
        int[] arr = {4,2,7,1,3};
        assertThat(Sorting.selectionSort(arr)).isEqualTo(new int[] {1,2,3,4,7});
    }
}
