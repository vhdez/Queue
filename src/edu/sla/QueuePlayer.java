package edu.sla;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

class QueuePlayer implements Runnable {
    private MediaPlayer playerGoofy;
    private MediaPlayer playerChildish;
    private MediaPlayer playerSmash;
    Queue theQueue;

    QueuePlayer() {
        theQueue = new Queue();
        playerGoofy = new MediaPlayer(new Media(new File("src/goofy-yell.mp3").toURI().toString()));
        playerChildish = new MediaPlayer(new Media(new File("src/wii-shop-bonfire.mp3").toURI().toString()));
        playerSmash = new MediaPlayer(new Media(new File("src/all-star-vaporwave.mp3").toURI().toString()));
    }

    private void playNext(String pressed) {
        playerGoofy.stop();
        playerGoofy.seek(Duration.ZERO);
        playerChildish.stop();
        playerChildish.seek(Duration.ZERO);
        playerSmash.stop();
        playerSmash.seek(Duration.ZERO);

        if(pressed == null) return;
        if (pressed.equals("goofy")) playerGoofy.play();
        if (pressed.equals("childish")) playerChildish.play();
        if (pressed.equals("smash")) playerSmash.play();
    }

    public void run() {
        boolean waiting;
        Thread.currentThread().setName("Playback Thread");
        while(!Thread.interrupted()) {
            playNext(theQueue.pullNext());
            waiting = true;

            //TODO: Only works for goofy right now; fix this please
            while(waiting) {
                if (playerGoofy.getCurrentTime().equals(playerGoofy.getTotalDuration())) waiting = false;
                if (playerGoofy.getStatus().equals(MediaPlayer.Status.READY) || playerGoofy.getStatus().equals(MediaPlayer.Status.STOPPED)) waiting = false;
            }
        }
    }

}
