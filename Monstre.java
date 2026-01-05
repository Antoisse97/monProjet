<<<<<<< HEAD
public class Monstre {
    private String nom;
    private int pointsDeVie;
    private int force;
    
    public Monstre(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
=======

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
>>>>>>> febba460dc9873a7c55e907095746ef3db3ffbc7
        this.force = force;
    }
<<<<<<< HEAD
    
    public void attaquer(Robot robot) {
        System.out.println(nom + " attaque " + robot.getNom() + " !");
        robot.setVie(robot.getVie() - force);
        System.out.println(robot.getNom() + " perd " + force + " points de vie.");
    }
    
    public void subirDegats(int valeur) {
        pointsDeVie -= valeur;
        System.out.println(nom + " subit " + valeur + " dégâts. PV restants : " + pointsDeVie);
        
        if (pointsDeVie <= 0) {
            System.out.println(nom + " est vaincu !");
        }
    }
    
    public boolean estVaincu() {
        return pointsDeVie <= 0;
    }
    
    public String getNom() {
        return nom;
    }
    
    public int getPointsDeVie() {
        return pointsDeVie;
    }
    
    public int getForce() {
        return force;
    }
=======

    public String getNom() { return nom; }
    public int getForce() { return force; }
>>>>>>> febba460dc9873a7c55e907095746ef3db3ffbc7
}