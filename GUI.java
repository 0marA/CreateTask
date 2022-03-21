import javax.swing.*;

public class GUI {
    private JFrame frame;
    private JPanel panel;

    public GUI() {
        frame = new JFrame();
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        
        frame.setSize(600, 600);
        frame.setTitle("2048");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}