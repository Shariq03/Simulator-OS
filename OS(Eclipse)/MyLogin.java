import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class MyLogin {

	JFrame frame;
	JButton j,k;
	JLabel l;
	JFrame f3,f2;
	private JTextField txtShariqDharmaRambabu;
	private JTextField txtShariqDharma;
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLogin window = new MyLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MyLogin() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 105, 30));
		frame.getContentPane().setForeground(new Color(205, 92, 92));
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.setBounds(200, 100, 800, 500);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JButton btnStop = new JButton("PageFault_Algos");
		btnStop.setBounds(100, 208, 200, 80);
		btnStop.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnStop.setForeground(Color.BLACK);
		btnStop.setBackground(new Color(255, 0, 0));
		
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PageFaultGUI OBJ2=new PageFaultGUI();
				OBJ2.main();
			}
		});
		frame.getContentPane().setLayout(null);
		
		JLabel lblShariq = new JLabel("Shariq, Dharma, Rambabu, Viswanatha");
		lblShariq.setBounds(506, 66, 262, 80);
		lblShariq.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShariq.setBackground(new Color(255, 99, 71));
		lblShariq.setForeground(new Color(222, 184, 135));
		frame.getContentPane().add(lblShariq);
		frame.getContentPane().add(btnStop);
		
		
		
		JButton btnClick = new JButton("Scheduling_Algos");
		btnClick.setBounds(456, 208, 200, 80);
		btnClick.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnClick.setForeground(Color.BLACK);
		btnClick.setBackground(new Color(255, 0, 0));
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SchedulingGUI OBJ1=new SchedulingGUI();
				OBJ1.main();				
			}
		});
		frame.getContentPane().add(btnClick);
		

		
		JButton btnNewButton = new JButton("Dining Philopher");
		btnNewButton.setBounds(456, 319, 200, 80);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DP_GUI OBJ3=new DP_GUI("Dining Philosopher");
				OBJ3.main();
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SIMULATOR");
		lblNewLabel.setBounds(312, 0, 200, 100);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		
		JLabel lblS = new JLabel("");
		lblS.setBounds(0, 0, 784, 150);
		lblS.setOpaque(true);
		lblS.setBackground(Color.BLACK);
		frame.getContentPane().add(lblS);
		Font labelFont = lblNewLabel.getFont();
		String labelText = lblNewLabel.getText();
		int stringWidth = lblNewLabel.getFontMetrics(labelFont).stringWidth(labelText);
		int componentWidth = lblNewLabel.getWidth();
		double widthRatio = (double)componentWidth / (double)stringWidth;
		int newFontSize = (int)(labelFont.getSize() * widthRatio);
		int componentHeight = lblNewLabel.getHeight();
		int fontSizeToUse = Math.min(newFontSize, componentHeight);
		lblNewLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
		
		JButton btnDiskScheduling = new JButton("Disk Scheduling");
		btnDiskScheduling.setBounds(100, 319, 200, 80);
		btnDiskScheduling.setForeground(new Color(0, 0, 0));
		btnDiskScheduling.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnDiskScheduling.setBackground(new Color(255, 0, 0));
		btnDiskScheduling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiskSched_GUI OBJ4=new DiskSched_GUI();
				OBJ4.main();
			}
		});
		frame.getContentPane().add(btnDiskScheduling);
		
		JButton btnA = new JButton("a");
		btnA.setBounds(10, 165, -1, 23);
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
			}
		});
		btnA.setBackground(new Color(210, 105, 30));
		btnA.setForeground(new Color(210, 105, 30));
		frame.getContentPane().add(btnA);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginview o=new Loginview();
				String args[]=new String[2];
				args[0]="0"; args[1]="1";
				o.main(args);
			}
		});
		btnLogOut.setBackground(new Color(238, 232, 170));
		btnLogOut.setBounds(679, 419, 89, 31);
		frame.getContentPane().add(btnLogOut);
		
		
	}
}
