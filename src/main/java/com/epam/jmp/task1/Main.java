package com.epam.jmp.task1;

import java.util.Map;

public class Main {

    public static void main(String args[]) throws InterruptedException {
//        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map = new ThreadSafeMap<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 2000000; i++) {
                map.put(i, i);
                System.out.println("i = " + i);
//                try {
//                    Thread.sleep(100);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
//                    Thread.sleep(500);
                    int sum = map.values().stream()
//                            .map(MutableInteger::get)
                            .reduce(0, Integer::sum);
                    System.out.println("Sum: " + sum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
