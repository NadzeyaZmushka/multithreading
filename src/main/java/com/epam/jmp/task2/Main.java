package com.epam.jmp.task2;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread writer = new Thread(() -> {
            while (true) {
                sharedResource.addNumber(sharedResource.getRandomNumber());
            }
        });

        Thread sumReader = new Thread(() -> {
            while (true) {
                System.out.println("Sum: " + sharedResource.getSum());
            }
        });

        Thread sqrtReader = new Thread(() -> {
            while (true) {
                System.out.println("Square root of squares sum: " + sharedResource.getSquaredSum());
            }
        });

        writer.start();
        sumReader.start();
        sqrtReader.start();
    }
}