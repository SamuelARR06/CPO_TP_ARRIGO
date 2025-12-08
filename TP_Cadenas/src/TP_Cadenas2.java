public class TP_Cadenas2 {
    private int[] codeSecret;           // Le code à trouver (4 chiffres)
    private int[] saisie;               // La saisie du joueur (4 chiffres)
    private int tentativesUtilisees;
    
    // Constructeur
    public TP_Cadenas2() {
        codeSecret = new int[4];
        saisie = new int[4];
        tentativesUtilisees = 0;
        genererCode();
    }
    
    // Générer un code aléatoire de 4 chiffres
    private void genererCode() {
        for (int i = 0; i < 4; i++) {
            codeSecret[i] = (int) (Math.random() * 10);
        }
    }
    
    // Augmenter le chiffre à la position donnée
    public int augmenterChiffre(int position) {
        saisie[position] = (saisie[position] + 1) % 10;
        return saisie[position];
    }
    
    // Diminuer le chiffre à la position donnée
    public int diminuerChiffre(int position) {
        saisie[position] = (saisie[position] - 1 + 10) % 10;
        return saisie[position];
    }
    
    // Vérifier la saisie et retourner les résultats
    public int[] verifier() {
        int justes = 0, trop_hauts = 0, trop_bas = 0;
        
        for (int i = 0; i < 4; i++) {
            if (saisie[i] == codeSecret[i]) {
                justes++;
            } else if (saisie[i] > codeSecret[i]) {
                trop_hauts++;
            } else {
                trop_bas++;
            }
        }
        
        tentativesUtilisees++;
        return new int[] {justes, trop_hauts, trop_bas};
    }
    public boolean aGagne() {
    return saisie[0] == codeSecret[0]
        && saisie[1] == codeSecret[1]
        && saisie[2] == codeSecret[2]
        && saisie[3] == codeSecret[3];
}

public boolean aPerdu() {
    return !aGagne() && tentativesUtilisees >= 5;
}

    // Getters
    public int[] getSaisie() {
        return saisie;
    }
    
    public int getTentativesUtilisees() {
        return tentativesUtilisees;
    }
    
    public void recommencer() {
        codeSecret = new int[4];
        saisie = new int[4];
        tentativesUtilisees = 0;
        genererCode();
    }
}
