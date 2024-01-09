import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Date;

public class SolicitanteUDP {
    public static void main(String args[]) throws SocketException, UnknownHostException, IOException{
        args = new String[]{"hora", "localhost"};
        DatagramSocket socketUDP = new DatagramSocket();
        byte[] msj = args[0].getBytes();
        InetAddress hostServidor = InetAddress.getByName(args[1]);
        DatagramPacket peticion = new DatagramPacket(msj, msj.length, hostServidor, 6001);
        
        socketUDP.send(peticion);
        
        byte[] buffer = new byte[1000];
        DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
        
        try{
            socketUDP.setSoTimeout(5000);
            socketUDP.receive(respuesta);
        
            String stringHoraServidor = new String(respuesta.getData());
            Date horaServidor = new Date(stringHoraServidor);
            System.out.println("Hora del servidor: " + horaServidor);
        }catch(SocketTimeoutException ex){
            System.err.println("No se obtuvo respuesta del servidor.");
        }
        socketUDP.close();
    }
}