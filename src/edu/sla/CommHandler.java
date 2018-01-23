package edu.sla;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class CommHandler implements Runnable {
    boolean isServer;
    private InputStream in;
    private ArrayList clientOutputStreams;
    private BufferedReader reader;

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
    CommHandler(Socket sock, BufferedReader r) {
        isServer = false;
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
            while ((message = reader.readLine()) != null) {
                //TODO: Make this read strings and update clients
                System.out.println("PictureChat CommunicationHandler: read " + message);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("CommHandler: Reading failed.");
        }
    }
}
