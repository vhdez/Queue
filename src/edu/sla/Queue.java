package edu.sla;

public class Queue {
    private String[] myQueue;
    int currentPut;
    int currentGet;
    int amountAvailable;

    Queue() {
        myQueue = new String[100];
        amountAvailable = 0;
        currentPut = 0;
        currentGet = 0;
    }

    synchronized boolean put(String newValue) {
        if (amountAvailable < 99) {
            amountAvailable = amountAvailable + 1;
            myQueue[currentPut] = newValue;
            if (currentPut < 99) {
                currentPut = currentPut + 1;
            } else {
                currentPut = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    synchronized String get() {
        if (amountAvailable > 0) {
            amountAvailable = amountAvailable - 1;
            if (currentGet < 99) {
                currentGet = currentGet + 1;
                return myQueue[currentGet - 1];
            } else {
                currentGet = 0;
                return myQueue[99];
            }
        } else {
            return null;
        }

    }
}