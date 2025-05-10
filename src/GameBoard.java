import java.util.*;

public class GameBoard {

    private final int rows, cols, titleSize;
    private final Set<GameEntity> walls = new HashSet<>();
    private final Set<GameEntity> foods = new HashSet<>();
    private final Set<GameEntity> ghosts = new HashSet<>();
    private final PacMan pacman;

    private int score = 0;
    private int lives = 3;
    private boolean gameOver = false;
    private int scaredTimer = 0;

    
    private final String[] layout = {
        "XXXXXXXXXXXXXXXXXXX",
        "X        X  s     X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "X   X       X X   X",
        "X X X XXrXX X X X X",
        "X       P         X",
        "X X X XXXXX X X X X",
        "X   X       X X   X",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     p     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX"
    };


    public GameBoard(int rows, int cols, int titleSize){
        this.rows = rows;
        this.cols = cols;
        this.titleSize = titleSize;
        pacman = new PacMan(titleSize, titleSize, titleSize);
        loadMap();
    }

    public void loabMap(){
        
    }
    
}
