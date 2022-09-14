package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static final List<Thread> testThreadsList = new LinkedList<>();
    public static final ThreadGroup testThreadGroup = new ThreadGroup("test group");
    public static final Integer maxTreads = 4;

    public static void main(String[] args) throws InterruptedException {
        createThreadsInGroup();
        startThreadsInGroup();
        stopThreadsInGroup();
    }

    private static void stopThreadsInGroup() throws InterruptedException {
        Thread.sleep(15000);
        System.out.println("Завершаю все потоки.");
        testThreadGroup.interrupt();
    }

    private static void startThreadsInGroup() {
        System.out.println("Создаю потоки...");
        testThreadsList.forEach(Thread::start);
    }

    private static void createThreadsInGroup() {
        for (int i = 0; i < maxTreads; i++) {
            testThreadsList.add(
                    i, new MyThread(
                            testThreadGroup, String.valueOf(i + 1)
                    )
            );
        }
    }
}
