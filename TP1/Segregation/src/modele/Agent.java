package modele;

public abstract class Agent {

    private static int LAST_ID_USED = 0;
    private int ID;
    protected Environnement environnement;
    protected int satisfaction;

    /**
     * Cree une instance d'Agent
     */
    public Agent() {
        this.ID = LAST_ID_USED;
        LAST_ID_USED++;
    }

    /**
     * Effectue l'action de l'agent
     */
    public abstract void action();

    /**
     *
     * @return l'ID de l'agent
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @return l'environnement dans lequel evolue l'agent
     */
    public Environnement getEnvironnement() {
        return environnement;
    }

    /**
     *
     * @param environnement : L'environnement a assigne a l'agent
     */
    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }
    
    /**
     * 
     * @return la satisfaction de l'agent
     */
    public int getSatisfaction(){
        return satisfaction;
    }
    
    /**
     * Change la valeur de satisfaction
     * @param value : la nouvelle valeur
     */
    public void setSatisfaction(int value){
        this.satisfaction = value;
    }
}
