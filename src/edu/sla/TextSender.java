package edu.sla;

import java.io.PrintWriter;

public class TextSender implements Runnable{
    private Queue outQueue;
    private PrintWriter writer;

    TextSender(Queue queue, PrintWriter w) {
        outQueue = queue;
        writer = w;
    }

    public void run() {
        while(!Thread.interrupted()) {
            while (outQueue.empty()) {
                Thread.currentThread().yield();
            }
            try {
                writer.println(outQueue.pullNext());
                writer.flush();
            } catch(Exception ex) {
                ex.printStackTrace();
                System.out.println("SongClient TextSender: Unable to send text.");
            }
        }
    }
}
