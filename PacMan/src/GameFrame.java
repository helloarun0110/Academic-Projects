import javax.swing.*;

public class GameFrame extends JFrame {

    private final int tileSize = 32;
    private final int rows = 21;
    private final int cols = 19;

    public GameFrame(){
        setTitle("Pac-Man");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel panel = new GamePanel(rows, cols, tileSize);
        add(panel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

        panel.requestFocusInWindow();
        
    }

    public void start(){}
    
}
