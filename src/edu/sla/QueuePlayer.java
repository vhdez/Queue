package edu.sla;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

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
        playerSmash = new MediaPlayer(new Media(new File("src/all-star-short.m4a").toURI().toString()));
    }

    private void playNext(String pressed) {
        if(pressed == null) return;
        if (pressed.equals("goofy")) playAndWait(playerGoofy);
        if (pressed.equals("childish")) playAndWait(playerChildish);
        if (pressed.equals("smash")) playAndWait(playerSmash);
    }

    private void playAndWait(MediaPlayer player) {
        player.seek(Duration.ZERO);
        player.play();
        System.out.print("Playing...");
        int times = 0;
        while(!player.getCurrentTime().equals(player.getTotalDuration())) times++;
        System.out.print("Waited for " + times + " iterations...");
        player.pause();
        System.out.println("Stopping.");
    }

    public void run() {
        Thread.currentThread().setName("Playback Thread");
        while(!Thread.interrupted()) {
            playNext(theQueue.pullNext());
        }
    }
}