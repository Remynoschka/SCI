/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Remynoschka
 */
public class Requin extends Creature {
	public static int population;
	public static final int TIME_BEFORE_DIE = 3;
	private int pv = TIME_BEFORE_DIE;

	public Requin() {
		population++;
	}

	@Override
	public void action() {
		Random alea = new Random();
		boolean hasMoved = false;
		// NOURRITURE
		boolean aMange = false;
		List<Point> poissonsCoords = new ArrayList<>();
		for (int l = getY() - 1; l <= getY() + 1; l++) {
			for (int c = getX() - 1; c <= getX() + 1; c++) {
				if (((Grille) this.getEnvironnement()).isInGrid(c, l)
						&& !hasMoved) {
					if (!((Grille) this.getEnvironnement()).isFree(c, l)
							&& ((Grille) this.getEnvironnement()).getCreature(
									c, l).getType() == Type.POISSON) {
						// On ajoute le poissons aux poissons possibles
						poissonsCoords.add(new Point(c, l));
					}
				}
			}
		}
		// on mange le poisson
		if (!poissonsCoords.isEmpty()) {
			Point p = poissonsCoords.get(alea.nextInt(poissonsCoords.size()));
			((Grille) this.getEnvironnement()).removeCreature(((Grille) this
					.getEnvironnement()).getCreature((int) p.getX(),
					(int) p.getY()));
			this.pv = TIME_BEFORE_DIE;
			hasMoved = true;
			aMange = true;
			move((int) p.getX(), (int) p.getY());
		}
		// DEPLACEMENT
		int movX = alea.nextInt(3) - 1;
		int movY = alea.nextInt(3) - 1;

		boolean coordUsed[][] = new boolean[3][3];
		boolean allUsed = false;
		coordUsed[movX + 1][movY + 1] = true;

		if (!hasMoved) {

			while (!((Grille) this.getEnvironnement()).isInGrid(this.getX()
					+ movX, this.getY() + movY)
					&& !allUsed) {
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
				if (nbUsed == 9)
					allUsed = true;

			}
			if (!allUsed)
				move(this.getX() + movX, this.getY() + movY);

		}
		if (!aMange) {
			// REPRODUCTION
			if (getAge() % getTauxReproduction() == 0) {
				movX = alea.nextInt(3) - 1;
				movY = alea.nextInt(3) - 1;
				coordUsed = new boolean[3][3];
				allUsed = false;
				coordUsed[movX + 1][movY + 1] = true;
				while (!((Grille) this.getEnvironnement()).isReachable(
						this.getX() + movX, this.getY() + movY)
						&& !allUsed) {
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
					if (nbUsed == 9)
						allUsed = true;
				}
				if (!allUsed) {

					((Grille) getEnvironnement()).addCreature(new Requin(),
							this.getX() + movX, this.getY() + movY);
				}
			}
		}
		age++;
		pv--;
		if (pv == 0) {
			((Grille) getEnvironnement()).removeCreature(this);

		}

	}

	@Override
	public String toString() {
		return "^";
	}

	@Override
	public Type getType() {
		return Type.REQUIN;
	}

	@Override
	public int getTauxReproduction() {
		return 10;
	}

	@Override
	public int getPopulation() {
		return population;

	}

	@Override
	public void killOne() {
		population--;
	}
}
