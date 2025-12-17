import java.util.Scanner;

/**
 * Représente une partie du jeu LightOff.
 */
public class Partie {

    private GrilleDeCellules grille;
    private int nbCoups;

    public Partie(int lignes, int colonnes) {
        grille = new GrilleDeCellules(lignes, colonnes);
        nbCoups = 0;
    }

    /**
     * Initialise la partie : mélange la grille.
     */
    public void initialiserPartie() {
        nbCoups = 0;
        grille.melangerMatriceAleatoirement(10);
    }

    /**
     * Lance la partie en mode console.
     */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);

        while (!grille.cellulesToutesEteintes()) {
            System.out.println(grille);
            System.out.println("Nombre de coups : " + nbCoups);

            System.out.println("Choisir une action :");
            System.out.println("1 = ligne");
            System.out.println("2 = colonne");
            System.out.println("3 = diagonale descendante");
            System.out.println("4 = diagonale montante");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Indice ligne : ");
                    int ligne = scanner.nextInt();
                    grille.activerLigneDeCellules(ligne);
                    break;
                case 2:
                    System.out.print("Indice colonne : ");
                    int colonne = scanner.nextInt();
                    grille.activerColonneDeCellules(colonne);
                    break;
                case 3:
                    grille.activerDiagonaleDescendante();
                    break;
                case 4:
                    grille.activerDiagonaleMontante();
                    break;
                default:
                    System.out.println("Choix invalide");
                    continue;
            }

            nbCoups++;
        }

        System.out.println(grille);
        System.out.println("🎉 Grille éteinte en " + nbCoups + " coups !");
        scanner.close();
    }

    /**
     * Point d'entrée du programme.
     */
  public static void main(String[] args) {

    Partie partie = new Partie(5, 5);  
    partie.initialiserPartie();          
    partie.lancerPartie();             
}

}
