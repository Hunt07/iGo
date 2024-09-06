import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class AdminDashboard extends JFrame 
{

    // Define a consistent font style
    private static final Font STANDARD_FONT = new Font("Aharoni", Font.PLAIN, 15);
    private static final Font BOLD_FONT = new Font("Aharoni", Font.BOLD, 15);
    private DefaultTableModel scheduleTableModel;
    private JTable scheduleTable;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 880);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null); 

        // Panel 0
        JPanel panel0 = new JPanel();
        panel0.setBackground(new Color(0x8F1402));
        panel0.setBounds(0, 0, 800, 80);
        panel0.setLayout(null);

        JLabel LabelLogo1 = new JLabel("i-Go!");
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
        tabbedPane.addTab("Manage User", NewUser());
        tabbedPane.addTab("Create Schedule", createSchedulePanel());
        tabbedPane.addTab("Update Schedule", updateSchedulePanel());
       // tabbedPane.addTab("Delete Schedule", deleteSchedulePanel());
        tabbedPane.addTab("Assign Transport", assignTransportPanel());

        //Add two buttons "Logout" and "Quit"
    JButton logoutButton = new JButton("Logout");
    logoutButton.setFont(BOLD_FONT);
    logoutButton.setBounds(350, 750, 140, 45);
    JButton quitButton = new JButton("Quit");
    quitButton.setFont(BOLD_FONT);
    quitButton.setBounds(510, 750, 140, 45);

    // Quit button functionality
    quitButton.addActionListener(e -> System.exit(0));

    // logout button functionality
    logoutButton.addActionListener(e -> {
        new HomePage().setVisible(true);
        dispose(); // Close the current window
    });


        add(panel0);
        add(quitButton);
        add(logoutButton);
        add(tabbedPane);
        setVisible(true);
    }


    // Panel for "New User"
    private JPanel NewUser() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Manage User");
        titleLabel.setFont(BOLD_FONT);
        titleLabel.setBounds(250, 20, 200, 30);
        panel.add(titleLabel);

        JLabel UserRoleLabel = new JLabel("User Role:");
        UserRoleLabel.setFont(STANDARD_FONT);
        UserRoleLabel.setBounds(100, 80, 150, 30);
        panel.add(UserRoleLabel);

        JComboBox<String> transportTypeCombo = new JComboBox<>(new String[]{"Public", "Driver", "Admin"});
        transportTypeCombo.setFont(STANDARD_FONT);
        transportTypeCombo.setBounds(300, 80, 250, 30);
        panel.add(transportTypeCombo);

        JLabel f_nameLabel = new JLabel("First name:");
        f_nameLabel.setFont(STANDARD_FONT);
        f_nameLabel.setBounds(100, 130, 150, 30);
        panel.add(f_nameLabel);

        JTextField f_nameField = new JTextField();
        f_nameField.setFont(STANDARD_FONT);
        f_nameField.setBounds(300, 130, 250, 30);
        panel.add(f_nameField);

        JLabel l_namelLabel = new JLabel("Last name:");
        l_namelLabel.setFont(STANDARD_FONT);
        l_namelLabel.setBounds(100, 180, 150, 30);
        panel.add(l_namelLabel);

        JTextField l_namelField = new JTextField();
        l_namelField.setFont(STANDARD_FONT);
        l_namelField.setBounds(300, 180, 250, 30);
        panel.add(l_namelField);

        JLabel DOBLabel = new JLabel("D.O.B. (dd-MM-yyyy):");
        DOBLabel.setFont(STANDARD_FONT);
        DOBLabel.setBounds(100, 230, 150, 30);
        panel.add(DOBLabel);

        JTextField DOBField = new JTextField();
        DOBField.setFont(STANDARD_FONT);
        DOBField.setBounds(300, 230, 250, 30);
        panel.add(DOBField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(STANDARD_FONT);
        emailLabel.setBounds(100, 280, 150, 30);
        panel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setFont(STANDARD_FONT);
        emailField.setBounds(300, 280, 250, 30);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(STANDARD_FONT);
        passwordLabel.setBounds(100, 330, 150, 30);
        panel.add(passwordLabel);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(STANDARD_FONT);
        passwordField.setBounds(300, 330, 250, 30);
        panel.add(passwordField);

        JLabel UserIdLabel = new JLabel("User ID:");
        UserIdLabel.setFont(STANDARD_FONT);
        UserIdLabel.setBounds(100, 380, 150, 30);
        panel.add(UserIdLabel);

        JTextField UserIdField = new JTextField();
        UserIdField.setFont(STANDARD_FONT);
        UserIdField.setBounds(300, 380, 250, 30);
        panel.add(UserIdField);

        JButton createButton = new JButton("Create");
        createButton.setFont(BOLD_FONT);
        createButton.setBounds(400, 410, 140, 45);
        panel.add(createButton);

        // Add a table to display users
        String[] columns = {"User ID", "First Name", "Last Name", "Email", "Role"};
        Object[][] data = {
                {"DV001", "Talha", "Khan", "itsTalha@gmail.com", "Admin"},
                {"DV002", "Ali", "Ahmed", "itsAli12@gmail.com", "Driver"},
                {"DV003", "Kareem", "Khan", "itsMrKareem@edu.my", "Public"},
                {"DV004", "Osama", "Ahmed", "Osam@edu.my", "Public"}
        };
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 470, 610, 200);
        panel.add(scrollPane);

        return panel;
    }

   // Panel for "Create Schedule"
   private JPanel createSchedulePanel() {
    JPanel panel = new JPanel();
    panel.setLayout(null);

    JLabel titleLabel = new JLabel("Create New Schedule");
    titleLabel.setFont(BOLD_FONT);
    titleLabel.setBounds(250, 20, 200, 30);
    panel.add(titleLabel);

    JLabel transportTypeLabel = new JLabel("Transport Type:");
    transportTypeLabel.setFont(STANDARD_FONT);
    transportTypeLabel.setBounds(100, 80, 150, 30);
    panel.add(transportTypeLabel);

    JComboBox<String> transportTypeCombo = new JComboBox<>(new String[]{"Bus", "Train"});
    transportTypeCombo.setFont(STANDARD_FONT);
    transportTypeCombo.setBounds(250, 80, 250, 30);
    panel.add(transportTypeCombo);

    JLabel departureLabel = new JLabel("Departure Time:");
    departureLabel.setFont(STANDARD_FONT);
    departureLabel.setBounds(100, 130, 150, 30);
    panel.add(departureLabel);

    JTextField departureField = new JTextField();
    departureField.setFont(STANDARD_FONT);
    departureField.setBounds(250, 130, 250, 30);
    panel.add(departureField);

    JLabel arrivalLabel = new JLabel("Arrival Time:");
    arrivalLabel.setFont(STANDARD_FONT);
    arrivalLabel.setBounds(100, 180, 150, 30);
    panel.add(arrivalLabel);

    JTextField arrivalField = new JTextField();
    arrivalField.setFont(STANDARD_FONT);
    arrivalField.setBounds(250, 180, 250, 30);
    panel.add(arrivalField);

    JLabel routeLabel = new JLabel("Route:");
    routeLabel.setFont(STANDARD_FONT);
    routeLabel.setBounds(100, 230, 150, 30);
    panel.add(routeLabel);

    JTextField routeField = new JTextField();
    routeField.setFont(STANDARD_FONT);
    routeField.setBounds(250, 230, 250, 30);
    panel.add(routeField);

    JLabel scheduleIDLabel = new JLabel("Schedule ID:");
    scheduleIDLabel.setFont(STANDARD_FONT);
    scheduleIDLabel.setBounds(100, 280, 150, 30);
    panel.add(scheduleIDLabel);

    JComboBox<String> scheduleIDCombo = new JComboBox<>(new String[]{"TB001", "TB002"});
    scheduleIDCombo.setFont(STANDARD_FONT);
    scheduleIDCombo.setBounds(250, 280, 250, 30);
    panel.add(scheduleIDCombo);

    JLabel transportIDLabel = new JLabel("Transport ID:");
    transportIDLabel.setFont(STANDARD_FONT);
    transportIDLabel.setBounds(100, 330, 150, 30);
    panel.add(transportIDLabel);

    JComboBox<String> transportIDCombo = new JComboBox<>(new String[]{"BS001", "TN002"});
    transportIDCombo.setFont(STANDARD_FONT);
    transportIDCombo.setBounds(250, 330, 250, 30);
    panel.add(transportIDCombo);

    JButton createButton = new JButton("Create");
    createButton.setFont(BOLD_FONT);
    createButton.setBounds(360, 380, 140, 45);
    panel.add(createButton);

    // Create a table to display existing schedules
    String[] columns = {"Transport ID", "Schedule ID", "Transport Type", "Departure Time", "Arrival Time", "Route"};
    Object[][] data = {
        {"TN001", "TB001", "Train", "07:00", "08:00", "Jalan Ampang"},
        {"TN002", "TB002", "Train", "08:30", "09:30", "Jalan Bukit Bintang"},
        {"BS003", "TB003", "Bus", "11:20", "12:50", "Jalan Raja"},
        {"BS004", "TB004", "Bus", "14:15", "16:00", "Jalan Gombak"},
    };
    scheduleTableModel = new DefaultTableModel(data, columns);
    scheduleTable = new JTable(scheduleTableModel);
    JScrollPane scrollPane = new JScrollPane(scheduleTable);
    scrollPane.setBounds(30, 450, 610, 200);
    panel.add(scrollPane);

    // Add action listener to the create button
    createButton.addActionListener(e -> {
        String transportID = JOptionPane.showInputDialog("Enter Transport ID:");
        String scheduleID = JOptionPane.showInputDialog("Enter Schedule ID:");
        String transportType = JOptionPane.showInputDialog("Enter Transport Type:");
        String departureTime = JOptionPane.showInputDialog("Enter Departure Time:");
        String arrivalTime = JOptionPane.showInputDialog("Enter Arrival Time:");
        String route = JOptionPane.showInputDialog("Enter Route:");
        // Add the new schedule to the table model
        scheduleTableModel.addRow(new Object[]{transportID, scheduleID, transportType, departureTime, arrivalTime, route});
        JOptionPane.showMessageDialog(panel, "Schedule created successfully!");
    });
    panel.add(createButton, BorderLayout.SOUTH);

    return panel;
}

   // Panel for "Update Schedule"
private JPanel updateSchedulePanel() {
    JPanel panel = new JPanel();
    panel.setLayout(null);

    JLabel titleLabel = new JLabel("Update Existing Schedule");
    titleLabel.setFont(BOLD_FONT);
    titleLabel.setBounds(250, 20, 200, 30);
    panel.add(titleLabel);

   /*  JLabel scheduleIDLabel = new JLabel("Schedule ID:");
    scheduleIDLabel.setFont(STANDARD_FONT);
    scheduleIDLabel.setBounds(100, 80, 200, 30);
    panel.add(scheduleIDLabel);

    JComboBox<String> scheduleIDCombo = new JComboBox<>(new String[]{"TB001", "TB002"});
    scheduleIDCombo.setFont(STANDARD_FONT);
    scheduleIDCombo.setBounds(280, 80, 250, 30);
    panel.add(scheduleIDCombo);

    JLabel newDepartureLabel = new JLabel("New Departure Time:");
    newDepartureLabel.setFont(STANDARD_FONT);
    newDepartureLabel.setBounds(100, 130, 200, 30);
    panel.add(newDepartureLabel);

    JTextField newDepartureField = new JTextField();
    newDepartureField.setFont(STANDARD_FONT);
    newDepartureField.setBounds(280, 130, 250, 30);
    panel.add(newDepartureField);

    JLabel newArrivalLabel = new JLabel("New Arrival Time:");
    newArrivalLabel.setFont(STANDARD_FONT);
    newArrivalLabel.setBounds(100, 180, 200, 30);
    panel.add(newArrivalLabel);*/

    /*JTextField newArrivalField = new JTextField();
    newArrivalField.setFont(STANDARD_FONT);
    newArrivalField.setBounds(280, 180, 250, 30);
    panel.add(newArrivalField);*/

    JButton updateButton = new JButton("Update");
    updateButton.setFont(BOLD_FONT);
    updateButton.setBounds(390, 210, 140, 45);
    panel.add(updateButton);

    JLabel titleLabel2 = new JLabel("Delete Existing Schedule");
    titleLabel2.setFont(BOLD_FONT);
    titleLabel2.setBounds(250, 300, 200, 30);
    panel.add(titleLabel2);

   /* JLabel scheduleIDLabel2 = new JLabel("Schedule ID:");
    scheduleIDLabel2.setFont(STANDARD_FONT);
    scheduleIDLabel2.setBounds(100, 350, 140, 30);
    panel.add(scheduleIDLabel2);

    JComboBox<String> scheduleIDCombo2 = new JComboBox<>(new String[]{"TB001", "TB002"});
    scheduleIDCombo2.setFont(STANDARD_FONT);
    scheduleIDCombo2.setBounds(280, 350, 250, 30);
    panel.add(scheduleIDCombo2);*/

    JButton deleteButton = new JButton("Delete");
    deleteButton.setFont(BOLD_FONT);
    deleteButton.setBounds(390, 380, 140, 45);
    panel.add(deleteButton);

    // Create a table to display existing schedules
    String[] columns = {"Schedule ID", "Transport ID", "Departure Time", "Arrival Time"};
    Object[][] data = {
        {"TN001", "TB001", "Train", "07:00", "08:00"},
        {"TN002", "TB002", "Train", "08:30", "09:30"},
        {"BS003", "TB003", "Bus", "11:20", "12:50"},
        {"BS004", "TB004", "Bus", "14:15", "16:00"},
    };
    scheduleTableModel = new DefaultTableModel(data, columns);
    JTable table = new JTable(scheduleTableModel);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(30, 450, 610, 200);
    panel.add(scrollPane);

    // Add action listener to the update button
    updateButton.addActionListener(e -> {
        String scheduleID = JOptionPane.showInputDialog("Enter Schedule ID to update:");
        String newDepartureTime = JOptionPane.showInputDialog("Enter new Departure Time:");
        String newArrivalTime = JOptionPane.showInputDialog("Enter new Arrival Time:");
        // Update the schedule in the table with the new departure and arrival times
        for (int i = 0; i < scheduleTableModel.getRowCount(); i++) {
            if (scheduleTableModel.getValueAt(i, 0).equals(scheduleID)) {
                scheduleTableModel.setValueAt(newDepartureTime, i, 2); // Assuming column 2 is Departure Time
                scheduleTableModel.setValueAt(newArrivalTime, i, 3); // Assuming column 3 is Arrival Time
                break;
            }
        }
        JOptionPane.showMessageDialog(panel, "Schedule updated successfully!");
    });
    panel.add(updateButton, BorderLayout.SOUTH);

    // Add action listener to the delete button
    deleteButton.addActionListener(e -> {
        String scheduleID = JOptionPane.showInputDialog("Enter Schedule ID to delete:");
        if (scheduleID == null) return; // If the user cancels the input dialog
        if (scheduleID.isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Please enter a Schedule ID to delete!");
            return;
        }
        // if scheduleID not found
        

        // Remove the schedule from the table
        boolean found = false;
        for (int i = 0; i < scheduleTableModel.getRowCount(); i++) {
            if (scheduleTableModel.getValueAt(i, 0).equals(scheduleID)) {
            scheduleTableModel.removeRow(i);
            found = true;
            break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(panel, "Schedule ID not found!");
        }
        if (found) {
            JOptionPane.showMessageDialog(panel, "Schedule deleted successfully!");
        }
      
    });
    panel.add(deleteButton, BorderLayout.SOUTH);

    return panel;
}

    // Panel for "Assign Transport"
    private JPanel assignTransportPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Assign Transport to Schedule");
        titleLabel.setFont(BOLD_FONT);
        titleLabel.setBounds(200, 20, 250, 30);
        panel.add(titleLabel);

        JLabel scheduleIDLabel = new JLabel("Schedule ID:");
        scheduleIDLabel.setFont(STANDARD_FONT);
        scheduleIDLabel.setBounds(100, 80, 150, 30);
        panel.add(scheduleIDLabel);

        JComboBox<String> scheduleIDCombo = new JComboBox<>(new String[]{"TB001", "TB002"});
        scheduleIDCombo.setFont(STANDARD_FONT);
        scheduleIDCombo.setBounds(250, 80, 250, 30);
        panel.add(scheduleIDCombo);

        JLabel transportIDLabel = new JLabel("Transport ID:");
        transportIDLabel.setFont(STANDARD_FONT);
        transportIDLabel.setBounds(100, 130, 150, 30);
        panel.add(transportIDLabel);

        JComboBox<String> transportIDCombo = new JComboBox<>(new String[]{"BS001", "TN002"});
        transportIDCombo.setFont(STANDARD_FONT);
        transportIDCombo.setBounds(250, 130, 250, 30);
        panel.add(transportIDCombo);

        JLabel driverIDLabel = new JLabel("Driver ID:");
        driverIDLabel.setFont(STANDARD_FONT);
        driverIDLabel.setBounds(100, 180, 150, 30);
        panel.add(driverIDLabel);

        JComboBox<String> driverIdCombo = new JComboBox<>(new String[]{"DV001", "DV002"});
        driverIdCombo.setFont(STANDARD_FONT);
        driverIdCombo.setBounds(250, 180, 250, 30);
        panel.add(driverIdCombo);

        JButton assignButton = new JButton("Assign");
        assignButton.setFont(BOLD_FONT);
        assignButton.setBounds(350, 235, 140, 45);
        panel.add(assignButton);


        //Create a table to display existing schedules 
        String[] columns = {"Schedule ID","Transport ID", "Driver ID", "Driver Name"};
        Object[][] data = {
            {"TN001", "TB001", "DV001", "Khan"},
            {"TN002", "TB002", "DV010", "Harris"},
            {"BS003", "TB003", "DV021", "Kareem"},
            {"BS004", "TB004", "DV011", "Osama"},
        };
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 400, 610, 200);
        panel.add(scrollPane);

        return panel;
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}