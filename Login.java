import javax.swing.*;
import java.awt.*;

public class Login {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(280, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel lblUser = new JLabel("Username:");
        JLabel lblPass = new JLabel("Password:");

        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();

        JButton btnLogin = new JButton("Login");

        btnLogin.addActionListener(e -> {
            String u = txtUser.getText();
            String p = new String(txtPass.getPassword());

            if (u.equals("admin") && p.equals("admin")) {
                JOptionPane.showMessageDialog(frame, "Login berhasil!");
            } else {
                JOptionPane.showMessageDialog(frame, "Username atau Password salah!");
            }
        });

        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPass);
        panel.add(txtPass);
        panel.add(new JLabel()); 
        panel.add(btnLogin);

        frame.add(panel);
        frame.setVisible(true);
    }
}
