package billes;

import java.util.ArrayList;
import java.util.List;

public abstract class Environnement {
	private List<Agent> agents;

	/**
	 * Cree un nouvel environnement
	 */
	public Environnement() {
		agents = new ArrayList<>();
	}

	/**
	 * Ajoute un agent a l'environnement
	 * 
	 * @param agent
	 *            : l'agent a ajouter
	 */
	public void addAgent(Agent agent) {
		agents.add(agent);
	}

	/**
	 * Retire un agent des agents presents dans l'environnement
	 * 
	 * @param agent
	 *            : l'agent a retirer
	 * @return true si l'agent a bien ete retire
	 */
	public boolean removeAgent(Agent agent) {
		return agents.remove(agent);
	}

	/**
	 * Retire un agent des agents presents dans l'environnement
	 * 
	 * @param i
	 *            : l'indice de l'agent a retirer
	 * @return l'objet Agent retire
	 */
	public Agent removeAgent(int i) {
		return agents.remove(i);
	}
}
