/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Remy FRANCOIS
 */
public abstract class Creature extends Agent {
    protected int x, y;
    protected int age;

    public Creature() {
        super();
        this.age = 1;
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
     * @param x
     * @param y 
     */
    public void move(int x, int y){
       
        ((Grille) this.getEnvironnement()).moveCreature(this, x, y);
    }
    
    /**
     * 
     * @return l'age de la creature
     */
    public int getAge(){
        return age;
    }
    
    
    /**
     * 
     * @return le type de la creature
     */
    public abstract Type getType();
    
    /**
     * 
     * @return le nombre de tours avant reproduction
     */
    public abstract int getTauxReproduction();
    
    /**
     * 
     * @return la population de la creature
     */
    public abstract int getPopulation();
    
    /**
     * Reduit la population
     */
    public abstract void killOne();
    
    /**
     * Met la population a 0
     */
    public abstract void resetPopulation();
    
    
}
