/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

/**
 *
 * @author Remynoschka
 */
public class PyramideAges extends javax.swing.JFrame {

    /**
     * Creates new form PyramideAges
     */
    public PyramideAges() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pyramidePanel1 = new ihm.PyramidePanel();

        setTitle("Pyramide des Ages");
        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pyramidePanel1Layout = new javax.swing.GroupLayout(pyramidePanel1);
        pyramidePanel1.setLayout(pyramidePanel1Layout);
        pyramidePanel1Layout.setHorizontalGroup(
            pyramidePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pyramidePanel1Layout.setVerticalGroup(
            pyramidePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pyramidePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pyramidePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ihm.PyramidePanel pyramidePanel1;
    // End of variables declaration//GEN-END:variables
}
