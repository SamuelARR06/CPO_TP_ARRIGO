package tp3_heroic_fantasy_arrigo;

import Armes.Baton;
import Armes.Epee;
import Armes.Arme;
import Personnages.Magicien;
import Personnages.Guerrier;
import Personnages.Personnages;
import java.util.ArrayList;

public class TP3_Heroic_Fantasy_ARRIGO {
    public static void main(String[] args) {
        // Création des épées
        Epee excalibur = new Epee("Excalibur", 7, 5);
        Epee durandal = new Epee("Durandal", 4, 7);

        // Création des bâtons
        Baton chene = new Baton("Chêne", 4, 5);
        Baton charme = new Baton("Charme", 5, 6);

        // Tableau dynamique d'armes
        ArrayList<Arme> inventaire = new ArrayList<>();
        inventaire.add(excalibur);
        inventaire.add(durandal);
        inventaire.add(chene);
        inventaire.add(charme);

        // Création des magiciens
        Magicien gandalf = new Magicien("gandalf", 65, true);
        Magicien garcimore = new Magicien("Garcimore", 44, false);

        // Création des guerriers
        Guerrier conan = new Guerrier("Conan", 78, false);
        Guerrier lannister = new Guerrier("Lannister", 45, true);

        // Tableau dynamique des Personnages 
        ArrayList<Personnages> persos = new ArrayList<>();
        persos.add(gandalf);
        persos.add(garcimore);
        persos.add(conan);
        persos.add(lannister);

        // Affichage des persos
        System.out.println("Inventaire des personnages :");
        for (Personnages p : persos) {
            System.out.println(p);
        }

        // Affichage de l'inventaire des armes
        System.out.println("\n=== Inventaire des armes ===");
        for (Arme a : inventaire) {
            System.out.println(a);
        }

        // Test 3.2 Gestion avancée des armes par les personnages
        Guerrier guerrier = new Guerrier("Conan", 80, false);
        Magicien magicien = new Magicien("Merlin", 60, true);

        Baton baton1 = new Baton("Bâton1", 3, 10);
        Baton baton2 = new Baton("Bâton2", 5, 20);
        Baton baton3 = new Baton("Bâton3", 7, 30);

        Epee epee1 = new Epee("Épée1", 8, 40);
        Epee epee2 = new Epee("Épée2", 6, 30);
        Epee epee3 = new Epee("Épée3", 10, 25);

        guerrier.ajouterArme(baton1);
        guerrier.ajouterArme(epee1);
        guerrier.ajouterArme(epee2);
        guerrier.equiperArme("Épée1");

        magicien.ajouterArme(baton2);
        magicien.ajouterArme(baton3);
        magicien.ajouterArme(epee3);

        System.out.println("\nNombre de bâtons possédés par le magicien : " + magicien.nbBatons());

        System.out.println("\nCaractéristiques des personnages de test :");
        System.out.println(guerrier);
        System.out.println(magicien);

        // Partie statique : affichage du nombre de personnages, magiciens et guerriers créés
        System.out.println("\nNombre de personnages : " + Personnages.getNbPersonnages());
        System.out.println("Nombre de magiciens : " + Magicien.getNbMagiciens());
        System.out.println("Nombre de guerriers : " + Guerrier.getNbGuerriers());
    }
}
