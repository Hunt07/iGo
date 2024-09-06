import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.BevelBorder;

/**
 * Create 5 panels for home page UI
 * panel0 for logo with text Public Scheduling Transportation System"
 * panel1 for search bar and buttons and a label with text "Search"
 * panel2 for train schedule table with columns: Train Number, Line, Departure Time
 * panel3 for bus schedule table with columns: Bus Number, Line, Departure Time
 * panel4 for login with text "Login" and text fields with text "Username" and "Password" and buttons "Login" and "Register" and "Quit"
 */

public class HomePage extends JFrame {
    private List<User> users;

    public HomePage() {
        // Initialize the list of users
        users = new ArrayList<>();
        users.add(new User("admin", "admin", true)); // Admin user
        users.add(new User("user1", "password1", false)); // Regular user
        users.add(new User("user2", "password2", false)); // Regular user

        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        // Add a background image
        ImageIcon originalIcon = new ImageIcon("/Users/majid/Desktop/OOP /FinalProjectGP/ProjectUI/ProjectOOP/src/bg.png");

        // Scale the image to fit the frame size
        Image scaledImage = originalIcon.getImage().getScaledInstance(1000, 850, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 1000, 850);

        // Panel 0
        JPanel panel0 = new JPanel();
        panel0.setBounds(0, 0, 1000, 100);
        panel0.setBackground(new Color(0x8F1402));
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

        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 100, 1000, 50);
        panel1.setLayout(null);
        panel1.setOpaque(false);

        JLabel LabelSearch1 = new JLabel("Enter Train/Bus No.:");
        LabelSearch1.setFont(new Font("Aharoni", Font.BOLD, 15));
        LabelSearch1.setForeground(Color.BLACK);
        LabelSearch1.setBounds(450, 5, 200, 40);
        JTextField searchField = new JTextField(15);
        searchField.setBounds(605, 5, 200, 40);
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Aharoni", Font.BOLD, 15));
        searchButton.setBounds(805, 5, 100, 40);
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Aharoni", Font.BOLD, 15));
        clearButton.setBounds(900, 5, 100, 40);

        panel1.add(LabelSearch1);
        panel1.add(searchField);
        panel1.add(searchButton);
        panel1.add(clearButton);

        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 150, 1000, 200);
        panel2.setLayout(null);

        String[] trainColumns = {"Train Number", "Line", "Departure Time"};
        Object[][] trainData = {}; // Data should be fetched and placed here
        JTable trainTable = new JTable(trainData, trainColumns);
        JScrollPane scrollPane1 = new JScrollPane(trainTable);
        scrollPane1.setBounds(0, 0, 1000, 200);

        panel2.add(scrollPane1);

        // Panel 3
        JPanel panel3 = new JPanel();
        panel3.setBounds(0, 350, 1000, 200);
        panel3.setLayout(null);

        String[] busColumns = {"Bus Number", "Line", "Departure Time"};
        Object[][] busData = {}; // Data should be fetched and placed here
        JTable busTable = new JTable(busData, busColumns);
        JScrollPane scrollPane2 = new JScrollPane(busTable);
        scrollPane2.setBounds(0, 0, 1000, 200);

        panel3.add(scrollPane2);

        // Panel 4
        JPanel panel4 = new JPanel();
        panel4.setBounds(0, 550, 1000, 210);
        panel4.setLayout(null);
        panel4.setOpaque(false);

        JLabel LabelUsername = new JLabel("Username:");
        LabelUsername.setFont(new Font("Aharoni", Font.BOLD, 15));
        LabelUsername.setForeground(Color.WHITE);
        LabelUsername.setBounds(600, 5, 200, 40);
        JTextField usernameField = new JTextField(15);
        usernameField.setBounds(705, 5, 250, 45);

        JLabel LabelPassword = new JLabel("Password:");
        LabelPassword.setFont(new Font("Aharoni", Font.BOLD, 15));
        LabelPassword.setForeground(Color.WHITE);
        LabelPassword.setBounds(600, 50, 200, 40);
        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBounds(705, 50, 250, 45);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Aharoni", Font.BOLD, 15));
        loginButton.setBounds(705, 95, 120, 40);

        JButton clearFormButton = new JButton("Clear");
        clearFormButton.setFont(new Font("Aharoni", Font.BOLD, 15));
        clearFormButton.setBounds(825, 95, 120, 40);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Aharoni", Font.BOLD, 15));
        registerButton.setBounds(705, 135, 240, 40);

        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Aharoni", Font.BOLD, 15));
        quitButton.setBounds(450, 170, 100, 40);

        panel4.add(LabelUsername);
        panel4.add(usernameField);
        panel4.add(LabelPassword);
        panel4.add(passwordField);
        panel4.add(clearFormButton);
        panel4.add(loginButton);
        panel4.add(registerButton);
        panel4.add(quitButton);

        // Quit button functionality
        quitButton.addActionListener(e -> System.exit(0));

        // Add action listener for login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticate(username, password)) {
                // Redirect to AdminDashboard or UserDashboard based on user role
                if (isAdmin(username)) {
                    new AdminDashboard().setVisible(true);
                } else {
                    new booking().setVisible(true);
                }
                dispose(); // Close the login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add action listener for register button
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (register(username, password)) {
                JOptionPane.showMessageDialog(this, "Registration successful", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(panel4);
        add(panel3);
        add(panel2);
        add(panel1);
        add(panel0);
        add(backgroundLabel);
    }

    private boolean  authenticate(String username, String password) {
        // Implementing authentication logic here
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAdmin(String username) {
        // Implement logic to check if the user is an admin
        for (User user : users) {
            if (user.getUsername().equals(username) && user.isAdmin()) {
                return true;
            }
        }
        return false;
    }

    private boolean register(String username, String password) {
        // Check if the username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already exists
            }
        }
        // Add new user to the list
        users.add(new User(username, password, false));
        return true;
    }

    public static void main(String[] args) {
        new HomePage().setVisible(true);
    }
}

// User class to store user details
class User {
    private String username;
    private String password;
    private boolean isAdmin;

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}