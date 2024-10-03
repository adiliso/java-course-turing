package az.edu.turing.homeworks.customlinkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public MyLinkedList() {
        head = new ListNode<>();
        tail = head;
        size = 0;
    }

    public void addFirst(T data) {
        head.val = data;
        head = new ListNode<>(null, head);
        size++;
    }

    public void add(T data) {
        tail.next = new ListNode<>(data);
        tail = tail.next;
        size++;
    }

    public T removeFirst() {
        if (size == 0) throw new IndexOutOfBoundsException();
        head = head.next;
        T removed = head.val;
        head.val = null;
        size--;
        return removed;
    }

    public T removeLast() {
        if (size == 0) throw new NoSuchElementException();
        T removed = tail.val;
        ListNode<T> curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }
        tail = curr;
        tail.next = null;
        size--;
        return removed;
    }

    public void insert(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = new ListNode<>(data, curr.next);
        size++;
    }

    public T update(int index, T data) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        ListNode<T> curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        T prev = curr.val;
        curr.val = data;
        return prev;
    }

    public boolean remove(Object o) {
        ListNode<T> curr = head;
        while (curr.next != null) {
            if (curr.next.val.equals(o)) {
                curr.next = curr.next.next;
                if (curr.next == null) tail = curr;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        ListNode<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        T prev = curr.next.val;
        curr.next = curr.next.next;
        if (curr.next == null) tail = curr;
        size--;
        return prev;
    }

    public int size() {
        return size;
    }

    public void removeAll() {
        head = new ListNode<>();
        tail = head;
        size = 0;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int count = 0;
        ListNode<T> curr = head.next;
        while (curr != null) {
            array[count++] = curr.val;
            curr = curr.next;
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
