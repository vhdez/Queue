package edu.sla;

public class QueuePopulator implements Runnable {
    private int timesRun = 0;
    public void run() {
        timesRun++;
    }
}
