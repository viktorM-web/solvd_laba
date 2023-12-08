package com.solvd.post.multithread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultithreadingTask implements Runnable{

    private String name;

    public MultithreadingTask(String name, ConnectionPool connectionPool) {
        this.name = name;
        this.connectionPool = connectionPool;
    }

    private ConnectionPool connectionPool;


    @SneakyThrows
    @Override
    public void run() {
        log.info(name + " client work with post system");
        ConnectionWithPostalChain connection = connectionPool.getConnection();
        log.info(name + " got connection");
        Thread.sleep(10000);
        connectionPool.releaseConnection(connection);
    }
}
