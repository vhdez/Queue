package edu.sla;

class Queue {
    private String[] queue;
    private int queuePos;

    Queue() {
        queue = new String[100];
        queuePos = 0;
    }

    synchronized void add(String pressed) {
        if(canAdd()) queue[queuePos] = pressed;
        queuePos++;
    }

    synchronized String pullNext() {
        if(queuePos > 0) {
            String sendMe = queue[0];
            for(int i = 1; i < queuePos; i++) queue[i - 1] = queue[i];
            queue[queuePos - 1] = null;
            queuePos--;
            return sendMe;
        }
        else return null;
    }

    boolean empty() {
        return (queuePos == 0);
    }

    boolean canAdd() {
        return (queuePos < queue.length);
    }
}
