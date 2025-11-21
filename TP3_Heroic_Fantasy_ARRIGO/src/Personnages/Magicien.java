package Personnages;
import Armes.Arme;
import Armes.Baton;

public class Magicien extends Personnages {
    private static int nbMagiciens = 0;
    private boolean confirme;

    public Magicien(String nom, int niveauDeVie, boolean confirme) {
        super(nom, niveauDeVie);
        this.confirme = confirme;
        nbMagiciens++; // Incrémente à chaque création
    }

    public static int getNbMagiciens() {
        return nbMagiciens;
    }

    public void setConfirme(boolean confirme) {
        this.confirme = confirme;
    }

    // Méthode pour compter le nombre de bâtons
    public int nbBatons() {
        int nb = 0;
        for (Arme a : getInventaireArmes()) {
            if (a instanceof Baton) nb++;
        }
        return nb;
    }

    @Override
    public String toString() {
        return super.toString() + ", Magicien " + (confirme ? "confirmé" : "novice");
    }
    @Override
protected void finalize() throws Throwable {
    nbMagiciens--;
    super.finalize();
}

}
