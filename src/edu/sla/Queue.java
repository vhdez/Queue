package edu.sla;

class Queue {
    private String[] theQueue = new String[100];
    private int timesPopulated;

    Queue() {
        for(int i = 0; i < theQueue.length; i++) theQueue[i] = "0";
    }

    void populate() {
        for(int i = 0; i < 100; i++) theQueue[i] = String.valueOf(i + (timesPopulated * 100));
        timesPopulated++;
    }

    String[] getQueue() {
        return theQueue;
    }
}
