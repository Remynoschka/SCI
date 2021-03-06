package modele;

import ihm.Fenetre;
import java.util.Random;

public class Main {

    /**
     * @param args
     */
    public static int SPEED = 100;
    public static int SEUIL_SATISFACTION = 70;

    public static void main(String[] args) {
        Grille.GRILLE = new Grille(50, 50);
        Grille.GRILLE.generateRandomCreaturePlacement();
        Fenetre f = new Fenetre(Grille.GRILLE);
        f.setVisible(true);
        Grille.GRILLE.addObserver(f);
        //System.out.println(Grille.GRILLE);
        while (true) {
            Grille grille = Grille.GRILLE;
            try {
                Thread.sleep(SPEED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < grille.getAgents().size(); i++) {
                grille.getAgents().get(i).action();
                //grille.getAgents().get(i).setSatisfaction(new Random().nextInt(101));
            }
            grille.notifyObservers();
            //System.out.println(Grille.GRILLE);
        }
    }
}
