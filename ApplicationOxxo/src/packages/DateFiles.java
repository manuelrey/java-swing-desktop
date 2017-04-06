package packages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFiles {
	
	public static String main() {
		Date date = new Date();
    	DateFormat dateFormat = new SimpleDateFormat("HHmmss_ddMMyyyy");
    	//System.out.print("Hora y fecha: "+dateFormat.format(date));
    	return (dateFormat.format(date));

	}

}
