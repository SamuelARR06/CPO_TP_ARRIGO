import java.util.Random;

/**
 * Représente une grille de cellules lumineuses.
 */
public class GrilleDeCellules {

    private CelluleLumineuse[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;

    /**
     * Constructeur de la grille.
     */
    public GrilleDeCellules(int lignes, int colonnes) {
        nbLignes = lignes;
        nbColonnes = colonnes;

        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }
    public void activerDiagonaleDescendante() {
    for (int i = 0; i < nbLignes && i < nbColonnes; i++) {
        matriceCellules[i][i].activerCellule();
    }
}

public void activerDiagonaleMontante() {
    for (int i = 0; i < nbLignes && i < nbColonnes; i++) {
        matriceCellules[i][nbColonnes - 1 - i].activerCellule();
    }
}

    /**
     * Éteint toutes les cellules.
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    /**
     * Active (inverse) toutes les cellules d'une ligne.
     */
    public void activerLigneDeCellules(int ligne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[ligne][j].activerCellule();
        }
    }

    /**
     * Active (inverse) toutes les cellules d'une colonne.
     */
    public void activerColonneDeCellules(int colonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][colonne].activerCellule();
        }
    }

    /**
     * Mélange la grille en appliquant des coups aléatoires.
     * Garantit une configuration solvable.
     */
    public void melangerMatriceAleatoirement(int nbCoups) {
        Random rand = new Random();

        for (int k = 0; k < nbCoups; k++) {
            if (rand.nextBoolean()) {
                activerLigneDeCellules(rand.nextInt(nbLignes));
            } else {
                activerColonneDeCellules(rand.nextInt(nbColonnes));
            }
        }
    }

    /**
     * Retourne une cellule précise.
     */
    public CelluleLumineuse getCellule(int ligne, int colonne) {
        return matriceCellules[ligne][colonne];
    }

    /**
     * Vérifie si toutes les cellules sont éteintes.
     */
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (!matriceCellules[i][j].estEteint()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Affichage texte (debug).
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
