import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Canvas {
    private JFrame frame;
    private MyPanel panel;
    private int tailleCase = 40; // Taille d'une case en pixels (zoom)
    private int largeur, hauteur;

    public Canvas(int nbCasesX, int nbCasesY) {
        this.largeur = nbCasesX;
        this.hauteur = nbCasesY;
        frame = new JFrame("Vice Versa - Le Jeu");
        panel = new MyPanel();
        
        // Taille de la fenêtre calculée automatiquement
        panel.setPreferredSize(new Dimension(nbCasesX * tailleCase, nbCasesY * tailleCase));
        
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    // Méthode pour tout effacer et redessiner la grille
    public void dessinerMonde(Monde monde, Robot robot) {
        panel.setDonnees(monde, robot);
        panel.repaint(); // Demande à la fenêtre de se rafraîchir
    }

    // Classe interne pour gérer le dessin (Swing)
    private class MyPanel extends JPanel {
        private Monde monde;
        private Robot robot;

        public void setDonnees(Monde m, Robot r) {
            this.monde = m;
            this.robot = r;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (monde == null) return;

            // 1. DESSINER LA CARTE
            for (int x = 0; x < largeur; x++) {
                for (int y = 0; y < hauteur; y++) {
                    Piece p = monde.getPiece(x, y);
                    
                    // Couleur par défaut (vide)
                    g.setColor(Color.WHITE); 
                    
                    // Gestion des couleurs selon le type
                    if (!p.estAccessible()) g.setColor(Color.DARK_GRAY); // Mur
                    else if (p.aUneEnigme()) g.setColor(Color.CYAN);     // Enigme
                    else if (p.aUnMonstre()) g.setColor(Color.RED);      // Monstre
                    
                    // Dessin du carré
                    g.fillRect(x * tailleCase, y * tailleCase, tailleCase, tailleCase);
                    
                    // Bordure noire pour la grille
                    g.setColor(Color.BLACK);
                    g.drawRect(x * tailleCase, y * tailleCase, tailleCase, tailleCase);
                }
            }

            // 2. DESSINER LE ROBOT
            if (robot != null) {
                g.setColor(Color.ORANGE); // Couleur du robot
                g.fillOval(robot.getX() * tailleCase + 5, robot.getY() * tailleCase + 5, tailleCase - 10, tailleCase - 10);
            }
        }
    }
}