package edu.sla;

public class QueuePrinter implements Runnable {
    private Queue theQueue;

    QueuePrinter(Queue queue) {
        theQueue = queue;
    }

    public void run() {
        //while(theQueue.getItem(99).equals("0")) /*do nothing*/System.out.println("Waiting to print");
        for (String queueItem : theQueue.getQueue()) {
            while(queueItem.equals("0")) /*do nothing*/System.out.println("Waiting to print");
            System.out.print(queueItem + " ");
            queueItem = "0";
        }
    }
}
