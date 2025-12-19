import java.util.Random;

public class GrilleDeCellules {

    private CelluleLumineuse[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;

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

    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                matriceCellules[i][j].eteindreCellule();
            }
        }
    }

    public void activerLigneDeCellules(int ligne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[ligne][j].activerCellule();
        }
    }

    public void activerColonneDeCellules(int colonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][colonne].activerCellule();
        }
    }

    public void activerDiagonaleDescendante() {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    public void activerDiagonaleMontante() {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }

    public void melangerMatriceAleatoirement(int nbCoups) {
        eteindreToutesLesCellules();
        Random rand = new Random();

        for (int k = 0; k < nbCoups; k++) {
            int choix = rand.nextInt(4);
            switch (choix) {
                case 0 -> activerLigneDeCellules(rand.nextInt(nbLignes));
                case 1 -> activerColonneDeCellules(rand.nextInt(nbColonnes));
                case 2 -> activerDiagonaleDescendante();
                case 3 -> activerDiagonaleMontante();
            }
        }
    }

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

    public CelluleLumineuse getCellule(int i, int j) {
        return matriceCellules[i][j];
    }
}
