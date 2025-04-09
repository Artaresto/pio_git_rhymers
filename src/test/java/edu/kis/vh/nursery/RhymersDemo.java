package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;


    /**
     * Klasa demonstracyjna służąca do testowania działania różnych implementacji
     * klasy {@link DefaultCountingOutRhymer} za pomocą wzorca.
     */
class RhymersDemo {
    /**
     * Maksymalna liczba elementów, które zostaną dodane do każdego z liczników.
     */
    private static final int MAXIMAL_COUNT = 15;
    /**
            * @param args argumenty wejściowe
     */
    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();

        testRhymers(factory);

    }

    /**
     * Metoda testująca działanie różnych implementacji liczników.
     * Dodaje wartości do liczników, wypisuje ich zawartość oraz liczbę odrzuconych
     * wartości w przypadku HanoiRhymer.
     *
     * @param factory instancja która dostarcza różne implementacje liczników
     */

    private static void testRhymers(RhymersFactory factory) {
        DefaultCountingOutRhymer[] rhymers = { factory.GetStandardRhymer(), factory.GetFalseRhymer(),
                factory.GetFifoRhymer(), factory.GetHanoiRhymer()};

        for (int i = 1; i < MAXIMAL_COUNT; i++)
            for (int j = 0; j < 3; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < MAXIMAL_COUNT; i++)
            rhymers[3].countIn(rn.nextInt(20));

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[3]).reportRejected());
    }

}