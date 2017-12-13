package edu.sla;

import static edu.sla.Main.timesToFill;

public class QueuePrinter implements Runnable {
    private Queue theQueue;

    QueuePrinter(Queue queue) {
        theQueue = queue;
    }

    synchronized public void run() {
        while(theQueue.moreToPrint()){
            while (theQueue.getNext() == null) /*do nothing*/ ;
            System.out.print(theQueue.getNext() + " ");
            theQueue.nullNext();
        }
    }
}
