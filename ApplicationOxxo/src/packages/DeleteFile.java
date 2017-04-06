package packages;

import java.io.File;

public class DeleteFile {
	
	public static void main(String[] args){
		
		try{
			
			File file = new File("D:\\ApplicationOxxo\\log.txt");			
			file.delete();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
