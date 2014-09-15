package billes;

import ihm.Window;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grille grille = new Grille(10, 10);
		grille.generateRandomBillesPlacement();
                Window f = new Window(grille);
                f.setVisible(true);
                grille.addObserver(f);
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (Agent a : grille.getAgents()) {
				a.action();
                                
			}
                        f.update(grille, null);
			//System.out.println(grille);
		}
	}

}
