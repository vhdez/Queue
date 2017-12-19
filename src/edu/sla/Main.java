package edu.sla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
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
        Media goofyMedia = new Media(new File("src/goofy-yell.mp3").toURI().toString());
        MediaPlayer goofyPlayer = new MediaPlayer(goofyMedia);
        Media smashMedia = new Media(new File("src/all-star-vaporwave.mp3").toURI().toString());
        MediaPlayer smashPlayer = new MediaPlayer(smashMedia);
        Media childishMedia = new Media(new File("src/wii-shop-bonfire.mp3").toURI().toString());
        MediaPlayer childishPlayer = new MediaPlayer(childishMedia);

        Button goofy = new Button("Goofy");
        Button smash = new Button("Smash");
        Button childish = new Button("Childish");

        goofy.setOnAction(e-> {
            goofyPlayer.play();
        });

        smash.setOnAction(e-> {
            smashPlayer.play();
        });

        childish.setOnAction(e-> {
            childishPlayer.play();
        });

        HBox buttons = new HBox();
        buttons.getChildren().add(goofy);
        buttons.getChildren().add(smash);
        buttons.getChildren().add(childish);

        Scene theScene = new Scene(buttons, 200, 40);
        theStage.setScene(theScene);
        theStage.setTitle("Music Buttons");
        theStage.show();
    }
}