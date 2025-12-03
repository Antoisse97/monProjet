
/**
 * Décrivez votre classe Robot ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.ArrayList;

public class Robot {
    // Mes attributs
    private String nom;
    private int x; // Ma position ligne
    private int y; // Ma position colonne
    private Emotion emotionCourante; // L'émotion qui me contrôle en ce moment
    private ArrayList<Emotion> emotionsDebloquees; // Mon sac à dos d'émotions
    private int pointsDeVie;

    // Mon constructeur : c'est ici que je nais
    public Robot(String nom, int xDepart, int yDepart) {
        this.nom = nom;
        this.x = xDepart;
        this.y = yDepart;
        this.emotionsDebloquees = new ArrayList<Emotion>();
        this.emotionCourante = null; // Au début, je n'ai pas d'émotion active
        this.pointsDeVie = 100;
    }

    // La méthode principale : je demande à mon émotion de me faire bouger
    public void seDeplacer(Monde monde) {
        if (this.emotionCourante != null) {
            // Je me donne moi-même ("this") à l'émotion pour qu'elle modifie mes x et y
            this.emotionCourante.seDeplacer(this, monde);
        } else {
            System.out.println(this.nom + " : Je ne ressens rien, je ne bouge pas.");
        }
    }

    // Méthode pour changer mon émotion active
    public void changerEmotion(Emotion nouvelleEmotion) {
        this.emotionCourante = nouvelleEmotion;
        System.out.println(this.nom + " ressent maintenant : " + nouvelleEmotion.getNom());
    }

    // Pour débloquer une nouvelle émotion dans mon inventaire
    public void ajouterEmotion(Emotion e) {
        this.emotionsDebloquees.add(e);
    }

    // --- Actions physiques (utilisées par la classe Emotion) ---

    // Exemple simple pour avancer (à adapter selon la direction)
    public void avancer(int nombreDeCases) {
        this.x = this.x + nombreDeCases; 
        System.out.println(this.nom + " avance vers la case [" + x + ", " + y + "]");
    }
    
    // Pour téléporter le robot directement (utile pour le Monde)
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Accesseurs (pour savoir où je suis)
    public int getX() { return x; }
    public int getY() { return y; }
    public String getNom() { return nom; }
    
    // Le joueur utilise cette méthode pour répondre à l'énigme de la pièce actuelle
    public void tenterReponse(Monde monde, String maReponse) {
        // 1. Je récupère la pièce où je suis
        Piece pieceActuelle = monde.getPiece(this.x, this.y);

        // 2. Y a-t-il une énigme ici ?
        if (pieceActuelle.aUneEnigme()) {
            Enigme e = pieceActuelle.getEnigme();
            
            // 3. Je vérifie la réponse
            if (e.verifierReponse(maReponse)) {
                System.out.println("BRAVO ! Bonne réponse !");
                
                // AUTOMATISATION : Je gagne l'émotion et je l'équipe tout de suite
                Emotion gain = e.getRecompense();
                this.ajouterEmotion(gain);
                this.changerEmotion(gain); // Hop, c'est automatique !
                
                // On peut supprimer l'énigme pour ne pas la refaire
                pieceActuelle.setEnigme(null); 
            } else {
                System.out.println("Mauvaise réponse... Essayez encore.");
            }
        } else {
            System.out.println("Il n'y a pas d'énigme ici.");
        }
    }
    public void combattre(Monstre m) {
        System.out.println("--- COMBAT CONTRE " + m.getNom() + " ---");
        
        int maForce = 1; 
        if (emotionCourante != null) {
            maForce = 3 + emotionCourante.getBonusVitesse();
        }

        if (maForce >= m.getForce()) {
            System.out.println("Victoire ! Vous avez écrasé le monstre !");
        } else {
            System.out.println("Aïe ! Le monstre est trop fort !");
            this.pointsDeVie = this.pointsDeVie - m.getForce();
            System.out.println("Il vous reste " + pointsDeVie + " PV.");
        }
    }
}