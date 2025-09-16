import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ClockGUI {
    private JFrame frame;
    private JLabel timeLabel;
    private ClockDisplay clock;
    private Timer timer;

    public ClockGUI() {
        java.util.Calendar now = java.util.Calendar.getInstance();
        int h = now.get(java.util.Calendar.HOUR_OF_DAY);
        int m = now.get(java.util.Calendar.MINUTE);
        int s = now.get(java.util.Calendar.SECOND);
        clock = new ClockDisplay(h, m, s);

        frame = new JFrame("Awokowkw Happy Clock ^-^"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);

        Border padding = new EmptyBorder(20, 20, 20, 20);
        Border neonBorder = new LineBorder(new Color(0, 255, 255), 8, true);
        panel.setBorder(new CompoundBorder(padding, neonBorder));

        timeLabel = new JLabel(clock.getTime(), SwingConstants.CENTER);
        timeLabel.setForeground(new Color(0, 255, 255)); 
        timeLabel.setFont(new Font("Atlantik", Font.BOLD, 80));
        panel.add(timeLabel, BorderLayout.CENTER);

        frame.setContentPane(panel);

        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);

        timer = new Timer(1000, e -> updateClock());
        timer.start();
    }

    private void updateClock() {
        clock.timeTick();
        timeLabel.setText(clock.getTime());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClockGUI());
    }
}
