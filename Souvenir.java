public class Souvenir {
    private String description;
    private String cle; // Clé unique pour identifier le souvenir
    
    public Souvenir(String description, String cle) {
        this.description = description;
        this.cle = cle;
    }
    
    public void afficher() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║         SOUVENIR                    ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ " + description);
        System.out.println("╚════════════════════════════════════╝");
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getCle() {
        return cle;
    }
}