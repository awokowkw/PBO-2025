import java.awt.*;

public class Ball {
    int x, y;
    int xVelocity = 3;
    int yVelocity = 3;
    int diameter = 30;
    
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }
    
    public void move() {
        x += xVelocity;
        y += yVelocity;
        
        if (y <= 0 || y >= GamePanel.GAME_HEIGHT - diameter)
        yVelocity = -yVelocity;
    }
    
    public void reset() {
        x = (GamePanel.GAME_WIDTH / 2) - (diameter / 2);
        y = (GamePanel.GAME_HEIGHT / 2) - (diameter / 2);
        xVelocity = 0;
        yVelocity = 0;
    }

    public void start() {
        xVelocity = Math.random() < 0.5 ? 3 : -3;
        yVelocity = Math.random() < 0.5 ? 3 : -3;
    }
}
