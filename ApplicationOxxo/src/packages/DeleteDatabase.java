package packages;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


import javax.swing.JOptionPane;

import org.hsqldb.lib.InOutUtil;

public class DeleteDatabase {
	
	public static String main(String messages)  {
		try{
			
			Path path = Paths.get("D:\\ApplicationOxxo\\Database\\oxxoDB.accdb");
			Files.delete(path);
			String ok = "Database is deleted"; 
			JOptionPane.showMessageDialog(null,ok);
			messages = Calendar.main()+" - "+ ok + "\n";
			
		}catch(IOException | SecurityException e){
			
			String error = "Failed to delete database";
			JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
			messages = Calendar.main()+" - "+ error + "\n";
			e.printStackTrace();
		}

		return messages;
	}

}