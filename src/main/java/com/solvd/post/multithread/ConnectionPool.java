package com.solvd.post.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {

    private static final Integer DEFAULT_POOL_SIZE = 5;

    private volatile static ConnectionPool Instance;
    private final BlockingQueue<ConnectionWithPostalChain> pool;

    private ConnectionPool(Integer pollSize) {
        pool = new ArrayBlockingQueue<>(pollSize);
        for (int i = 0; i < pollSize; i++) {
            pool.add(new ConnectionWithPostalChain());
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (Instance == null) {
            Instance = new ConnectionPool(DEFAULT_POOL_SIZE);
        }
        return Instance;
    }

    public ConnectionWithPostalChain getConnection() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(ConnectionWithPostalChain connection) {
        pool.add(connection);
    }
}
