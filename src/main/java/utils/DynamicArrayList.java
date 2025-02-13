package utils;

public class DynamicArrayList {
    private String[] array;
    private int numElements;
    private int capacity = 10;
    private int RESIZE_FACTOR = 2;

    public DynamicArrayList(String[] Initial) {
        if (Initial == null || Initial.length == 0) {
            this.array = new String[capacity];
        } else {
            this.array = new String[Initial.length];
            for (String Val : Initial) {
                this.array[this.numElements++] = Val;

            }
        }


    }

    public DynamicArrayList() {
        this.array = new String[capacity];
    }
    public int size(){
        return numElements;
    }

    public boolean isEmpty(){
        if (numElements == 0){
            return true;
        }
        return false;
    }

    public String get(int index) {
        if (index < 0 || index >= numElements) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return array[index];
    }
    public int indexOf(String value){
        for (int i = 0; i < numElements ; i++) {
            if  ((array[i] == null && value == null) || (array[i] != null && array[i].equals(value))) {
                return i;
            }
        }
        return -1;

    }
    public boolean add(String value){
        if (numElements == array.length){
            growArray();
        }
        array[numElements++] = value;
        return true;
    }
    public boolean add(String value, int position) {
        if (position < 0 || position > numElements) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        if (numElements == array.length) {
            growArray();
        }
        for (int i = numElements; i > position; i--) {
            array[i] = array[i - 1];
        }
        array[position] = value;
        numElements++;
        return true;
    }

    private void growArray() {
        int newCapacity = array.length * RESIZE_FACTOR;
        String[] newArray = new String[newCapacity];
        for (int i = 0; i < numElements; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    public boolean removeAll(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value to remove cannot be null");
        }
        boolean removed = false;
        int newSize = 0;
        for (int i = 0; i < numElements; i++) {
            if (!array[i].equals(value)) {
                array[newSize++] = array[i];
            } else {
                removed = true;
            }
        }
        numElements = newSize;
        return removed;
    }
    public DynamicArrayList clone() {
        DynamicArrayList clonedList = new DynamicArrayList();
        clonedList.array = new String[this.array.length];
        System.arraycopy(this.array, 0, clonedList.array, 0, this.numElements);
        clonedList.numElements = this.numElements;
        return clonedList;
    }



}