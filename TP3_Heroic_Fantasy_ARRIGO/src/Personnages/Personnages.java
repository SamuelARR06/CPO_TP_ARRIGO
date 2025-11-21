package Personnages;
import Armes.Arme;
import java.util.ArrayList;

public abstract class Personnages {
    private String nom; 
    private int niveauDeVie;
    private ArrayList<Arme> inventaireArmes = new ArrayList<>();
    private Arme armeEnMain = null;

    // Propriété statique partagée par tous les personnages
    private static int nbPersonnages = 0;

    public Personnages(String nom, int niveauDeVie) {
        this.nom = nom;
        this.niveauDeVie = niveauDeVie;
        nbPersonnages++; // Incrémente à chaque création de personnage
    }

    // Accès au compteur global
    public static int getNbPersonnages() {
        return nbPersonnages;
    }

    public int getNiveauDeVie() {
        return niveauDeVie;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Arme> getInventaireArmes() {
        return inventaireArmes;
    }

    // Ajout d'une arme (maximum 5)
    public void ajouterArme(Arme a) {
        if (inventaireArmes.size() < 5) {
            inventaireArmes.add(a);
        } else {
            System.out.println(nom + " ne peut pas avoir plus de 5 armes !");
        }
    }

    public Arme getArmeEnMain() {
        return armeEnMain;
    }

    // Équipe une arme du personnage par son nom
    public void equiperArme(String nomArme) {
        boolean trouve = false;
        for (Arme a : inventaireArmes) {
            if (a.getNom().equals(nomArme)) {
                armeEnMain = a;
                trouve = true;
                System.out.println(nom + " a équipé " + nomArme);
                break;
            }
        }
        if (!trouve) {
            System.out.println("Arme " + nomArme + " introuvable dans l'inventaire de " + nom);
        }
    }

    @Override
    public String toString() {
        String res = "Personnage : " + nom + ", Niveau de vie : " + niveauDeVie;
        if (armeEnMain != null) {
            res += " [Arme en main : " + armeEnMain + "]";
        }
        return res;
    }

    // Destructeur pour mettre à jour le compteur lors de la suppression de l’objet
    @Override
    protected void finalize() throws Throwable {
        nbPersonnages--;
        super.finalize();
    }
}
