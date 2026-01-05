public class Porte {
    private Piece destination;
    private Amelioration effet;
    private int requeteEmotions; // Nombre d'émotions requises pour ouvrir
    
    public Porte(Piece destination) {
        this.destination = destination;
        this.effet = null;
        this.requeteEmotions = 0;
    }
    
    public Porte(Piece destination, Amelioration effet, int requeteEmotions) {
        this.destination = destination;
        this.effet = effet;
        this.requeteEmotions = requeteEmotions;
    }
    
    public void ouvrir(Robot robot) {
        if (robot.getEmotionsDebloquees().size() >= requeteEmotions) {
            System.out.println("La porte s'ouvre vers " + destination.getNom());
            
            if (effet != null) {
                effet.appliquer(robot);
            }
        } else {
            System.out.println("Il faut " + requeteEmotions + " émotions pour ouvrir cette porte.");
        }
    }
    
    public Piece getDestination() {
        return destination;
    }
    
    public void setDestination(Piece destination) {
        this.destination = destination;
    }
    
    public Amelioration getEffet() {
        return effet;
    }
    
    public void setEffet(Amelioration effet) {
        this.effet = effet;
    }
    
    public int getRequeteEmotions() {
        return requeteEmotions;
    }
    
    public void setRequeteEmotions(int requeteEmotions) {
        this.requeteEmotions = requeteEmotions;
    }
}