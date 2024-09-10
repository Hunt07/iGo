import javax.swing.*;
import java.awt.*;

public class loading extends JFrame
{
    public loading()
    {
        setTitle("Loading Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 850);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        //add a background image 
        ImageIcon originalIcon = new ImageIcon("./bg.png");

        // Scale the image to fit the frame size
        Image scaledImage = originalIcon.getImage().getScaledInstance(1000, 850, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel backgroundLabel = new JLabel(scaledIcon);
        backgroundLabel.setBounds(0, 0, 1000, 850);

        //Create a panel and add the logo 
        JPanel panel0 = new JPanel();
        panel0.setBounds(100, 100, 1000, 350);
        panel0.setLayout(null);
        panel0.setOpaque(false);
    
        JLabel LabelLogo1 = new JLabel("I-Go!");
        LabelLogo1.setFont(new Font("Aharoni", Font.BOLD, 100));
        LabelLogo1.setBounds(30, 5, 1000, 150);
        JLabel LabelLogo2 = new JLabel("Public Scheduling Transportation System");
        LabelLogo2.setFont(new Font("Aharoni", Font.BOLD, 30));
        LabelLogo2.setBounds(30, 100, 1000, 100);
    
        panel0.add(LabelLogo1);
        panel0.add(LabelLogo2);

        //Add a panel for text "WELCOME"
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(new Color(0, 0, 0, 250));  
        welcomePanel.setBounds(200, 400, 600, 150); 
        welcomePanel.setLayout(new BorderLayout()); 
        JLabel titleLabel = new JLabel("WELCOME!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 80)); 
        titleLabel.setForeground(Color.WHITE); 
        welcomePanel.add(titleLabel, BorderLayout.CENTER);

        JLabel loadingLabel = new JLabel("Loading the page...");
        loadingLabel.setFont(new Font("SansSerif", Font.BOLD, 20)); 
        loadingLabel.setForeground(Color.WHITE); 
        loadingLabel.setBounds(750, 700, 200, 100);

         add(loadingLabel);
         add(welcomePanel);
         add(panel0);
         add(backgroundLabel);
         setVisible(true);
    }
}