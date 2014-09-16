package modele;

import java.util.Random;

public class Grille extends Environnement {
    public static Grille GRILLE;
    private Creature[][] grille;
    private int h, w;

    /**
     * Cree un environnement de type grille
     *
     * @param h : hauteur
     * @param w : largeur
     */
    public Grille(int h, int w) {
        super();
        this.h = h;
        this.w = w;
        grille = new Creature[h][w];
    }

    /**
     * @return the grille
     */
    public Creature[][] getTab() {
        return grille;
    }

    /**
     * @param grille the grille to set
     */
    public void setTAb(Creature[][] grille) {
        this.grille = grille;
    }

    /**
     * Ajoute une creature a la grille a la case (x,y)
     *
     * @param creature
     * @param x
     * @param y
     */
    public void addCreature(Creature creature, int x, int y) {
        addAgent(creature);
        creature.setX(x);
        creature.setY(y);
        grille[x][y] = creature;
    }

    /**
     * Deplace une creature sur la grille
     *
     * @param creature : la creature a deplacer
     * @param x : la nouvelle coordonnee X
     * @param y : la nouvelle coordonnee Y
     */
    public void moveCreature(Creature creature, int x, int y) {
        setChanged();
        grille[creature.getX()][creature.getY()] = null;
        creature.setX(x);
        creature.setY(y);
        grille[x][y] = creature;
    }

    /**
     * Indique si la case (x,y) est atteignable (vide et dans la grille)
     * @param x
     * @param y
     * @return true si la case est atteignable
     */
    public boolean isReachable(int x, int y){
        return x < w && x >= 0 && y < h && y >=0 && isFree(x, y);
    }
    
     /**
     * Indique si la case (x,y) est dans la grille
     * @param x
     * @param y
     * @return true si la case est dans la grille
     */
    public boolean isInGrid(int x, int y){
        return x < w && x >= 0 && y < h && y >=0;
    }
            
    /**
     * Retire une creature de la grille
     *
     * @param creature : la creature a retirer
     */
    public void removeCreature(Creature creature) {
        removeAgent(creature);
        grille[creature.getX()][creature.getY()] = null;
        creature.killOne();
        creature = null;
        
    }

    @Override
    public String toString() {
        String toRet = "";
        for (int l = 0; l < w; l++) {
            for (int c = 0; c < h; c++) {
                toRet += "[";
                if (isFree(c, l)) {
                    toRet += " ";
                } else {
                    toRet += getCreature(c, l);
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
     * @return la creature a la case (x,y) ou null s'il n'y a rien.
     */
    public Creature getCreature(int x, int y) {
        return grille[x][y];
    }

    /**
     *
     * @param x
     * @param y
     * @return true si une creature ne se trouve pas a la case (x,y).
     */
    public boolean isFree(int x, int y) {
        return getCreature(x, y) == null;
    }

    /**
     * Sur la grille, ajoute un nombre aleatoire de creatures a des emplacements
     * aleatoires
     */
    public void generateRandomCreaturePlacement() {
        Random alea = new Random();
        for (int l = 0; l < w; l++) {
            for (int c = 0; c < h; c++) {
                if (alea.nextInt(10) < 7) {
                    if (alea.nextInt(100) < 10) {
                        addCreature(new Requin(), c, l);
                    } else {
                        addCreature(new Poisson(), c, l);
                    }
                }
            }
        }
    }
}
