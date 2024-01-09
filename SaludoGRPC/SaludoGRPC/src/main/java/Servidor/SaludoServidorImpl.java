package Servidor;

import com.proto.saludo.SaludoRequest;
import com.proto.saludo.SaludoResponse;
import com.proto.saludo.SaludoServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SaludoServidorImpl extends SaludoServiceGrpc.SaludoServiceImplBase {
    public void saludo(SaludoRequest request, StreamObserver<SaludoResponse> responseObserver){
        responseObserver.onNext(SaludoResponse.newBuilder().setResult("Hola" + request.getNombre()).build());
        responseObserver.onCompleted();
    }
}