public class Enigme {
    private String question;
    private String reponse;
    private boolean resolue;
    
    public Enigme(String question, String reponse) {
        this.question = question;
        this.reponse = reponse;
        this.resolue = false;
    }
    
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
    }
}