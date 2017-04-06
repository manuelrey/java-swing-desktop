package packages;

import java.io.File;

import javax.swing.JOptionPane;

public class CreateDirectory {
	
	public static String DirectoryMain(String messagesMain){
		String directoryName = "D:\\ApplicationOxxo";		
		File theDir = new File(directoryName);
		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    System.out.println("Creating directory: " + directoryName);
		    boolean result = false;
		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        System.out.print(se);
		    }        
		    if(result) {   
		    	String ok = "ApplicationOxxo directory was created in: "+ directoryName;
				JOptionPane.showMessageDialog(null,ok);
				messagesMain = Calendar.main()+" - "+ ok + "\n"; 
		        System.out.println("Directory main created");  
		    }
		}else{
			String error = "Failed to create ApplicationOxxo directory  / Directory already exist";
			JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
			messagesMain = Calendar.main()+" - "+ error + "\n"; 
			System.out.println("Failed to create directory / Directory already exist");
		}
		return messagesMain;
	}
	
	public static String DirectoryDatabase(String messagesDatabase){
		String directoryName = "D:\\ApplicationOxxo\\Database";		
		File theDir = new File(directoryName);
		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    System.out.println("Creating directory: " + directoryName);
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        System.out.print(se);
		    }        
		    if(result) {
		    	String ok = "Database directory was created in: " + directoryName;
				JOptionPane.showMessageDialog(null,ok);
				messagesDatabase= Calendar.main()+" - "+ ok + "\n"; 
		        System.out.println("Database directory was created");  
		    }
		}else{
			String error = "Failed to create Database directory / Directory already exist";
			JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
			messagesDatabase= Calendar.main()+" - "+ error + "\n"; 
			System.out.println("Failed to create Database directory / Directory already exist");
		}
		return messagesDatabase;
	}

	public static String DirectoryLog(String messagesLog){
		String directoryName = "D:\\ApplicationOxxo\\Log";		
		File theDir = new File(directoryName);
		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    System.out.println("Creating directory: " + directoryName);
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        System.out.print(se);
		    }        
		    if(result) { 
		    	String ok = "Log directory was created in: " + directoryName;
				JOptionPane.showMessageDialog(null,ok);
				messagesLog = Calendar.main()+" - "+ ok + "\n"; 
		        System.out.println("Directory Log created");  
		    }
		}else{
			String error = "Failed to create Log directory / Directory already exist";
			JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
			messagesLog = Calendar.main()+" - "+ error + "\n"; 
			System.out.println("Failed to create Log directory / Directory already exist");
		}
		return messagesLog;
	}
	
	public static String DirectoryFiles(String messagesFiles){
		String directoryName = "D:\\ApplicationOxxo\\Files";		
		File theDir = new File(directoryName);
		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    System.out.println("Creating directory: " + directoryName);		    
		    boolean result = false;

		    try{
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		        System.out.print(se);
		    }        
		    if(result) { 
		    	String ok = "Files directory was created in: " + directoryName;
				JOptionPane.showMessageDialog(null,ok);
				messagesFiles = Calendar.main()+" - "+ ok + "\n"; 
		        System.out.println("Files directory was created");  
		    }
		}else{
			String error = "Failed to create directory Files / Directory already exist";
			JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
			messagesFiles = Calendar.main()+" - "+ error + "\n"; 
			System.out.println("Failed to create directory / Directory already exist");
		}
		return messagesFiles;
	}
	
	public static String main(String [] args ) {
		
		return 	DirectoryMain(null)+ 
				DirectoryDatabase(null)+
				DirectoryLog(null)+
				DirectoryFiles(null);
		
	}
}
