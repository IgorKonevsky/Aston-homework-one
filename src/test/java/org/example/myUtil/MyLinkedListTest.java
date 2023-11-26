package org.example.myUtil;

import org.example.myUtil.implementations.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    private MyLinkedList<Integer> myLinkedList;

    @BeforeEach
    public void setUp() {
        myLinkedList = new MyLinkedList<>();
    }

    @Test
    public void testAddFirst() {
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(10);
        assertEquals(Integer.valueOf(10), myLinkedList.getFirst());
    }

    @Test
    public void testAddLast() {
        myLinkedList.addLast(5);
        myLinkedList.addLast(10);
        assertEquals(Integer.valueOf(10), myLinkedList.getLast());
    }

    @Test
    public void testGetFirst() {
        myLinkedList.addLast(5);
        myLinkedList.addLast(10);
        assertEquals(Integer.valueOf(5), myLinkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        myLinkedList.addLast(5);
        myLinkedList.addLast(10);
        assertEquals(Integer.valueOf(10), myLinkedList.getLast());
    }

    @Test
    public void testAdd() {
        myLinkedList.add(5);
        myLinkedList.add(10);
        assertEquals(2, myLinkedList.size());
    }

    @Test
    public void testAddAtIndex() {
        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.add(15, 1);
        assertEquals(Integer.valueOf(15), myLinkedList.get(1));
    }

    @Test
    public void testRemoveByObject() {
        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.remove(Integer.valueOf(5));
        assertFalse(myLinkedList.contains(5));
        assertEquals(1, myLinkedList.size());
    }

    @Test
    public void testRemoveByIndex() {
        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.remove(0);
        assertFalse(myLinkedList.contains(5));
        assertEquals(Integer.valueOf(10), myLinkedList.get(0));
    }

    @Test
    public void testClear() {
        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.clear();
        assertEquals(0, myLinkedList.size());
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    public void testSort() {
        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.add(2);
        myLinkedList.sort(Comparator.reverseOrder());
        assertEquals(Integer.valueOf(10), myLinkedList.get(0));
        assertEquals(Integer.valueOf(5), myLinkedList.get(1));
        assertEquals(Integer.valueOf(2), myLinkedList.get(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, myLinkedList.size());
        myLinkedList.add(5);
        assertEquals(1, myLinkedList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myLinkedList.isEmpty());
        myLinkedList.add(5);
        assertFalse(myLinkedList.isEmpty());
    }

    @Test
    public void testContains() {
        assertFalse(myLinkedList.contains(5));
        myLinkedList.add(5);
        assertTrue(myLinkedList.contains(5));
    }

    @Test
    public void testGet() {
        myLinkedList.add(5);
        myLinkedList.add(10);
        assertEquals(Integer.valueOf(5), myLinkedList.get(0));
        assertEquals(Integer.valueOf(10), myLinkedList.get(1));
    }

    @Test
    public void testIterator() {
        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.add(15);

        int sum = 0;
        for (Integer i : myLinkedList) {
            sum += i;
        }
        assertEquals(30, sum);
    }


}
