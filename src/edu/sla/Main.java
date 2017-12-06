package edu.sla;

public class Main {
    static String[] myQueue;

    public static void main(String[] args) {
        myQueue = new String[100];
        for (int i = 0; i < 100; i++) {
            myQueue[i] = String.valueOf(i);
        }
        for (int j = 0; j < 100; j++) {
            System.out.print(myQueue[j] + " ");
        }

    }
}
