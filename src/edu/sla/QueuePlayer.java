package edu.sla;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

class QueuePlayer implements Runnable {
    private MediaPlayer playerGoofy;
    private MediaPlayer playerChildish;
    private MediaPlayer playerSmash;
    private Queue theQueue;

    QueuePlayer(Queue queue) {
        theQueue = queue;
        playerGoofy = new MediaPlayer(new Media(new File("src/goofy-yell.mp3").toURI().toString()));
        playerChildish = new MediaPlayer(new Media(new File("src/wii-shop-bonfire.mp3").toURI().toString()));
        playerSmash = new MediaPlayer(new Media(new File("src/all-star-vaporwave.mp3").toURI().toString()));
    }

    private void playNext(String pressed) {
        playerGoofy.stop();
        playerChildish.stop();
        playerSmash.stop();

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

            //while(waiting) {
                //if(playerGoofy.getStatus().equals(MediaPlayer.Status.STOPPED)) waiting = false;
                System.out.println(String.valueOf(playerGoofy.getCurrentTime())+" out of "+String.valueOf(playerGoofy.getTotalDuration()));
            //}
        }
    }

}
