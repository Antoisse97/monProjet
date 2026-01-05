<<<<<<< HEAD
public class Enigme {
    private String question;
    private String reponse;
    private boolean resolue;
    
    public Enigme(String question, String reponse) {
        this.question = question;
        this.reponse = reponse;
        this.resolue = false;
=======

/**
 * Décrivez votre classe Enigme ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Enigme {
    private String question;
    private String reponseAttendue;
    private Emotion emotionRecompense; // L'émotion qu'on gagne

    public Enigme(String question, String reponseAttendue, Emotion emotionRecompense) {
        this.question = question;
        this.reponseAttendue = reponseAttendue;
        this.emotionRecompense = emotionRecompense;
>>>>>>> febba460dc9873a7c55e907095746ef3db3ffbc7
    }
<<<<<<< HEAD
    
    public boolean verifier(String reponseJoueur) {
        if (reponseJoueur.trim().equalsIgnoreCase(reponse.trim())) {
            resolue = true;
            System.out.println("Bravo ! Énigme résolue !");
            return true;
        } else {
            System.out.println("Ce n'est pas la bonne réponse...");
            return false;
        }
    }
    
    public void poser() {
        if (!resolue) {
            System.out.println("ÉNIGME : " + question);
        } else {
            System.out.println("Cette énigme a déjà été résolue.");
        }
    }
    
    public String getQuestion() {
        return question;
    }
    
    public boolean isResolue() {
        return resolue;
    }
    
    public void setResolue(boolean resolue) {
        this.resolue = resolue;
=======

    // Vérifie si la réponse du joueur est bonne (ignorer majuscules/minuscules)
    public boolean verifierReponse(String proposition) {
        return this.reponseAttendue.equalsIgnoreCase(proposition);
>>>>>>> febba460dc9873a7c55e907095746ef3db3ffbc7
    }

    public String getQuestion() { return question; }
    public Emotion getRecompense() { return emotionRecompense; }
}