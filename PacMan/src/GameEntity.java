import java.awt.*;
import javax.swing.ImageIcon;

public class GameEntity {
    protected int x, y, size, oldX, oldY;
    protected Image image;

    public GameEntity(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
        this.oldX = x;
        this.oldY = y;

    }

    public void setImage(String path){
        ImageIcon icon = new ImageIcon(path);
        this.image = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
    }

    public void draw(Graphics g){
        if (image != null){
            g.drawImage(image, x, y, null);
        }
    }

    public boolean collidesWith(GameEntity other){
        return x < other.x + other. size && x + size >other.x && y < other.y + other.size && y + size > other.y;
    }

    
}
