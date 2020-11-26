package alexromanov.engconcepts.algorithms.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayTest {
    private final int[] arrayForSorting = {4,2,7,1,3};
    private final int[] sortedArray = {1,2,3,4,7};

    @Test
    public void shouldSortUsingBubbleSort() {
        assertThat(Array.bubbleSort(arrayForSorting)).isEqualTo(sortedArray);
    }

    @Test
    public void shouldSortUsingSelectionSort() {
        assertThat(Array.selectionSort(arrayForSorting)).isEqualTo(sortedArray);
    }

    @Test
    public void shouldSortUsingInsertionSort() {
        assertThat(Array.insertionSort(arrayForSorting)).isEqualTo(sortedArray);
    }

    @Test
    public void shouldFindArraysIntersection() {
        assertThat(Array.intersection(new int[] {3,1,4,2}, new int[] {4,5,3,6})).isEqualTo(new int[] {3,4});
    }
}
