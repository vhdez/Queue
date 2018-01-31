package edu.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Application {
    private static PrintWriter writer;
    private static String username;
    private static Queue inQueue;
    private static Queue nameQueue;

    @Override
    public void start(Stage theStage) {

        Thread.currentThread().setName("GUI Thread");
        Queue outQueue = new Queue();

        Button goofy = new Button("Goofy");
        Button smash = new Button("Smash");
        Button childish = new Button("Childish");

        Text culprit = new Text("Current song chosen by ");

        goofy.setOnAction(e-> {
            if(outQueue.canAdd()) outQueue.add("goofy");
        });
        smash.setOnAction(e-> {
            if(outQueue.canAdd()) outQueue.add("smash");
        });
        childish.setOnAction(e-> {
            if(outQueue.canAdd()) outQueue.add("childish");
        });

        TextSender sender = new TextSender(outQueue, writer, username);
        Thread senderThread = new Thread(sender);
        senderThread.start();

        HBox buttons = new HBox();
        buttons.getChildren().add(goofy);
        buttons.getChildren().add(smash);
        buttons.getChildren().add(childish);

        VBox things = new VBox();
        things.getChildren().add(culprit);
        things.getChildren().add(buttons);

        Scene theScene = new Scene(things, 300, 60);
        theStage.setScene(theScene);
        theStage.setTitle("Music Buttons");
        theStage.show();

        QueuePlayer thePlayer = new QueuePlayer(inQueue, nameQueue, culprit);
        Thread letsPlay = new Thread(thePlayer);
        letsPlay.start();
    }

    public static void main(String[] args) {
        inQueue = new Queue();
        nameQueue = new Queue();
        username = "user";

        try{
            Socket sock = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            OutputStream out = sock.getOutputStream();
            writer = new PrintWriter(out);

            CommHandler handler = new CommHandler(sock, inQueue, nameQueue, reader);
            Thread handlerThread = new Thread(handler);
            handlerThread.start();

            Application.launch(args);
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("SongClient: No SongServer available.  Exiting....");
        }

    }
}