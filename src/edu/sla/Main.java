package edu.sla;

public class Main {
    static int timesToFill = 1;

    public static void main(String[] args) {
        Queue theQueue = new Queue();

        QueuePopulator qpop = new QueuePopulator(theQueue);
        QueuePrinter qprint = new QueuePrinter(theQueue);
        Thread populate = new Thread(qpop);
        Thread print = new Thread(qprint);

//        Thread print2 = new Thread(qprint);
//        Thread print3 = new Thread(qprint);
//        Thread print4 = new Thread(qprint);

        print.start();
        populate.start();

//        print2.start();
//        print3.start();
//        print4.start();
    }
}