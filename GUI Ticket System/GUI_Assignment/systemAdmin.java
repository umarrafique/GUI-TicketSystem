package GUI_Assignment;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;




import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextField;
 


public class systemAdmin extends JFrame {
	
	 JTextField id = null;
	 JTextField username = null;
	 JTextField password = null;
	 JTextField type = null;
	 
	 JComboBox usType = null;
	
	public systemAdmin() {
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);  // *** this will center your app ***
	  this.setVisible(true);
	  this.setSize(250,420);
	 
	  

	Controller myController = new Controller(this);
	

	
   	this.setLayout(new GridLayout(2,1));
	JPanel top = new JPanel();
	top.setLayout(new FlowLayout());
	
	JLabel idLabel = new JLabel("ID(only when UPDATING USER)");
	top.add(idLabel);
	
	id = new JTextField(20); // Go up and make it global
	top.add(id);
	
	JLabel urLabel = new JLabel("New USERNAME");
	top.add(urLabel);
	
	username = new JTextField(20); // Go up and make it global
	top.add(username);
	
	JLabel pwLabel = new JLabel("NEW PASSWORD");
	top.add(pwLabel);
	
	password = new JTextField(20);
	top.add(password);
	
	
	JLabel tp = new JLabel("TYPE(only when ADDING NEW USER)");
	top.add(tp);
	
	//type = new JTextField(20);
	//top.add(type);
	usType = new JComboBox();
	
	usType.addItem("Admin");
	usType.addItem("Manager");
	usType.addItem("Tech Support");
	usType.setSelectedItem(myController);
	top.add(usType);
	

	
	JPanel bottom = new JPanel();
	bottom.setLayout(new FlowLayout());
	
	this.add(top);
	this.add(bottom); 
	
	
	
	
	//Buttons
	
	JButton B = new JButton("UPDATE USER DETAILS");
	B.addActionListener(myController);
	B.setActionCommand("update");
	bottom.add(B);
	
	JButton B0 = new JButton("CREATE NEW USER");
	B0.addActionListener(myController);
	B0.setActionCommand("addNew");
	bottom.add(B0);
	
	JButton B1 = new JButton ("LOGOUT");
	B1.addActionListener(myController);
	B1.setActionCommand("logout");
	bottom.add(B1);  

		
	validate();
	repaint();
    System.out.println("System Admin");

   }
}