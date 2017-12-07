package edu.sla;

public class Main {
    static String[] myQueue = new String[100];

    public static void main(String[] args) {
        QueuePopulator qpop = new QueuePopulator();
        Thread populate = new Thread(qpop);

        QueuePrinter qprint = new QueuePrinter(populate);
        Thread print = new Thread(qprint);

        print.start();
        populate.start();

    }

}