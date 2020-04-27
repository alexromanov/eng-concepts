package alexromanov.engconcepts.datastructures.list.single;

import java.util.Collection;

public class SingleLinkedList<T> {
    private SingleNode<T> head;
    private long size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        if (head == null) {
            head = new SingleNode<>(data);
        } else {
            SingleNode<T> node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new SingleNode<>(data));
        }
        size++;
    }

    public void addAll(Collection<T> items) {
        for (T item : items) add(item);
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        SingleNode<T> node = head;
        this.head = head.getNext();
        size--;
        return node.getData();
    }

    public T removeLast() {
        T item = null;
        if (size == 0) {
            return item;
        } else {
            SingleNode<T> node = head;
            while (node.getNext().getNext() != null) {
                node = node.getNext();
            }
            item = node.getNext().getData();
            node.setNext(null);
            size--;
            return item;
        }
    }

    public T get(int index) {
        if (head == null || size <= index) {
            return null;
        }
        int count = 0;
        SingleNode<T> node = head;
        while (count != index) {
            node = node.getNext();
            count++;
        }
        return node.getData();
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public long getSize() {
        return size;
    }

    public String print() {
        if (head == null) {
            return "The list is empty";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            SingleNode<T> node = head;
            while (node.getNext() != null) {
                sb.append(node.getData() + ", ");
                node = node.getNext();
            }
            sb.append(node.getData() + " ]");
            return sb.toString();
        }
    }
}
