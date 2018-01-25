package edu.sla;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerNetworking implements Runnable {
    private ArrayList clientOutputStreams;

    ServerNetworking() {
        clientOutputStreams = new ArrayList();
    }

    public void run() {
        try {
            ServerSocket serverSock = new ServerSocket(5000);
            System.out.println("SongServer: Networking is ready.");
            while(!Thread.interrupted()) {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                // for every new client, run an IncomingDataReceiver on a new thread to receive data from it
                CommHandler handler = new CommHandler(clientSocket, clientOutputStreams);
                Thread handlerThread = new Thread(handler);
                handlerThread.start();
                System.out.println("SongServer: Accepted client connection.");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("SongServer: Networking failed.  Exiting...");
        }
    }
}
