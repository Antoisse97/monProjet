
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
    }

    // Vérifie si la réponse du joueur est bonne (ignorer majuscules/minuscules)
    public boolean verifierReponse(String proposition) {
        return this.reponseAttendue.equalsIgnoreCase(proposition);
    }

    public String getQuestion() { return question; }
    public Emotion getRecompense() { return emotionRecompense; }
}