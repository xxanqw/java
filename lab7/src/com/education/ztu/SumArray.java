package com.education.ztu;

import java.util.Random;
import java.util.concurrent.*;

public class SumArray {
    private static final int ARRAY_SIZE = 1_000_000;

    private static Callable<Long> createTask(final int start, final int end, final int[] array) {
        return () -> {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        };
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = new Random().ints(ARRAY_SIZE, 0, 100).toArray();

        // Однопоточна реалізація
        long startSingle = System.currentTimeMillis();
        long singleSum = 0;
        for (int num : array) {
            singleSum += num;
        }
        long endSingle = System.currentTimeMillis();
        System.out.println("Однопотокова сума: " + singleSum);
        System.out.println("Час виконання: " + (endSingle - startSingle) + " мс");

        // Багатопотокова реалізація
        long startMulti = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        int chunkSize = ARRAY_SIZE / 5;


        Future<Long> result1 = executor.submit(createTask(0, chunkSize, array));
        Future<Long> result2 = executor.submit(createTask(chunkSize, 2 * chunkSize, array));
        Future<Long> result3 = executor.submit(createTask(2 * chunkSize, 3 * chunkSize, array));
        Future<Long> result4 = executor.submit(createTask(3 * chunkSize, 4 * chunkSize, array));
        Future<Long> result5 = executor.submit(createTask(4 * chunkSize, ARRAY_SIZE, array));

        long multiSum = result1.get() + result2.get() + result3.get() + result4.get() + result5.get();

        long endMulti = System.currentTimeMillis();

        System.out.println("Багатопотокова сума: " + multiSum);
        System.out.println("Час виконання: " + (endMulti - startMulti) + " мс"); // Виправлено обчислення часу

        executor.shutdown();
    }
}