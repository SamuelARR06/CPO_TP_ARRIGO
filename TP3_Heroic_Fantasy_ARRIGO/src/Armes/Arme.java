package Armes;

public abstract class Arme {
    private String nom;
    private int niveauAttaque;
    
    public Arme(String nom, int niveauAttaque) {
        this.nom = nom;
        this.niveauAttaque = niveauAttaque;
    }
    
    public int getNiveauAttaque() {
        return niveauAttaque;
    }
    
    public String getNom() {
        return nom;
    }
    
    @Override
    public String toString() {
        return "Arme: " + nom + ", Niveau d'attaque: " + niveauAttaque;
    }
}
