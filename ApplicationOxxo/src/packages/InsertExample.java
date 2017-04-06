package packages;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class InsertExample {
	
	static JTextField text1;
	static JTextField text2;
	static JTextField text3;

private static void createAndShowGUI() {
    	
    	//Use the Java look and feel.
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { }
        
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Insert example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        //Create and set up the content pane.
        Frame insert = new Frame();
        
        JLabel label1 = new JLabel("From: ");
        JLabel label2 = new JLabel("To: ");
        JLabel label3 = new JLabel("Price: ");

        text1 = new JTextField(20);
        text2 = new JTextField(20);
        text3 = new JTextField(20);

        JButton button1 = new JButton("Add");
        JButton button2 = new JButton("Close");

        frame.add(label1, BorderLayout.WEST);
        frame.add(text1, BorderLayout.EAST);
        frame.add(label2, BorderLayout.WEST);
        frame.add(text2, BorderLayout.EAST);
        frame.add(label3, BorderLayout.WEST);
        frame.add(text3, BorderLayout.EAST);
        frame.add(button1);
        frame.add(button2);

        //Display the window.
        frame.setSize(500, 120);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        
      
    }
    

    
    public static void main(String[] args) {
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
}
