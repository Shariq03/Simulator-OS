import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DiskSched_GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiskSched_GUI window = new DiskSched_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiskSched_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 504, 385);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(123, 25, 340, 20);
		textField.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 58, 46, 20);
		textField_1.setBackground(new Color(240, 230, 140));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(67, 28, 46, 14);
		lblInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblInput.setForeground(new Color(139, 69, 19));
		frame.getContentPane().add(lblInput);
		
		JLabel lblHead = new JLabel("Head");
		lblHead.setBounds(67, 59, 46, 14);
		lblHead.setForeground(new Color(139, 0, 0));
		lblHead.setBackground(new Color(128, 128, 0));
		lblHead.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		frame.getContentPane().add(lblHead);
		
		JButton btnFifo = new JButton("FIFO");
		btnFifo.setBounds(24, 123, 89, 42);
		btnFifo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				DFCFS Obj1=new DFCFS();
				int ans=Obj1.main(A, n, head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
				Graph OBJ1=new Graph(A,n);
				OBJ1.test(A,n);

			}
		});
		btnFifo.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(btnFifo);
		
		JButton btnSstf = new JButton("SSTF");
		btnSstf.setBounds(192, 123, 89, 42);
		btnSstf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				SSTF Obj2= new SSTF();
				int ans=Obj2.main(A, n, head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
				Graph OBJ2=new Graph(A,n);
				OBJ2.test(A,n);
			}
		});
		btnSstf.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(btnSstf);
		
		JButton btnScan = new JButton("Scan");
		btnScan.setBounds(364, 123, 89, 42);
		btnScan.setBackground(new Color(95, 158, 160));
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				Scan Obj3 = new Scan();
				int ans=Obj3.main(A,n,head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
				Graph OBJ3=new Graph(A,n);
				OBJ3.test(A,n);
			}
		});
		frame.getContentPane().add(btnScan);
		
		JButton btnCscan = new JButton("C-Scan");
		btnCscan.setBounds(107, 195, 89, 42);
		btnCscan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				CScan Obj4 = new CScan();
				int ans=Obj4.main(A,n,head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
				Graph OBJ4=new Graph(A,n);
				OBJ4.test(A,n);
			}
		});
		btnCscan.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(btnCscan);
		
		JButton btnClook = new JButton("C-Look");
		btnClook.setBounds(285, 195, 89, 42);
		btnClook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				CLook Obj5 = new CLook();
				int ans=Obj5.main(A,n,head);
				textField.setText(x);
				textField_1.setText(head+"");
				textField_2.setText(ans+"");
				Graph OBJ5=new Graph(A,n);
				OBJ5.test(A,n);
			}
		});
		btnClook.setBackground(new Color(95, 158, 160));
		frame.getContentPane().add(btnClook);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(240, 230, 140));
		textField_2.setBounds(397, 58, 66, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNoOfCylinders = new JLabel("No of Cylinders moved");
		lblNoOfCylinders.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNoOfCylinders.setForeground(new Color(139, 69, 19));
		lblNoOfCylinders.setBounds(252, 59, 144, 14);
		frame.getContentPane().add(lblNoOfCylinders);
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(319, 294, 169, 20);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(47, 169, 66, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(223, 169, 58, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(395, 169, 58, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(138, 244, 58, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(319, 244, 55, 14);
		frame.getContentPane().add(label_5);
		
		JButton btnCompare = new JButton("COMPARE");
		btnCompare.setBackground(new Color(205, 133, 63));
		btnCompare.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				String x="";
				int n=ra.nextInt(10)+5;
				int A[]=new int[n];
				for(int i=0;i<n;i++) 
				{	A[i]=ra.nextInt(200);
					x=x+" "+A[i];
				}
				int head=ra.nextInt(200);
				textField.setText(x);
				textField_1.setText(head+"");
				DFCFS Obj1=new DFCFS();
				SSTF Obj2= new SSTF();
				CLook Obj5 = new CLook();
				CScan Obj4 = new CScan();
				Scan Obj3 = new Scan();
				int aa[]=new int[6];
				aa[3]=Obj3.main(A,n,head);
				aa[4]=Obj4.main(A,n,head);
				aa[5]=Obj5.main(A,n,head);
				aa[2]=Obj2.main(A, n, head);
				aa[1]=Obj1.main(A, n, head);
				label_1.setText(aa[1]+"");
				label_2.setText(aa[2]+"");
				label_3.setText(aa[3]+"");
				label_4.setText(aa[4]+"");
				label_5.setText(aa[5]+"");
				int ans=aa[1];
				String ref[]=new String[6];
				ref[1]="FCFS"; ref[2]="SSTF"; ref[3]="SCAN"; ref[4]="C-SCAN"; ref[5]="C-LOOK";
				String fin="";
				for(int i=2;i<=5;i++)
				{
					if(ans>aa[i])
					{
						ans=aa[i];
						fin=ref[i];
					}
				}
				label.setText("Best Algo is: "+fin);
				}
		});
		btnCompare.setBounds(176, 280, 133, 42);
		frame.getContentPane().add(btnCompare);
		
	
		
		
		
		
	}
}
