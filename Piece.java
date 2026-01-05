<<<<<<< HEAD
import java.util.List;
import java.util.ArrayList;

public class Piece {
    private String nom;
    private List<Porte> portes;
    private List<Robot> robots;
    private List<Souvenir> souvenirs;
    private List<Enigme> enigmes;
    private List<Monstre> monstres;
    private String imagePath; // Chemin vers l'image de la pièce
    
    public Piece(String nom, String imagePath) {
        this.nom = nom;
        this.imagePath = imagePath;
        this.portes = new ArrayList<>();
        this.robots = new ArrayList<>();
        this.souvenirs = new ArrayList<>();
        this.enigmes = new ArrayList<>();
        this.monstres = new ArrayList<>();
=======
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
>>>>>>> febba460dc9873a7c55e907095746ef3db3ffbc7
    }
<<<<<<< HEAD
    
    public void ajouterSortie(Piece destination) {
        Porte nouvellePorte = new Porte(destination);
        portes.add(nouvellePorte);
    }
    
    public void ajouterPorte(Porte porte) {
        portes.add(porte);
    }
    
    public void ajouterEnigme(Enigme enigme) {
        enigmes.add(enigme);
    }
    
    public void ajouterMonstre(Monstre monstre) {
        monstres.add(monstre);
    }
    
    public void afficherDescription() {
        System.out.println("=== " + nom + " ===");
        System.out.println("Image: " + imagePath);
        System.out.println("Portes disponibles: " + portes.size());
        System.out.println("Énigmes: " + enigmes.size());
        System.out.println("Monstres: " + monstres.size());
    }
    
    // Getters
    public String getNom() {
        return nom;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public List<Porte> getPortes() {
        return portes;
    }
    
    public List<Robot> getRobots() {
        return robots;
    }
    
    public List<Souvenir> getSouvenirs() {
        return souvenirs;
    }
    
    public List<Enigme> getEnigmes() {
        return enigmes;
    }
    
    public List<Monstre> getMonstres() {
        return monstres;
=======

    // --- GESTION DES MONSTRES ---
    public void setMonstre(Monstre m) {
        this.monstre = m;
>>>>>>> febba460dc9873a7c55e907095746ef3db3ffbc7
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