public class Amelioration {
    private AmeliorationType type;
    private int valeur;
    private Emotion nouvelleEmotion;
    
    public Amelioration(AmeliorationType type, int valeur) {
        this.type = type;
        this.valeur = valeur;
        this.nouvelleEmotion = null;
    }
    
    public Amelioration(Emotion nouvelleEmotion) {
        this.type = AmeliorationType.NOUVELLE_EMOTION;
        this.nouvelleEmotion = nouvelleEmotion;
        this.valeur = 0;
    }
    
    public void appliquer(Robot robot) {
        switch (type) {
            case VITESSE:
                robot.setVitesse(robot.getVitesse() + valeur);
                System.out.println("Vitesse augmentée de " + valeur);
                break;
            case VIE:
                robot.setVie(robot.getVie() + valeur);
                System.out.println("Vie augmentée de " + valeur);
                break;
            case NOUVELLE_EMOTION:
                if (nouvelleEmotion != null) {
                    robot.ajouterEmotion(nouvelleEmotion);
                    System.out.println("Nouvelle émotion débloquée : " + nouvelleEmotion.getNom());
                }
                break;
        }
    }
    
    public AmeliorationType getType() {
        return type;
    }
    
    public int getValeur() {
        return valeur;
    }
}

enum AmeliorationType {
    VITESSE, VIE, NOUVELLE_EMOTION
}