import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginview {
	private static JPanel panel_1;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Login Page");
		//frame.setSize(300, 150);
		frame.setBounds(200, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(210, 105, 30));
		frame.getContentPane().add(panel_1);
		placeComponents(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 784, 150);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblSimulator = new JLabel("SIMULATOR");
		lblSimulator.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblSimulator.setForeground(new Color(255, 0, 0));
		lblSimulator.setBounds(319, 46, 172, 32);
		panel.add(lblSimulator);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {
		panel_1.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		userLabel.setBounds(209, 277, 80, 25);
		panel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setFont(new Font("Tahoma", Font.BOLD, 13));
		userText.setBackground(new Color(238, 232, 170));
		userText.setBounds(299, 270, 250, 32);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		passwordLabel.setBounds(209, 313, 80, 25);
		panel.add(passwordLabel);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBackground(new Color(238, 232, 170));
		passwordText.setBounds(299, 313, 250, 32);
		panel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] P=passwordText.getPassword();
				String N=userText.getText();
				String x="";
				for(int i=0;i<P.length;i++)
					x=x+P[i];
				if(N.equals("Shariq")  && (x.equals("1234")))
				{
					MyLogin o=new MyLogin();
					o.main();
				}
				else
				{
					passwordText.setText("");
					userText.setText("");
				}
			}
		});
		loginButton.setBackground(new Color(240, 128, 128));
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginButton.setBounds(374, 369, 112, 39);
		panel.add(loginButton);
	}
}