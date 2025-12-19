public class Partie {

    private GrilleDeCellules grille;
    private int nbCoups;

    public Partie(int lignes, int colonnes) {
        grille = new GrilleDeCellules(lignes, colonnes);
        nbCoups = 0;
    }

    public void initialiserPartie() {
    grille.eteindreToutesLesCellules();
    grille.melangerMatriceAleatoirement(20); // changer la dificulté: 20 Difficile, 15 moyen...
    nbCoups = 0;
}


    // ===== Actions de jeu =====
    public void jouerLigne(int ligne) {
        grille.activerLigneDeCellules(ligne);
        nbCoups++;
    }

    public void jouerColonne(int colonne) {
        grille.activerColonneDeCellules(colonne);
        nbCoups++;
    }

    // ===== Getters =====
    public GrilleDeCellules getGrille() {
        return grille;
    }

    public int getNbCoups() {
        return nbCoups;
    }
    
public void jouerDiagonaleDescendante() {
    grille.activerDiagonaleDescendante();
    nbCoups++;
}

public void jouerDiagonaleMontante() {
    grille.activerDiagonaleMontante();
    nbCoups++;
}
    public boolean estGagnee() {
        return grille.cellulesToutesEteintes();
    }
}


