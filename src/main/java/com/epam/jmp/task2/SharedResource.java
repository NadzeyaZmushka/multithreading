package com.epam.jmp.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SharedResource {
    private List<Double> numberList = new ArrayList<>();
    private final Random random = new Random();

    public double getRandomNumber() {
        return random.nextDouble();
    }

    public synchronized void addNumber(double num) {
        numberList.add(num);
    }

    public synchronized double getSum() {
        return numberList.stream().mapToDouble(Double::doubleValue).sum();
    }

    public synchronized double getSquaredSum() {
        return Math.sqrt(numberList.stream().mapToDouble(i -> i * i).sum());
    }
}
