package edu.sla;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.util.Random;
import javafx.scene.text.Text;

public class Main {


    public static void main(String[] args) {

       SynchronizedQueue myQueue = new SynchronizedQueue();

        QueuePutter myPutter1 = new QueuePutter(myQueue);
        QueuePutter myPutter2 = new QueuePutter(myQueue);
        QueuePutter myPutter3 = new QueuePutter(myQueue);

        QueueGetter myGetter1 = new QueueGetter(myQueue, 1);
        QueueGetter myGetter2 = new QueueGetter(myQueue, 2);
        QueueGetter myGetter3 = new QueueGetter(myQueue, 3);

        Thread putterThread1 = new Thread(myPutter1);
        putterThread1.start();

        Thread putterThread2 = new Thread(myPutter2);
        putterThread2.start();

        Thread putterThread3 = new Thread(myPutter3);
        putterThread3.start();

        Thread getterThread1 = new Thread(myGetter1);
        getterThread1.start();

        Thread getterThread2 = new Thread(myGetter2);
        getterThread2.start();

        Thread getterThread3 = new Thread(myGetter3);
        getterThread3.start();
    }

 public void start (Stage firstStage) throws Exception {
     Button intoTheArray = new Button("Insert Into The Array");

     BorderPane border = new BorderPane();
     AnchorPane QueuePutter = new AnchorPane();
     AnchorPane QueueGetter = new AnchorPane();
     border.setTop(QueuePutter);
     border.setBottom(QueueGetter);

     Scene theScene = new Scene(border, 450, 150);
     firstStage.setScene(theScene);
     firstStage.setTitle("Array Assembly Line");
     firstStage.show();
    }
}
