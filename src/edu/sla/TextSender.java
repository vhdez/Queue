package edu.sla;

import java.io.OutputStream;
import java.io.PrintWriter;

public class TextSender implements Runnable{
    private Queue outQueue;
    private PrintWriter writer;
    private OutputStream out;

    TextSender(Queue queue, PrintWriter w, OutputStream outStream) {
        outQueue = queue;
        writer = w;
        out = outStream;
    }

    public void run() {
        while (outQueue.empty()) Thread.currentThread().yield();
        try {
            writer.println(outQueue.pullNext());
            writer.flush();
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("SongClient TextSender: Unable to send text.");
        }
    }
}
