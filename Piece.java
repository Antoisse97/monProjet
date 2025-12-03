
/**
 * Décrivez votre classe Piece ici.
 *
 * @author Sofia Kadiri
 * @version 1.0
 */
public class Piece {
    private String nom;
    private boolean estUnMur;
    private Enigme enigme;
    private Monstre monstre; // NOUVEAU : La pièce peut avoir un monstre

    public Piece(String nom, boolean estUnMur) {
        this.nom = nom;
        this.estUnMur = estUnMur;
        this.enigme = null;
        this.monstre = null; // Par défaut, pas de monstre
    }

    // --- Gestion des Monstres (NOUVEAU) ---
    public void setMonstre(Monstre m) {
        this.monstre = m;
    }

    public boolean aUnMonstre() {
        return this.monstre != null;
    }

    public Monstre getMonstre() {
        return this.monstre;
    }
    
    // --- Tes méthodes existantes ---
    public boolean estAccessible() { return !this.estUnMur; }
    
    public void setEnigme(Enigme e) { this.enigme = e; }
    public boolean aUneEnigme() { return this.enigme != null; }
    public Enigme getEnigme() { return this.enigme; }
    public String getNom() { return this.nom; }
}