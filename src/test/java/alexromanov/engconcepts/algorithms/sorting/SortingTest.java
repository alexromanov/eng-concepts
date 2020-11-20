package alexromanov.engconcepts.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingTest {
    @Test
    public void shouldSortUsingBubbleSort(){
        int[] arr = {3,5,1,2,8};
        assertThat(Bubble.sort(arr)).isEqualTo(new int[] {1,2,3,5,8});
    }
}
