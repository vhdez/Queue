package edu.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage theStage) throws Exception {

        Thread.currentThread().setName("GUI Thread");

        QueuePlayer thePlayer = new QueuePlayer();

        //TODO: make the queue better my man, its calling weird in the buttons
        Thread letsPlay = new Thread(thePlayer);

        Button goofy = new Button("Goofy");
        Button smash = new Button("Smash");
        Button childish = new Button("Childish");

        goofy.setOnAction(e-> {
            if(thePlayer.theQueue.canAdd()) thePlayer.theQueue.add("goofy");
        });
        smash.setOnAction(e-> {
            if(thePlayer.theQueue.canAdd()) thePlayer.theQueue.add("smash");
        });
        childish.setOnAction(e-> {
            if(thePlayer.theQueue.canAdd()) thePlayer.theQueue.add("childish");
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