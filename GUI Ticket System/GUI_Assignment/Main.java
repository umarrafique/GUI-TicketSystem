package GUI_Assignment;
import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Main extends JFrame {
		
		JTextField username = null;
		JTextField password = null;
		
		

		
		public Main(){
			
		
			
			
			setSize(300,300);
			setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setLayout(new GridLayout(3,1));
			
			Controller myController = new Controller(this);
			
			
			JLabel un = new JLabel("Username");
			this.add(un);
			
			username = new JTextField(20);
			this.add(username);
			
			JLabel pw = new JLabel("Password");
			this.add(pw);
			password = new JTextField(20);
			this.add(password);
			
			JLabel b = new JLabel();
			this.add(b);
			
			JButton Login = new JButton("Login");
			
			Login.addActionListener(myController);
			Login.setActionCommand("login");
			this.add(Login);
			
			
			validate();
			repaint();
		}	
		
		
		public static void main(String[] args) {
			
			new Main();
		}

}