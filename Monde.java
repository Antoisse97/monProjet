import java.util.List;
import java.util.ArrayList;

public class Monde {
    private List<Piece> pieces;
    private List<Robot> robots;
    private Carte carte;
    
    public Monde() {
        this.pieces = new ArrayList<>();
        this.robots = new ArrayList<>();
        this.carte = new Carte(10, 10); // Grille par défaut 10x10
    }
    
    public void deplacerTous() {
        for (Robot robot : robots) {
            if (!robot.isControleParJoueur()) {
                robot.seDeplacer(this);
            }
        }
    }
    
    public void ajouterPiece(Piece piece) {
        pieces.add(piece);
    }
    
    public void ajouterRobot(Robot robot) {
        robots.add(robot);
    }
    
    public void initialiserMonde() {
        // Création des pièces principales du quartier général
        Piece sallePrincipale = new Piece("Salle Principale", "images/salle_principale.png");
        Piece salleSouvenirs = new Piece("Salle des Souvenirs", "images/salle_souvenirs.png");
        Piece labyrinthe = new Piece("Labyrinthe des Émotions", "images/labyrinthe.png");
        
        // Ajout des pièces au monde
        ajouterPiece(sallePrincipale);
        ajouterPiece(salleSouvenirs);
        ajouterPiece(labyrinthe);
        
        // Création des liens entre pièces
        sallePrincipale.ajouterSortie(salleSouvenirs);
        sallePrincipale.ajouterSortie(labyrinthe);
        
        System.out.println("Monde initialisé avec " + pieces.size() + " pièces.");
    }
    
    public List<Piece> getPieces() {
        return pieces;
    }
    
    public List<RobotEmotion> getRobots() {
        return robots;
    }
    
    public Carte getCarte() {
        return carte;
    }
}