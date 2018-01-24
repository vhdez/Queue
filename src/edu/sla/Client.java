package edu.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Application {
    static BufferedReader reader;
    static PrintWriter writer;
    static OutputStream out;
    static Queue inQueue;
    static Queue outQueue;

    @Override
    public void start(Stage theStage) {

        Thread.currentThread().setName("GUI Thread");
        outQueue = new Queue();

        Button goofy = new Button("Goofy");
        Button smash = new Button("Smash");
        Button childish = new Button("Childish");

        goofy.setOnAction(e-> {
            if(outQueue.canAdd()) outQueue.add("goofy");
        });
        smash.setOnAction(e-> {
            if(outQueue.canAdd()) outQueue.add("smash");
        });
        childish.setOnAction(e-> {
            if(outQueue.canAdd()) outQueue.add("childish");
        });

        TextSender sender = new TextSender(outQueue, out, writer);
        Thread senderThread = new Thread(sender);
        senderThread.start();

        HBox buttons = new HBox();
        buttons.getChildren().add(goofy);
        buttons.getChildren().add(smash);
        buttons.getChildren().add(childish);

        VBox things = new VBox();
        things.getChildren().add(buttons);

        Scene theScene = new Scene(things, 200, 40);
        theStage.setScene(theScene);
        theStage.setTitle("Music Buttons");
        theStage.show();
    }

    public static void main(String[] args) {
        inQueue = new Queue();

        try{
            Socket sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            out = sock.getOutputStream();
            writer = new PrintWriter(out);

            CommHandler handler = new CommHandler(sock, inQueue, outQueue, reader);
            Thread handlerThread = new Thread(handler);
            handlerThread.start();

            QueuePlayer thePlayer = new QueuePlayer(inQueue);
            Thread letsPlay = new Thread(thePlayer);
            letsPlay.start();

            Application.launch(args);
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("SongClient: No SongServer available.  Exiting....");
        }

    }
}