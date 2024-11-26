package com.epam.jmp.task3;

import java.util.Random;

class Producer extends Thread{

    private final MessageQueue queue;
    private final String topic;
    private final Random rand;

    public Producer(MessageQueue queue, String topic){
        this.queue = queue;
        this.topic = topic;
        this.rand = new Random();
    }

    public void run(){
        try{
            while(true){
                String payload = Integer.toString(rand.nextInt(100));
                Message message = new Message(this.topic, payload);
                queue.enqueue(message);
                System.out.println("Produced new message on topic " + message.getTopic() + ": " + message.getPayload());
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
