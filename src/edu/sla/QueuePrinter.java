package edu.sla;

public class QueuePrinter implements Runnable {
    private Queue theQueue;

    QueuePrinter(Queue queue) {
        theQueue = queue;
    }

    public void run() {
//        while(theQueue.moreToPrint()) {
//            while(theQueue.getNext() == null) if(!theQueue.moreToPrint()) break;
//            theQueue.print();
//        }
    }
}
