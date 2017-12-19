package edu.sla;

public class QueueGetter implements Runnable {
    SynchronizedQueue originalQueue;

    Thread[] newInsert;

    QueueGetter(SynchronizedQueue queue, int id) { originalQueue = queue; }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            String getString = originalQueue.get();
            while (getString == null) {
                Thread.currentThread().yield();
                getString = originalQueue.get();
            }
            System.out.print(getString + " ");
        }
    }
}

