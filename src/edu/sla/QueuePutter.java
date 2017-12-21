package edu.sla;

public class QueuePutter implements Runnable {
    Queue originalQueue;

    QueuePutter(Queue queue){
        originalQueue = queue;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {

            while (!originalQueue.put(String.valueOf(i))) {
                Thread.currentThread().yield();
            }
        }
    }
}
