package edu.sla;

import static edu.sla.Main.timesToFill;

class Queue {
    private String[] theQueue;
    private int timesPopulated = 0;
    private int populatePos = 0;
    private int printPos = 0;

    Queue() {
        theQueue = new String[100];
        for(int i = 0; i < theQueue.length; i++) theQueue[i] = null;

    }

    void populate() {
        theQueue[populatePos] = String.valueOf(populatePos + (timesPopulated * 100));
        populatePos++;
        if(populatePos >= theQueue.length) {
            timesPopulated++;
            populatePos = 0;
        }
    }

    String getNext() {
        return theQueue[printPos];
    }

    void nullNext() {
        theQueue[printPos] = null;
        printPos++;
        if(printPos >= theQueue.length) printPos = 0;
    }

    boolean moreToPrint() {
        return !(timesPopulated == timesToFill && printPos == 0);
    }
}
