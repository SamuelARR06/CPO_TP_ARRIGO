package tp2_bieres_arrigo2;

/**
 *
 * @author samar
 */
public class TP2_Bieres_ARRIGO2 {

    public static void main(String[] args) {
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvee des Trolls", 7.0, "Dubuisson");
        uneBiere.lireEtiquette();
        System.out.println(uneBiere);

        BouteilleBiere deuxiemeBiere = new BouteilleBiere("Leffe", 6.6, "Abbaye de Leffe");
        deuxiemeBiere.lireEtiquette();
        System.out.println(deuxiemeBiere);

        // Trois autres exemples
        BouteilleBiere biere3 = new BouteilleBiere("Tripel Karmeliet", 8.4, "Bosteels");
        BouteilleBiere biere4 = new BouteilleBiere("Punk IPA", 5.6, "BrewDog");
        BouteilleBiere biere5 = new BouteilleBiere("Chouffe", 8.0, "Achouffe");

        biere3.lireEtiquette();
        biere4.lireEtiquette();
        biere5.lireEtiquette();

        biere3.decapsuler();
        System.out.println(biere3);
    }
}


