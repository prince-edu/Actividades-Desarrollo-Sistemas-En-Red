
package sistema;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import javax.swing.JOptionPane;

public class Servidor {
    
    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.createRegistry(1099);
            r.rebind("Calculadora", new CalcRMI());
            JOptionPane.showMessageDialog(null, "Servidor conectado!");
            System.out.println("Servidor ejecutándose!");
        } catch (RemoteException ex) {
            System.err.println(ex);
        }
    }
    
}
