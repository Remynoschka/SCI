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
 * Les monstres poursuivants
 * @author Remy FRANCOIS
 */
public class Monstre extends PacManAgent {

    @Override
    public void action() {
        // calcul des positons possibles
        List<Point> positionsPossibles = new ArrayList<>();
        int minValue = ((Grille) this.getEnvironnement()).getH() + ((Grille) this.getEnvironnement()).getW();
        for (int l = getY() - 1; l <= getY() + 1; l++) {
            for (int c = getX() - 1; c <= getX() + 1; c++) {
                // delpacement en croix
                if (((Grille) this.getEnvironnement()).isReachable(c, l)
                        && !(l == getY() - 1 && c == getX() - 1) && !(l == getY() + 1 && c == getX() + 1) && !(l == getY() - 1 && c == getX() + 1) && !(l == getY() + 1 && c == getX() - 1)) {
                    // On ajoute la valeurs
                    if (PacMan.INSTANCE.getDistanceValues()[c][l] < minValue) {
                        minValue = PacMan.INSTANCE.getDistanceValues()[c][l];
                        positionsPossibles.clear();
                        positionsPossibles.add(new Point(c, l));
                    }
                    if (PacMan.INSTANCE.getDistanceValues()[c][l] == minValue) {
                        positionsPossibles.add(new Point(c, l));
                    }
                }
            }
        }
        // on bouge
        if (positionsPossibles.size() > 0) {
            Point dst = positionsPossibles.get(new Random().nextInt(positionsPossibles.size()));
            move(dst.x, dst.y);
        }
    }

    @Override
    public String toString() {
        return "A";
    }
}
