/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Random;

/**
 * 
 * @author Remynoschka
 */
public class SatisfactionAgent extends Agent {
	private static int SATISFACTION_SUM_BLANC = 0;
	private static int SATISFACTION_SUM_NOIR = 0;
	private static int POPULATION_BLANC = 0;
	private static int POPULATION_NOIR = 0;
	private Type type;
	protected int x, y;

	public SatisfactionAgent(Type type) {
		super();
		this.type = type;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Bouge la creature a la case (x,y)
	 * 
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {

		((Grille) this.getEnvironnement()).moveCreature(this, x, y);
	}

	/**
	 * 
	 * @return le type de la creature
	 */
	public Type getType() {
		return this.type;
	}

	public void setSatisfaction(int value) {
		if (this.type == Type.BLANC) {
			SATISFACTION_SUM_BLANC -= this.satisfaction;
			super.setSatisfaction(value);
			SATISFACTION_SUM_BLANC += value;
		} else {
			SATISFACTION_SUM_NOIR -= this.satisfaction;
			super.setSatisfaction(value);
			SATISFACTION_SUM_NOIR += value;
		}
	}

	/**
	 * 
	 * @return la satisfaction moyenne des blancs
	 */
	public static int getSatisfactionBlanc() {
		return SATISFACTION_SUM_BLANC / POPULATION_BLANC;
	}

	/**
	 * 
	 * @return la satisfaction moyenne des blancs
	 */
	public static int getSatisfactionNoir() {
		return SATISFACTION_SUM_NOIR / POPULATION_NOIR;
	}

	@Override
	public void action() {
		Random alea = new Random();
        // DEPLACEMENT
        int movX = alea.nextInt(3) - 1;
        int movY = alea.nextInt(3) - 1;
        boolean coordUsed[][] = new boolean[3][3];
        boolean allUsed = false;
        coordUsed[movX + 1][movY + 1] = true;
        while (!((Grille) this.getEnvironnement()).isReachable(this.getX() + movX, this.getY() + movY) && !allUsed) {
            movX = alea.nextInt(3) - 1;
            movY = alea.nextInt(3) - 1;
            coordUsed[movX + 1][movY + 1] = true;
            int nbUsed = 0;
            for (int l = 0; l < 3; l++) {
                for (int c = 0; c < 3; c++) {
                    if (coordUsed[c][l] == true) {
                        nbUsed++;
                    }
                }
            }
            if (nbUsed == 9) {
                allUsed = true;
            }

        }
        if (!allUsed) {
            move(this.getX() + movX, this.getY() + movY);
        }
	}
}
