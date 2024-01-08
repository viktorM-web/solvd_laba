package com.solvd.post.multithread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Runner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ConnectionPool connectionPool = ConnectionPool.getInstance();

        ExecutorService threadPool = Executors.newFixedThreadPool(7);

        threadPool.submit(new MultithreadingTask("[1]First", connectionPool));
        threadPool.submit(new MultithreadingTask("[2]Second", connectionPool));
        threadPool.submit(new MultithreadingTask("[3]Third", connectionPool));
        threadPool.submit(new MultithreadingTask("[4]Fourth", connectionPool));
        threadPool.submit(new MultithreadingTask("[5]Fifth", connectionPool));
        threadPool.submit(new MultithreadingTask("[6]Sixth", connectionPool));
        threadPool.submit(new MultithreadingTask("[7]Seventh", connectionPool));

        Future<String> work_with_completable_future = threadPool.submit(() -> {
            ConnectionWithPostalChain connection = connectionPool.getConnection();
            log.info("Work with Future");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connectionPool.releaseConnection(connection);

            return "result";
        });

        CompletableFuture
                .runAsync(() -> {
                    ConnectionWithPostalChain connection = connectionPool.getConnection();
                    log.info("Work with Completable Future");
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    connectionPool.releaseConnection(connection);
                })
                .thenRun(() -> log.info("Work with Completable Future part 2"));


        threadPool.shutdown();
        threadPool.awaitTermination(2L, TimeUnit.MINUTES);

        System.out.println(work_with_completable_future.get());

    }
}
