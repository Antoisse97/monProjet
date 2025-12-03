
/**
 * Décrivez votre classe Emotion ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.Random;

public class Emotion {
    // J'ai enlevé "abstract", c'est maintenant une classe normale
    private String nom;
    private String couleur;
    private int bonusVitesse;
    private Random hasard; // Utile pour la Joie

    public Emotion(String nom, String couleur, int bonusVitesse) {
        this.nom = nom;
        this.couleur = couleur;
        this.bonusVitesse = bonusVitesse;
        this.hasard = new Random();
    }

    // Cette méthode gère TOUS les cas ici (pas de classes filles)
    public void seDeplacer(Robot robot, Monde monde) {
        int xActuel = robot.getX();
        int yActuel = robot.getY();
        int nouveauX = xActuel;
        int nouveauY = yActuel;

        switch (this.nom) {
            case "Joie":
                // Joie : Déplacement aléatoire d'une case (diagonale possible)
                // On tire un nombre entre -1 et 1 pour X et Y
                int dx = hasard.nextInt(3) - 1; 
                int dy = hasard.nextInt(3) - 1;
                nouveauX = xActuel + dx;
                nouveauY = yActuel + dy;
                System.out.println("Joie essaie de sauter partout !");
                break;

            case "Colère":
                // Colère : Fonce tout droit (par exemple vers la droite X+2)
                // Pour l'instant on fixe la direction vers la droite pour faire simple
                nouveauX = xActuel + this.bonusVitesse;
                System.out.println("Colère charge vers l'avant !");
                break;

            case "Tristesse":
                // Tristesse : Bouge de 1 case vers le bas (Y+1) lentement
                nouveauY = yActuel + 1;
                System.out.println("Tristesse descend doucement...");
                break;
                
             default:
                System.out.println("Pas de mouvement défini.");
                return; // On sort
        }

        // --- VERIFICATION IMPORTANTE ---
        // On demande au Monde si la case est libre (pas de mur, pas hors limite)
        if (monde.verifierDeplacement(nouveauX, nouveauY)) {
            robot.setPosition(nouveauX, nouveauY);
            System.out.println("-> Déplacement réussi vers [" + nouveauX + ", " + nouveauY + "]");
        } else {
            System.out.println("-> BOUM ! Mur ou sortie de carte, le robot reste sur place.");
        }
    }
    
    // Les getters (accesseurs) pour récupérer les infos
    public String getNom() { return nom; }
    public String getCouleur() { return couleur; }
    public int getBonusVitesse() { return bonusVitesse; }

}