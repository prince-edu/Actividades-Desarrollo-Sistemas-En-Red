package Cliente;

import com.proto.saludo.SaludoRequest;
import com.proto.saludo.SaludoResponse;
import com.proto.saludo.SaludoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SaludoCliente {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        SaludoServiceGrpc.SaludoServiceBlockingStub stub = SaludoServiceGrpc.newBlockingStub(channel);
        SaludoResponse response = stub.saludo(SaludoRequest.newBuilder().setNombre("Saúl").build());

        System.out.println("Saludo: " + response.getResult());
        System.out.println("Apagando...");
        channel.shutdown();
    }
}