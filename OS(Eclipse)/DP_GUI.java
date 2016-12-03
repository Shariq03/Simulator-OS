import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class DP_GUI extends JFrame implements WindowListener,ActionListener 
{
        TextField text1 = new TextField(20);
        TextField text2 = new TextField(20);
        TextField text3 = new TextField(20);
        TextField text4 = new TextField(20);
        TextField text5 = new TextField(20);
        TextField text6 = new TextField(3);
        Button b1;
        Button b2;
        private ImageIcon image;
        private JLabel label;
		private Component lblNewLabel;
		private final JLabel lblNewLabel_1 = new JLabel("");
		private final JLabel lblNewLabel_2 = new JLabel("DINING PHILOSOPHER");
		private final JTextField textField = new JTextField();
		private final JLabel lblThinking = new JLabel("THINKING");
		private final JTextField textField_1 = new JTextField();
		private final JLabel lblEating = new JLabel("EATING");
		private final JTextField textField_2 = new JTextField();
		private final JLabel lblHungry = new JLabel("HUNGRY");
		private final JLabel lblTimeQuantumIs = new JLabel("Time Quantum is 2 seconds");
		private JTextField textField_3;
        public void main() 
        {
                DP_GUI myWindow = new DP_GUI("Dining Philosopher");
                //myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myWindow.setSize(500,520);
                //myWindow.pack();
                myWindow.setVisible(true);
        }
        public DP_GUI(String title) 
        {        	
                super(title);
                getContentPane().setForeground(new Color(0, 0, 0));
                getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
                getContentPane().setBackground(new Color(240, 230, 140));
                textField_2.setBounds(364, 11, 17, 14);
                textField_2.setBackground(new Color(255, 0, 0));
                textField_2.setColumns(10);
                textField_1.setBounds(195, 11, 17, 14);
                textField_1.setBackground(new Color(255, 215, 0));
                textField_1.setColumns(10);
                textField.setBounds(10, 11, 17, 14);
                textField.setBackground(new Color(50, 205, 50));
                textField.setColumns(10);
                addWindowListener(this);
                getContentPane().setLayout(null);
                b1 = new Button("Start");
                b1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
                b1.setBounds(10, 56, 75, 32);
                b1.setForeground(new Color(250, 240, 230));
                b1.setBackground(new Color(0, 128, 128));
                getContentPane().add(b1);
                text1.setBounds(192, 97, 72, 22);
                getContentPane().add(text1);
                text2.setBounds(10, 199, 75, 22);
                getContentPane().add(text2);
                text3.setBounds(40, 370, 75, 22);
                getContentPane().add(text3);
                text4.setBounds(342, 370, 75, 22);
                getContentPane().add(text4);
                text5.setBounds(380, 199, 75, 22);
                getContentPane().add(text5);
                text6.setForeground(new Color(0, 0, 0));
                text6.setBackground(new Color(189, 183, 107));
                text6.setBounds(212, 425, 42, 32);
                getContentPane().add(text6);
                lblNewLabel_1.setBounds(81, 114, 300, 301);
                lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\MY PC\\Downloads\\dining.png"));
                
                getContentPane().add(lblNewLabel_1);
                
                getContentPane().add(textField);
                lblThinking.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
                lblThinking.setBounds(32, 7, 83, 24);
                
                getContentPane().add(lblThinking);
                
                getContentPane().add(textField_1);
                lblEating.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
                lblEating.setBounds(222, 10, 54, 14);
                
                getContentPane().add(lblEating);
                
                getContentPane().add(textField_2);
                lblHungry.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
                lblHungry.setBounds(394, 10, 61, 14);
                
                getContentPane().add(lblHungry);
                lblTimeQuantumIs.setForeground(new Color(210, 105, 30));
                lblTimeQuantumIs.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
                lblTimeQuantumIs.setBounds(280, 446, 185, 14);
                
                getContentPane().add(lblTimeQuantumIs);
                
                textField_3 = new JTextField();
                textField_3.setBackground(new Color(210, 180, 140));
                textField_3.setFont(new Font("Tahoma", Font.BOLD, 11));
                textField_3.setBounds(352, 48, 65, 22);
                getContentPane().add(textField_3);
                textField_3.setColumns(10);
                
                JLabel lblEnterTheRuntime = new JLabel("Enter the Runtime : ");
                lblEnterTheRuntime.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
                lblEnterTheRuntime.setForeground(Color.BLUE);
                lblEnterTheRuntime.setBounds(231, 41, 150, 32);
                getContentPane().add(lblEnterTheRuntime);
                
                
				//((JLabel) lblNewLabel).setIcon(new ImageIcon("C:\\Users\\MY PC\\Downloads\\Din-phi.jpg"));
                
                //getContentPane().add(lblNewLabel);
                //image=new ImageIcon(this.getClass().getResource("/src/img.png"));
                //label = new JLabel(image);
                //add(label);
                b1.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) 
        {
        	JLabel label_1 = new JLabel("");
            label_1.setBounds(327, 81, 128, 22);
            getContentPane().add(label_1);
            
        	Random ra=new Random();
    		Queue HungryList=new Queue();
    		int ThinkingTime[]=new int[6];
    		int PresentEating[]=new int[2];
    		int visited[]=new int[2];
    		PresentEating[0]=0;
    		PresentEating[1]=0;
    		int Remaning_time_left_1=0;
    		int Remaning_time_left_2=0;
    		Scanner sc=new Scanner(System.in);
    		for(int i=1;i<=5;i++)
    		{	ThinkingTime[i]=ra.nextInt(5)+1;
    		}
    		System.out.println();
    		int eatTime=2;
    		int count=0,count1=0,count2=0;
    		boolean Eatingflag=false;
    		int arr[]=new int[6];
    		String str=textField_3.getText();
    		if(!str.equals(""))
    		{
    			label_1.setText("");
    		int n=Integer.parseInt(str);
    		for(int i=1;i<=5;i++)
    			arr[i]=0;
    		for(int i=1;i<=n;i++)
    		{	int flag=0;
    		for(int j=1;j<=5;j++)
			{
				if(ThinkingTime[j]>=i)
				{	arr[j]=1;
				}	
				else if(PresentEating[0]==0 || PresentEating[1]==0)
				{	
						if(PresentEating[0]==0 && arr[j]==1)
						{	int k1,k2;
							if(j-1==0) k1=5;
								else k1=j-1;
							if(j+1==6) k2=1;
								else k2=j+1;
							if(arr[k1]!=2 && arr[k2]!=2)
							{
								PresentEating[0]=j;
								Remaning_time_left_1=2;
								arr[j]=2;
							}
							else
							{
								arr[j]=3;
                                HungryList.add(j);
							}
						}
						else if(PresentEating[1]==0 && arr[j]==1)
						{	int k1,k2;
							if(j-1==0) k1=5;
								else k1=j-1;
							if(j+1==6) k2=1;
								else k2=j+1;
							if(arr[k1]!=2 && arr[k2]!=2)
							{
								PresentEating[1]=j;
								Remaning_time_left_2=2;
								arr[j]=2;
							}
							else
							{
								arr[j]=3;
                                HungryList.add(j);
							}
						}		
				}
				else
                {       if(arr[j]!=2) 
						{	arr[j]=3;
							boolean sha=false;
							for(int h=HungryList.front;h<HungryList.size();h++)
							{
								if(HungryList.A[h]==j)
								{
									sha=true;
									break;
								}
							}
							if(!sha)
                            HungryList.add(j);
						}
                 }
			}
    			for(int y=1;y<=5;y++)
    			{   if(y==1)
    				{	if(arr[y]==1)
    					{text1.setText("THINKING");
    					 text1.setBackground(Color.GREEN);
    					}
    					else if(arr[y]==2){ text1.setText("EATING"); text1.setBackground(Color.YELLOW);}
    					else {text1.setText("HUNGRY"); text1.setBackground(Color.RED);}
    				}
    			else if(y==2)
    				{
    					if(arr[y]==1)
    					{text2.setText("THINKING");
    					text2.setBackground(Color.GREEN);
    					}
        				else if(arr[y]==2) {text2.setText("EATING"); text2.setBackground(Color.YELLOW);}
        				else { text2.setText("HUNGRY"); text2.setBackground(Color.RED);}
    				}
    			else if(y==3)
    				{
    					if(arr[y]==1)
    					{
    						text3.setText("THINKING");
    						text3.setBackground(Color.GREEN);
    					}
        				else if(arr[y]==2){ text3.setText("EATING"); text3.setBackground(Color.YELLOW);}
        				else {text3.setText("HUNGRY"); text3.setBackground(Color.RED);}
    				}
    			else if(y==4)
    				{
    					if(arr[y]==1)
    					{text4.setText("THINKING");
    					text4.setBackground(Color.GREEN);
    					}
    					else if(arr[y]==2){ text4.setText("EATING"); text4.setBackground(Color.YELLOW);}
    					else {text4.setText("HUNGRY"); text4.setBackground(Color.RED);}
    				}
    			else
    				{
    					if(arr[y]==1)
    					{text5.setText("THINKING");
    					text5.setBackground(Color.GREEN);
    					}
    					else if(arr[y]==2){ text5.setText("EATING"); text5.setBackground(Color.YELLOW);}
    					else {text5.setText("HUNGRY"); text5.setBackground(Color.RED);}
    				}
    			}
    			text6.setText(""+i);
    			delay ob=new delay();
    			ob.basic();
    			boolean p1=false,p2=false;
    			if(Remaning_time_left_1>1)
    			{	Remaning_time_left_1--;
    			}
    			else
    			{
    				if(PresentEating[0]!=0)
    				{	
    					ThinkingTime[PresentEating[0]]=4+i;
    					arr[PresentEating[0]]=1;
    					if(HungryList.size()>0)
    					{	int g=HungryList.peek();
    						int k1,k2;
    							if(g-1==0) k1=5;
    								else k1=g-1;
    							if(g+1==6) k2=1;
    								else k2=g+1;
    						if(arr[k1]!=2 && arr[k2]!=2)
    						{
    							HungryList.remove();
    							PresentEating[0]=g;
    							Remaning_time_left_1=2;
                                                    	arr[g]=2;
    						}
    						else
    						PresentEating[0]=0;
    					}
    					else
    					{	
    						arr[PresentEating[0]]=0;
    						PresentEating[0]=0;
    					}
    				}	
    			}
    			if(Remaning_time_left_2>1)
    			{	Remaning_time_left_2--;

    			}
    			else
    			{
    				if(PresentEating[1]!=0)
    				{
    					ThinkingTime[PresentEating[1]]=4+i;
    					arr[PresentEating[1]]=1;
    					if(HungryList.size()>0)
    					{
    						int g=HungryList.peek();
    						int k1,k2;
    							if(g-1==0) k1=5;
    								else k1=g-1;
    							if(g+1==6) k2=1;
    								else k2=g+1;
    						if(arr[k1]!=2 && arr[k2]!=2)
    						{
    							HungryList.remove();
    							PresentEating[1]=g;
    							Remaning_time_left_2=2;
                                                    	arr[g]=2;
    						}
    						else
    						PresentEating[1]=0;
    					}
    					else
    					{
    						arr[PresentEating[1]]=0;
    						PresentEating[1]=0;
    					}
    				}
    			}
    			
    			if((PresentEating[0]==0 || PresentEating[1]==0) && HungryList.size()>0)
    			{
    				if(PresentEating[0]==0)
    				{
    					int g=HungryList.peek();
    						int k1,k2;
    							if(g-1==0) k1=5;
    								else k1=g-1;
    							if(g+1==6) k2=1;
    								else k2=g+1;
    						if(arr[k1]!=2 && arr[k2]!=2)
    						{
    							HungryList.remove();	
    							PresentEating[0]=g;
    							Remaning_time_left_1=2;
                                                    	arr[g]=2;
    						}
    				}
    				else if(PresentEating[1]==0)
    				{
    					int g=HungryList.peek();
    						int k1,k2;
    							if(g-1==0) k1=5;
    								else k1=g-1;
    							if(g+1==6) k2=1;
    								else k2=g+1;
    						if(arr[k1]!=2 && arr[k2]!=2)
    						{
    							HungryList.remove();
    							PresentEating[1]=g;
    							Remaning_time_left_2=2;
                                                    	arr[g]=2;
    						}
    				}
    			}
    		}
    		}
    		else
    		{
    			
    			label_1.setText("Please enter Runtime");
    		}
        }

        public void windowClosing(WindowEvent e) 
        {
                dispose();
                System.exit(0);
        }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}
}