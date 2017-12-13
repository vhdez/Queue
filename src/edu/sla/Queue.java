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

    synchronized void populate() {
        if(timesPopulated == timesToFill) return;
        theQueue[populatePos] = String.valueOf(populatePos + (timesPopulated * theQueue.length));
        populatePos++;
        if(populatePos >= theQueue.length) {
            timesPopulated++;
            populatePos = 0;
        }
    }

    synchronized String getNext() {
        //if(printPos >= theQueue.length) printPos = 0;
        return theQueue[printPos];
    }

    synchronized void print() {
        if(theQueue[printPos] == null) return;
        System.out.print(theQueue[printPos] + " ");
        theQueue[printPos] = null;
        printPos++;
        if(printPos >= theQueue.length) printPos = 0;
    }

    synchronized boolean moreToPrint() {
        //System.out.println("Times populated: " + timesPopulated);
        return !(timesPopulated == timesToFill);
    }
}
