package billes;



import java.util.Random;

public class Grille extends Environnement {
	private Bille[][] grille;
	private int h, w;

	/**
	 * Cree un environnement de type grille
	 * 
	 * @param h
	 *            : hauteur
	 * @param w
	 *            : largeur
	 */
	public Grille(int h, int w) {
		super();
		this.h = h;
		this.w = w;
		grille = new Bille[h][w];
	}

	/**
	 * @return the grille
	 */
	public Bille[][] getTab() {
		return grille;
	}

	/**
	 * @param grille
	 *            the grille to set
	 */
	public void setTAb(Bille[][] grille) {
		this.grille = grille;
	}

	/**
	 * Ajoute une bille a la grille a la case (x,y)
	 * 
	 * @param bille
	 * @param x
	 * @param y
	 */
	public void addBille(Bille bille, int x, int y) {
		addAgent(bille);
		bille.setX(x);
		bille.setY(y);
		grille[x][y] = bille;
	}

	/**
	 * Deplace une bille sur la grille
	 * 
	 * @param bille
	 *            : la bille a deplacer
	 * @param x
	 *            : la nouvelle coordonnee X
	 * @param y
	 *            : la nouvelle coordonnee Y
	 */
	public void moveBille(Bille bille, int x, int y) {
		grille[bille.getX()][bille.getY()] = null;
		bille.setX(x);
		bille.setY(y);
		grille[x][y] = bille;
	}

	/**
	 * Retire une bille de la grille
	 * 
	 * @param bille
	 *            : la grille a retirer
	 */
	public void removeBille(Bille bille) {
		removeAgent(bille);
		bille = null;
	}

	@Override
	public String toString() {
		String toRet = "";
		for (int l = 0; l < w; l++) {
			for (int c = 0; c < h; c++) {
				toRet += "[";
				if (!isFree(c, l)) {
					toRet += "O";

				} else {
					toRet += " ";
				}
				toRet += "]";
			}
			toRet += "\n";
		}
		return toRet;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return la bille a la case (x,y) ou null s'il n'y a rien.
	 */
	public Bille getBille(int x, int y) {
		return grille[x][y];
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return true si une bille ne se trouve pas a la case (x,y).
	 */
	public boolean isFree(int x, int y) {
		return getBille(x, y) == null;
	}

	/**
	 * Sur la grille, ajoute un nombre aleatoire de bille a des emplacements
	 * aleatoires
	 */
	public void generateRandomBillesPlacement() {
		Random alea = new Random();
		for (int l = 0; l < w; l++) {
			for (int c = 0; c < h; c++) {
				if (alea.nextInt(10) < 3) {
					addBille(new Bille(), c, l);
				}
			}
		}
	}

}
