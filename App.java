import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//talha
//osama 9/11
public class App
{
    public static void main(String[] args) {
        // loading page
        loading load = new loading();

        // Set up a timer to switch to the home page after 5 seconds
        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the loading frame
                load.dispose();
                // Load the home page
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}

