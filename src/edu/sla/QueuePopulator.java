package edu.sla;

public class QueuePopulator implements Runnable {
    private  Queue theQueue;

    QueuePopulator(Queue queue) {
        theQueue = queue;
    }

    public void run() {
        while(!theQueue.getItem(99).equals("0")) ;
        theQueue.populate();
    }
}
