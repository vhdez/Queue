package edu.sla;

class Queue {
    private String[] theQueue;
    private int timesPopulated = 0;
    private int populatePos = 0;
    private int printPos = 0;
    private int timesToFill;

    //constructor for counting queue
    Queue(int fillTimes) {
        theQueue = new String[100];
        for(int i = 0; i < theQueue.length; i++) theQueue[i] = null;
        timesToFill = fillTimes;

    }

    //constructor for keyAction queue
    Queue() {
        theQueue = new String[3];
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
        return !(timesPopulated == timesToFill);
    }
}
