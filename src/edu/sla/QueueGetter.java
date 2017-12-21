package edu.sla;

public class QueueGetter implements Runnable {
    Queue originalQueue;

    QueueGetter(Queue queue){
        originalQueue = queue;
    }

    public void run() {
        for (int l = 0; l < 100; l++) {
            String gottenValue = originalQueue.get();
            while (gottenValue == null) {
                Thread.currentThread().yield();
                gottenValue = originalQueue.get();
            }
            System.out.print(" " + gottenValue);
        }
    }
}
