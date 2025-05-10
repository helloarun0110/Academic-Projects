import java.awt.*;
import javax.swing.ImageIcon;


public class PacMan extends GameEntity {
   
       private int dx, dy = 0;
    private Image[] pacmanImages = new Image[4];
    private  boolean imagesLoaded = false;

    public PacMan(int x, int y, int size){
        super(x, y, size);
        loadImages();
    }

    private Image scaleImage(Image original){
    return original.getScaledInstance(size, size, Image.SCALE_SMOOTH);
}

    private void loadImages(){
        pacmanImages[0] = scaleImage(new ImageIcon("images/pacmanRight.png").getImage());
        pacmanImages[1] = scaleImage(new ImageIcon("images/pacmanLeft.png").getImage());
        pacmanImages[2] = scaleImage(new ImageIcon("images/pacmanUp.png").getImage());
        pacmanImages[3] = scaleImage (new ImageIcon("images/pacmanDown.png").getImage());

        imagesLoaded = true;
    }
    

    public void setDirection(char dir){
        switch(dir){
            case 'U' -> { dx = 0; dy = -size / 4;}
            case 'D' -> {dx = 0; dy = size / 4;}
            case 'L' -> {dy = 0; dx = -size / 4;}
            case 'R' -> {dy = 0; dx = size / 4;}
        }
    }

    public void move(){
        oldX = x;
        oldY = y;
        x += dx;
        y += dy;
    }

    public void undo(){
        x = oldX;
        y = oldY;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
    }

    public void reset(){
        x = oldX;
        y = oldY;

    }


    private void drawWithImages(Graphics g){
        if(dx > 0){
            g.drawImage(pacmanImages[0], x, y, null);
        }
        else if(dx < 0){
            g.drawImage(pacmanImages[1], x, y, null);
        }
        else if(dy < 0){
            g.drawImage(pacmanImages[2], x, y, null);
        }
        else if(dy > 0){
            g.drawImage(pacmanImages[3], x, y, null);
        }
    }

    public void draw(Graphics g){
        if(imagesLoaded){
            drawWithImages(g);
        }
        else{
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, size, size);
        }
    }

}
