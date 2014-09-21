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
public class Poisson extends Creature {

    private static int SATISFACTION_SUM = 0;
    public static int population;

    public Poisson() {
        population++;
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

        // REPRODUCTION
        if (age % getTauxReproduction() == 0) {
            movX = alea.nextInt(3) - 1;
            movY = alea.nextInt(3) - 1;
            coordUsed = new boolean[3][3];
            allUsed = false;
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
                ((Grille) getEnvironnement()).addCreature(new Poisson(), this.getX() + movX, this.getY() + movY);
            }
        }
        age++;
    }

    @Override
    public void setSatisfaction(int value) {
        SATISFACTION_SUM -= this.satisfaction;
        super.setSatisfaction(value);
        SATISFACTION_SUM += value;
    }

    @Override
    public String toString() {
        return "<";
    }

    @Override
    public Type getType() {
        return Type.POISSON;
    }

    @Override
    public int getTauxReproduction() {
        return 3;
    }

    @Override
    public int getPopulation() {
        return population;

    }

    @Override
    public void killOne() {
        SATISFACTION_SUM -= this.satisfaction;
        population--;
    }

    @Override
    public void resetPopulation() {
        population = 0;
    }

    /**
     * 
     * @return la satisfaction moyenne des poissons
     */
    public static int getSatisfactionPoisson() {
        return SATISFACTION_SUM / population;
    }
}
