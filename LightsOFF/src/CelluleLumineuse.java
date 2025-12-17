/**
 * Représente une cellule lumineuse pouvant être allumée ou éteinte.
 */
public class CelluleLumineuse {

    /**
     * État de la cellule :
     * true  -> allumée
     * false -> éteinte
     */
    private boolean etat;

    /**
     * Constructeur par défaut.
     * Initialise la cellule à l'état éteint.
     */
    public CelluleLumineuse() {
        this.etat = false;
    }

    /**
     * Inverse l'état de la cellule.
     */
    public void activerCellule() {
        etat = !etat;
    }

    /**
     * Éteint la cellule.
     */
    public void eteindreCellule() {
        etat = false;
    }

    /**
     * Indique si la cellule est éteinte.
     *
     * @return true si la cellule est éteinte, false sinon
     */
    public boolean estEteint() {
        return !etat;
    }

    /**
     * Retourne l'état actuel de la cellule.
     *
     * @return true si la cellule est allumée, false sinon
     */
    public boolean getEtat() {
        return etat;
    }

    /**
     * Représentation textuelle de la cellule.
     *
     * @return "X" si la cellule est allumée, "O" sinon
     */
    @Override
    public String toString() {
        return etat ? "X" : "O";
    }
}
