/*
 * FrmPrincipal.java
 *
 * Created on 19 de julio de 2007, 07:57 PM
 */

package sistemamascotas;

import java.awt.BorderLayout;

/**
 *
 * @author  Ricardo Adrian Delgadillo Rivera 6*A T/V
 */
public class FrmPrincipal extends javax.swing.JFrame {
    
    /** Creates new form FrmPrincipal */
    public FrmPrincipal() {
        initComponents();
        PnlFondo pnlFondo = new PnlFondo();
        pnlFondo.setjFramePadre(this);
        this.add(pnlFondo, BorderLayout.CENTER);
        this.pack();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalogo CANES");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
