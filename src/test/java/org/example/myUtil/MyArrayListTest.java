package org.example.myUtil;

import org.example.myUtil.implementations.MyArrayList;
import org.example.myUtil.interfaces.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    private MyList<Integer> myArrayList;

    @BeforeEach
    public void setUp() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    public void testAdd() {
        myArrayList.add(5);
        myArrayList.add(10);
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testAddWithIndex() {
        myArrayList.add(5);
        myArrayList.add(10, 1);
        assertEquals(Integer.valueOf(10), myArrayList.get(1));
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void testSet() {
        myArrayList.add(5);
        myArrayList.add(10);
        myArrayList.set(15, 0);
        assertEquals(Integer.valueOf(15), myArrayList.get(0));
    }

    @Test
    public void testRemoveByObject() {
        myArrayList.add(5);
        myArrayList.add(10);
        myArrayList.remove(Integer.valueOf(5));
        assertFalse(myArrayList.contains(5));
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void testRemoveByIndex() {
        myArrayList.add(5);
        myArrayList.add(10);
        myArrayList.remove(0);
        assertFalse(myArrayList.contains(5));
        assertEquals(Integer.valueOf(10), myArrayList.get(0));
    }

    @Test
    public void testToArray() {
        myArrayList.add(5);
        myArrayList.add(10);
        Object[] array = myArrayList.toArray();
        assertEquals(2, array.length);
        assertArrayEquals(new Object[]{5, 10}, array);
    }

    @Test
    public void testClear() {
        myArrayList.add(5);
        myArrayList.add(10);
        myArrayList.clear();
        assertEquals(0, myArrayList.size());
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void testSort() {
        myArrayList.add(5);
        myArrayList.add(10);
        myArrayList.add(2);
        myArrayList.sort(Comparator.reverseOrder());
        assertEquals(Integer.valueOf(10), myArrayList.get(0));
        assertEquals(Integer.valueOf(5), myArrayList.get(1));
        assertEquals(Integer.valueOf(2), myArrayList.get(2));
    }

    @Test
    public void testSize() {
        assertEquals(0, myArrayList.size());
        myArrayList.add(5);
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(myArrayList.isEmpty());
        myArrayList.add(5);
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    public void testContains() {
        assertFalse(myArrayList.contains(5));
        myArrayList.add(5);
        assertTrue(myArrayList.contains(5));
    }

    @Test
    public void testGet() {
        myArrayList.add(5);
        myArrayList.add(10);
        assertEquals(Integer.valueOf(5), myArrayList.get(0));
        assertEquals(Integer.valueOf(10), myArrayList.get(1));
    }

    @Test
    public void testIterator() {
        myArrayList.add(5);
        myArrayList.add(10);
        myArrayList.add(15);

        int sum = 0;
        for (Integer i : myArrayList) {
            sum += i;
        }
        assertEquals(30, sum);
    }



}