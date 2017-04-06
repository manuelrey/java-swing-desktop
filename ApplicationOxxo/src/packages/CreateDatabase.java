package packages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CreateDatabase {
	public static String main(String messages)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String urlDB = "D:\\ApplicationOxxo\\Database\\oxxoDB.accdb";
            String url = "jdbc:ucanaccess://" + urlDB +";newDatabaseVersion=V2010";
            Connection conctn = DriverManager.getConnection(url);
            Statement statmnt = conctn.createStatement();
              	
            String sql = "CREATE TABLE detalle(" +
            		"clave_banco text," +
            		"cuenta_banco text," +
            		"consecutivo_extracto text," +
            		"fecha_transaccion text," +
            		"campo_vacio_01 text," +
            		"campo_vacio_02 text," +
            		"clave_trans_banco text," +
            		"campo_vacio_03 text," +
            		"campo_vacio_04 text," +
            		"numero_cheque text," +
            		"monto_cheque text," +
            		"campo_vacio_05 text," +
            		"campo_vacio_06 text," +
            		"fecha_efectiva text," +
            		"campo_vacio_07 text," +
            		"campo_vacio_08 text," +
            		"nit_ref_1 text," +
            		"ref_2 text," +
            		"referencia text," +
            		"causal_rechazo text," +
            		"codigo_unico_trans text," +
            		"numero_consignacion text)";
            
            statmnt.execute(sql);
            try {
            	conctn.close();
            	System.out.print("Database closed" + "\n");
            }catch(SQLException e){
            	System.out.print("Error to close database");
            }
            String ok = "Database created: ";
            JOptionPane.showMessageDialog(null,ok + urlDB);
            messages = Calendar.main()+" - "+ ok + urlDB + "\n";
            
        }
        catch(Exception sqlException)
        {
        	String error = "Failed to create database";       	
        	JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
        	messages = Calendar.main()+" - " + error + "\n"; 
        	sqlException.printStackTrace();
        }
        System.gc();
        return messages;
        
    } 	
}

