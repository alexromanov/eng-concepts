package alexromanov.engconcepts.datastructures.array.ediotasks;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskSolverTest {
    @Test
    public void shouldRemoveEvenNumbers(){
        int[] input = new int[] {1,2,3,4,5};
        int[] result = TaskSolver.removeEvenNumbers(input);
        assertThat(result).hasSize(3);
        assertThat(result).containsExactly(1,3,5);
        assertThat(result).doesNotContain(2,4);
    }

    @Test
    public void shouldRemoveEventNumbersUsingStream(){
        int[] input = new int[] {1,2,3,4,5};
        int[] result = TaskSolver.removeEvenNumbersWithStream(input);
        assertThat(result).hasSize(3);
        assertThat(result).containsExactly(1,3,5);
        assertThat(result).doesNotContain(2,4);
    }
}
