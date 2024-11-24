package grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class HelloWorldServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new HelloWorldServiceImpl())
                .build();

        System.out.println("Servidor gRPC iniciado na porta 50051");
        server.start();
        server.awaitTermination();
    }
}
