
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

        // --- 1. CHOIX DE LA DIRECTION ---
        switch (this.nom) {
            case "Joie":
                // Mouvement aléatoire
                int dx = hasard.nextInt(3) - 1; 
                int dy = hasard.nextInt(3) - 1;
                nouveauX = xActuel + dx;
                nouveauY = yActuel + dy;
                System.out.println("Joie essaie de sauter partout !");
                break;

            case "Colère":
                // Fonce vers la droite (+2)
                nouveauX = xActuel + this.bonusVitesse;
                System.out.println("Colère charge vers l'avant !");
                break;

            case "Tristesse":
                // Descend doucement (+1 en Y)
                nouveauY = yActuel + 1;
                System.out.println("Tristesse descend doucement...");
                break;

            default:
                System.out.println("Pas de mouvement défini.");
                return; 
        } // <--- IMPORTANT : Le switch se ferme ICI !

        // --- 2. VÉRIFICATION ET ACTION (À l'extérieur du switch) ---
        
        // On demande au Monde si le passage est libre
        if (monde.verifierDeplacement(nouveauX, nouveauY)) {
            
            // A. On bouge le robot
            robot.setPosition(nouveauX, nouveauY);
            System.out.println("-> Déplacement réussi vers [" + nouveauX + ", " + nouveauY + "]");

            // B. On regarde ce qu'il y a dans la pièce (Monstre / Enigme)
            Piece pieceActuelle = monde.getPiece(nouveauX, nouveauY);

            // --- GESTION MONSTRE ---
            if (pieceActuelle.aUnMonstre()) {
                System.out.println("⚠️ ATTENTION ! Un monstre surgit !");
                robot.combattre(pieceActuelle.getMonstre());
            }
            
            // --- GESTION ENIGME ---
            if (pieceActuelle.aUneEnigme()) {
                System.out.println("❓ Tiens ? Une énigme !");
                System.out.println("QUESTION : " + pieceActuelle.getEnigme().getQuestion());
                System.out.println("(Utilise 'tenterReponse' pour gagner l'émotion)");
            }

        } else {
            // Si verifierDeplacement renvoie faux (Mur ou Hors limite)
            System.out.println("-> Le robot reste sur place.");
        }
    

        // --- VÉRIFICATION ET DÉPLACEMENT ---
        if (monde.verifierDeplacement(nouveauX, nouveauY)) {
            // 1. On bouge le robot
            robot.setPosition(nouveauX, nouveauY);
            System.out.println("-> Déplacement vers [" + nouveauX + ", " + nouveauY + "]");

            // 2. On regarde ce qu'il y a dans la pièce (NOUVEAU)
            Piece pieceActuelle = monde.getPiece(nouveauX, nouveauY);

            // Y a-t-il un monstre ?
            if (pieceActuelle.aUnMonstre()) {
                System.out.println("ATTENTION ! Un monstre surgit !");
                // Le robot se bat automatiquement
                robot.combattre(pieceActuelle.getMonstre());
            }
            
            // Y a-t-il une énigme ?
            if (pieceActuelle.aUneEnigme()) {
                System.out.println("❓ Tiens ? Une énigme flotte dans l'air...");
                
                // On récupère l'énigme pour lire la question
                Enigme e = pieceActuelle.getEnigme();
                System.out.println("QUESTION : " + e.getQuestion()); // <-- C'est ça qui manquait !
                
                System.out.println("(Faites un clic-droit 'tenterReponse' sur le robot pour répondre)");
            }

        } else {
            System.out.println("-> BOUM ! Mur ou sortie de carte.");
        }
    }
    
    // Les getters (accesseurs) pour récupérer les infos
    public String getNom() { return nom; }
    public String getCouleur() { return couleur; }
    public int getBonusVitesse() { return bonusVitesse; }

}