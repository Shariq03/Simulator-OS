import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Button;

public class SchedulingGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnFcfs;
	private JButton btnNpp;
	private JButton btnPp;
	private JButton btnRr;
	private JButton btnSjnf;
	private JButton btnSjfp;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchedulingGUI window = new SchedulingGUI();
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
	public SchedulingGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.setBounds(100, 100, 658, 391);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStart = new JButton("COMPARE");
		btnStart.setBounds(199, 157, 102, 42);
		btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnStart.setForeground(Color.BLACK);
		btnStart.setBackground(Color.RED);

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				int n=ra.nextInt(5)+3;
				int at[]=new int[n];
				int bt[]=new int[n];
				int pr[]=new int[n];
				int at1[]=new int[n+1];
				int bt1[]=new int[n+1];
				int pr1[]=new int[n+1];
				//int xyz=ra.nextInt(n);
				at[0]=0;
				bt[0]=ra.nextInt(10);
				if(bt[0]==0) bt[0]=1;
				//pr[0]=xyz;
				//if(pr[0]==0) pr[0]=n;
				pr[0]=ra.nextInt(5)+1;
				int time=0;
				for(int i=1;i<n;i++)
				{
					bt[i]=ra.nextInt(10);
						if(bt[i]==0)
							bt[i]=1;
					time=time+ra.nextInt(3);
					at[i]=time;
					//xyz+=1;
					//pr[i]=xyz%n;
					//if(pr[i]==0) pr[i]=n;
					pr[i]=ra.nextInt(5)+1;
				}
				String x="";
				String y="";
				String z="";
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				int t=ra.nextInt(3)+1;
				for(int i=0;i<n;i++)
				{	x=x+" "+at[i];
					y=y+" "+bt[i];
					z=z+" "+pr[i];
					at1[i+1]=at[i];
					bt1[i+1]=bt[i];
					pr1[i+1]=pr[i];
				}
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				float best=1000;
				String algo="";
				FCFS Obj1=new FCFS();
				nonpre_priority Obj2=new nonpre_priority();
				pre_priority Obj3=new pre_priority();
				RoundRobin Obj4 = new RoundRobin();
				SJF_non_preemptive Obj5=new SJF_non_preemptive();
				SJF_preemptive Obj6=new SJF_preemptive();
				float ans1=Obj1.begin(n,at1,bt1);
				textField.setText(""+ans1);
				if(ans1<best)
				{
					best=ans1;
					algo="FCFS";
				}
				float ans2=Obj2.begin(n,at1,bt1,pr1);
				textField_1.setText(""+ans2);
				if(ans2<best)
				{
					best=ans2;
					algo="NPP";
				}
				int at2[]=new int[n];
				int bt2[]=new int[n];
				for(int i=0;i<n;i++)
				{	
					at2[i]=at[i];
					bt2[i]=bt[i];
				}
				float ans4=Obj4.begin(n,bt2,t);
				textField_5.setText(""+ans4);
				if(ans4<best)
				{
					best=ans4;
					algo="RR";
				}
				int at3[]=new int[n];
				int bt3[]=new int[n];
				for(int i=0;i<n;i++)
				{	
					at3[i]=at[i];
					bt3[i]=bt[i];
				}
				float ans5=Obj5.begin(n,at3,bt3);
				textField_4.setText(""+ans5);
				if(ans5<best)
				{
					best=ans5;
					algo="SJFNP";
				}
				
				int at4[]=new int[n];
				int bt4[]=new int[n];
				for(int i=0;i<n;i++)
				{	
					at4[i]=at[i];
					bt4[i]=bt[i];
				}
				float ans6=Obj6.begin(n,at4,bt4);
				textField_3.setText(""+ans6);
				if(ans6<best)
				{
					best=ans6;
					algo="SJFP";
				}
				float ans3=Obj3.begin(n,at,bt,pr);
				textField_2.setText(""+ans3);
				if(ans3<best)
				{
					best=ans3;
					algo="PP";
				}
				textField_6.setText(algo+":  "+best);
				double Ans[]=new double[6];
				Ans[0]=ans1; Ans[1]=ans2; Ans[2]=ans3; Ans[3]=ans4; Ans[4]=ans5; Ans[5]=ans6;
				String algos[]=new String[6];
				algos[0]="FCFS"; algos[1]="NPP"; algos[2]="PP"; algos[3]="RR"; algos[4]="SJFNP"; algos[5]="SJFP";
				String ti="";
				Bargraph obj=new Bargraph(Ans,algos,ti);
				obj.test(Ans,algos);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(10, 302, 86, 20);
		textField.setForeground(SystemColor.desktop);
		textField.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 302, 76, 20);
		textField_1.setBackground(new Color(238, 232, 170));
		textField_1.setForeground(SystemColor.desktop);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(225, 302, 76, 20);
		textField_2.setForeground(SystemColor.activeCaptionText);
		textField_2.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(553, 302, 86, 20);
		textField_3.setForeground(SystemColor.activeCaptionText);
		textField_3.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(435, 302, 86, 20);
		textField_4.setForeground(SystemColor.activeCaptionText);
		textField_4.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(333, 302, 76, 20);
		textField_5.setForeground(SystemColor.activeCaptionText);
		textField_5.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(530, 167, 102, 26);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_6.setForeground(SystemColor.controlText);
		textField_6.setBackground(new Color(238, 232, 170));
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblBestAlgoIs = new JLabel("Best Algo is:");
		lblBestAlgoIs.setBounds(435, 171, 86, 14);
		lblBestAlgoIs.setForeground(new Color(139, 0, 0));
		lblBestAlgoIs.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		frame.getContentPane().add(lblBestAlgoIs);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_7.setBounds(121, 11, 334, 26);
		textField_7.setBackground(new Color(240, 230, 140));
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(121, 52, 334, 26);
		textField_8.setBackground(new Color(240, 230, 140));
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_9.setBounds(121, 89, 334, 26);
		textField_9.setBackground(new Color(240, 230, 140));
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(23, 14, 88, 14);
		lblArrivalTime.setForeground(new Color(139, 69, 19));
		lblArrivalTime.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		frame.getContentPane().add(lblArrivalTime);
		
		JLabel lblBurstTime = new JLabel("Burst Time");
		lblBurstTime.setBounds(25, 56, 86, 14);
		lblBurstTime.setForeground(new Color(139, 69, 19));
		lblBurstTime.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		frame.getContentPane().add(lblBurstTime);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(33, 93, 63, 14);
		lblPriority.setForeground(new Color(139, 69, 19));
		lblPriority.setBackground(new Color(139, 69, 19));
		lblPriority.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		frame.getContentPane().add(lblPriority);
		
		btnFcfs = new JButton("FCFS");
		btnFcfs.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				int n=ra.nextInt(5)+3;
				int at[]=new int[n];
				int bt[]=new int[n];
				int pr[]=new int[n];
				int at1[]=new int[n+1];
				int bt1[]=new int[n+1];
				int pr1[]=new int[n+1];
				at[0]=0;
				bt[0]=ra.nextInt(10);
				if(bt[0]==0) bt[0]=1;
				pr[0]=ra.nextInt(5)+1;
				int time=0;
				for(int i=1;i<n;i++)
				{
					bt[i]=ra.nextInt(10);
						if(bt[i]==0)
							bt[i]=1;
					time=time+ra.nextInt(3);
					at[i]=time;
					pr[i]=ra.nextInt(5)+1;
				}
				String x="";
				String y="";
				String z="";
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				int t=ra.nextInt(3)+1;
				for(int i=0;i<n;i++)
				{	x=x+" "+at[i];
					y=y+" "+bt[i];
					z=z+" "+pr[i];
					at1[i+1]=at[i];
					bt1[i+1]=bt[i];
					pr1[i+1]=pr[i];
				}
				textField_7.setText(x);
				textField_8.setText(y);
				//textField_9.setText(z);
				FCFS Obj1=new FCFS();
				float ans1=Obj1.begin(n,at1,bt1);
				textField.setText(ans1+"");
			}
		});
		
		btnFcfs.setBounds(7, 268, 86, 23);
		frame.getContentPane().add(btnFcfs);
		
		btnNpp = new JButton("NPP");
		btnNpp.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNpp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				int n=ra.nextInt(5)+3;
				int at[]=new int[n];
				int bt[]=new int[n];
				int pr[]=new int[n];
				int at1[]=new int[n+1];
				int bt1[]=new int[n+1];
				int pr1[]=new int[n+1];
				at[0]=0;
				bt[0]=ra.nextInt(10);
				if(bt[0]==0) bt[0]=1;
				pr[0]=ra.nextInt(5)+1;
				int time=0;
				for(int i=1;i<n;i++)
				{
					bt[i]=ra.nextInt(10);
						if(bt[i]==0)
							bt[i]=1;
					time=time+ra.nextInt(3);
					at[i]=time;
					pr[i]=ra.nextInt(5)+1;
				}
				String x="";
				String y="";
				String z="";
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				int t=ra.nextInt(3)+1;
				for(int i=0;i<n;i++)
				{	x=x+" "+at[i];
					y=y+" "+bt[i];
					z=z+" "+pr[i];
					at1[i+1]=at[i];
					bt1[i+1]=bt[i];
					pr1[i+1]=pr[i];
				}
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				nonpre_priority Obj1=new nonpre_priority();
				float ans2=Obj1.begin(n,at1,bt1,pr1);
				textField_1.setText(ans2+"");
			}
		});
		btnNpp.setBounds(121, 268, 76, 23);
		frame.getContentPane().add(btnNpp);
		
		btnPp = new JButton("PP");
		btnPp.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnPp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				int n=ra.nextInt(5)+3;
				int at[]=new int[n];
				int bt[]=new int[n];
				int pr[]=new int[n];
				at[0]=0;
				bt[0]=ra.nextInt(10);
				if(bt[0]==0) bt[0]=1;
				pr[0]=ra.nextInt(5)+1;
				int time=0;
				for(int i=1;i<n;i++)
				{
					bt[i]=ra.nextInt(10);
						if(bt[i]==0)
							bt[i]=1;
					time=time+ra.nextInt(3);
					at[i]=time;
					pr[i]=ra.nextInt(5)+1;
				}
				String x="";
				String y="";
				String z="";
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				int t=ra.nextInt(3)+1;
				for(int i=0;i<n;i++)
				{	x=x+" "+at[i];
					y=y+" "+bt[i];
					z=z+" "+pr[i];
				}
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				pre_priority Obj1=new pre_priority();
				float ans3=Obj1.begin(n,at,bt,pr);
				textField_2.setText(ans3+"");
			}
		});
		btnPp.setBounds(225, 268, 76, 23);
		frame.getContentPane().add(btnPp);
		
		btnRr = new JButton("RR");
		btnRr.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnRr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				int n=ra.nextInt(5)+3;
				int at[]=new int[n];
				int bt[]=new int[n];
				int pr[]=new int[n];
				at[0]=0;
				bt[0]=ra.nextInt(10);
				if(bt[0]==0) bt[0]=1;
				pr[0]=ra.nextInt(5)+1;
				int time=0;
				for(int i=1;i<n;i++)
				{
					bt[i]=ra.nextInt(10);
						if(bt[i]==0)
							bt[i]=1;
					time=time+ra.nextInt(3);
					at[i]=time;
					pr[i]=ra.nextInt(5)+1;
				}
				String x="";
				String y="";
				String z="";
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				int t=ra.nextInt(3)+1;
				for(int i=0;i<n;i++)
				{	x=x+" "+at[i];
					y=y+" "+bt[i];
					z=z+" "+pr[i];
				}
				textField_7.setText(x);
				textField_8.setText(y);
				label.setText("Time Quantum is: "+t+"");
				//textField_9.setText(z);
				RoundRobin Obj1=new RoundRobin();
				float ans4=Obj1.begin(n,bt,t);
				textField_5.setText(ans4+"");
			}
		});
		btnRr.setBounds(333, 268, 76, 23);
		frame.getContentPane().add(btnRr);
		
		btnSjnf = new JButton("SJNP");
		btnSjnf.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnSjnf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				int n=ra.nextInt(5)+3;
				int at[]=new int[n];
				int bt[]=new int[n];
				int pr[]=new int[n];
				at[0]=0;
				bt[0]=ra.nextInt(10);
				if(bt[0]==0) bt[0]=1;
				pr[0]=ra.nextInt(5)+1;
				int time=0;
				for(int i=1;i<n;i++)
				{
					bt[i]=ra.nextInt(10);
						if(bt[i]==0)
							bt[i]=1;
					time=time+ra.nextInt(3);
					at[i]=time;
					pr[i]=ra.nextInt(5)+1;
				}
				String x="";
				String y="";
				String z="";
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				int t=ra.nextInt(3)+1;
				for(int i=0;i<n;i++)
				{	x=x+" "+at[i];
					y=y+" "+bt[i];
					z=z+" "+pr[i];
				}
				textField_7.setText(x);
				textField_8.setText(y);
				//textField_9.setText(z);
				SJF_non_preemptive Obj1=new SJF_non_preemptive();
				float ans5=Obj1.begin(n,at,bt);
				textField_4.setText(ans5+"");
			}
		});
		btnSjnf.setBounds(432, 268, 89, 23);
		frame.getContentPane().add(btnSjnf);
		
		btnSjfp = new JButton("SJFP");
		btnSjfp.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnSjfp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ra=new Random();
				int n=ra.nextInt(5)+3;
				int at[]=new int[n];
				int bt[]=new int[n];
				int pr[]=new int[n];
				at[0]=0;
				bt[0]=ra.nextInt(10);
				if(bt[0]==0) bt[0]=1;
				pr[0]=ra.nextInt(5)+1;
				int time=0;
				for(int i=1;i<n;i++)
				{
					bt[i]=ra.nextInt(10);
						if(bt[i]==0)
							bt[i]=1;
					time=time+ra.nextInt(3);
					at[i]=time;
					pr[i]=ra.nextInt(5)+1;
				}
				String x="";
				String y="";
				String z="";
				textField_7.setText(x);
				textField_8.setText(y);
				textField_9.setText(z);
				int t=ra.nextInt(3)+1;
				for(int i=0;i<n;i++)
				{	x=x+" "+at[i];
					y=y+" "+bt[i];
					z=z+" "+pr[i];
				}
				textField_7.setText(x);
				textField_8.setText(y);
				//textField_9.setText(z);
				SJF_preemptive Obj1=new SJF_preemptive();
				float ans6=Obj1.begin(n,at,bt);
				textField_3.setText(ans6+"");
			}
		});
		btnSjfp.setBounds(553, 268, 89, 23);
		frame.getContentPane().add(btnSjfp);
		
		label = new JLabel("");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(465, 89, 174, 26);
		frame.getContentPane().add(label);
	}
}
