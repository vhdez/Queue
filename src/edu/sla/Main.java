package edu.sla;

public class Main {


    public static void main(String[] args) {

        QueuePopulator qpop = new QueuePopulator();
        QueuePrinter qprint = new QueuePrinter();
        Thread populate = new Thread(qpop);
        Thread print = new Thread(qprint);

        print.start();
        populate.start();
    }
}