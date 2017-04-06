package packages;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import javax.swing.table.DefaultTableModel;

class ShowData1 extends JFrame{
	
	String[] columnNames = {"field 01",
			"Field 02",
			"Field 03",
			"Field 04",
			"Field 05",
			"Field 06",
			"Field 07",
			"Field 08",
			"Field 09",
			"Field 10", 
			"Field 11",
			"Field 12",
			"Field 13", 
			"Field 14",
			"Field 15",
			"Field 16",
			"Field 17",
			"Field 18", 
			"Field 19",
			"Field 20",
			"Field 21",
			"Field 22"};
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll ;
	String driver;
	String dsn;
	String qry;
	Connection con;
	Statement st;
	ResultSet rs ;
	
	void ShowData2(){
		setTitle("Database Search Result");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		
		//Connection to access database 
        String urlDb ="D:\\ApplicationOxxo\\oxxoDB.accdb"; 
		String url = "jdbc:ucanaccess://" + urlDb;
		//Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		//Connection con = DriverManager.getConnection(url);
		//Statement st=con.createStatement();
		
		driver="net.ucanaccess.jdbc.UcanaccessDriver";
		//dsn="jdbc:odbc:stumdb";
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("Select * from detalle");
			//To remove previously added rows
			while(model.getRowCount() > 0){
				model.removeRow(0);
			}
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				Object[] row = new Object[columns];
				for (int i = 0; i < columns; i++){
					row[i] = rs.getObject(i+1);
				}
				//table.insertRow(rs.getRow()-1,row);
				model.addRow(row);
			}
			rs.close();
			stat.close();
			con.close();
		}catch(SQLException e){
			System.out.println(e);
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}
	table = new JTable();
	table.setModel(model);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	scroll = new JScrollPane(table);
	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	add(scroll);
	setVisible(true);
	setSize(500, 400);
	setLocationRelativeTo(null);
	}
}

public class ViewData{
	public static void main(String ar[]){
		ShowData1 s1=new ShowData1();
		s1.ShowData2();
	}
}
