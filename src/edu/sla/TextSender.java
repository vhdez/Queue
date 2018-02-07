package edu.sla;

import java.io.PrintWriter;

public class TextSender implements Runnable{
    private Queue outQueue;
    private PrintWriter writer;
    private String username;

    TextSender(Queue queue, PrintWriter w, String uname) {
        outQueue = queue;
        writer = w;
        username = uname;
    }

    public void run() {
        while(!Thread.interrupted()) {
            while (outQueue.empty()) {
                Thread.currentThread().yield();
            }
            try {
                writer.println(outQueue.pullNext() + "//break//" + username);
                writer.flush();
            } catch(Exception ex) {
                ex.printStackTrace();
                System.out.println("SongClient TextSender: Unable to send text.");
            }
        }
    }// "goofy//break//user"

    public void setName(String uname) {
        username = uname;
    }
}
