package az.edu.turing.homeworks;

import az.edu.turing.homeworks.customlinkedlist.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

public class LinkedListTest {

    MyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
        list.add("Harry");
        list.add("Harmonie");
        list.add("Ron");
    }

    @Test
    void addLinkedList_Should_ReturnSuccess() {
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("Harry");
        list1.add("Harmonie");
        list1.add("Ron");
        assertEquals(list, list1);
    }
}
