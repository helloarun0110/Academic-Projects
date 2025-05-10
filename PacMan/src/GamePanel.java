import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private final GameBoard board;
    private final Timer timer;

    public GamePanel(int rows, int cols, int tileSize){
        setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);


        board = new GameBoard(rows, cols, tileSize);
        timer = new Timer(50,this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        board.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        board.update();
        repaint();
        if (board.isGameOver()) timer.stop();
    }

    @Override
    public void keyPressed(KeyEvent e){
        board.handleKeyPress(e);
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
