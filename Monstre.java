
/**
 * Décrivez votre classe Monstre ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Monstre {
    private String nom;
    private int force; 

    public Monstre(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() { return nom; }
    public int getForce() { return force; }
}