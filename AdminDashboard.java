import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    private static final Font BOLD_FONT = new Font("Aharoni", Font.BOLD, 15);
    
    private AdminMethods adminMethods;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 880);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        adminMethods = new AdminMethods();

        // Panel 0 (Header)
        JPanel panel0 = new JPanel();
        panel0.setBackground(new Color(0x8F1402));
        panel0.setBounds(0, 0, 800, 80);
        panel0.setLayout(null);

        JLabel LabelLogo1 = new JLabel("I-Go!");
        LabelLogo1.setFont(new Font("Aharoni", Font.BOLD, 50));
        LabelLogo1.setForeground(Color.WHITE);
        LabelLogo1.setBounds(30, 5, 940, 50);
        JLabel LabelLogo2 = new JLabel("Public Scheduling Transportation System");
        LabelLogo2.setFont(new Font("Aharoni", Font.BOLD, 15));
        LabelLogo2.setForeground(Color.WHITE);
        LabelLogo2.setBounds(30, 40, 940, 40);

        panel0.add(LabelLogo1);
        panel0.add(LabelLogo2);

        // Tabbed pane to hold different functionalities
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(50, 100, 700, 780);

        // Add tabs
        tabbedPane.addTab("Manage User", adminMethods.manageUser());
        tabbedPane.addTab("Create Schedule", adminMethods.createSchedulePanel());
        tabbedPane.addTab("Update Schedule", adminMethods.updateSchedulePanel());
        tabbedPane.addTab("Assign Transport", adminMethods.assignTransportPanel());

        // Buttons for Logout and Quit
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(BOLD_FONT);
        logoutButton.setBounds(250, 800, 140, 45);
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(BOLD_FONT);
        quitButton.setBounds(400, 800, 140, 45);

        quitButton.addActionListener(e -> System.exit(0));

        logoutButton.addActionListener(e -> {
            HomePage homePage = new HomePage();
            homePage.setVisible(true);
            dispose();
        });

        add(panel0);
        add(quitButton);
        add(logoutButton);
        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
