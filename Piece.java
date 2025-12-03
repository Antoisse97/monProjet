/**
 * Décrivez votre classe Piece ici.
 *
 * @author Sofia Kadiri
 * @version 1.0
 */
public class Piece {
    // --- ATTRIBUTS ---
    private String nom;
    private boolean estUnMur;
    private Enigme enigme;
    private Monstre monstre; 

    // --- CONSTRUCTEUR ---
    public Piece(String nom, boolean estUnMur) {
        this.nom = nom;
        this.estUnMur = estUnMur;
        this.enigme = null;
        this.monstre = null; 
    }

    // --- GESTION DES MONSTRES ---
    public void setMonstre(Monstre m) {
        this.monstre = m;
    }

    public boolean aUnMonstre() {
        return this.monstre != null;
    }

    public Monstre getMonstre() {
        return this.monstre;
    }
    
    // --- AUTRES METHODES ---
    public boolean estAccessible() { 
        return !this.estUnMur; 
    }
    
    // Gestion Enigmes
    public void setEnigme(Enigme e) { this.enigme = e; }
    public boolean aUneEnigme() { return this.enigme != null; }
    public Enigme getEnigme() { return this.enigme; }
    
    // Accesseurs
    public String getNom() { return this.nom; }
}