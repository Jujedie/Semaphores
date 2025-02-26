
import java.util.Random;

public class ProdConso extends Thread {

    private int id, nbprodcons;
    Random alea;
    Buffer buffer;

    public ProdConso(int id, Buffer buffer, int nbprodcons) {
        this.id = id;
        this.buffer = buffer;
        this.nbprodcons = nbprodcons;
        this.alea = new Random(System.currentTimeMillis());
    }

    public void run() {
        int currentnb = 0;
        while (currentnb < this.nbprodcons) {
            if (alea.nextBoolean()) {
                System.out.println("prodcons:" + this.id + " va produire");
                this.buffer.ajouter();
				System.out.println(this.buffer);
                System.out.println("prodcons:" + this.id + " a fini de produire: nbprodcons=" + currentnb);
                currentnb++;
            } else {
                System.out.println("prodcons:" + this.id + " va consommer");
                this.buffer.retirer();
				System.out.println(this.buffer);
                System.out.println("prodcons:" + this.id + " a fini de consommer: nbprodcons=" + currentnb);
                currentnb++;
            }
        }
        System.out.println("prodcons:" + this.id + " a TERMINÉ");
    }
}
