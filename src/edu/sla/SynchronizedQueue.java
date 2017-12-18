package edu.sla;

public class SynchronizedQueue {
    private String[] myQueue;
    int putLocation;
    int getLocation;
    int queueAmount;

    SynchronizedQueue() {
        myQueue = new String[100];
        putLocation = 0;
        queueAmount = 0;
        getLocation = 0;
    }

    synchronized boolean put(String newValue) {

        if (queueAmount < 100) {
            myQueue[putLocation] = newValue;
            if (putLocation < 99) {
                putLocation += 1;
            } else {
                putLocation = 0;
            }
            queueAmount += 1;
            return true;
        } else {
            return false;
        }
    }

    synchronized String get() {

        if (queueAmount > 0) {
            if (getLocation < 99) {
                getLocation += 1;
            } else {
                getLocation = 0;
            }
            queueAmount -= 1;
            return myQueue[getLocation];
        } else {
            return null;
        }
    }
}


