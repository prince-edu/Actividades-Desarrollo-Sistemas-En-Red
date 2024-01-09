package filosofos;

public class Tenedor {
    public char idTenedor;
    public int idFilosofoAgarrando;
    public Tenedor(char idTenedor){
        this.idTenedor = idTenedor;
        this.idFilosofoAgarrando = 0;
    }
    
    public synchronized void agarrar(int idFilosofo) throws InterruptedException {
        while (!estaDisponible())
        {
            wait();
        }
        this.idFilosofoAgarrando = idFilosofo;
    }
    public synchronized void soltar(int idFilosofo){
        this.idFilosofoAgarrando = 0;
        notify();
    }
    public boolean estaDisponible(){
        return this.idFilosofoAgarrando == 0;
    }
    public String toString(){
        return "("+this.idTenedor+")";
    }
}