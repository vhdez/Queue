package edu.sla;

import static edu.sla.Main.timesToFill;

class Queue {
    private String[] theQueue;
    private int timesPopulated;
    private int populatePos;
    private int printPos;

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

    synchronized int getLength() {
        return theQueue.length;
    }

    synchronized String getNext() {
        return theQueue[printPos];
    }

    synchronized void nullNext() {
        theQueue[printPos] = null;
        printPos++;
        if(printPos >= theQueue.length) printPos = 0;
    }

    synchronized boolean moreToPrint() {
        return Integer.valueOf(theQueue[theQueue.length-1]) == 99+((timesToFill-1)*100);
    }
}
