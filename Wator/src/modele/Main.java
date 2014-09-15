package modele;

import ihm.Fenetre;
import ihm.FenetreGraphiquePopulation;





public class Main {
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grille grille = new Grille(20, 20);
                Grille.GRILLE = grille;
		grille.generateRandomCreaturePlacement();
                Fenetre f = new Fenetre(grille);
                f.setVisible(true);
                grille.addObserver(f);
                //System.out.println(grille);
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0 ; i < grille.getAgents().size() ; i++) {
				grille.getAgents().get(i).action();
                                
			}
                       grille.notifyObservers();			
		}
	}

}
