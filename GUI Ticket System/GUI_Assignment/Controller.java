package GUI_Assignment;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.Instant;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.bind.JAXB;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import java.time.Instant;


public class Controller implements ActionListener{

	Main Login = null;
	
	systemAdmin sa = null;
	
	techSupport tc = null;
	
	manager m = null;
	





	
	public Controller(Main view) {
		
		this.Login = view; // local variable
		
//		
	}
	
	public Controller(systemAdmin admin) {
		// TODO Auto-generated constructor stub
		this.sa = admin ;
	
	}
	
	public Controller(techSupport tech) {
		
		this.tc = tech;
	}
	
	public Controller(manager ma) {
		this.m = ma;
	}
	






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("logoutTech")) {
			
			
			int n = JOptionPane.showConfirmDialog(Login, "Are you sure you want to Logout?",
				    "Cofirmation",
				    JOptionPane.YES_NO_OPTION);
				
			if (n == 0){
				tc.dispose();
				new Main();
				//System.exit(0);
				
			}
			
		} else if (e.getActionCommand().equals("logout")) {
			
			
			int n = JOptionPane.showConfirmDialog(Login, "Are you sure you want to Logout?",
				    "Cofirmation",
				    JOptionPane.YES_NO_OPTION);
				
			if (n == 0){
				
				sa.dispose();
				new Main();
				//System.exit(0);
				
			}
			
		} else if (e.getActionCommand().equals("logoutma")) {
			
			
			int n = JOptionPane.showConfirmDialog(Login, "Are you sure you want to Logout?",
				    "Cofirmation",
				    JOptionPane.YES_NO_OPTION);
				
			if (n == 0){
				
				m.dispose();
				new Main();
				//System.exit(0);
				
			}
			
		 } else if(e.getActionCommand().equals("login")) {
			String un = Login.username.getText();
			String pw = Login.password.getText();
			String query = "select * from users where username = '"+un+"' and password = '"+pw+"'";
			
			database db = new database(query);
			ResultSet rs = db.login();
			   try {
		    	    while(rs.next()){
		    	    String type = rs.getString("type");
	    	    	if(type.equals("Manager")) {
	    	    		new manager();
	    	    	}else if(type.equals("Tech Support")){
	    	    		new techSupport();  		 
	    	    	}else if (type.equals("Admin")) {
	    	    		new systemAdmin();
	    	    	}
	    	    	Login.dispose();
		    	    	
		    	 	   
		    	    	}
				   }catch (SQLException se) {
		    	    // handle any errors
		    	    		se.printStackTrace();
		    	}
			     

			
		}
		 else if (e.getActionCommand().equals("addNew")) {
			String usTp = (String) sa.usType.getSelectedItem();
			System.out.println("jcb Item is" + (String) sa.usType.getSelectedItem());
			
    	    String un = sa.username.getText();
    	    String pw = sa.password.getText();
    	 //   String tp = sa.type.getText();
    	    System.out.println("Working");
    	    String query = "INSERT INTO `gui`.`users` (`username`, `password`, `type` ) VALUES ('"+un+"', '"+pw+"', '"+usTp+"');";
    	    
    	    database db = new database(query);
    	    db.insert();
    	    System.out.println("inserted");
			JOptionPane.showMessageDialog(sa, "DATA Added to Table.", "Confirmation Dialog", 
					JOptionPane.INFORMATION_MESSAGE);
				   
		}
		else if(e.getActionCommand().equals("update")){
			  String id = sa.id.getText();    	    
			  String un = sa.username.getText();
	    	  String pw = sa.password.getText();
	    	  
	    	  String query = "update users Set username = ('"+un+"') , password = ('"+pw+"') Where ID = ('"+id+"');";
	    	
	    	  database db = new database(query);
	    	    db.insert();
	    	    System.out.println("UPDATED");
				JOptionPane.showMessageDialog(sa, "DATA UPDATED to Table.", "Confirmation Dialog", 
						JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(e.getActionCommand().equals("create")) {
			
			String tkDs = tc.dsc.getText();
			
			String tkTp = (String) tc.tkType.getSelectedItem();
			System.out.println("jcb Item is" + (String) tc.tkType.getSelectedItem());
			
			String tkUs = (String) tc.tkUser.getSelectedItem();
			System.out.println("jcb Item is" + (String) tc.tkUser.getSelectedItem());
			
	
			
			
			System.out.println(Instant.now().getEpochSecond());
			int ep =	(int) Instant.now().getEpochSecond() ; 
			//String query = "INSERT INTO `gui`.`tickets` (`Epoch Open`) VALUES ('"+ep+"');";
		//	String query = "INSERT INTO `gui`.`tickets` (`Epoch Open`,`Type`) VALUES ('"+ep+"','"+jcbItem+"');";
		//	String query = "INSERT INTO `gui`.`tickets` (`Epoch Open`,`Type`,`Assigned to`) VALUES ('"+ep+"', '"+tkTp+"', '"+tkUs+"');";
			String query = "INSERT INTO `gui`.`tickets` (`Epoch Open`,`Description`,`Type`,`Assigned to`) VALUES ('"+ep+"', '"+tkDs+"', '"+tkTp+"', '"+tkUs+"');";
			database db = new database(query);
    	    db.insert();
    	    System.out.println("UPDATED");
    		JOptionPane.showMessageDialog(tc, "TICKET CREATED IN TABLE." ,  "Confirmation Dialog", 
    		JOptionPane.INFORMATION_MESSAGE);   
    		
    		
		}
		else if(e.getActionCommand().equals("cls")) {
			System.out.println("Working");
			
			
			String id = tc.id.getText();
			
			
			System.out.println(Instant.now().getEpochSecond());
			
			int ep1 = (int) Instant.now().getEpochSecond() ; 
			
			String query = "UPDATE `gui`.`tickets` SET `Epoch Close`= ('"+ep1+"') WHERE  `Id`=('"+id+"');";
	    	 database db = new database(query);
	    	  db.insert();
	    	  System.out.println("UPDATED");
				JOptionPane.showMessageDialog(tc, "TICKET CLOSED FROM TABLE.", "Confirmation Dialog", 
				JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand().equals("del")) {
			 String id = tc.id.getText();
	    	  String query = "DELETE FROM `gui`.`tickets` WHERE  `Id`= ('"+id+"');";
		    	 
	    	  database db = new database(query);
	    	    db.insert();
	    	    System.out.println("UPDATED");
				JOptionPane.showMessageDialog(tc, "TICKET DELETED FROM TABLE.", "Confirmation Dialog", 
				JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand().equals("chkTk")) {
			System.out.println("Checking Ticket");
			m.ticks();

		}
		else if(e.getActionCommand().equals("opnTk")) {
			System.out.println("Open Tickets");
			m.ticks0();
			

		}
		else if(e.getActionCommand().equals("clsTK")) {
			System.out.println("Close Ticket");
			m.ticks1();
		}
		else if(e.getActionCommand().equals("cT")) {
			System.out.println("Checking Cost");
			System.out.println("This Button is not working");
			m.ticks3();
		}
		else if (e.getActionCommand().equals("f5")) {
			System.out.println("Refresh");
			
			m.ticks2();
			
		}
		else if(e.getActionCommand().equals("brG")) {
			
			
			
			DefaultCategoryDataset barChartData = new DefaultCategoryDataset();
			barChartData.setValue(8,"Open Tickets ", "Dec");
			barChartData.setValue(6,"Close Tickets","Dec");
		//	barChartData.setValue(5000,"this barchart is manual", "mar");
		
			JFreeChart barChart = ChartFactory.createBarChart("Ticket Chart", "Month", "Total Tickets" , barChartData);
			
			CategoryPlot barchrt = barChart.getCategoryPlot();
			barchrt.setRangeGridlinePaint(Color.BLACK);
			
			ChartPanel p3 = new ChartPanel(barChart);
			JFrame chart = new JFrame();
			chart.setVisible(true);
			chart.setSize(300, 300);
		//	chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			chart.add(p3);
			chart.validate();
		}
	}

 
}