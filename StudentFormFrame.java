
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




// to do list
// add panels
//Robin Lopez(text field) is a Year 1(radio) ITEC(combo box) student that is taking CPS101 and CPS202
//String fullName  = firstName + " " + lastName; append this to done


public class StudentFormFrame extends JFrame {
  
  private JLabel label;
  private JLabel label2;
  private JButton button;
  private JButton button2;
  private JTextField textfield;
  private JCheckBox chinButton;
  private JCheckBox glassButton;
  private JCheckBox hairButton;
  private JCheckBox teethButton;
  private JRadioButton radio1;
  private JRadioButton radio2;
  private JRadioButton radio3;
  private JRadioButton radio4;
  
  JMenuBar menubar;
  JMenu file;
  JMenuItem exit;
  
  JTextArea ta = new JTextArea();
  JScrollPane sp = new JScrollPane(ta);
  
  String text1="";
  String text2="";
  String text3="";
  String text4="";
  String text5="";
  String result="";
  
  
  int x =0 , y = 0;
  
  
  Boolean cbFlag= false;
  //combo box
  String[] messageStrings = {"ITEC", "Computer Science", "Computer Engineering"};
  JComboBox cmbMessageList = new JComboBox(messageStrings);
  JLabel lblText = new JLabel();
  
  //constructor
  public StudentFormFrame(){
    //left to right top to bottom
    setLayout(new GridLayout(2,3));
    
    //menu
    menubar = new JMenuBar();
    setJMenuBar(menubar);
    file = new JMenu("File");
    menubar.add(file);
    exit = new JMenuItem("Exit");
    file.add(exit);
    event3 eve = new event3();
    exit.addActionListener(eve);
    
    
    //label
    label = new JLabel("Enter Your Name");
    add(label, BorderLayout.NORTH);
    
    
    
    
    //textfield
    textfield=(new JTextField(15));
    add(textfield);
    
       //radio button
    radio1 = new JRadioButton("Year 1");
    add(radio1);
    //default on Year 1
    //radio1.setSelected(true);
    radio2 = new JRadioButton("Year 2");
    add(radio2);
    radio3 = new JRadioButton("Year 3");
    add(radio3);
    radio4 = new JRadioButton("Year 4");
    add(radio4);
    ButtonGroup bG = new ButtonGroup();
    bG.add(radio1);
    bG.add(radio2);
    bG.add(radio3);
    bG.add(radio4);
    
   
    
    //combo box
    cmbMessageList.setSelectedIndex(0);
    add(cmbMessageList);
    add(lblText);
    event4 ce = new event4();
    cmbMessageList.addActionListener(ce);
    
    //check boxes
    chinButton = new JCheckBox("CPS 101");
    add(chinButton);
    glassButton = new JCheckBox("CPS 202");
    add(glassButton);
       
    //buttons
    button = new JButton("Done");
    add(button);
    
    //scrollable text area
    add(sp);
    
    
    //ActionListener
    //done button
    event e = new event();
    button.addActionListener(e);
    
    //text field -> text area
    event5 e5 = new event5();
    textfield.addActionListener(e5);
    
    //radio button (Years)
    event6 e6 = new event6();
    radio1.addActionListener(e6);
    radio2.addActionListener(e6);
    radio3.addActionListener(e6);
    radio4.addActionListener(e6);
    
    //check button actionlisteners
    event7 e7 = new event7();
    chinButton.addActionListener(e7);
    glassButton.addActionListener(e7);
    
             
  }
  

  //menu exit
  public class event3 implements ActionListener{
    public void actionPerformed(ActionEvent eve){
      System.exit(0);
    }
  }
  
  //school program
  public class event4 implements ActionListener{
    public void actionPerformed(ActionEvent eve){
      if (eve.getSource() == cmbMessageList){
       JComboBox cb = (JComboBox)eve.getSource();
       String msg = (String)cb.getSelectedItem();
       switch(msg){
         case "ITEC": 
           lblText.setText("ITEC");
           text3 = lblText.getText();
            break;
         case "Computer Science": lblText.setText("Computer Science");
           text3 = lblText.getText();
            break;
         case "Computer Engineering": lblText.setText("Computer Engineering");
           text3 = lblText.getText();
            break;
         default: lblText.setText("Whoops");
         
       }
      }
    }
  }
  
  //text field. student name
  public class event5 implements ActionListener{
    public void actionPerformed(ActionEvent e){
      text1 = textfield.getText();
    }
  }
  
  //radio buttons
  public class event6 implements ActionListener{
    public void actionPerformed(ActionEvent eve){
      if(radio1.isSelected()){
        text2=radio1.getText();
      }
      if(radio2.isSelected()){
        text2=radio2.getText();
      }
      if(radio3.isSelected()){
        text2=radio3.getText();
      }
      if(radio4.isSelected()){
        text2=radio4.getText();
      }
    }
  }
   
  
  //event 7 check box
   public class event7 implements ActionListener{
    public void actionPerformed(ActionEvent e){
     
      if(chinButton.isSelected() && glassButton.isSelected()){
       text4=chinButton.getText();
       text5=glassButton.getText();
       
      }
      if(glassButton.isSelected()){
       text5=glassButton.getText(); 
      // chinButton.setSelected(false);
      }
      
      else{
      text4=chinButton.getText();
      //glassButton.setSelected(false);
      }
    }
  }
  
  
    //done button
  public class event implements ActionListener {
    public void actionPerformed(ActionEvent e){
      if(chinButton.isSelected() == false && glassButton.isSelected() == false){
       result = ""; 
      }
      if(chinButton.isSelected() && glassButton.isSelected()){
      //Robin Lopez(text field) is a Year 1(radio) ITEC(combo box) student that is taking CPS101  or/and CPS202
      result = text1+ " " + "is a " + text2 + " " + text3 + " " + "student " + "that is taking " + text4 + " and "+ text5;
      }
      if(chinButton.isSelected() && glassButton.isSelected() == false){
      //Robin Lopez(text field) is a Year 1(radio) ITEC(combo box) student that is taking CPS101  or/and CPS202
      result = text1+ " " + "is a " + text2 + " " + text3 + " " + "student " + "that is taking " + text4;
      }
      if(glassButton.isSelected() && chinButton.isSelected() == false){
      result = text1+ " " + "is a " + text2 + " " + text3 + " " + "student " + "that is taking " + text5;  
      }
               
     ta.append(result);
     ta.append("\n");
     
    }
  }
  
 
  
}