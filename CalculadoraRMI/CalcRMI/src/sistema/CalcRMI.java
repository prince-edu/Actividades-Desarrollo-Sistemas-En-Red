
package sistema;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcRMI extends UnicastRemoteObject implements Calculadora, Serializable {
    
    private static final long serialVersionUID = 98798798778458L;
    
    public CalcRMI() throws RemoteException{}
    
    @Override
    public int div(int a, int b) throws RemoteException {
        return a/b;
    }

    @Override
    public int mul(int a, int b) throws RemoteException {
        return a*b;
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int res(int a, int b) throws RemoteException {
        return a - b;
    }
    
}
