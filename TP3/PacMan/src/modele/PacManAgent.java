/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * @author Remy FRANCOIS
 */
public abstract class PacManAgent extends Agent {

    protected int x, y;

    public PacManAgent() {
        super();
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
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
     * @param y the y to set
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
        ((Grille) this.getEnvironnement()).moveAgent(this, x, y);
    }
}
