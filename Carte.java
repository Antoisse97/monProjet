public class Carte {
    private Cellule[][] grille;
    private int largeur;
    private int hauteur;
    
    public Carte(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.grille = new Cellule[hauteur][largeur];
        initialiserGrille();
    }
    
    private void initialiserGrille() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grille[i][j] = new Cellule(CellType.VIDE);
            }
        }
    }
    
    public boolean estAccessible(int x, int y) {
        if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
            return false;
        }
        CellType type = grille[y][x].getType();
        return type != CellType.OBSTACLE;
    }
    
    public Cellule getCellule(int x, int y) {
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            return grille[y][x];
        }
        return null;
    }
    
    public int getLargeur() {
        return largeur;
    }
    
    public int getHauteur() {
        return hauteur;
    }
}