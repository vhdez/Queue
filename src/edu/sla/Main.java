package edu.sla;

public class Main {

    public static void main(String[] args) {

       SynchronizedQueue myQueue = new SynchronizedQueue();

        QueuePutter myPutter1 = new QueuePutter(myQueue);
        QueuePutter myPutter2 = new QueuePutter(myQueue);
        QueuePutter myPutter3 = new QueuePutter(myQueue);

        QueueGetter myGetter1 = new QueueGetter(myQueue, 1);
        QueueGetter myGetter2 = new QueueGetter(myQueue, 2);
        QueueGetter myGetter3 = new QueueGetter(myQueue, 3);

        Thread putterThread = new Thread(myPutter1);
        putterThread.start();

        Thread getterThread1 = new Thread(myGetter1);
        getterThread1.start();

        Thread getterThread2 = new Thread(myGetter2);
        getterThread2.start();

        Thread getterThread3 = new Thread(myGetter3);
        getterThread3.start();
    }

}


