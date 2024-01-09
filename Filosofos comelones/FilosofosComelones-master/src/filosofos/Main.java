package filosofos;


public class Main {

    public static void main(String[] args) {
        Tenedor tenedorA = new Tenedor('a');
        Tenedor tenedorB = new Tenedor('b');
        Tenedor tenedorC = new Tenedor('c');
        Tenedor tenedorD = new Tenedor('d');
        Tenedor tenedorE = new Tenedor('e');
        Filosofo filosofo1 = new Filosofo(1,"\033[41m",tenedorE, tenedorA);
        Filosofo filosofo2 = new Filosofo(2,"\033[43m",tenedorA, tenedorB);
        Filosofo filosofo3 = new Filosofo(3, "\033[42m",tenedorB, tenedorC);
        Filosofo filosofo4 = new Filosofo(4,"\033[45m",tenedorC, tenedorD);
        Filosofo filosofo5 = new Filosofo(5, "\033[46m",tenedorD, tenedorE);

        Thread t1 = new Thread(filosofo1);
        Thread t2 = new Thread(filosofo2);
        Thread t3 = new Thread(filosofo3);
        Thread t4 = new Thread(filosofo4);
        Thread t5 = new Thread(filosofo5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
    
}
