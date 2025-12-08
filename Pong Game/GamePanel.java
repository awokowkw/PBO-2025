import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 600;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Paddle player1, player2;
    Ball ball;
    int player1Score = 0;
    int player2Score = 0;
    boolean gameStart = false;
    int speedIncrease = 1;
    int maxSpeed = 10;
    
    public GamePanel() {
        player1 = new Paddle(0, (GAME_HEIGHT/2)-50);
        player2 = new Paddle(GAME_WIDTH-20, (GAME_HEIGHT/2)-50);
        ball = new Ball((GAME_WIDTH/2)-15, (GAME_HEIGHT/2)-15);
        ball.reset();
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(new AL());
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        draw(g);
    }

    
    public void draw(Graphics g) {
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Player 1: " + player1Score, 50, 50);
        g.drawString("Player 2: " + player2Score, GAME_WIDTH - 200, 50);
    
        if (!gameStart) {
            g.drawString("Press ANY KEY to start",
                    (GAME_WIDTH / 2) - 100, GAME_HEIGHT / 2);
        }
    }
    
    public void resetRound() {
        ball.reset();
        gameStart = false;
    }

    
    public void move() {
        player1.move();
        player2.move();
    
        if (gameStart) {
            ball.move();
        }
        
        if (ball.x <= player1.x + player1.width &&
            ball.x + ball.diameter >= player1.x &&
            ball.y + ball.diameter >= player1.y &&
            ball.y <= player1.y + player1.height) {
        
            ball.xVelocity = Math.min(Math.abs(ball.xVelocity) + speedIncrease, maxSpeed);
        }
        
        if (ball.x + ball.diameter >= player2.x &&
            ball.x <= player2.x + player2.width &&
            ball.y + ball.diameter >= player2.y &&
            ball.y <= player2.y + player2.height) {
        
            ball.xVelocity = -Math.min(Math.abs(ball.xVelocity) + speedIncrease, maxSpeed);
        }

        if (ball.x <= 0) {
            player2Score++;
            resetRound();
        }
    
        if (ball.x >= GAME_WIDTH - ball.diameter) {
            player1Score++;
            resetRound();
        }
    
        checkWinner();
    }
    
    public void checkWinner() {
        if (player1Score == 5) {
            JOptionPane.showMessageDialog(this, "Player 1 MENANG!");
            System.exit(0);
        }
        
        if (player2Score == 5) {
            JOptionPane.showMessageDialog(this, "Player 2 MENANG!");
            System.exit(0);
        }
    }

    public void run() {
        double nsPerFrame = 1000000000 / 60.0;
        long lastTime = System.nanoTime();
        double delta = 0;
            
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerFrame;
            lastTime = now;
                
            while (delta >= 1) {
                move();
                repaint();
                delta--;
            }
        }
    }
        
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
            
            if (!gameStart) {
                ball.start();
                gameStart = true;
            }
        
        }
        
        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }
    
}
