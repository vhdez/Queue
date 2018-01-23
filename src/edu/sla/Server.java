package edu.sla;

public class Server {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ServerNetworking serverNetworking = new ServerNetworking();
        Thread serverNetworkingThread = new Thread(serverNetworking);
        serverNetworkingThread.setName("serverNetworkingThread");
        serverNetworkingThread.start();
    }
}
