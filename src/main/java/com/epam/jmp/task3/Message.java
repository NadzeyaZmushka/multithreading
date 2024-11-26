package com.epam.jmp.task3;

class Message {
    private final String topic;
    private final String payload;

    public Message(String topic, String payload){
        this.topic = topic;
        this.payload = payload;
    }

    public String getTopic(){
        return this.topic;
    }

    public String getPayload(){
        return this.payload;
    }
}
