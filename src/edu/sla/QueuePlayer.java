package edu.sla;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;

class QueuePlayer implements Runnable {
    private MediaPlayer playerGoofy;
    private MediaPlayer playerChildish;
    private MediaPlayer playerSmash;
    private Queue theQueue;
    private Queue nameQueue;
    private Text culprit;

    QueuePlayer(Queue queue, Queue nameQ, Text culp) {
        theQueue = queue;
        nameQueue = nameQ;
        culprit = culp;
        playerGoofy = new MediaPlayer(new Media(new File("src/goofy-yell.mp3").toURI().toString()));
        playerChildish = new MediaPlayer(new Media(new File("src/wii-shop-short.m4a").toURI().toString()));
        playerSmash = new MediaPlayer(new Media(new File("src/all-star-short.m4a").toURI().toString()));
    }

    private void playNext(String pressed) {
        if(pressed == null) return;
        culprit.setText("Current song chosen by " + nameQueue.pullNext());
        if (pressed.equals("goofy")) playAndWait(playerGoofy);
        if (pressed.equals("childish")) playAndWait(playerChildish);
        if (pressed.equals("smash")) playAndWait(playerSmash);
    }

    private void playAndWait(MediaPlayer player) {
        player.seek(Duration.ZERO);
        player.play();
        while(!player.getCurrentTime().equals(player.getTotalDuration())) Thread.currentThread().yield();
        player.pause();
    }

    public void run() {
        Thread.currentThread().setName("Playback Thread");
        while(!Thread.interrupted()) {
            playNext(theQueue.pullNext());
        }
    }
}
