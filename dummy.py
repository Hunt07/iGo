'''
To ensure that the schedules are preserved even after logging out and logging back in, you need to save the schedules to a persistent storage (e.g., a file or a database) when logging out and load them back when logging in.
def my_function(num):
    """
    This function takes an integer as input and performs some operation.
    Parameters:
        num (int): The input integer.
    Returns:
        None
    """
    # Perform some operation with the input integer
    pass

Here is a step-by-step guide to achieve this:

1. **Save Schedules to a File**: When the user logs out, save the current schedules to a file.
2. **Load Schedules from a File**: When the user logs in, load the schedules from the file.

### Step-by-Step Implementation

#### 1. Save Schedules to a File

Add a method to save the schedules to a file in the `AdminDashboard` class.

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public void saveSchedulesToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("schedules.txt"))) {
        for (int i = 0; i < scheduleTableModel.getRowCount(); i++) {
            for (int j = 0; j < scheduleTableModel.getColumnCount(); j++) {
                writer.write(scheduleTableModel.getValueAt(i, j).toString() + ",");
            }
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

#### 2. Load Schedules from a File

Add a method to load the schedules from a file in the `AdminDashboard` class.

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public void loadSchedulesFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("schedules.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            scheduleTableModel.addRow(data);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

#### 3. Call Save Method on Logout

Modify the logout button's action listener to call the `saveSchedulesToFile` method.

```java
logoutButton.addActionListener(e -> {
    saveSchedulesToFile();
    // Perform logout operations
    System.exit(0);
});
```

#### 4. Call Load Method on Login

Modify the `AdminDashboard` constructor to call the `loadSchedulesFromFile` method.

```java
public AdminDashboard() {
    // Initialize the frame
    setTitle("Admin Dashboard");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Initialize the schedule table model
    String[] columns = {"Transport ID", "Schedule ID", "Transport Type", "Departure Time", "Arrival Time", "Route"};
    scheduleTableModel = new DefaultTableModel(columns, 0);
    scheduleTable = new JTable(scheduleTableModel);
    JScrollPane scrollPane = new JScrollPane(scheduleTable);
    add(scrollPane, BorderLayout.CENTER);

    // Load schedules from file
    loadSchedulesFromFile();

    // Add the schedule management panel
    add(createSchedulePanel(), BorderLayout.SOUTH);

    setVisible(true);
}
```

### Full Updated Code for [`AdminDashboard.java`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fc%3A%2FUsers%2Fosama%2FiGo%2FAdminDashboard.java%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "c:\Users\osama\iGo\AdminDashboard.java")

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdminDashboard extends JFrame {
    private DefaultTableModel scheduleTableModel;
    private JTable scheduleTable;

    public AdminDashboard() {
        // Initialize the frame
        setTitle("Admin Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize the schedule table model
        String[] columns = {"Transport ID", "Schedule ID", "Transport Type", "Departure Time", "Arrival Time", "Route"};
        scheduleTableModel = new DefaultTableModel(columns, 0);
        scheduleTable = new JTable(scheduleTableModel);
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load schedules from file
        loadSchedulesFromFile();

        // Add the schedule management panel
        add(createSchedulePanel(), BorderLayout.SOUTH);

        // Add logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            saveSchedulesToFile();
            // Perform logout operations
            System.exit(0);
        });
        add(logoutButton, BorderLayout.NORTH);

        setVisible(true);
    }

    // Panel for "Create Schedule"
    private JPanel createSchedulePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Create New Schedule");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(250, 20, 200, 30);
        panel.add(titleLabel);

        JLabel transportTypeLabel = new JLabel("Transport Type:");
        transportTypeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        transportTypeLabel.setBounds(100, 80, 150, 30);
        panel.add(transportTypeLabel);

        JComboBox<String> transportTypeCombo = new JComboBox<>(new String[]{"Bus", "Train"});
        transportTypeCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        transportTypeCombo.setBounds(250, 80, 250, 30);
        panel.add(transportTypeCombo);

        JLabel departureLabel = new JLabel("Departure Time:");
        departureLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        departureLabel.setBounds(100, 130, 150, 30);
        panel.add(departureLabel);

        JTextField departureField = new JTextField();
        departureField.setFont(new Font("Arial", Font.PLAIN, 14));
        departureField.setBounds(250, 130, 250, 30);
        panel.add(departureField);

        JLabel arrivalLabel = new JLabel("Arrival Time:");
        arrivalLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        arrivalLabel.setBounds(100, 180, 150, 30);
        panel.add(arrivalLabel);

        JTextField arrivalField = new JTextField();
        arrivalField.setFont(new Font("Arial", Font.PLAIN, 14));
        arrivalField.setBounds(250, 180, 250, 30);
        panel.add(arrivalField);

        JLabel routeLabel = new JLabel("Route:");
        routeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        routeLabel.setBounds(100, 230, 150, 30);
        panel.add(routeLabel);

        JTextField routeField = new JTextField();
        routeField.setFont(new Font("Arial", Font.PLAIN, 14));
        routeField.setBounds(250, 230, 250, 30);
        panel.add(routeField);

        JLabel scheduleIDLabel = new JLabel("Schedule ID:");
        scheduleIDLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        scheduleIDLabel.setBounds(100, 280, 150, 30);
        panel.add(scheduleIDLabel);

        JComboBox<String> scheduleIDCombo = new JComboBox<>(new String[]{"TB001", "TB002"});
        scheduleIDCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        scheduleIDCombo.setBounds(250, 280, 250, 30);
        panel.add(scheduleIDCombo);

        JLabel transportIDLabel = new JLabel("Transport ID:");
        transportIDLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        transportIDLabel.setBounds(100, 330, 150, 30);
        panel.add(transportIDLabel);

        JComboBox<String> transportIDCombo = new JComboBox<>(new String[]{"BS001", "TN002"});
        transportIDCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        transportIDCombo.setBounds(250, 330, 250, 30);
        panel.add(transportIDCombo);

        JButton createButton = new JButton("Create");
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.setBounds(360, 380, 140, 45);
        panel.add(createButton);

        // Create a table to display existing schedules
        String[] columns = {"Transport ID", "Schedule ID", "Transport Type", "Departure Time", "Arrival Time", "Route"};
        scheduleTableModel = new DefaultTableModel(columns, 0);
        scheduleTable = new JTable(scheduleTableModel);
        JScrollPane scrollPane = new JScrollPane(scheduleTable);
        scrollPane.setBounds(30, 450, 610, 200);
        panel.add(scrollPane);

        // Add action listener to the create button
        createButton.addActionListener(e -> {
            String transportID = (String) transportIDCombo.getSelectedItem();
            String scheduleID = (String) scheduleIDCombo.getSelectedItem();
            String transportType = (String) transportTypeCombo.getSelectedItem();
            String departureTime = departureField.getText();
            String arrivalTime = arrivalField.getText();
            String route = routeField.getText();
            // Add the new schedule to the table model
            scheduleTableModel.addRow(new Object[]{transportID, scheduleID, transportType, departureTime, arrivalTime, route});
            JOptionPane.showMessageDialog(panel, "Schedule created successfully!");
        });

        return panel;
    }

    public void saveSchedulesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("schedules.txt"))) {
            for (int i = 0; i < scheduleTableModel.getRowCount(); i++) {
                for (int j = 0; j < scheduleTableModel.getColumnCount(); j++) {
                    writer.write(scheduleTableModel.getValueAt(i, j).toString() + ",");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadSchedulesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("schedules.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                scheduleTableModel.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AdminDashboard();
    }
}
```

### Explanation

- **Save Schedules to File**: The `saveSchedulesToFile` method writes the current schedules to a file named `schedules.txt`.
- **Load Schedules from File**: The `loadSchedulesFromFile` method reads the schedules from the `schedules.txt` file and populates the `scheduleTableModel`.
- **Logout Button**: The logout button's action listener calls the `saveSchedulesToFile` method before performing logout operations.
- **Constructor Update**: The `AdminDashboard` constructor calls the `loadSchedulesFromFile` method to load the schedules when the application starts.

This implementation ensures that the schedules are preserved even after logging out and logging back in.