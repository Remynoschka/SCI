/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import modele.Agent;
import modele.Creature;

/**
 *
 * @author Remynoschka
 */
public class Grille extends javax.swing.JPanel {

    private static final int CASE_SIZE = 10;
    private modele.Grille grille;

    /**
     * Creates new form Grille
     */
    public Grille(modele.Grille grille) {
       this.grille = grille;
        initComponents();
        setPreferredSize(new Dimension(grille.getH() * CASE_SIZE, grille.getW() * CASE_SIZE));
    }

    /**
     * Changer la grille affichee
     * @param grille : la nouvelle grille
     */
    public void setGrille(modele.Grille grille) {
        this.grille = grille;
        setPreferredSize(new Dimension(grille.getW() * CASE_SIZE,grille.getH() * CASE_SIZE));
        this.setSize(getPreferredSize());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // CADRILLAGE
        for (int l = 1; l < grille.getH(); l++) {
            g.drawLine(0, l * CASE_SIZE, getX() + getWidth(), l * CASE_SIZE);
        }
        for (int c = 1; c < grille.getW(); c++) {
            g.drawLine(c * CASE_SIZE, 0, c * CASE_SIZE, getY() + getHeight());
        }
        // Creatures
        List<Agent> agents = grille.getAgents();
        for (Agent a : agents) {
            switch (((Creature) a).getType()) {
                case POISSON:
                    g.setColor(Color.CYAN);
                    break;
                case REQUIN:
                    g.setColor(new Color(134, 34, 34));
                    break;
                    default: g.setColor(Color.WHITE);
            }
            g.fillOval(((Creature) a).getX() * CASE_SIZE + CASE_SIZE / 4, ((Creature) a).getY() * CASE_SIZE + CASE_SIZE / 4, CASE_SIZE / 2, CASE_SIZE / 2);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
