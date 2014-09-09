package billes;

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

	public void addBille(Bille bille, int x, int y) {
		addAgent(bille);
		bille.setX(x);
		bille.setY(y);
	}
	
	@Override
	public String toString() {
		String toRet ="";
		for (int l=0; l < w ; l++){
			for (int c=0; c < h ; l++){
				
			}
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

}
