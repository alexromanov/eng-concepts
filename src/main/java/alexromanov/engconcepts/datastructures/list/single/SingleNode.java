package alexromanov.engconcepts.datastructures.list.single;

import java.util.Objects;

public class SingleNode<E> {
    private E data;
    private SingleNode<E> next;

    public SingleNode(E data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleNode<?> that = (SingleNode<?>) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public SingleNode<E> getNext() {
        return next;
    }

    public void setNext(SingleNode<E> next) {
        this.next = next;
    }
}
