
package filosofos;

public class Filosofo implements Runnable {
    private final int idFilosofo;
    private final String color;
    private final Tenedor tenedorDerecho;
    private final Tenedor tenedorIzquierdo;
    private final int tiempoMinimo;
    private final int tiempoMaximo;
    public Filosofo(int idFilosofo,
                    String color,
                    Tenedor tenedorIzquierdo,
                    Tenedor tenedorDerecho){
        this.idFilosofo = idFilosofo;
        this.color = color;
        this.tenedorDerecho = tenedorDerecho;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tiempoMinimo = 1000;
        this.tiempoMaximo = 5000;
    }
    
    /*
    •Vivir (run): 
        es un ciclo infinito, los filósofos piensan por un tiempo 
        aleatorio, luego se disponen a comer, tratan de tomar 
        primero el tenedor izquierdo y luego el derecho, si tienen 
        los dos tenedores comen durante un tiempo aleatorio 
        (sino esperan, hacen wait), dejan de comer (liberan los tenedores) 
        y repiten el ciclo indefinidamente.
    */
    @Override
    public void run()  {
        while (true){
            try {
                
                pensar();               
                comer();
            } catch (InterruptedException IException) {}
        }
    }
    
    /*
    •Pensar: 
        se imprime un mensaje que indica que el  
        filósofo está pensando. El hilo se duerme por un 
        tiempo aleatorio.
    */
    public void pensar() throws InterruptedException{
        hacer("PENSANDO");
        Thread.sleep(getTiempoAleatorio(this.tiempoMinimo,this.tiempoMaximo));
    }
    
    /*
    •Tomar tenedor: 
        se indica si se quiere tomar el tenedor 
        izquierdo o derecho. Si alguno de los 
        tenedores esta ocupado el hilo se bloquea (se hace un wait)
    */
    
    public void tomarTenedores() throws InterruptedException{
        hacer("preparando para comer...");
        if (this.idFilosofo == 1){
            tomarDerecha();
            tomarIzquierda();
        }else{
            tomarIzquierda();
            tomarDerecha();
        }
    }
    
    public void tomarDerecha() throws InterruptedException{
        this.tenedorDerecho.agarrar(idFilosofo);
        hacer("toma tenedor derecho "+this.tenedorDerecho.toString()+"...");
    }
    
    public void tomarIzquierda() throws InterruptedException{
        this.tenedorIzquierdo.agarrar(idFilosofo);        
        hacer("toma tenedor izquierdo "+this.tenedorIzquierdo.toString()+"...");
    }

    
    /*
    •Comer: 
        se imprime un mensaje indicando que el 
        filósofo está comiendo. El hilo se duerme 
        por un tiempo aleatorio. Al terminar de 
        comer el hilo libera los tenedores y despierta 
        a los hilos adyacentes que pudieron haberse bloqueado
    */
    public void comer() throws InterruptedException{
        tomarTenedores();
        
        hacer("COMIENDO");
        Thread.sleep(getTiempoAleatorio(this.tiempoMinimo,this.tiempoMaximo));
        soltarTenedores();
    }
    
    public void soltarTenedores(){
        hacer("suelta tenedor derecho "+this.tenedorDerecho.toString()+"...");
        this.tenedorDerecho.soltar(this.idFilosofo);
        hacer("suelta tenedor izquierdo "+this.tenedorIzquierdo.toString()+"...");
        this.tenedorIzquierdo.soltar(this.idFilosofo);

    }
    
    private void hacer(String accion){
        System.out.println(this.color + "FILOSOFO " + this.idFilosofo + "> "
                + accion + "\u001B[0m");
    }
    
    public int getTiempoAleatorio(int minimoMilisegundos, int maximoMilisegundos){
      return 
        (int)
        Math.floor(Math.random() 
        * (maximoMilisegundos - minimoMilisegundos + 1)
        + minimoMilisegundos);
    }
    
    public String toString(){
        return "ID: " + this.idFilosofo 
                + ", I:" + this.tenedorIzquierdo.idFilosofoAgarrando 
                + " D:" + this.tenedorDerecho.idFilosofoAgarrando;
    }
}