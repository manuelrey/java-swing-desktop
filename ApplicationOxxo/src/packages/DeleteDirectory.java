package packages;

import java.io.File;

import javax.swing.JOptionPane;

public class DeleteDirectory {

	public static void DeleteFileFolder() {
		String path = "D:\\ApplicationOxxo";
	    File file = new File(path);
	    if(file.exists())
	    {
        	int n = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete all directories and files?","Validation",JOptionPane.YES_NO_OPTION);

        	String result = "?";
        	switch (n) {
        	
        	case JOptionPane.YES_OPTION:
        	  result = "YES";
        	  do{
  	            delete(file);
  	        	}while(file.exists());
        	break;
        	
        	case JOptionPane.NO_OPTION:
        	  result = "NO";
        	  System.out.print("Deleting directories was cancelled");
        	  break;
        	default:
        	  ;
        	}
        	System.out.println("Replace? " + result);
	    }else
	    {
	        System.out.println("File or Folder not found : "+path);
	    }

	}
	private static void delete(File file)
	{
	    if(file.isDirectory())
	    {
	        String fileList[] = file.list();
	        if(fileList.length == 0)
	        {
	            System.out.println("Deleting Directory : "+file.getPath());
	            try{
	            	file.delete();
	            }catch(Exception e){
	            	System.out.println(e);
	            }
	        }else
	        {
	            int size = fileList.length;
	            for(int i = 0 ; i < size ; i++)
	            {
	                String fileName = fileList[i];
	                System.out.println("File path : "+file.getPath()+" and name :"+fileName);
	                String fullPath = file.getPath()+"/"+fileName;
	                File fileOrFolder = new File(fullPath);
	                System.out.println("Full Path :"+fileOrFolder.getPath());
	                try{
	                	delete(fileOrFolder);
		            }catch(Exception e){
		            	System.out.println(e);
		            }
	            }
	        }
	    }else
	    {
	        System.out.println("Deleting file : "+file.getPath());
	        try{
	        file.delete();
	        }catch(Exception e){
            	System.out.println(e);
            }
	    }
	}
	
	public static String main(String[] args) {
		
		DeleteFileFolder();
		return null;
	}

}
