package alexromanov.engconcepts.datastructures.list.single;

import java.util.Collection;

public class SingleLinkedList<E> {
    private SingleNode<E> head;
    private long size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Appends the element to the end of the list. Add new head in case if list is empty
     * @param item
     */
    public boolean add(E item) {
        if (head == null) {
            head = new SingleNode<>(item);
        } else {
            SingleNode<E> node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new SingleNode<>(item));
        }
        size++;
        return true;
    }

    public void add(int index, E element){
        if (head != null){
            SingleNode<E> node = head;
            int counter = 0;
            while (counter < index){
                node = node.getNext();
                counter++;
            }
            SingleNode<E> curr = new SingleNode<>(element);
            curr.setNext(node.getNext());
            node.setNext(curr);
        }
    }

    public boolean addAll(Collection<E> items) {
        for (E item : items) {
            boolean result = add(item);
            if (!result) return false;
        }
        return true;
    }

    public boolean contains(E element){
        boolean result = false;
        if (head == null){
            return result;
        }
        SingleNode<E> node = head;
        while (node.getNext() != null){
            if (node.getData().equals(element)) {
                result = true;
            }
            node = node.getNext();
        }
        return result;
    }

    public E remove() {
        if (head == null) {
            return null;
        }
        SingleNode<E> node = head;
        this.head = head.getNext();
        size--;
        return node.getData();
    }

    public E removeLast() {
        E item = null;
        if (size == 0) {
            return item;
        } else {
            SingleNode<E> node = head;
            while (node.getNext().getNext() != null) {
                node = node.getNext();
            }
            item = node.getNext().getData();
            node.setNext(null);
            size--;
            return item;
        }
    }

    public E get(int index) {
        if (head == null || size <= index) {
            return null;
        }
        int count = 0;
        SingleNode<E> node = head;
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
            SingleNode<E> node = head;
            while (node.getNext() != null) {
                sb.append(node.getData() + ", ");
                node = node.getNext();
            }
            sb.append(node.getData() + " ]");
            return sb.toString();
        }
    }
}
