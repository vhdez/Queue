package edu.sla;

public class QueuePrinter implements Runnable {
    private Queue theQueue;

    QueuePrinter(Queue queue) {
        theQueue = queue;
    }

    public void run() {
        while (theQueue.getQueue()[theQueue.getQueue().length - 1].equals("0")) ; //wait for last queue item = "0"
        for (String queueItem : theQueue.getQueue()) {
            System.out.print(queueItem + " ");
            queueItem = "0";
        }
    }
}
