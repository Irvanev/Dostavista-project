package com.delivery;

import io.grpc.ServerBuilder;
import io.grpc.Server;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(8888)
                .addService(new OrderServiceImpl())
                .build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started on port 8888");

        server.awaitTermination();
    }
}