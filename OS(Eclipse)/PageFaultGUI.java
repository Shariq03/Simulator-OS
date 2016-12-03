import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextArea;
public class PageFaultGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnLru;
	private JButton btnSecondchance;
	private JButton btnOptimal;
	private JTextField textField_5;
	private JButton btnCompare;
	private JTextField textField_7;
	private JLabel lblLengthOfInput;
	

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageFaultGUI window = new PageFaultGUI();
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
	public PageFaultGUI() {
		initialize();
	}

	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		frame.setBounds(100, 100, 479, 389);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStart = new JButton("FIFO\r\n");
		btnStart.setBounds(10, 181, 84, 34);
		btnStart.setBackground(new Color(240, 128, 128));
		btnStart.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{	Random ra=new Random();
				int n=ra.nextInt(8)+12;
				int F=ra.nextInt(4)+3;
				int A[]=new int[n];
				int[][] Table = new int[100][];
				for(int i=0;i<100;i++)
				{
					Table[i]=new int[100];
				}
				
				String x="";
				textField_3.setText("");
				for(int i=0;i<n;i++)
				{   
					A[i]=ra.nextInt(9)+1;
					x=x+" "+A[i];
					System.out.print(A[i]+" ");
				}
				fif Obj1 = new fif();
				int ans1=Obj1.fifo(n,F,A,Table);
				
				textField.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_3.setText("");
				
				textField_3.setText(x);
				textField.setText(ans1+"");		
				textField_5.setText(F+"");
				textField_7.setText(n+"");
				String t6="";
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<F;j++)
					{
						if(Table[i][j]!=-1 && Table[i][j]!=0)
							t6=t6+" "+Table[i][j];
					}
					t6=t6+"\n";
				}
				SwingControlDemo oo=new SwingControlDemo();
				oo.main(t6);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(10, 237, 84, 20);
		textField.setBackground(new Color(245, 222, 179));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(134, 237, 84, 20);
		textField_1.setBackground(new Color(245, 222, 179));
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(254, 237, 84, 20);
		textField_2.setBackground(new Color(245, 222, 179));
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(97, 13, 335, 20);
		textField_3.setBackground(new Color(255, 250, 205));
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(20);
		
		JLabel lblInputString = new JLabel("Input String");
		lblInputString.setBounds(6, 15, 88, 14);
		lblInputString.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblInputString.setForeground(new Color(0, 0, 128));
		frame.getContentPane().add(lblInputString);
		
		textField_4 = new JTextField();
		textField_4.setBounds(369, 237, 84, 20);
		textField_4.setBackground(new Color(245, 222, 179));
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnLru = new JButton("LRU");
		btnLru.setBounds(134, 180, 84, 36);
		btnLru.setBackground(new Color(240, 128, 128));
		btnLru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Random ra=new Random();
				int A[]=new int[20];
				String x="";
				textField.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_3.setText("");
				for(int i=0;i<20;i++)
				{   
					A[i]=ra.nextInt(10);
					x=x+" "+A[i];
					System.out.print(A[i]+" ");
				}
				textField_3.setText(x);
				textField_5.setText(3+"");
				textField_7.setText(20+"");
				
				LRU Obj2 = new LRU();
				int ans2=Obj2.main(A);
				textField_1.setText(ans2+"");*/
				Random ra=new Random();
				int n=ra.nextInt(8)+12;
				int F=ra.nextInt(4)+3;
				int A[]=new int[n+1];
				int[][] Table = new int[100][];
				for(int i=0;i<100;i++)
				{
					Table[i]=new int[100];
				}
				
				String x="";
				textField_3.setText("");
				for(int i=1;i<=n;i++)
				{   
					A[i]=ra.nextInt(9)+1;
					x=x+" "+A[i];
					System.out.print(A[i]+" ");
				}
				lr Obj2 = new lr();
				int ans2=Obj2.lru(n,F,A,Table);
				
				textField.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_3.setText("");
				
				textField_3.setText(x);
				textField_1.setText(ans2+"");		
				textField_5.setText(F+"");
				textField_7.setText(n+"");
				String t6="";
				for(int i=1;i<=n;i++)
				{
					for(int j=1;j<=F;j++)
					{
						if(Table[i][j]!=-1 && Table[i][j]!=0)
							t6=t6+" "+Table[i][j];
					}
					t6=t6+"\n";
				}
				SwingControlDemo oo=new SwingControlDemo();
				oo.main(t6);
			}
		});
		btnLru.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		frame.getContentPane().add(btnLru);
		
		btnSecondchance = new JButton("SC\r\n");
		btnSecondchance.setBounds(254, 180, 84, 36);
		btnSecondchance.setBackground(new Color(240, 128, 128));
		btnSecondchance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Random ra=new Random();
				int A[]=new int[20];
				String x="";
				textField.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_3.setText("");
				for(int i=0;i<20;i++)
				{   
					A[i]=ra.nextInt(10);
					x=x+" "+A[i];
					System.out.print(A[i]+" ");
				}
				textField_3.setText(x);
				
				Secondchance Obj3 = new Secondchance();
				int ans3=Obj3.main(A);
				textField_2.setText(ans3+"");
				
				textField_5.setText(3+"");
				textField_7.setText(20+"");*/
				Random ra=new Random();
				int n=ra.nextInt(8)+12;
				int F=ra.nextInt(4)+3;
				int A[]=new int[n+1];
				int[][] Table = new int[100][];
				for(int i=0;i<100;i++)
				{
					Table[i]=new int[100];
				}
				
				String x="";
				textField_3.setText("");
				for(int i=1;i<=n;i++)
				{   
					A[i]=ra.nextInt(9)+1;
					x=x+" "+A[i];
					System.out.print(A[i]+" ");
				}
				SC Obj3 = new SC();
				int ans3=Obj3.second_chance(n,F,A,Table);
				
				textField.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_3.setText("");
				
				textField_3.setText(x);
				textField_2.setText(ans3+"");		
				textField_5.setText(F+"");
				textField_7.setText(n+"");
				String t6="";
				for(int i=1;i<=n;i++)
				{
					for(int j=1;j<=F;j++)
					{
						if(Table[i][j]!=-1 && Table[i][j]!=0)
							t6=t6+" "+Table[i][j];
					}
					t6=t6+"\n";
				}
				SwingControlDemo oo=new SwingControlDemo();
				oo.main(t6);
			}
		});
		btnSecondchance.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		frame.getContentPane().add(btnSecondchance);
		
		btnOptimal = new JButton("Optimal");
		btnOptimal.setBounds(369, 180, 84, 36);
		btnOptimal.setBackground(new Color(240, 128, 128));
		btnOptimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Random ra=new Random();
				int A[]=new int[20];
				String x="";
				textField.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_3.setText("");
				for(int i=0;i<20;i++)
				{   
					A[i]=ra.nextInt(10);
					x=x+" "+A[i];
					System.out.print(A[i]+" ");
				}
				textField_3.setText(x);
				
				OPTIMAL Obj4=new OPTIMAL();
				int ans4=Obj4.main(A);
				textField_4.setText(ans4+"");
				textField_7.setText(20+"");
				textField_5.setText(3+"");*/
				Random ra=new Random();
				int n=ra.nextInt(8)+12;
				int F=ra.nextInt(4)+3;
				int A[]=new int[n+1];
				int[][] Table = new int[100][];
				for(int i=0;i<100;i++)
				{
					Table[i]=new int[100];
				}
				
				String x="";
				textField_3.setText("");
				for(int i=1;i<=n;i++)
				{   
					A[i]=ra.nextInt(9)+1;
					x=x+" "+A[i];
					System.out.print(A[i]+" ");
				}
				opti Obj3 = new opti();
				int ans3=Obj3.optimal(n,F,A,Table);
				
				textField.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_3.setText("");
				
				textField_3.setText(x);
				textField_4.setText(ans3+"");		
				textField_5.setText(F+"");
				textField_7.setText(n+"");
				String t6="";
				for(int i=1;i<=n;i++)
				{
					for(int j=1;j<=F;j++)
					{
						if(Table[i][j]!=-1 && Table[i][j]!=0)
							t6=t6+" "+Table[i][j];
					}
					t6=t6+"\n";
				}
				SwingControlDemo oo=new SwingControlDemo();
				oo.main(t6);
			}
		});
		btnOptimal.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		frame.getContentPane().add(btnOptimal);
		
		textField_5 = new JTextField();
		textField_5.setBounds(96, 44, 46, 20);
		textField_5.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNoOfFrames = new JLabel("No of Frames");
		lblNoOfFrames.setBounds(6, 47, 84, 14);
		lblNoOfFrames.setForeground(new Color(0, 0, 139));
		lblNoOfFrames.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNoOfFrames.setBackground(new Color(0, 0, 139));
		frame.getContentPane().add(lblNoOfFrames);
		
		btnCompare = new JButton("COMPARE ALGOS");
		btnCompare.setBackground(new Color(219, 112, 147));
		btnCompare.setBounds(160, 110, 151, 34);
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				int A[]=new int[20];
				String x="";
				textField.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textField_3.setText("");
				for(int i=0;i<20;i++)
				{   
					A[i]=ra.nextInt(10);
					x=x+" "+A[i];
					System.out.print(A[i]+" ");
				}
				textField_3.setText(x);
				FIFO o1=new FIFO(); int a1=o1.main(A);
				LRU o2=new LRU(); int a2=o2.main(A);
				Secondchance o3=new Secondchance(); int a3=o3.main(A);
				OPTIMAL o4=new OPTIMAL(); int a4=o4.main(A);
				textField_2.setText(a3+"");
				textField_1.setText(a2+"");
				textField.setText(a1+"");
				textField_4.setText(a4+"");
				textField_5.setText(3+"");
				textField_7.setText(20+"");
				double m[]=new double[4];
				m[0]=(double) a1; m[1]=(double)a2; m[2]=(double) a3; m[3]= (double) a4;
				Piechart_AWT ooo=new Piechart_AWT("",m);
				ooo.main(m);
				
				//GRAPH OBJECT
			}
		});
		btnCompare.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		frame.getContentPane().add(btnCompare);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(238, 232, 170));
		textField_7.setBounds(375, 44, 46, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		lblLengthOfInput = new JLabel("Length of Input String");
		lblLengthOfInput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLengthOfInput.setBounds(243, 46, 135, 14);
		lblLengthOfInput.setForeground(new Color(0, 0, 139));
		frame.getContentPane().add(lblLengthOfInput);
		
	}
}
