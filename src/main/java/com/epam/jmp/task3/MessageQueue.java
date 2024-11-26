package com.epam.jmp.task3;

import java.util.LinkedList;

class MessageQueue {

    private final LinkedList<Message> queue;
    private final int limit;

    public MessageQueue(int limit){
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    public synchronized void enqueue(Message item) throws InterruptedException {
        while(this.queue.size() == this.limit) {
            wait();
        }
        this.queue.add(item);
        notifyAll();
    }

    public synchronized Message dequeue() throws InterruptedException{
        while(this.queue.isEmpty()){
            wait();
        }
        notifyAll();
        return this.queue.poll();
    }
}
