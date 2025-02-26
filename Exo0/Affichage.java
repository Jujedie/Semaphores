
class Affichage {

    public synchronized void afficher(String t) {
        for (int i = 0; i < t.length(); i++) {
            System.out.print(t.charAt(i));
        }
        System.out.println();
    }
}
