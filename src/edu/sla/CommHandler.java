package edu.sla;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class CommHandler implements Runnable {
    private boolean isServer;
    private InputStream in;
    private ArrayList clientOutputStreams;
    private BufferedReader reader;
    private Queue inQueue;
    private Queue nameQueue;

    //constructor for server
    CommHandler(Socket sock, ArrayList streams) {
        isServer = true;
        try {
            in = sock.getInputStream();
            InputStreamReader incomingDataReader = new InputStreamReader(in);
            reader = new BufferedReader(incomingDataReader);
            clientOutputStreams = streams;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("CommHandler: Server creation failed.");
        }
    }

    //constructor for client
    CommHandler(Socket sock, Queue inQ, Queue nameQ, BufferedReader r) {
        isServer = false;
        inQueue = inQ;
        nameQueue = nameQ;
        reader = r;
        try {
            in = sock.getInputStream();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("CommHandler: Client creation failed.");
        }

    }

    public void run() {
        try {
            String message;
            String name;
            while ((message = reader.readLine()) != null) {
                if(isServer) {
                    Iterator allClients = clientOutputStreams.iterator();
                    while(allClients.hasNext()) {
                        try {
                            PrintWriter writer = (PrintWriter) allClients.next();
                            writer.println(message);
                            writer.flush();
                            Thread.sleep(10);
                            name = reader.readLine();
                            writer.println(name);
                            writer.flush();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            System.out.println("SongServer CommHandler: Failed to tell all clients.");
                        }
                    }
                }
                else if(inQueue.canAdd()) {
                    inQueue.add(message);
                    Thread.sleep(10);
                    name = reader.readLine();
                    nameQueue.add(name);
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("CommHandler: Reading failed.");
        }
    }
}
