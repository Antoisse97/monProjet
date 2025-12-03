
/**
 * Décrivez votre classe Piece ici.
 *
 * @author Sofia Kadiri
 * @version 1.0
 */
public class Piece {
    // --- 1. DÉCLARATION DES ATTRIBUTS ---
    // Il faut déclarer ces variables ici pour que "this.nom" existe
    private String nom;
    private boolean estUnMur;
    private Enigme enigme; // L'ajout pour le jeu

    // --- 2. CONSTRUCTEUR ---
    public Piece(String nom, boolean estUnMur) {
        this.nom = nom;
        this.estUnMur = estUnMur;
        this.enigme = null; // Par défaut, la pièce est vide d'énigme
    }

    // --- 3. MÉTHODES ---

    // Est-ce qu'on peut marcher ici ?
    public boolean estAccessible() {
        return !this.estUnMur; 
    }

    // Gestion des énigmes
    public void setEnigme(Enigme e) {
        this.enigme = e;
    }

    public boolean aUneEnigme() {
        return this.enigme != null;
    }

    public Enigme getEnigme() {
        return this.enigme;
    }

    // Accesseur simple
    public String getNom() {
        return this.nom;
    }
}