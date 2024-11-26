package com.epam.jmp.task4;

import java.util.LinkedList;

public class BlockingObjectPool {
    private final LinkedList<Object> objects;
    private final int size;

    public BlockingObjectPool(int size) {
        this.size = size;
        this.objects = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            objects.add(new Object());
        }
    }

    public synchronized Object get() {
        while (objects.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread was interrupted", e);
            }
        }
        Object obj = objects.poll();
        notifyAll();
        return obj;
    }

    public synchronized void take(Object object) {
        while (objects.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread was interrupted", e);
            }
        }
        objects.add(object);
        notifyAll();
    }
}
