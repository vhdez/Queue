package edu.sla;

public class QueuePutter implements Runnable {
    SynchronizedQueue originalQueue;

    QueuePutter(SynchronizedQueue queue) {
        originalQueue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            while (!originalQueue.put(String.valueOf(i))) {
                Thread.currentThread().yield();
            }
        }
    }
}
//