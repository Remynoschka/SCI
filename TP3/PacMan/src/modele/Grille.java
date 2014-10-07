package modele;

import java.util.Random;

public class Grille extends Environnement {

    public static Grille GRILLE;
    private PacManAgent[][] grille;
    
    private int h, w;
    private int nbMonstres = 1;
    private int nbWalls;

    /**
     * Cree un environnement de type grille par defaut
     *
     * @param h : hauteur
     * @param w : largeur
     */
    public Grille(int h, int w) {
        super();
        this.h = h;
        this.w = w;
        grille = new PacManAgent[w][h];
        nbWalls = (int) ((h + w) / 1.5);
        
    }

    /**
     * Cree un environnement de type grille
     *
     * @param h : hauteur
     * @param w : largeur
     * @param nbWalls : nombre de murs
     * @param nbMonstres : nombre de monstres
     */
    public Grille(int h, int w, int nbWalls, int nbMonstres) {
        super();
        this.h = h;
        this.w = w;
        grille = new PacManAgent[w][h];
        this.nbWalls = nbWalls;
        this.nbMonstres = nbMonstres;
    }

    /**
     * @return the grille
     */
    public PacManAgent[][] getTab() {
        return grille;
    }

    /**
     * @param grille the grille to set
     */
    public void setTAb(PacManAgent[][] grille) {
        this.grille = grille;
    }
    
 
    /**
     * Ajoute un agent a la grille a la case (x,y)
     *
     * @param agent
     * @param x
     * @param y
     */
    public void addAgent(PacManAgent agent, int x, int y) {
        addAgent(agent);
        agent.setX(x);
        agent.setY(y);
        grille[x][y] = agent;
    }

    /**
     * Deplace un agent sur la grille
     *
     * @param agent : l'agent a deplacer
     * @param x : la nouvelle coordonnee X
     * @param y : la nouvelle coordonnee Y
     */
    public void moveAgent(PacManAgent agent, int x, int y) {
        setChanged();
        grille[agent.getX()][agent.getY()] = null;
        agent.setX(x);
        agent.setY(y);
        grille[x][y] = agent;
    }

    /**
     * Indique si la case (x,y) est atteignable (vide et dans la grille)
     *
     * @param x
     * @param y
     * @return true si la case est atteignable
     */
    public boolean isReachable(int x, int y) {
        return x < w && x >= 0 && y < h && y >= 0 && isFree(x, y);
    }

    /**
     * Indique si la case (x,y) est dans la grille
     *
     * @param x
     * @param y
     * @return true si la case est dans la grille
     */
    public boolean isInGrid(int x, int y) {
        return x < w && x >= 0 && y < h && y >= 0;
    }

    /**
     * Retire un agent de la grille
     *
     * @param agent : l'agent a retirer
     */
    public void removeAgent(PacManAgent agent) {
        removeAgent(agent);
        grille[agent.getX()][agent.getY()] = null;
        agent = null;

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
                    toRet += getAgent(c, l);
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
     * @return le nombre de monstres
     */
    public int getNbMonstres() {
        return nbMonstres;
    }

    /**
     * set le nombre de monstres
     */
    public void setNbMonstres(int nb) {
        this.nbMonstres = nb;
    }

    /**
     * @return le nombre de murs
     */
    public int getNbWalls() {
        return nbWalls;
    }

    /**
     * set le nombre de murs
     */
    public void setNbWalls(int nb) {
        this.nbWalls = nb;
    }

    /**
     *
     * @param x
     * @param y
     * @return la creature a la case (x,y) ou null s'il n'y a rien.
     */
    public PacManAgent getAgent(int x, int y) {
        return grille[x][y];
    }

    /**
     *
     * @param x
     * @param y
     * @return true si un agent ne se trouve pas a la case (x,y).
     */
    public boolean isFree(int x, int y) {
        return getAgent(x, y) == null;
    }

    /**
     * Sur la grille, ajoute les murs et monstres a des positions aleatoires
     */
    public void generatePlacement() {
        Random alea = new Random();
        // placement des murs
        int nbPlaced = 0;
        while (nbPlaced != nbWalls) {
            int x = alea.nextInt(w);
            int y = alea.nextInt(h);
            if (isFree(x, y)) {
                addAgent(new Mur(), x, y);
                nbPlaced++;
            }
        }
        // placement des monstres
        nbPlaced = 0;
        while (nbPlaced != nbMonstres) {
            int x = alea.nextInt(w);
            int y = alea.nextInt(h);
            if (isFree(x, y)) {
                addAgent(new Monstre(), x, y);
                nbPlaced++;
            }
        }
        // placement du pacman
        nbPlaced = 0;
        while (nbPlaced != 1) {
            int x = alea.nextInt(w);
            int y = alea.nextInt(h);
            if (isFree(x, y)) {
                addAgent(PacMan.INSTANCE, x, y);
                PacMan.INSTANCE.initializeDistanceGrid();
                PacMan.INSTANCE.calculateDistanceGrid();
                nbPlaced++;
            }
        }
    }
}
