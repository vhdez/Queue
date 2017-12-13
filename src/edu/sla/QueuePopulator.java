package edu.sla;

public class QueuePopulator implements Runnable {
    private  Queue theQueue;

    QueuePopulator(Queue queue) {
        theQueue = queue;
    }

    public void run() {
        while(theQueue.moreToPrint()) {
            while(theQueue.getNext() != null) if(!theQueue.moreToPrint()) break;
            theQueue.populate();
        }
    }
}
