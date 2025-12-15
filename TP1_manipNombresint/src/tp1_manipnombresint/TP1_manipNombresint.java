package tp1_manipnombresint;

import java.util.Scanner;

/**
 *
 * @author samar
 */
public class TP1_manipNombresint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Saisie des deux nombres
        System.out.print("Entrez le premier entier : ");
        int a = scanner.nextInt();
        System.out.print("Entrez le second entier : ");
        int b = scanner.nextInt();

        // Affichage des nombres saisis
        System.out.println("Vous avez saisi : " + a + " et " + b);

        // Calculs et affichages
        System.out.println("Somme : " + (a + b));
        System.out.println("Différence : " + (a - b));
        System.out.println("Produit : " + (a * b));

        if (b != 0) {
            System.out.println("Quotient entier : " + (a / b));
            System.out.println("Reste de la division : " + (a % b));
        } else {
            System.out.println("La division par zéro n'est pas possible !");
        }
    }
}

