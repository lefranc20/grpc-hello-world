package grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

import grpc.HelloWorldServiceProto.HelloRequest;
import grpc.HelloWorldServiceProto.HelloResponse;

// Implementação do servidor gRPC
public class HelloWorldServiceImpl extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = "Ola, " + request.getName();
        HelloResponse response = HelloResponse.newBuilder().setMessage(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Método main para inicializar o servidor
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051).addService(new HelloWorldServiceImpl()).build();
        System.out.println("Servidor gRPC iniciado na porta 50051...");
        server.start();
        server.awaitTermination();
    }
}
