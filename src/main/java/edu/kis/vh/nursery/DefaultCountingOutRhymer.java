package edu.kis.vh.nursery;



public class DefaultCountingOutRhymer {


    private static final int MAX_CAP = 12;
    private static final int EMPTY_STACK = -1;
    private static final int LAST_ELEM = 11;
    private final int[] numbers = new int[MAX_CAP];
    private static final int IVALID_STACK = -1;
    private int total = EMPTY_STACK;


    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }



    public boolean callCheck() {
        return total == IVALID_STACK;
    }

    public boolean isFull() {

        return total == LAST_ELEM;

    }

    protected int peekaboo() {
        if (callCheck())
            return EMPTY_STACK;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return EMPTY_STACK;
        return numbers[total--];
    }
    public int getTotal() {
        return total;
    }
}
