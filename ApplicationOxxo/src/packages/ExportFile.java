package packages;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ExportFile {
	public static String main(String messages)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String urlDB = "D:\\ApplicationOxxo\\Database\\oxxoDB.accdb";
            String url = "jdbc:ucanaccess://" + urlDB;           
            Connection conctn = DriverManager.getConnection(url);
            Statement statmnt = conctn.createStatement();
            String sql = "SELECT * FROM detalle";
            
            String dateFile= DateFiles.main();
			String urlFile = "D:\\ApplicationOxxo\\Files\\"+dateFile+"_File.txt";          
            FileWriter fw = new FileWriter(urlFile);
            
            ResultSet rsltSet = statmnt.executeQuery(sql);
            while(rsltSet.next())
		    {
		        String clave_banco = rsltSet.getString("clave_banco");
		        String cuenta_banco = rsltSet.getString("cuenta_banco");
		        String consecutivo_extracto = rsltSet.getString("consecutivo_extracto");
		        String fecha_transaccion = rsltSet.getString("fecha_transaccion");
		        String campo_vacio_01 = rsltSet.getString("campo_vacio_01");
		        String campo_vacio_02 = rsltSet.getString("campo_vacio_02");
		        String clave_trans_banco = rsltSet.getString("clave_trans_banco");
		        String campo_vacio_03 = rsltSet.getString("campo_vacio_03");
		        String campo_vacio_04 = rsltSet.getString("campo_vacio_04");
		        String numero_cheque = rsltSet.getString("numero_cheque");
		        String monto_cheque = rsltSet.getString("monto_cheque");
		        String campo_vacio_05 = rsltSet.getString("campo_vacio_05");
		        String campo_vacio_06 = rsltSet.getString("campo_vacio_06");
		        String fecha_efectiva = rsltSet.getString("fecha_efectiva");
		        String campo_vacio_07 = rsltSet.getString("campo_vacio_07");
		        String campo_vacio_08 = rsltSet.getString("campo_vacio_08");
		        String nit_ref_1 = rsltSet.getString("nit_ref_1");
		        String ref_2 = rsltSet.getString("ref_2");
		        String referencia = rsltSet.getString("referencia");
		        String causal_rechazo = rsltSet.getString("causal_rechazo");
		        String codigo_unico_trans = rsltSet.getString("codigo_unico_trans");
		        String numero_consignacion = rsltSet.getString("numero_consignacion");
		        
		        //String apellidos = rsltSet.getString("apellidos");
		        System.out.println(clave_banco +
		        		";" + cuenta_banco +
		        		";" + consecutivo_extracto +
		        		";" + fecha_transaccion +
		        		";" + campo_vacio_01 +
		        		";" + campo_vacio_02 +
		        		";" + clave_trans_banco +
		        		";" + campo_vacio_03 + 
		        		";" + campo_vacio_04 + 
		        		";" + numero_cheque + 
		        		";" + monto_cheque +
		        		";" + campo_vacio_05 +
		        		";" + campo_vacio_06 + 
		        		";" + fecha_efectiva + 
		        		";" + campo_vacio_07 + 
		        		";" + campo_vacio_08 + 
		        		";" + nit_ref_1 + 
		        		";" + ref_2 + 
		        		";" + referencia + 
		        		";" + causal_rechazo +
		        		";" + codigo_unico_trans + 
		        		";" + numero_consignacion +";;;;;;;;;;;;;;");
		        try{
					
					fw.write(clave_banco +
							";" + cuenta_banco +
			        		";" + consecutivo_extracto +
			        		";" + fecha_transaccion +
			        		";" + campo_vacio_01 +
			        		";" + campo_vacio_02 +
			        		";" + clave_trans_banco +
			        		";" + campo_vacio_03 + 
			        		";" + campo_vacio_04 + 
			        		";" + numero_cheque + 
			        		";" + monto_cheque +
			        		";" + campo_vacio_05 +
			        		";" + campo_vacio_06 + 
			        		";" + fecha_efectiva + 
			        		";" + campo_vacio_07 + 
			        		";" + campo_vacio_08 + 
			        		";" + nit_ref_1 + 
			        		";" + ref_2 + 
			        		";" + referencia + 
			        		";" + causal_rechazo +
			        		";" + codigo_unico_trans + 
			        		";" + numero_consignacion +";;;;;;;;;;;;;;"+"\r\n");
					
				}catch(IOException e){
					System.out.print(e);
				}		    
		    }
            String ok = "File was created in: ";
            JOptionPane.showMessageDialog(null,ok + urlFile);
            messages =Calendar.main() + " - " + ok + urlFile + "\n" ; 
		    conctn.close();
		    fw.close();		    
        }
        catch(Exception sqlExcptn)
        {
        	String error = "Failed to export file";
        	JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
        	messages = Calendar.main() + " - " + error + "\n";
            System.out.println(sqlExcptn);
        }
        return messages;
    }
}