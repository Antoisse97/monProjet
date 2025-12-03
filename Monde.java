
/**
 * Décrivez votre classe Monde ici.
 *
 * @author (caleb)
 * @version (un numéro de version ou une date)
 */
public class Monde {
    // Je crée une matrice (tableau à 2 dimensions) pour faire la grille
    // [y] (lignes) et [x] (colonnes)
    private Piece[][] grille;
    private int tailleX = 10; // Largeur arbitraire (à ajuster selon ton dessin)
    private int tailleY = 10; // Hauteur arbitraire

    public Monde() {
        this.grille = new Piece[tailleX][tailleY];
        this.initialiserCarte();
    }

    // C'est ici que je construis ton labyrinthe
    private void initialiserCarte() {
        // 1. D'abord, on remplit tout de vide
        for (int x = 0; x < tailleX; x++) {
            for (int y = 0; y < tailleY; y++) {
                grille[x][y] = new Piece("Couloir", false);
            }
        }

        // --- 2. CRÉATION DES ÉMOTIONS À GAGNER ---
        Emotion colere = new Emotion("Colère", "Rouge", 2);
        Emotion joie = new Emotion("Joie", "Jaune", 1);
        Emotion tristesse = new Emotion("Tristesse", "Bleu", 1);

        // --- 3. CRÉATION ET PLACEMENT DES ÉNIGMES ---
        
        // SCÉNARIO 1 : La salle de la Colère (en x=2, y=2)
        Piece salleColere = grille[2][2];
        Enigme enigmeColere = new Enigme(
            "Je deviens tout rouge quand ça ne va pas. Qui suis-je ?", // La question
            "Colère",                                                  // La réponse
            colere                                                     // La récompense
        );
        salleColere.setEnigme(enigmeColere);
        // On peut renommer la pièce pour s'y retrouver
        // (Note: il faudrait ajouter un setter pour le nom dans Piece, sinon ce n'est pas grave)
        
        // SCÉNARIO 2 : La salle de la Joie (en x=5, y=0)
        Piece salleJoie = grille[5][0];
        Enigme enigmeJoie = new Enigme(
            "Quelle est la couleur du soleil dans les dessins d'enfants ?", 
            "Jaune", 
            joie
        );
        salleJoie.setEnigme(enigmeJoie);

        // --- 4. PLACEMENT DES MURS (Pour faire un labyrinthe) ---
        // Exemple : Un mur juste devant le départ pour forcer un détour
        grille[1][0] = new Piece("Mur", true); 
        grille[1][1] = new Piece("Mur", true);
        grille[3][3] = new Piece("Mur", true);
        
        // --- 5. L'OBJECTIF FINAL (Le Souvenir) ---
        // On le place loin, par exemple en (9, 9)
        // Pour l'instant c'est juste une pièce nommée "Souvenir"
        grille[9][9] = new Piece("SOUVENIR FINAL", false);
    }

    // La méthode CRUCIALE : Le robot demandera "Est-ce que je peux aller là ?"
    public boolean verifierDeplacement(int x, int y) {
        // 1. Je vérifie qu'on ne sort pas du tableau (sinon bug !)
        if (x < 0 || x >= tailleX || y < 0 || y >= tailleY) {
            return false; // Hors limites
        }
        // 2. Je regarde si la case est un mur
        return grille[x][y].estAccessible();
    }
    
    // Pour récupérer le nom de la pièce où se trouve le robot
    public Piece getPiece(int x, int y) {
        if (x >= 0 && x < tailleX && y >= 0 && y < tailleY) {
            return grille[x][y];
        }
        return null;
    }
    
    // Il faut bien le mot PUBLIC devant pour le voir dans BlueJ
    public void afficher(Robot robot) {
        for (int y = 0; y < tailleY; y++) {
            for (int x = 0; x < tailleX; x++) {
                if (robot.getX() == x && robot.getY() == y) {
                    System.out.print(" R ");
                } else if (!grille[x][y].estAccessible()) {
                    System.out.print("###"); // Mur
                } else if (grille[x][y].aUnMonstre()) {
                    System.out.print(" M "); // Monstre (si tu l'as ajouté)
                } else if (grille[x][y].aUneEnigme()) {
                    System.out.print(" ? "); // Enigme
                } else {
                    System.out.print(" . "); // Vide
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}