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

}