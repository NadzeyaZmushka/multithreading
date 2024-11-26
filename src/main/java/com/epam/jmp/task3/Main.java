package com.epam.jmp.task3;

class Main{
    public static void main(String args[]) {
        MessageQueue queue = new MessageQueue(5);
        String topic = "topic";

        Producer producer = new Producer(queue, topic);
        Consumer consumer = new Consumer(queue, topic);

        producer.start();
        consumer.start();
    }
}
