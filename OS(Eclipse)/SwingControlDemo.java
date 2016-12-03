
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SwingControlDemo {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   //private JLabel statusLabel;
   private JPanel controlPanel;

   public SwingControlDemo(){
      prepareGUI();
   }

   public static void main(String args){
      SwingControlDemo  swingControlDemo = new SwingControlDemo();      
      swingControlDemo.showTextAreaDemo(args);
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Page Fault Algorithms");
      mainFrame.getContentPane().setBackground(new Color(238, 232, 170));
      mainFrame.setSize(400,400);
      mainFrame.getContentPane().setLayout(new GridLayout(3, 1));
      //mainFrame.addWindowListener(new WindowAdapter() {
      //   public void windowClosing(WindowEvent windowEvent){
      //      System.exit(0);
      //   }        
      //});    
      headerLabel = new JLabel("", JLabel.CENTER);        
      headerLabel.setForeground(new Color(25, 25, 112));
      headerLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
      headerLabel.setBackground(new Color(238, 232, 170));
     // statusLabel = new JLabel("",JLabel.CENTER);    
     // statusLabel.setBackground(new Color(169, 169, 169));

     // statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setBackground(new Color(240, 128, 128));
      controlPanel.setLayout(new FlowLayout());

      mainFrame.getContentPane().add(headerLabel);
      mainFrame.getContentPane().add(controlPanel);
    //  mainFrame.getContentPane().add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showTextAreaDemo(String T){
      headerLabel.setText("Page Faults"); 

      final JTextArea commentTextArea = 
         new JTextArea(T,5,20);

      JScrollPane scrollPane = new JScrollPane(commentTextArea);    

      //JButton showButton = new JButton("Show");

     // showButton.addActionListener(new ActionListener() {
      //   public void actionPerformed(ActionEvent e) {     
       //     statusLabel.setText( commentTextArea.getText());        
         //}
      //}); 

      controlPanel.add(scrollPane);        
      mainFrame.setVisible(true);  
   }
}