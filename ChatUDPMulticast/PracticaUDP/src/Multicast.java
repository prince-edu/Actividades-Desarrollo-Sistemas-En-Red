import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Multicast {
    public static void main(String[] args) {
        try {
           int puerto = 6789;
           SocketAddress socketAddress = new InetSocketAddress("239.0.0.1", puerto);
           NetworkInterface networkInterface = NetworkInterface.getByName("Wi-Fi");
           MulticastSocket socket = new MulticastSocket(puerto);
           
           socket.joinGroup(socketAddress, networkInterface);
           Scanner scan = new Scanner(System.in);
           System.out.println("Envía un mensaje al grupo");
           String msj = scan.nextLine();
           
           //Envía el mensaje
           byte[] m = msj.getBytes();
           DatagramPacket mensajeSalida = new  DatagramPacket(m, m.length, socketAddress);
           socket.send(mensajeSalida);
           
           byte[] buffer = new byte[1024];
           String linea;
           
           while (true){
               DatagramPacket mensajeEntrada = new DatagramPacket(buffer, buffer.length);
               
               socket.receive(mensajeEntrada);
               linea = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());
               System.out.println("Recibido: " + linea);
               if(linea.equalsIgnoreCase("bye")){
                   break;
               }
           }
           
           socket.leaveGroup(socketAddress, networkInterface);
        }catch (IOException ex) {
           Logger.getLogger(Multicast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}