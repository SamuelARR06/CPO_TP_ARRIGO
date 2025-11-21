package Personnages;
import Armes.Arme;
import Armes.Epee;

public class Guerrier extends Personnages {
    private static int nbGuerriers = 0;
    private boolean aCheval;

    public Guerrier(String nom, int niveauDeVie, boolean aCheval) {
        super(nom, niveauDeVie);
        this.aCheval = aCheval;
        nbGuerriers++; // Incrémente à chaque création
    }

    public static int getNbGuerriers() {
        return nbGuerriers;
    }

    public void setACheval(boolean aCheval) {
        this.aCheval = aCheval;
    }

    // Méthode pour compter le nombre d'épées
    public int nbEpees() {
        int nb = 0;
        for (Arme a : getInventaireArmes()) {
            if (a instanceof Epee) nb++;
        }
        return nb;
    }

    @Override
    public String toString() {
        return super.toString() + ", Guerrier " + (aCheval ? "à cheval" : "à pied");
    }
    @Override
protected void finalize() throws Throwable {
    nbGuerriers--;
    super.finalize();
}

}

