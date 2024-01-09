import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class ServidorUDP {
    public static void main(String args[]) throws SocketException, IOException{
        int puerto = 6001;
        System.out.println("Servidor en puerto: " + puerto);
        DatagramSocket socketUDP = new DatagramSocket(puerto);
        byte[] buffer = new byte [1000];
        
        while(true){
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            
            socketUDP.receive(peticion);
            System.out.println("Datagrama recibido por el host: " + peticion.getAddress());
            System.out.println("Desde el puerto remoto: " + peticion.getPort());
            Date now = new Date();
            
            DatagramPacket respuesta = new DatagramPacket(
                now.toString().getBytes(),
                now.toString().getBytes().length,
                peticion.getAddress(),
                peticion.getPort()
            );
            
            socketUDP.send(respuesta);
        }
    }
}