package Chap11;

import java.util.*;

public class MyVector implements List {
    Object[] data = null;
    int capacity = 0;
    int size = 0;

    public MyVector(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid value: " + capacity);
        }
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector() {
        this(10);
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity - data.length > 0) {
            setCapacity(minCapacity);
        }
    }

    public boolean add(Object obj) {
        ensureCapacity(size + 1);
        data[size++] = obj;
        return true;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The value is out of range.");
        }
        return data[index];
    }

    public Object remove(int index) {
        Object oldObj = null;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The value is out of range.");
        }
        oldObj = data[index];
        if (index != size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
        data[size - 1] = null;
        size--;
        return oldObj;
    }
}
