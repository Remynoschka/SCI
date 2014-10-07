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
 * Le pacman, traque par les Monstres
 *
 * @author Remy FRANCOIS
 */
public class PacMan extends PacManAgent {

    public static final PacMan INSTANCE = new PacMan();
    private int[][] distanceValue;

    private PacMan() {
    }

    /**
     * Cree ou reinitialise la matrice de distance
     */
    public void initializeDistanceGrid() {
        distanceValue = new int[((Grille) this.getEnvironnement()).getW()][((Grille) this.getEnvironnement()).getH()];
    }

    /**
     * Calcul la matrice de distance
     */
    public void calculateDistanceGrid() {
        for (int c = 0; c < ((Grille) this.getEnvironnement()).getW(); c++) {
            for (int l = 0; l < ((Grille) this.getEnvironnement()).getH(); l++) {
                distanceValue[c][l] = Math.abs((c - this.x)) + Math.abs((l - this.y));
            }
        }
    }

    /**
     *
     * @return la matrice des distance vers le pacman
     */
    public int[][] getDistanceValues() {
        return distanceValue;
    }

    @Override
    public void action() {
        // se deplacer random
        Random alea = new Random();
        // calcul des positons possibles
        List<Point> positionsPossibles = new ArrayList<>();
        for (int l = getY() - 1; l <= getY() + 1; l++) {
            for (int c = getX() - 1; c <= getX() + 1; c++) {
                // delpacement en croix
                if (((Grille) this.getEnvironnement()).isReachable(c, l) 
                        && !(l == getY() - 1 && c == getX() - 1) && !(l == getY() + 1 && c == getX() + 1) && !(l == getY() - 1 && c == getX() + 1) && !(l == getY() + 1 && c == getX() - 1)) {
                    // On ajoute la valeurs
                        positionsPossibles.add(new Point(c, l));
                }
            }
        }
        // on bouge
        if (positionsPossibles.size() > 0) {
            Point dst = positionsPossibles.get(alea.nextInt(positionsPossibles.size()));
            move(dst.x, dst.y);
        }
        calculateDistanceGrid();
    }

    @Override
    public String toString() {
        return "<";
    }
}
