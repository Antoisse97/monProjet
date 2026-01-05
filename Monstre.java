public class Monstre {
    private String nom;
    private int pointsDeVie;
    private int force;
    
    public Monstre(String nom, int pointsDeVie, int force) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.force = force;
    }
    
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
}