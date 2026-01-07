import java.util.ArrayList;

/**
 * Décrivez votre classe Robot ici.
 *
 * @author Sofia Kadiri
 * @version 1.0
 */
public class Robot {
    // --- ATTRIBUTS ---
    private String nom;
    private int x; // Ma position ligne
    private int y; // Ma position colonne
    private Emotion emotionCourante; // L'émotion qui me contrôle en ce moment
    private ArrayList<Emotion> emotionsDebloquees; // Mon sac à dos d'émotions
    private int pointsDeVie;

    // --- CONSTRUCTEUR ---
    public Robot(String nom, int xDepart, int yDepart) {
        this.nom = nom;
        this.x = xDepart;
        this.y = yDepart;
        this.emotionsDebloquees = new ArrayList<Emotion>();
        this.emotionCourante = null; // Au début, je n'ai pas d'émotion active
        this.pointsDeVie = 100; // Je commence avec 100 PV
    }

    // --- DEPLACEMENT ---
    public void seDeplacer(Monde monde) {
        if (this.emotionCourante != null) {
            // Je me donne moi-même ("this") à l'émotion pour qu'elle modifie mes x et y
            this.emotionCourante.seDeplacer(this, monde);
        } else {
            System.out.println(this.nom + " : Je ne ressens rien, je ne bouge pas.");
        }
    }
    
    // --- DÉPLACEMENT MANUEL (POUR ANXIÉTÉ) --- 
    /**
     * Permet au joueur de contrôler directement le robot
     * @param direction "haut", "bas", "gauche", "droite"
     * @param monde Le monde du jeu pour vérifier les collisions
     */
    
    public void deplacerManuellement(String direction, Monde monde) {
        int nouveauX = this.x; 
        int nouveauY = this.y;
    }
    // --- GESTION EMOTIONS ---
    public void changerEmotion(Emotion nouvelleEmotion) {
        this.emotionCourante = nouvelleEmotion;
        System.out.println(this.nom + " ressent maintenant : " + nouvelleEmotion.getNom());
    }

    public void ajouterEmotion(Emotion e) {
        this.emotionsDebloquees.add(e);
    }

    // --- ACTIONS PHYSIQUES ---
    // Exemple simple pour avancer (utilisé parfois par Emotion)
    public void avancer(int nombreDeCases) {
        this.x = this.x + nombreDeCases; 
        System.out.println(this.nom + " avance vers la case [" + x + ", " + y + "]");
    }
    
    // Pour téléporter le robot directement
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // --- ACCESSEURS ---
    public int getX() { return x; }
    public int getY() { return y; }
    public String getNom() { return nom; }
    
    // --- JEU : ENIGMES ---
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
                this.changerEmotion(gain); 
                
                // On supprime l'énigme résolue
                pieceActuelle.setEnigme(null); 
            } else {
                System.out.println("Mauvaise réponse... Essayez encore.");
            }
        } else {
            System.out.println("Il n'y a pas d'énigme ici.");
        }
    }

    // --- JEU : COMBAT ---
    public void combattre(Monstre m) {
        System.out.println("--- COMBAT CONTRE " + m.getNom() + " ---");
        
        // J'ai corrigé l'erreur ici :
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
            
            if (this.pointsDeVie <= 0) {
                System.out.println("GAME OVER... Robot détruit.");
            }
        }
    }
    
    
}