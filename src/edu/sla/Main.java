package edu.sla;

public class Main {

    public static void main(String[] args) {
        Queue theQueue = new Queue();

        QueuePopulator qpop = new QueuePopulator(theQueue);
        QueuePrinter qprint = new QueuePrinter(theQueue);
        Thread populate = new Thread(qpop);
        Thread print = new Thread(qprint);

        print.start();
        populate.start();
    }
}