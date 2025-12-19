import javax.swing.*;
import java.awt.*;

public class FenetrePrincipale extends JFrame {

    private Partie partie;
    private JButton[][] boutons;

    private final int TAILLE = 5;

    public FenetrePrincipale() {
        initComponents(); // NetBeans OK

        // ===== Modèle =====
        partie = new Partie(TAILLE, TAILLE);
        partie.initialiserPartie();

        // ===== Grille principale 6x6 =====
        JPanel panelPrincipal = new JPanel(new GridLayout(TAILLE + 1, TAILLE + 1));
        setContentPane(panelPrincipal);

        boutons = new JButton[TAILLE][TAILLE];

        // Case (0,0) vide
        JButton coin = new JButton("");
        coin.setEnabled(false);
        panelPrincipal.add(coin);

        // Boutons colonnes
        for (int j = 0; j < TAILLE; j++) {
            final int col = j;
            JButton b = new JButton("C" + j);
            b.addActionListener(e -> {
                partie.getGrille().activerColonneDeCellules(col);
                rafraichirGrille();
            });
            panelPrincipal.add(b);
        }

        // Lignes + cellules
        for (int i = 0; i < TAILLE; i++) {

            final int lig = i;
            JButton bLigne = new JButton("L" + i);
            bLigne.addActionListener(e -> {
                partie.getGrille().activerLigneDeCellules(lig);
                rafraichirGrille();
            });
            panelPrincipal.add(bLigne);

            for (int j = 0; j < TAILLE; j++) {
                JButton cell = new JButton();
                cell.setEnabled(false);
                boutons[i][j] = cell;
                panelPrincipal.add(cell);
            }
        }

        rafraichirGrille();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void rafraichirGrille() {
        GrilleDeCellules g = partie.getGrille();

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                boutons[i][j].setBackground(
                    g.getCellule(i, j).getEtat()
                        ? Color.YELLOW
                        : Color.DARK_GRAY
                );
            }
        }
    }
    
    
                
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGrille = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGrille.setBackground(new java.awt.Color(0, 242, 0));

        javax.swing.GroupLayout panelGrilleLayout = new javax.swing.GroupLayout(panelGrille);
        panelGrille.setLayout(panelGrilleLayout);
        panelGrilleLayout.setHorizontalGroup(
            panelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );
        panelGrilleLayout.setVerticalGroup(
            panelGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 242));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(242, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGrille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FenetrePrincipale::new);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelGrille;
    // End of variables declaration//GEN-END:variables
}
