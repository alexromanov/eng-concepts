package alexromanov.engconcepts.datastructures.list.single;

import org.junit.Rule;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleLinkedListTest {
    @Rule
    private SingleLinkedList<Integer> testList = new SingleLinkedList<>();

    @Test
    public void shouldCreateEmptyListByDefault() {
        assertThat(testList.getSize()).isEqualTo(0);
    }

    @Test
    public void shouldAddNewItemToList() {
        testList.add(5);
        assertThat(testList.getSize()).isEqualTo(1);
        assertThat(testList.get(0)).isNotNull();
        assertThat(testList.get(0)).isEqualTo(5);
    }

    @Test
    public void shouldRemoveItemFromHead() {
        testList.add(5);
        assertThat(testList.getSize()).isEqualTo(1);
        assertThat(testList.get(0)).isNotNull();
        Integer item = testList.remove();
        assertThat(testList.getSize()).isEqualTo(0);
        assertThat(item).isEqualTo(5);
    }

    @Test
    public void shouldPrintList() {
        testList.add(5);
        testList.add(4);
        testList.add(3);
        assertThat(testList.getSize()).isEqualTo(3);
        assertThat(testList.print()).isEqualTo("[ 5, 4, 3 ]");
    }
}
