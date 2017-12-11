package edu.sla;

public class QueuePopulator implements Runnable {
    private  Queue theQueue;

    QueuePopulator(Queue queue) {
        theQueue = queue;
    }

    public void run() {
        while (!theQueue.getQueue()[theQueue.getQueue().length - 1].equals("0")) ;
        theQueue.populate();
    }
}
