package edu.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application {

    @Override
    public void start(Stage theStage) throws Exception {

        Thread.currentThread().setName("GUI Thread");
        Queue outQueue = new Queue();

        QueuePlayer thePlayer = new QueuePlayer(outQueue);
        Thread letsPlay = new Thread(thePlayer);

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

        letsPlay.start();
    }
}