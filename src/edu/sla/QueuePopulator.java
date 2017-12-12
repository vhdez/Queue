package edu.sla;

import static edu.sla.Main.timesToFill;

public class QueuePopulator implements Runnable {
    private  Queue theQueue;

    QueuePopulator(Queue queue) {
        theQueue = queue;
    }

    public void run() {
        while(theQueue.moreToPrint()) {
            while(theQueue.getNext() != null) /*do nothing*/ ;
            theQueue.populate();
        }
    }
}
