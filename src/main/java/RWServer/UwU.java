package RWServer;

public class UwU<T> {
    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[10];

    private int elemCnt = 0; //Number of elements
    private int startIndex; //the index where elements start


    T getValueAtIndex(int i) {
        if (i >= elemCnt) {
            return null;
        }
        int ind = (startIndex + i) % data.length;
        return data[ind];
    }

    // Increment the index in a circular manner
    private int increase(int curValue) {
        return (curValue + 1) % data.length;
    }

    // Decrement the index in a circular manner
    private int decrease(int curValue) {
        return (curValue - 1 + data.length) % data.length;  // Ensure index stays positive
    }


    private void enhanceArray() {
        int i = 0;
        @SuppressWarnings("unchecked")
        T[] newdata = (T[]) new Object[data.length * 2];
        //reorder elements as the current array
        while (i < elemCnt) {
            newdata[i] = getValueAtIndex(i);
            i++;
        }
        this.data = newdata;
    }


    public T popFront() {
        if (elemCnt <= 0) {
            elemCnt = 0;
            return null;
        }
        T val = data[startIndex];
        elemCnt--;
        startIndex = increase(startIndex);
        return val;
    }

    public T popLast() {
        if (elemCnt <= 0) {
            elemCnt = 0;
            return null;
        }
        T elem = getValueAtIndex(elemCnt);
        elemCnt = (elemCnt - 1) % data.length;
        return elem; //Even value was unmarked it is still available
    }

    public void pushLast(T i) {
        if (data.length == elemCnt) {
            enhanceArray();
        }
        int maxindex = (startIndex + elemCnt) % data.length;
        data[maxindex] = i;
        elemCnt++;
    }

    public void pushFront(T i) {
        if (data.length == elemCnt) {
            enhanceArray();
        }
        startIndex = decrease(startIndex);
        data[startIndex] = i;
        elemCnt++;

    }


    public T get(int index) {
        return getValueAtIndex(index);
    }
}
