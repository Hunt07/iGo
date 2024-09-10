import javax.swing.*;
import java.awt.*;
//~ Talha

public class booking extends JFrame
{
    private static final Font STANDARD_FONT = new Font("Aharoni", Font.PLAIN, 15);
    private static final Font BOLD_FONT = new Font("Aharoni", Font.BOLD, 15);

    public booking(){
    setTitle("Ticket Booking");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1000, 850);
    setResizable(false);
    setLayout(null);
    setLocationRelativeTo(null); 

 // background image
 ImageIcon originalIcon = new ImageIcon("./py_bg.jpg");
 Image scaledImage = originalIcon.getImage().getScaledInstance(1000, 850, Image.SCALE_SMOOTH);
 ImageIcon scaledIcon = new ImageIcon(scaledImage);
 JLabel backgroundLabel = new JLabel(scaledIcon);
 backgroundLabel.setBounds(0, 0, 1000, 800);
 add(backgroundLabel);
    // Panel 0
    JPanel panel0 = new JPanel();
    panel0.setBackground(new Color(0x8F1402));
    panel0.setBounds(0, 0, 1000, 100);
    panel0.setLayout(null);

    JLabel LabelLogo1 = new JLabel("I-Go!");
    LabelLogo1.setFont(new Font("Aharoni", Font.BOLD, 50));
     
    LabelLogo1.setBounds(30, 5, 940, 50);
    JLabel LabelLogo2 = new JLabel("Public Scheduling Transportation System");
    LabelLogo2.setFont(new Font("Aharoni", Font.BOLD, 15));
    LabelLogo2.setForeground(Color.WHITE);
    LabelLogo2.setBounds(30, 40, 940, 40);

    panel0.add(LabelLogo1);
    panel0.add(LabelLogo2);

    //add a panel1 for seeting selection 
    JPanel panel1 = new JPanel();
    panel1.setBounds(10, 110, 600, 400);
    panel1.setLayout(null);

    JLabel bookingLabel = new JLabel("Please fill in the form below: ");
    bookingLabel.setFont(new Font("Aharoni", Font.PLAIN, 20));
    bookingLabel.setBounds(5, 5, 550, 40);
    panel1.add(bookingLabel);

    JLabel fromLabel = new JLabel("FROM:");
    fromLabel.setFont(BOLD_FONT);
    fromLabel.setBounds(5, 70, 150, 30 );
    panel1.add(fromLabel);
    JComboBox<String> fromField = new JComboBox<>(new String[]{"LRT Ampang", "KLCC", "Asia Jaya", "UNIVERSITY","Pasar Seni"});
    fromField.setFont(STANDARD_FONT);
    fromField.setBounds(90, 70, 200, 45 );
    panel1.add(fromField);

    JLabel toLabel = new JLabel("TO:");
    toLabel.setFont(BOLD_FONT);
    toLabel.setBounds(350, 70, 150, 30 );
    panel1.add(toLabel);
    JComboBox<String> toField = new JComboBox<>(new String[]{"Pasar Seni", "UNIVERSITY", "LRT Ampang", "KLCC","Asia Jaya"});
    toField.setFont(STANDARD_FONT);
    toField.setBounds(400, 70, 200, 45 );
    panel1.add(toField);

    JLabel transportTypeLabel = new JLabel("Transportation Type:");
    transportTypeLabel.setFont(BOLD_FONT);
    transportTypeLabel.setBounds(5, 120, 200, 30 );
    panel1.add(transportTypeLabel);
    JComboBox<String> transportTypeCombo = new JComboBox<>(new String[]{"Train", "Bus"});
    transportTypeCombo.setFont(STANDARD_FONT);
    transportTypeCombo.setBounds(200, 120, 250, 40);
    panel1.add(transportTypeCombo);

    JLabel departureTimeLabel = new JLabel("Departure Time:");
    departureTimeLabel.setFont(BOLD_FONT);
    departureTimeLabel.setBounds(5, 160, 200, 30 );
    panel1.add(departureTimeLabel);
    JComboBox<String> departureTimeCombo = new JComboBox<>(new String[]{"06:00", "07:30", "09:00", "13:20"});
    departureTimeCombo.setFont(STANDARD_FONT);
    departureTimeCombo.setBounds(200, 160, 150, 40);
    panel1.add(departureTimeCombo);

    JLabel passengerNoLabel = new JLabel("Number of Passenger:");
    passengerNoLabel.setFont(BOLD_FONT);
    passengerNoLabel.setBounds(5, 210, 180, 30 );
    panel1.add(passengerNoLabel);
    JComboBox<String> passengerNoField = new JComboBox<>(new String[]{ "1", "2", "3","4", "5", "6", "7", "8", "9", "10"});
    passengerNoField.setFont(STANDARD_FONT);
    passengerNoField.setBounds(200, 210, 150, 40 );
    panel1.add(passengerNoField);

    JLabel kidNoLabel = new JLabel("Number of Kid:");
    kidNoLabel.setFont(BOLD_FONT);
    kidNoLabel.setBounds(5, 260, 200, 30 );
    panel1.add(kidNoLabel);
    JComboBox<String> kidNoCombo = new JComboBox<>(new String[]{"0", "1", "2", "3","4", "5", "6", "7", "8", "9", "10"});
    kidNoCombo.setFont(STANDARD_FONT);
    kidNoCombo.setBounds(200, 260, 150, 40);
    panel1.add(kidNoCombo);

    JLabel contactLabel = new JLabel("Contact Noumber:");
    contactLabel.setFont(BOLD_FONT);
    contactLabel.setBounds(5, 300, 150, 30 );
    panel1.add(contactLabel);
    JTextField contactField = new JTextField();
    contactField.setFont(STANDARD_FONT);
    contactField.setBounds(200, 300, 200, 45 );
    panel1.add(contactField);

    JRadioButton confirmJRadioButton = new JRadioButton("CONFIRM");
    confirmJRadioButton.setFont(BOLD_FONT);
    confirmJRadioButton.setBounds(450, 340, 200, 30 );
    panel1.add(confirmJRadioButton);

    //panel2 for reciept display ~ Talha
    JPanel panel2 = new JPanel();
    panel2.setBounds(620, 110, 350, 530);
    panel2.setLayout(new BorderLayout());


    // TextArea for displaying the receipt ~ Talha
    JTextArea receiptTextArea = new JTextArea();
    receiptTextArea.setEditable(false); 
    receiptTextArea.setLineWrap(true); 
    receiptTextArea.setWrapStyleWord(true); 

    receiptTextArea.setFont(BOLD_FONT);

    // Receipt text ~ Talha
    String receiptText = "**************************************\n"
    + "*            RECEIPT                 *\n"
    + "**************************************\n\n"
    + "Date:          02-09-2024\n"
    + "---------------------------------\n"
    + "From:          Ampang LRT station\n"
    + "To:            Bukit Nanas Monorel station\n"
    + "---------------------------------\n"
    + "Ticket Type:   Train\n"
    + "Departure Time:    07:30\n"
    + "---------------------------------\n"
    + "Adult passengers No.:  3    RM 5.00 x 2\n"
    + "Kid passengers No.:    1    RM 3.00 x 1\n"
    + "---------------------------------\n\n"
    + "Total:        RM 16.00\n\n"
    + "---------------------------------\n\n"
    + "Please proceed to payment...\n\n"
    + "---------------------------------\n\n"
    + "THANK YOU FOR YOUR PURCHASE!\n"
    +"Come again<3";

    receiptTextArea.setText(receiptText);

    // Wrap the JTextArea in a JScrollPane
    JScrollPane scrollPane = new JScrollPane(receiptTextArea);
    panel2.add(scrollPane, BorderLayout.CENTER);


    // penel for buttons payment option
    JPanel panel3 = new JPanel();
    panel3.setBounds(10, 480, 600, 160);
    panel3.setLayout(null);
    
    JLabel paymentJLabel = new JLabel("How would you like to pay?");
    paymentJLabel.setFont(new Font("Aharoni", Font.PLAIN, 20));
    paymentJLabel.setBounds(20, 50, 300, 50);
    panel3.add(paymentJLabel);
    JButton paymeButton1 = new JButton("ONLINE");
    paymeButton1.setFont(BOLD_FONT);
    paymeButton1.setBounds(20, 105, 150, 50);
    panel3.add(paymeButton1);
    JButton paymeButton2 = new JButton("ONSITE");
    paymeButton2.setFont(BOLD_FONT);
    paymeButton2.setBounds(200, 105, 150, 50);
    panel3.add(paymeButton2);

    // buttons "Logout" and "quit"
    JButton logoutButton = new JButton("Logout");
    logoutButton.setFont(BOLD_FONT);
    logoutButton.setBounds(350, 750, 140, 45);
    JButton quitButton = new JButton("Quit");
    quitButton.setFont(BOLD_FONT);
    quitButton.setBounds(510, 750, 140, 45);

    // Quit button 
    quitButton.addActionListener(e -> System.exit(0));

    // logout button 
    logoutButton.addActionListener(e -> {
        new HomePage().setVisible(true);
        dispose(); // Close the current window
    });

    add(quitButton);
    add(logoutButton);
    add(panel3);
    add(panel2);
    add(panel1);
    add(panel0);
    add(backgroundLabel);
    setVisible(true);
    }

    public static void main(String[] args) {
        new booking();
    }
}
