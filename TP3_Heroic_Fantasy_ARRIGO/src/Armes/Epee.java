package Armes;

public class Epee extends Arme {
    private int finesse;
    
    public Epee(String nom, int niveauAttaque, int finesse) {
        super(nom, niveauAttaque);
        this.finesse = finesse;
    }
    
    public int getFinesse() {
        return finesse;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Finesse: " + finesse;
    }
}
