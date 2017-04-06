package packages;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ImportFile{
	
	public static String main(String messages){
	try{
		//Connection to access database 
        String urlDb ="D:\\ApplicationOxxo\\Database\\oxxoDB.accdb"; 
		String url = "jdbc:ucanaccess://" + urlDb;
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		Connection con = DriverManager.getConnection(url);
		Statement st=con.createStatement();
		
		//Chooser file.txt
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		int rVal = fileChooser.showOpenDialog(null);
		if(rVal == JFileChooser.APPROVE_OPTION){
			try {
				String line = null;
				BufferedReader br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
			
					ArrayList<String> list=new ArrayList<String>();
					while ((line = br.readLine()) != null ){	   
						list.add(line);
					}
					Iterator<String> itr;
				    for (itr=list.iterator(); itr.hasNext(); ){
				    	String str=itr.next().toString();  
				    	String [] splitSt =str.split(";");
				    	String 	clave_banco="",
							    cuenta_banco="", 
							    consecutivo_extracto="",
					            fecha_transaccion="",
					            campo_vacio_01="",
					            campo_vacio_02="",
					            clave_trans_banco="",
					            campo_vacio_03="",
					            campo_vacio_04="",
					            numero_cheque="",
					            monto_cheque="",
					            campo_vacio_05="",
					            campo_vacio_06="",
					            fecha_efectiva="",
					            campo_vacio_07="",
					            campo_vacio_08="",
					            nit_ref_1="",
					            ref_2="",
					            referencia="",
					            causal_rechazo="",
					            codigo_unico_trans="",
					            numero_consignacion="";
					            
				    	
				    	for (int i = 0 ; i < splitSt.length ; i++) {;
				    		clave_banco=splitSt[0];
				    		cuenta_banco=splitSt[1]; 
				    	    consecutivo_extracto=splitSt[2];
		            		fecha_transaccion=splitSt[3];
		            		campo_vacio_01=splitSt[4];
		            		campo_vacio_02=splitSt[5];
		            		clave_trans_banco=splitSt[6];
		            		campo_vacio_03=splitSt[7];
		            		campo_vacio_04=splitSt[8];
		            		numero_cheque=splitSt[9];
		            		monto_cheque=splitSt[10];
		            		campo_vacio_05=splitSt[11];
		            		campo_vacio_06=splitSt[12];
		            		fecha_efectiva=splitSt[13];
		            		campo_vacio_07=splitSt[14];
		            		campo_vacio_08=splitSt[15];
		            		nit_ref_1=splitSt[16];
		            		ref_2=splitSt[17];
		            		referencia=splitSt[18];
		            		causal_rechazo=splitSt[19];
		            		codigo_unico_trans=splitSt[20];
		            		numero_consignacion=splitSt[21];						    		
				    	}
				    	
				    String sql="insert into detalle(clave_banco," +
				    			"cuenta_banco," +
				    			"consecutivo_extracto," +
			            		"fecha_transaccion," +
			            		"campo_vacio_01," +
			            		"campo_vacio_02," +
			            		"clave_trans_banco," +
			            		"campo_vacio_03," +
			            		"campo_vacio_04," +
			            		"numero_cheque," +
			            		"monto_cheque," +
			            		"campo_vacio_05," +
			            		"campo_vacio_06," +
			            		"fecha_efectiva," +
			            		"campo_vacio_07," +
			            		"campo_vacio_08," +
			            		"nit_ref_1," +
			            		"ref_2," +
			            		"referencia," +
			            		"causal_rechazo," +
			            		"codigo_unico_trans," +
			            		"numero_consignacion)" +
			            		"values('"+clave_banco+"'," +
			            				"'"+cuenta_banco+"'," +
			            				"'"+consecutivo_extracto+"'," +
					            		"'"+fecha_transaccion+"'," +
					            		"'"+campo_vacio_01+"'," +
					            		"'"+campo_vacio_02+"'," +
					            		"'"+clave_trans_banco+"'," +
					            		"'"+campo_vacio_03+"'," +
					            		"'"+campo_vacio_04+"'," +
					            		"'"+numero_cheque+"'," +
					            		"'"+monto_cheque+"'," +
					            		"'"+campo_vacio_05+"'," +
					            		"'"+campo_vacio_06+"'," +
					            		"'"+fecha_efectiva+"'," +
					            		"'"+campo_vacio_07+"'," +
					            		"'"+campo_vacio_08+"'," +
					            		"'"+nit_ref_1+"'," +
					            		"'"+ref_2+"'," +
					            		"'"+referencia+"'," +
					            		"'"+causal_rechazo+"'," +
					            		"'"+codigo_unico_trans+"'," +
					            		"'"+numero_consignacion+"')";
				    	st.executeUpdate(sql);				    	
				    }					
			}catch(SQLException e){
				System.out.println(e);
			}
			String ok = "File was imported into a database";
			JOptionPane.showMessageDialog(null,ok);
			messages = Calendar.main()+" - "+ ok + "\n"; 
		}else{
			String error = "No file selected or cancel/close";
			JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
			messages = Calendar.main()+" - "+ error + "\n"; 
		}
	}catch(Exception e){
		String error = "Failed to import file";
		JOptionPane.showMessageDialog(null,error, null, JOptionPane.ERROR_MESSAGE);
		messages = Calendar.main()+" - "+ error + "\n"; 
		System.out.println(e);
	}
	return messages;
	}
	
}