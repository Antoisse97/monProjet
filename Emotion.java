public abstract class Emotion {
    protected String nom;
    protected String couleur;
    protected int effetVitesse;
    
    public Emotion(String nom, String couleur, int effetVitesse) {
        this.nom = nom;
        this.couleur = couleur;
        this.effetVitesse = effetVitesse;
    }
    
    // Méthode abstraite que chaque émotion doit implémenter
    public abstract void seDeplacer(Robot robot, Monde monde);
    
    public String getNom() {
        return nom;
    }
    
    public String getCouleur() {
        return couleur;
    }
    
    public int getEffetVitesse() {
        return effetVitesse;
    }
}

// ==================== ANXIÉTÉ (État de base) ====================
class Anxiete extends Emotion {
    public Anxiete() {
        super("Anxiété", "Orange", 1);
    }
    
    @Override
    public void seDeplacer(Robot robot, Monde monde) {
        // Anxiété est l'état de base, déplacement normal
        robot.setCouleur(this.couleur);
        System.out.println(robot.getNom() + " (Anxiété) se déplace normalement - Couleur: Orange");
        
        // Logique de déplacement basique
        Cellule positionActuelle = robot.getPosition();
        // Le robot avance d'une case
    }
}

// ==================== JOIE ====================
class Joie extends Emotion {
    public Joie() {
        super("Joie", "Jaune", 1);
    }
    
    @Override
    public void seDeplacer(Robot robot, Monde monde) {
        robot.setCouleur(this.couleur);
        System.out.println(robot.getNom() + " (Joie) tourne en avançant joyeusement ! - Couleur: Jaune");
        
        // Joie tourne en avançant (rotation + avancement)
        robot.tournerEtAvancer();
    }
}

// ==================== TRISTESSE ====================
class Tristesse extends Emotion {
    public Tristesse() {
        super("Tristesse", "Bleu", -1); // Vitesse réduite
    }
    
    @Override
    public void seDeplacer(Robot robot, Monde monde) {
        robot.setCouleur(this.couleur);
        robot.setVitesse(0); // Très lent
        System.out.println(robot.getNom() + " (Tristesse) avance très lentement... - Couleur: Bleu");
        
        // Déplacement très lent (peut-être une case tous les 2 tours)
    }
}

// ==================== COLÈRE ====================
class Colere extends Emotion {
    public Colere() {
        super("Colère", "Rouge", 2); // Vitesse doublée
    }
    
    @Override
    public void seDeplacer(Robot robot, Monde monde) {
        robot.setCouleur(this.couleur);
        robot.setVitesse(2); // Déplacement rapide
        System.out.println(robot.getNom() + " (Colère) fonce rapidement - 2 cases à la fois ! - Couleur: Rouge");
        
        // Le robot avance de 2 cases d'un coup
        Cellule positionActuelle = robot.getPosition();
        // Logique pour avancer de 2 cases
    }
}

// ==================== DÉGOÛT ====================
class Degout extends Emotion {
    public Degout() {
        super("Dégoût", "Vert", 0);
    }
    
    @Override
    public void seDeplacer(Robot robot, Monde monde) {
        robot.setCouleur(this.couleur);
        System.out.println(robot.getNom() + " (Dégoût) hésite... - Couleur: Vert");
        
        // 1 chance sur 2 de revenir à zéro (position initiale)
        if (Math.random() < 0.5) {
            System.out.println("Dégoût ! " + robot.getNom() + " revient à la case départ !");
            robot.revenirPositionInitiale();
            
            // Remet la cellule à zéro
            if (robot.getPosition() != null) {
                robot.getPosition().revenirAZero();
            }
        } else {
            System.out.println(robot.getNom() + " avance malgré le dégoût.");
            // Déplacement normal
        }
    }
}

// ==================== NOSTALGIE ====================
class Nostalgie extends Emotion {
    public Nostalgie() {
        super("Nostalgie", "Marron", 1);
    }
    
    @Override
    public void seDeplacer(Robot robot, Monde monde) {
        robot.setCouleur(this.couleur);
        System.out.println(robot.getNom() + " (Nostalgie) se souvient du passé... - Couleur: Marron");
        
        // Nostalgie donne accès aux souvenirs
        System.out.println("Accès aux souvenirs débloqué !");
        
        // Afficher les souvenirs disponibles dans la pièce actuelle
        if (monde != null) {
            Piece pieceActuelle = trouverPieceActuelle(robot, monde);
            if (pieceActuelle != null && !pieceActuelle.getSouvenirs().isEmpty()) {
                System.out.println("=== Souvenirs disponibles ===");
                for (Souvenir souvenir : pieceActuelle.getSouvenirs()) {
                    souvenir.afficher();
                }
            }
        }
    }
    
    private Piece trouverPieceActuelle(Robot robot, Monde monde) {
        // Trouve la pièce où se trouve le robot
        for (Piece piece : monde.getPieces()) {
            if (piece.getRobots().contains(robot)) {
                return piece;
            }
        }
        return null;
    }
}