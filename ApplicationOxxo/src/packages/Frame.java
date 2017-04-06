package packages;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class Frame  {
	
	 JTextArea output;
	 JScrollPane scrollPane;
	 
	 
	public JMenuBar createMenuBar() {
		
        JMenuBar menuBar;
        JMenu menu;
        JMenu database;
        JMenu directory;
        JMenuItem menuItemLoadFile;
        JMenuItem menuItemCreateFile;
        JMenuItem menuItemExit;
        JMenuItem databaseItemCreateDb;
        JMenuItem databaseItemDeleteDb;
        JMenuItem directoryItemCreate;
        JMenuItem directoryItemDelete;
            
        //Create the menu bar.
        menuBar = new JMenuBar();
        
        //Build the first menu.
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);
        
        database = new JMenu("Database");
        database.setMnemonic(KeyEvent.VK_D);
        menuBar.add(database);
        
        directory = new JMenu("Directory");
        directory.setMnemonic(KeyEvent.VK_R);
        menuBar.add(directory);
        
        //a group of JMenuItems
        menuItemLoadFile = new JMenuItem("Import...");
        menuItemLoadFile.setMnemonic(KeyEvent.VK_I);
        menuItemLoadFile.addActionListener(new MenuActionListenerLoadFile());
        menu.add(menuItemLoadFile);
        
        menuItemCreateFile = new JMenuItem("Export...");
        menuItemCreateFile.setMnemonic(KeyEvent.VK_X);
        menuItemCreateFile.addActionListener(new MenuActionListenerCreateFile());
        menu.add(menuItemCreateFile);
        
        menuItemExit = new JMenuItem("Exit");
        menuItemExit.setMnemonic(KeyEvent.VK_E);
        menuItemExit.addActionListener(new MenuActionListenerExit());
        menu.add(menuItemExit);
        
        databaseItemCreateDb = new JMenuItem("Create");
        databaseItemCreateDb.setMnemonic(KeyEvent.VK_C);
        databaseItemCreateDb.addActionListener(new MenuActionListenerCreateDb());
        database.add(databaseItemCreateDb);
        
        databaseItemDeleteDb = new JMenuItem("Delete");
        databaseItemDeleteDb.setMnemonic(KeyEvent.VK_L);
        databaseItemDeleteDb.addActionListener(new MenuActionListenerDeleteDb());
        database.add(databaseItemDeleteDb);
        
        directoryItemCreate = new JMenuItem("Create");
        directoryItemCreate.setMnemonic(KeyEvent.VK_A);
        directoryItemCreate.addActionListener(new MenuActionListenerCreateDirectory());
        directory.add(directoryItemCreate);
        
        directoryItemDelete = new JMenuItem("Delete");
        directoryItemDelete.setMnemonic(KeyEvent.VK_T);
        directoryItemDelete.addActionListener(new MenuActionListenerDeleteDirectory());
        directory.add(directoryItemDelete);
        
             
        return menuBar;
	}
	
    public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }
    
    class MenuActionListenerLoadFile implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	//LoadFile.main();
	    	output.append(ImportFile.main(null));		
	    }
    }
    
    class MenuActionListenerCreateFile implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	output.append(ExportFile.main(null));    		
	    }
    }
    
    class MenuActionListenerExit implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	System.exit(0);
	    }
    }
    
    class MenuActionListenerCreateDb implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	//CreateDb.main();
	    	output.append(CreateDatabase.main(null));	    	
	    }
    }
    
    class MenuActionListenerDeleteDb implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	output.append(DeleteDatabase.main(null));
	    }
    }
    
    class MenuActionListenerCreateDirectory implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	output.append(CreateDirectory.main(null));	    	
	    }
    }
    
    class MenuActionListenerDeleteDirectory implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	output.append(DeleteDirectory.main(null));	    	
	    }
    }
    
 
     
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
        JFrame frame = new JFrame("Application OXXO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Frame prueba = new Frame();
        frame.setJMenuBar(prueba.createMenuBar());
        frame.setContentPane(prueba.createContentPane());

        //Display the window.
        frame.setSize(450, 260);
        frame.setLocationRelativeTo(null);
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
