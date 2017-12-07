package edu.sla;

import static edu.sla.Main.myQueue;

public class QueuePopulator implements Runnable {

    public void run() {
        for(int i = 0; i < 100; i++) myQueue[i] = String.valueOf(i);
    }
}
