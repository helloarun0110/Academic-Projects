import java.awt.*;
import java.util.Random;
import java.util.Set;
import javax.swing.ImageIcon;



public class Ghost extends GameEntity {

        private int dx = 0, dy = 0;
    private  final Random rand = new Random();
    private Image normalImage;
    private Image scaredImage;
    private boolean isScared = false;
    private GhostColor ghostColor;
    private boolean imagesLoaded = false;
    private int scaredTimer = 0;

    public  enum GhostColor{
        RED, PINK, SCARED
    }

    public Ghost(int x, int y, int size, GhostColor color){
        super(x, y, size);
        this.ghostColor = color;
        loadImages();
        setRandomDirection();

        if (color == GhostColor.SCARED){
            setScared(true);
        }
    }


    private Image scaleImage(Image original){

        return original.getScaledInstance(size, size, Image.SCALE_SMOOTH);
}

    private void loadImages(){
        if(ghostColor == GhostColor.SCARED){
            scaredImage = scaleImage( new ImageIcon("images/scaredGhost.png").getImage());
            normalImage = scaredImage;
        }
        else{
            String colorName = ghostColor.name().toLowerCase();
            normalImage = scaleImage(new ImageIcon("images/" + colorName + "Ghost.png").getImage());

            scaredImage = scaleImage(new ImageIcon("images/scaredGhost.png").getImage());
        }

        imagesLoaded = true;

    }
    

    public void draw(Graphics g){
        if(imagesLoaded){
            if(ghostColor == GhostColor.SCARED){
                g.drawImage(scaredImage, x, y, null);
            }
            else{
                g.drawImage(isScared ? scaredImage : normalImage, x, y, null);
            }
        }
    }


    public void setScared(boolean scared){
        if (ghostColor != GhostColor.SCARED){
            this.isScared = scared;
            if (scared){
                scaredTimer = 400;
            }
        }
    }


    public void update(){
        if (scaredTimer > 0){
            scaredTimer--;
            if(scaredTimer == 0){
                isScared = false;
            }
        }
    }

    public boolean isScared(){
        return isScared || ghostColor == GhostColor.SCARED;
    }


    public void setRandomDirection(){
        switch(rand.nextInt(4)){
            case 0 -> { dx = 0; dy = -size / 4; } 
            case 1 -> { dx = 0; dy = size / 4; }  
            case 2 -> { dx = -size / 4; dy = 0; }
            case 3 -> { dx = size / 4; dy = 0; }  
        }
    }

    public void move(Set<GameEntity> walls){
        oldX = x;
        oldY = y;
        x += dx;
        y += dy;

        for (GameEntity wall: walls){
            if (this. collidesWith(wall)){
                x = oldX;
                y = oldY;
                setRandomDirection();
                break;
            }
        }
    }


    public void reset(){
        x = oldX;
        y = oldY;
        setRandomDirection();
        if(ghostColor != GhostColor.SCARED){
            isScared = false;
            scaredTimer = 0;
        }
    }

    public GhostColor geColor(){
        return ghostColor;
    }
    
}
