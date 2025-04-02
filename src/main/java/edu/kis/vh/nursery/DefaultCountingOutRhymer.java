package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {


    public static final int SIZE = 12;
    public static final int START = -1;
    public static final int MAXIMAL = 11;
    private int[] numbers = new int[SIZE];
    public static final int RETURN = -1;
    private int total = START;


    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }



    public boolean callCheck() {
        return total == RETURN;
    }

    private boolean isFull() {

        return total == MAXIMAL;

    }

    protected int peekaboo() {
        if (callCheck())
            return START;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return START;
        return numbers[total--];
    }
    public int getTotal() {
        return total;
    }
}
