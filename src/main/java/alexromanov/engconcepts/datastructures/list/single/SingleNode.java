package alexromanov.engconcepts.datastructures.list.single;

import java.util.Objects;

public class SingleNode<T> {
    private T data;
    private SingleNode<T> next;

    public SingleNode(T data) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }
}
