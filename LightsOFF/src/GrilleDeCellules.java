import java.util.Random;

/**
 * Représente une grille de cellules lumineuses.
 * Les cellules sont organisées en lignes et en colonnes.
 */
public class GrilleDeCellules {

    /**
     * Matrice contenant les cellules lumineuses.
     */
    private CelluleLumineuse[][] matriceCellules;

    /**
     * Nombre de lignes de la grille.
     */
    private int nbLignes;

    /**
     * Nombre de colonnes de la grille.
     */
    private int nbColonnes;

    /**
     * Constructeur de la grille.
     * Initialise la matrice et crée les cellules lumineuses.
     *
     * @param p_nbLignes   nombre de lignes
     * @param p_nbColonnes nombre de colonnes
     */
    public GrilleDeCellules(int p_nbLignes, int p_nbColonnes) {
        nbLignes = p_nbLignes;
        nbColonnes = p_nbColonnes;

        matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }

    /**
     * Éteint toutes les cellules de la grille.
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    /**
     * Active toutes les cellules d'une ligne donnée.
     *
     * @param idLigne indice de la ligne à activer
     */
    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }
    }

    /**
     * Active toutes les cellules d'une colonne donnée.
     *
     * @param idColonne indice de la colonne à activer
     */
    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }
    }

    /**
     * Active la diagonale descendante de la grille.
     */
    public void activerDiagonaleDescendante() {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    /**
     * Active la diagonale montante de la grille.
     */
    public void activerDiagonaleMontante() {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }

    /**
     * Active aléatoirement une ligne, une colonne ou une diagonale.
     */
    public void activerLigneColonneOuDiagonaleAleatoire() {
        Random rand = new Random();
        int choix = rand.nextInt(4);

        switch (choix) {
            case 0:
                activerLigneDeCellules(rand.nextInt(nbLignes));
                break;
            case 1:
                activerColonneDeCellules(rand.nextInt(nbColonnes));
                break;
            case 2:
                activerDiagonaleDescendante();
                break;
            case 3:
                activerDiagonaleMontante();
                break;
        }
    }

    /**
     * Mélange la grille de manière aléatoire tout en garantissant
     * l'existence d'une solution.
     *
     * @param nbTours nombre de coups aléatoires appliqués
     */
    public void melangerMatriceAleatoirement(int nbTours) {
        eteindreToutesLesCellules();

        for (int k = 0; k < nbTours; k++) {
            activerLigneColonneOuDiagonaleAleatoire();
        }
    }
public CelluleLumineuse getCellule(int ligne, int colonne) {
    return matriceCellules[ligne][colonne];
}

    /**
     * Vérifie si toutes les cellules de la grille sont éteintes.
     *
     * @return true si toutes les cellules sont éteintes, false sinon
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
     * Représentation textuelle de la grille.
     *
     * @return chaîne représentant la grille
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("   ");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append("| ").append(j).append(" ");
        }
        sb.append("|\n");

        for (int i = 0; i < nbLignes; i++) {
            sb.append(i).append("  ");
            for (int j = 0; j < nbColonnes; j++) {
                sb.append("| ").append(matriceCellules[i][j].toString()).append(" ");
            }
            sb.append("|\n");
        }

        return sb.toString();
    }
}
