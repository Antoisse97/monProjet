

public class Cellule {
    private CellType type;
    private Porte porte;
    private Piece piece;
    
    public Cellule(CellType type) {
        this.type = type;
        this.porte = null;
        this.piece = null;
    }
    
    public void revenirAZero() {
        this.porte = null;
        this.piece = null;
    }
    
    public CellType getType() {
        return type;
    }
    
    public Porte getPorte() {
        return porte;
    }
    
    public void setPorte(Porte porte) {
        this.porte = porte;
    }
    
    public Piece getPiece() {
        return piece;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}

enum CellType {
    VIDE, PORTE, PIECE, OBSTACLE
}