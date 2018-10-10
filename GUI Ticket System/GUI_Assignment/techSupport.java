package GUI_Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class techSupport extends JFrame {
	 JTextField id = null;
	 
	 String[] typeString = null;

	 JComboBox tkType = null;
	 
	 JComboBox tkUser = null;
	 
	 JTextField dsc = null;



	public techSupport() {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setLocationRelativeTo(null);  // *** this will center your app ***
		  setVisible(true);
		  setSize(300,420);
		//  setLayout(new GridLayout(5,1));
		  
		  
		  Controller myController = new Controller(this);
		   	this.setLayout(new GridLayout(2,1));
			JPanel top = new JPanel();
			top.setLayout(new FlowLayout());
			
		 	

			
			
			
		
			JLabel idLabel1 = new JLabel("ENTER ID TO DELETE");
			JLabel idLabel2 = new JLabel("OR CLOSE TICKET");
			
			top.add(idLabel1);
			top.add(idLabel2);
			
			id = new JTextField(20); // Go up and make it global
			top.add(id);
			
			
			JLabel textLabel1 = new JLabel("ENTER THE TICKET DESCRIPTION: ");

			top.add(textLabel1);
			dsc = new JTextField(20);
			top.add(dsc);
		
			
			
			
			JLabel ticketLabel = new JLabel("SELECT THE TYPE OF TICKET");
			top.add(ticketLabel);
		
	    	tkType = new JComboBox();
			
			tkType.addItem("Urgent");
			tkType.addItem("Normal");
			tkType.addItem("Long Term");
			tkType.setSelectedItem(myController);
			top.add(tkType);
		
		
			
			
		
			

			
			JLabel userLabel = new JLabel("SELECT THE USER YOU WANT TO ASSIGN TICKET");
			top.add(userLabel);
			
			tkUser = new JComboBox();
			
			tkUser.addItem("John");
			tkUser.addItem("James");
			tkUser.addItem("Johan");
			tkUser.setSelectedItem(myController);
			top.add(tkUser);

/*			String[] userString = { "JOHN", "JOHAN", "JD" };

			JLabel userLabel = new JLabel("Click the user you want to assign Ticket");
			top.add(userLabel);
			JComboBox userList = new JComboBox(userString);
			userList.setSelectedIndex(2);
			//
			userList.addActionListener(myController);
			top.add(userList);
		
*/			
			JPanel bottom = new JPanel();
			bottom.setLayout(new FlowLayout());
			
			this.add(top);
			this.add(bottom); 
	
			//Buttons
			
			
			
			
			JButton B = new JButton("Create Ticket");
			B.addActionListener(myController);
			B.setActionCommand("create");
			bottom.add(B);
			
			JButton b2 = new JButton("Close Ticket");
			b2.addActionListener(myController);
			b2.setActionCommand("cls");
			bottom.add(b2);
			
			JButton B0 = new JButton("Delete Ticket");
			B0.addActionListener(myController);
			B0.setActionCommand("del");
			bottom.add(B0);
			
			
			JButton B1 = new JButton ("Logout");
			B1.addActionListener(myController);
			B1.setActionCommand("logoutTech");
			bottom.add(B1);  

				
			validate();
			repaint();

			
			validate();
			repaint();
			
			
	       System.out.println("Tech Support Team");

	       }

}
