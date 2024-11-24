package grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import grpc.HelloWorldServiceProto.HelloRequest;
import grpc.HelloWorldServiceProto.HelloResponse;

public class HelloWorldClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);

        HelloResponse response = stub.sayHello(HelloRequest.newBuilder().setName("Mundo!").build());
        System.out.println("Resposta do servidor: " + response.getMessage());

        channel.shutdown();
    }
}
