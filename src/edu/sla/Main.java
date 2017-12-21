package edu.sla;

public class Main {

    public static void main(String[] args) {
        Queue theQueue = new Queue();

        QueuePutter myPutter = new QueuePutter(theQueue);
        Thread thread = new Thread(myPutter);
        thread.start();
        QueuePutter myPutter2 = new QueuePutter(theQueue);
        Thread thread6 = new Thread(myPutter2);
        thread6.start();
        QueuePutter myPutter3 = new QueuePutter(theQueue);
        Thread thread5 = new Thread(myPutter3);
        thread5.start();

        QueueGetter myGetter = new QueueGetter(theQueue);
        Thread thread2 = new Thread(myGetter);
        thread2.start();
        QueueGetter myGetter2 = new QueueGetter(theQueue);
        Thread thread3 = new Thread(myGetter2);
        thread3.start();
        QueueGetter myGetter3 = new QueueGetter(theQueue);
        Thread thread4 = new Thread(myGetter3);
        thread4.start();



        }
    }
