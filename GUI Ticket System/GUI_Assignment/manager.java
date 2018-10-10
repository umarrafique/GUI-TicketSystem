package GUI_Assignment;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;


public class manager extends JFrame {
	
	 String data [][]  = null;
	 String colNames[]  = null;
	 JTable table = null;
	 JScrollPane sr = null;
	 JPanel left = null;
	 JComboBox tkUser = null;
//	 int data1[][] = null;
	


	public manager() {
		
		
		
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		  setVisible(true);
		  setSize(1000,500);
		  this.setLayout(new GridLayout(1,1));
		  Controller myController = new Controller(this);
		  
		  
		  
		  left = new JPanel();
		  this.add(left);
	
			  
		  
	    	ticks2();
	    	
	   
	    	   
		
		    	    
	
		  
		  JPanel right = new JPanel();
		  right.setLayout(new FlowLayout());
		  
		  JLabel userLabel = new JLabel("SELECT THE USER YOU WANT TO CHECK TICKET");
			right.add(userLabel);
			
			tkUser = new JComboBox();
			
			tkUser.addItem("John");
			tkUser.addItem("James");
			tkUser.addItem("Johan");
			tkUser.setSelectedItem(myController);
			right.add(tkUser);
  
		  
		  JButton b = new JButton ("Check Tickets");
		  b.addActionListener(myController);
		  b.setActionCommand("chkTk");
		  right.add(b);
		  
		  JButton b1 = new JButton ("Open Tickets");
		  b1.addActionListener(myController);
		  b1.setActionCommand("opnTk");
		  right.add(b1);
		  
		  JButton b2 = new JButton ("Close Tickets");
		  b2.addActionListener(myController);
		  b2.setActionCommand("clsTK");
		  right.add(b2);
		  
		  JButton b3 = new JButton ("Cost");
		  b3.addActionListener(myController);
		  b3.setActionCommand("cT");
		  right.add(b3);
		  
		  JButton b4 = new JButton ("Refresh");
		  b4.addActionListener(myController);
		  b4.setActionCommand("f5");
		  right.add(b4);
		  
		  JButton b5 = new JButton ("Bar Graph");
		  b5.addActionListener(myController);
		  b5.setActionCommand("brG");
		  right.add(b5);
		  
		  JButton b6 = new JButton ("Logout");
		  b6.addActionListener(myController);
		  b6.setActionCommand("logoutma");
		  right.add(b6);
			
			
			this.add(right); 
		  

			validate();
			repaint();
	System.out.println(" Boss");
}
	
	public void ticks() {
		
		left.removeAll();
		String tkUs = (String) tkUser.getSelectedItem();
		System.out.println((String) tkUser.getSelectedItem());
		String query = "select * from tickets WHERE `Assigned to` LIKE ('%"+tkUs+"%');";
		database db = new database(query);
		db.login();
		ResultSet rs = db.login();
		
		
		 data = new String[100][6];
    	    int counter = 0;
    	    try {
				while(rs.next()){
					String Id = rs.getString("Id");
				 
					data[counter][0] = Id;
				  
				    String un = rs.getString("Description");
					data[counter][1] = un;    	      
				    
				    String pw = rs.getString("Type");
				    data[counter][2] = pw;
					
					String em =rs.getString("Assigned to");
					data[counter][3]= em;
				    
					String ag = rs.getString("Epoch Open");
					data[counter][4] = ag;
					
					String ad = rs.getString("Epoch Close");
					data[counter][5] = ad;
					
				    counter = counter + 1;
				}
	
				 String[] colNames = {"Id", "Description", "Type", "Assigned to", "Epoch Open", "Epoch Close"};
					
				 table = new JTable(data, colNames);
				 sr = new JScrollPane(table);
				 
				 left.add(sr);
				 left.validate();
				 left.repaint();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	public void ticks0() {
		
		left.removeAll();
		String query = "select * from tickets where `Epoch Open` ;";
		database db = new database(query);
		db.login();
		ResultSet rs = db.login();
		
		
		 data = new String[100][2];
    	    int counter = 0;
    	    try {
				while(rs.next()){
					
					String Id = rs.getString("Id");
					data[counter][0] = Id;
					
					String ad = rs.getString("Epoch Open");
					data[counter][1] = ad;
					
				    counter = counter + 1;
				}
	
				 String[] colNames = {"Id", "Epoch Open"};
					
				 table = new JTable(data, colNames);
				 sr = new JScrollPane(table);
				 
				 left.add(sr);
				 left.validate();
				 left.repaint();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    
		}
	
public void ticks1() {
		
		left.removeAll();
		String query = "select * from tickets where `Epoch Close` IS NOT NULL ;";
		database db = new database(query);
		db.login();
		ResultSet rs = db.login();
		
		
		 data = new String[100][3];
    	    int counter = 0;
    	    try {
				while(rs.next()){
					
					String Id = rs.getString("Id");
					data[counter][0] = Id;
					
					String ad = rs.getString("Epoch Open");
					data[counter][1] = ad;
					
					String ad1 = rs.getString("Epoch Close");
					data[counter][2] = ad1;
					
				    counter = counter + 1;
				}
	
				 String[] colNames = {"ID Of Closed Tickets","Ticket Opening Time", "Ticket Closing Time"};
					
				 table = new JTable(data, colNames);
				 sr = new JScrollPane(table);
				 
				 left.add(sr);
				 left.validate();
				 left.repaint();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    
		}
	
	public void ticks2() {
		
		left.removeAll();
		String query = "select * from tickets;";
		database db = new database(query);
		db.login();
		ResultSet rs = db.login();
		
		
		 data = new String[100][6];
    	    int counter = 0;
    	    try {
				while(rs.next()){
					String Id = rs.getString("Id");
				 
					data[counter][0] = Id;
				  
				    String un = rs.getString("Description");
					data[counter][1] = un;    	      
				    
				    String pw = rs.getString("Type");
				    data[counter][2] = pw;
					
					String em =rs.getString("Assigned to");
					data[counter][3]= em;
				    
					String ag = rs.getString("Epoch Open");
					data[counter][4] = ag;
					
					String ad = rs.getString("Epoch Close");
					data[counter][5] = ad;
					
				    counter = counter + 1;
				}
	
				 String[] colNames = {"Id", "Description", "Type", "Assigned to", "Epoch Open", "Epoch Close"};
					
				 table = new JTable(data, colNames);
				 sr = new JScrollPane(table);
				 
				 left.add(sr);
				 left.validate();
				 left.repaint();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}	
	public void ticks3() {
	left.removeAll();
	String query = "SELECT * From tickets";
	//String query = "SELECT * FROM tickets";
	database db = new database(query);
	db.login();
	ResultSet rs = db.login();

	
	
	 data = new String[100][2];
	    int counter = 0;
	    try {
			while(rs.next()){
				
				String Id = rs.getString("Id");
				data[counter][0] =  Id;
			    counter = counter + 1;
			  
			}
			 System.out.println( "Id" + counter );
			  int counter1 = counter * 50;
			  System.out.println("Total Cost of Tickets" + counter1);

			/* String[] colNames = {"Id", "Total Cost"};
			 int Cost = counter1;
			 */
			 JOptionPane.showInputDialog("Total Cost of Tickets: " + counter1  );
				
			/* table = new JTable(data, colNames);
			 sr = new JScrollPane(table);
			 
			 left.add(sr);
			 left.validate();
			 left.repaint();*/
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	    
	}
}