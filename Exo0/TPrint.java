
public class TPrint extends Thread {

    static Affichage mAff = new Affichage();
    String txt;

    public TPrint(String t) {
        txt = t;
    }

    public void run() {
        for (int j = 0; j < 20; j++) {
            mAff.afficher(txt);
        }
    }

    public static void main(String args[]) {
        new TPrint("0000000000000000000000000").start();
        new TPrint("111111111111111111111111111").start();
    }
}
