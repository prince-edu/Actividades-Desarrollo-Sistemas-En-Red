package Servidor;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SaludoServidor {
    public static void main(String[] args) throws IOException, InterruptedException {
        int puerto = 50051;
        Server servidor = ServerBuilder.forPort(puerto).addService(new SaludoServidorImpl()).build();

        servidor.start();
        System.out.println("Servidor iniciado...");
        System.out.println("Escuchando en puerto: " + puerto);

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Recibiendo solicitud de apagado...");
            servidor.shutdown();
            System.out.println("Servidor detenido...");
        }));

        servidor.awaitTermination();
    }
}