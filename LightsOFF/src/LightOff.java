import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Lights Off - Version graphique
 * Boutons à gauche = lignes
 * Boutons en haut = colonnes
 */
public class LightOff extends JFrame {

    private final int TAILLE = 5;

    private boolean[][] grille;
    private JButton[][] boutonsCellules;

    private JButton[] boutonsLignes;
    private JButton[] boutonsColonnes;

    private int nbCoups;
    private JLabel labelCoups;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LightOff::new);
    }

    public LightOff() {
        setTitle("Lights Off");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        grille = new boolean[TAILLE][TAILLE];
        boutonsCellules = new JButton[TAILLE][TAILLE];
        boutonsLignes = new JButton[TAILLE];
        boutonsColonnes = new JButton[TAILLE];

        // ===== Bandeau haut (colonnes) =====
        JPanel panelHaut = new JPanel(new GridLayout(1, TAILLE + 1));
        panelHaut.add(new JLabel("")); // coin vide

        for (int j = 0; j < TAILLE; j++) {
            JButton btnCol = new JButton("C" + j);
            final int col = j;
            btnCol.addActionListener(e -> jouerColonne(col));
            boutonsColonnes[j] = btnCol;
            panelHaut.add(btnCol);
        }
        add(panelHaut, BorderLayout.NORTH);

        // ===== Panneau central (lignes + grille) =====
        JPanel centre = new JPanel(new GridLayout(TAILLE, TAILLE + 1));

        for (int i = 0; i < TAILLE; i++) {

            // Bouton de ligne (à gauche)
            JButton btnLigne = new JButton("L" + i);
            final int ligne = i;
            btnLigne.addActionListener(e -> jouerLigne(ligne));
            boutonsLignes[i] = btnLigne;
            centre.add(btnLigne);

            // Cellules visuelles
            for (int j = 0; j < TAILLE; j++) {
                JButton cell = new JButton();
                cell.setEnabled(false); // pas cliquable
                cell.setOpaque(true);
                cell.setBorderPainted(false);
                boutonsCellules[i][j] = cell;
                centre.add(cell);
            }
        }

        add(centre, BorderLayout.CENTER);

        // ===== Bas (score + rejouer) =====
        JPanel bas = new JPanel();
        labelCoups = new JLabel("Coups : 0");
        JButton btnRejouer = new JButton("Rejouer");
        btnRejouer.addActionListener(e -> initialiserPartie());
        bas.add(labelCoups);
        bas.add(btnRejouer);
        add(bas, BorderLayout.SOUTH);

        initialiserPartie();
        setVisible(true);
    }

    // ===================== LOGIQUE DU JEU =====================

    private void initialiserPartie() {
        nbCoups = 0;
        labelCoups.setText("Coups : 0");

        // Tout éteint
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                grille[i][j] = false;
            }
        }

        // Génération solvable (coups aléatoires)
        Random rand = new Random();
        int nbCoupsAleatoires = 10;

        for (int k = 0; k < nbCoupsAleatoires; k++) {
            if (rand.nextBoolean()) {
                jouerLigneInterne(rand.nextInt(TAILLE));
            } else {
                jouerColonneInterne(rand.nextInt(TAILLE));
            }
        }

        rafraichirAffichage();
    }

    private void jouerLigne(int ligne) {
        jouerLigneInterne(ligne);
        finDeCoup();
    }

    private void jouerColonne(int colonne) {
        jouerColonneInterne(colonne);
        finDeCoup();
    }

    // --- méthodes internes (sans compteur)
    private void jouerLigneInterne(int ligne) {
        for (int j = 0; j < TAILLE; j++) {
            grille[ligne][j] = !grille[ligne][j];
        }
    }

    private void jouerColonneInterne(int colonne) {
        for (int i = 0; i < TAILLE; i++) {
            grille[i][colonne] = !grille[i][colonne];
        }
    }

    private void finDeCoup() {
        nbCoups++;
        labelCoups.setText("Coups : " + nbCoups);
        rafraichirAffichage();

        if (toutesEteintes()) {
            JOptionPane.showMessageDialog(this,
                    "🎉 Victoire en " + nbCoups + " coups !");
        }
    }

    private boolean toutesEteintes() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if (grille[i][j]) return false;
            }
        }
        return true;
    }

    private void rafraichirAffichage() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                boutonsCellules[i][j].setBackground(
                        grille[i][j] ? Color.YELLOW : Color.DARK_GRAY
                );
            }
        }
    }
}
