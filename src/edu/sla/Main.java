package edu.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    /*public static void main(String[] args) {
        int timesToFill = 0;
        Queue theQueue = new Queue(timesToFill);

        QueuePopulator qpop = new QueuePopulator(theQueue);
        QueuePrinter qprint = new QueuePrinter(theQueue);
        Thread populate = new Thread(qpop);
        Thread print = new Thread(qprint);

        Thread print2 = new Thread(qprint);
        Thread print3 = new Thread(qprint);
        Thread print4 = new Thread(qprint);
        Thread populate2 = new Thread(qpop);
        Thread populate3 = new Thread(qpop);
        Thread populate4 = new Thread(qpop);

        print.start();
        populate.start();

        print2.start();
        print3.start();
        print4.start();
        populate2.start();
        populate3.start();
        populate4.start();

        Queue keyQueue = new Queue();

    }*/

    @Override
    public void start(Stage theStage) throws Exception {
        MediaPlayer goofyPlayer = new MediaPlayer(new Media(new File("src/goofy-yell.mp3").toURI().toString()));
        MediaPlayer smashPlayer = new MediaPlayer(new Media(new File("src/all-star-vaporwave.mp3").toURI().toString()));
        MediaPlayer childishPlayer = new MediaPlayer(new Media(new File("src/wii-shop-bonfire.mp3").toURI().toString()));

        Button goofy = new Button("Goofy");
        Button smash = new Button("Smash");
        Button childish = new Button("Childish");

        //TODO: Turn these into separate thread stuff; make them stop on their own, maybe turn buttons into toggles
        goofy.setOnAction(e-> {
            smashPlayer.stop();
            childishPlayer.stop();
            goofyPlayer.play();
        });
        smash.setOnAction(e-> {
            goofyPlayer.stop();
            childishPlayer.stop();
            smashPlayer.play();
        });
        childish.setOnAction(e-> {
            goofyPlayer.stop();
            smashPlayer.stop();
            childishPlayer.play();
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
    }
}