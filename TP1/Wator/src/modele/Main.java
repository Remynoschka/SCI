package modele;

import ihm.Fenetre;
import ihm.FenetreGraphiquePopulation;





public class Main {
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
                Grille.GRILLE = new Grille(20, 20);
		Grille.GRILLE.generateRandomCreaturePlacement();
                Fenetre f = new Fenetre(Grille.GRILLE);
                f.setVisible(true);
                Grille.GRILLE.addObserver(f);
                //System.out.println(grille);
		while (true) {
                    Grille grille = Grille.GRILLE;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0 ; i < grille.getAgents().size() ; i++) {
				grille.getAgents().get(i).action();
                                
			}
                       grille.notifyObservers();	
                       //System.out.println(Grille.GRILLE);
		}
	}

}
