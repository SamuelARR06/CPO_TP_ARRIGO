import javax.swing.*;
import java.awt.*;

public class FenetrePrincipale extends JFrame {

    // ===== CONSTANTES =====
    private static final int TAILLE = 5;

    private static final Color ROSE_NEON = new Color(255, 20, 147);
    private static final Color BLEU_NEON = new Color(0, 200, 255);
    private static final Color NOIR_FOND = new Color(10, 10, 10);

    // ===== MODELE =====
    private Partie partie;

    // ===== VUE =====
    private JButton[][] boutons;
    private JLabel labelCoups;

    public FenetrePrincipale() {

        // ===== FENETRE =====
        setTitle("Lights Off – Neon Edition");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== MODELE =====
        partie = new Partie(TAILLE, TAILLE);
        partie.initialiserPartie();

        // ===== CONTENEUR PRINCIPAL =====
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.BLACK);
        setContentPane(panelPrincipal);

        // ===== GRILLE 6x6 (boutons + cellules) =====
        JPanel panelGrille = new JPanel(new GridLayout(TAILLE + 1, TAILLE + 1));
        panelGrille.setBackground(Color.BLACK);
        panelPrincipal.add(panelGrille, BorderLayout.CENTER);

        boutons = new JButton[TAILLE][TAILLE];

        // Coin vide
        JButton coin = new JButton("");
        coin.setEnabled(false);
        coin.setBackground(Color.BLACK);
        panelGrille.add(coin);

        // Boutons colonnes
        for (int j = 0; j < TAILLE; j++) {
            final int col = j;
            JButton bCol = new JButton("C" + j);
            bCol.addActionListener(e -> {
                partie.jouerColonne(col);
                mettreAJourApresCoup();
            });
            panelGrille.add(bCol);
        }

        // Lignes + cellules
        for (int i = 0; i < TAILLE; i++) {

            final int lig = i;
            JButton bLigne = new JButton("L" + i);
            bLigne.addActionListener(e -> {
                partie.jouerLigne(lig);
                mettreAJourApresCoup();
            });
            panelGrille.add(bLigne);

            for (int j = 0; j < TAILLE; j++) {
                JButton cell = new JButton();
                cell.setEnabled(false);
                cell.setOpaque(true);
                cell.setBackground(NOIR_FOND);
                cell.setBorder(BorderFactory.createLineBorder(ROSE_NEON, 2));
                boutons[i][j] = cell;
                panelGrille.add(cell);
            }
        }

        // ===== PANNEAU BAS =====
        JPanel panelBas = new JPanel();
        panelBas.setBackground(Color.BLACK);

        JButton diagMont = new JButton("Diagonale ↗");
        diagMont.addActionListener(e -> {
            partie.jouerDiagonaleMontante();
            mettreAJourApresCoup();
        });

        JButton diagDesc = new JButton("Diagonale ↘");
        diagDesc.addActionListener(e -> {
            partie.jouerDiagonaleDescendante();
            mettreAJourApresCoup();
        });

        JButton reset = new JButton("Recommencer");
        reset.addActionListener(e -> {
            partie.initialiserPartie();
            rafraichirGrille();
            labelCoups.setText("Coups : 0");
        });

        labelCoups = new JLabel("Coups : 0");
        labelCoups.setForeground(ROSE_NEON);
        labelCoups.setFont(new Font("Arial", Font.BOLD, 16));

        panelBas.add(diagMont);
        panelBas.add(diagDesc);
        panelBas.add(reset);
        panelBas.add(labelCoups);

        panelPrincipal.add(panelBas, BorderLayout.SOUTH);

        // ===== AFFICHAGE =====
        rafraichirGrille();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ===== RAFRAICHISSEMENT =====
    private void rafraichirGrille() {
        GrilleDeCellules g = partie.getGrille();

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                boutons[i][j].setBackground(
                        g.getCellule(i, j).getEtat()
                                ? BLEU_NEON
                                : NOIR_FOND
                );
            }
        }
    }

    // ===== APRES CHAQUE COUP =====
    private void mettreAJourApresCoup() {
        rafraichirGrille();
        labelCoups.setText("Coups : " + partie.getNbCoups());

        if (partie.estGagnee()) {
            JOptionPane.showMessageDialog(
                    this,
                    "🎉 VICTOIRE 🎉\nNombre de coups : " + partie.getNbCoups(),
                    "Gagné",
                    JOptionPane.INFORMATION_MESSAGE
            );
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
