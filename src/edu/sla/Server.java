package edu.sla;

public class Server {

    public static void main(String[] args) {
        ServerNetworking serverNetworking = new ServerNetworking();
        Thread serverNetworkingThread = new Thread(serverNetworking);
        serverNetworkingThread.setName("serverNetworkingThread");
        serverNetworkingThread.start();
    }
}
