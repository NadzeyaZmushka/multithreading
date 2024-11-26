package com.epam.jmp.task3;

class Consumer extends Thread{

    private final MessageQueue queue;
    private final String topic;

    public Consumer(MessageQueue queue, String topic){
        this.queue = queue;
        this.topic = topic;
    }

    public void run() {
        try {
            while (true) {
                Message message = queue.dequeue();
                if(message.getTopic().equals(this.topic)){
                    System.out.println("Consumed message on topic " + message.getTopic() + ": " + message.getPayload());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
