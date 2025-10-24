/**/
package tp0_.addition;

import java.util.Scanner;

/**
 *
 * @author samar
 */
public class TP0_Addition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
int nb; // nombre d'entiers à additionner
int result = 0; // resultat
int ind; //indice
// initialisation
Scanner sc = new Scanner(System.in);
System.out.println("Entrer le nombre :");
nb=sc.nextInt();
// addition des nb premiers entiers
ind=1;
while (ind< nb) {
 result=result+ind;
 ind++;
}
// affichage du resultat
System.out.println("la somme des "+ nb + "entiers est:"+result); }
        // TODO code application logic here
    }
