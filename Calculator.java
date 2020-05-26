
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



class Calculator extends JFrame implements ActionListener{
    static Panel panel,panel2;
    static Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,subtract,
                   add,divide,multi,clear,equals,decimal;
    static JTextField userInput;
    static JLabel label;

    
    public void createGUI(){
        panel = new Panel();
        panel.setLayout(new FlowLayout());
        userInput = new JTextField(15);
        panel.add(userInput);
        label = new JLabel("");
        clear = new Button("Clear");
        clear.setSize(new Dimension(4,4));
        panel.add(userInput,FlowLayout.LEFT);
        panel.add(clear,  FlowLayout.CENTER );
        panel.add(label, FlowLayout.RIGHT);
        
        panel2 = new Panel();
        panel2.setLayout(new GridLayout(4,4));
        n1 = new Button("1");
        n2 = new Button("2");
        n3 = new Button("3");
        n4 = new Button("4");
        n5 = new Button("5");
        n6 = new Button("6");
        n7 = new Button("7");
        n8 = new Button("8");
        n9 = new Button("9");
        n0 = new Button("0");
        decimal = new Button(".");
        add = new Button("+");
        subtract = new Button("-");
        multi = new Button("*");
        divide = new Button("/");
        equals = new Button("=");
                        
        panel2.add(n7);
        panel2.add(n8);
        panel2.add(n9);
        panel2.add(add);
        panel2.add(n4);
        panel2.add(n5);
        panel2.add(n6);
        panel2.add(subtract);
        panel2.add(n1);
        panel2.add(n2);
        panel2.add(n3);
        panel2.add(multi);
        panel2.add(n0);
        panel2.add(decimal);
        panel2.add(equals);
        panel2.add(divide);
        
        add(panel,BorderLayout.SOUTH);
        add(panel2);
        
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);   
    }
    
    public void addListeners(){
      n1.addActionListener(this);
      n2.addActionListener(this);
      n3.addActionListener(this);
      n4.addActionListener(this);
      n5.addActionListener(this);
      n6.addActionListener(this);
      n7.addActionListener(this);
      n8.addActionListener(this);
      n9.addActionListener(this);
      n0.addActionListener(this);
      decimal.addActionListener(this);       

      
      Operatorr a = new Operatorr();
      clear.addActionListener(a);
      add.addActionListener(a);
      subtract.addActionListener(a);
      divide.addActionListener(a);
      multi.addActionListener(a);  
      equals.addActionListener(a); 
    }
    
    public Calculator(){
    super("Sparsh's Calculator");
      createGUI();
      addListeners();
    }

    public void actionPerformed(ActionEvent e){
          Calculator.label.setText("");
          String num; 
          if(Operatorr.chosen)
                  userInput.setText(""); 
                  
            num = userInput.getText()+((Button)e.getSource()).getLabel();
            Operatorr.chosen = false;
            userInput.setText(num);
            
}
    public static void main(String[] args){
      Calculator mainGUI = new Calculator();
         
    }
}

class Operatorr extends Frame implements ActionListener{
    static double total;
    static boolean chosen=false;
    Object next, previous; 
    
    
    void init(){
        next=previous=null;
        total=0;
        chosen=false;  
        Calculator.userInput.setText("");   
    }
    
    public void actionPerformed(ActionEvent e){
         Calculator.label.setText("");
           if(e.getSource() == Calculator.clear)
              init();
           else if(!chosen){
            next = e.getSource();
            String current = Calculator.userInput.getText();
           
            if(previous == Calculator.add)                 
               total+=Double.parseDouble(current);
            else if(previous == Calculator.subtract)
               total-=Double.parseDouble(current);
            else if(previous == Calculator.multi)            
               total*=Double.parseDouble(current);
            else if(previous == Calculator.divide)
               total/=Double.parseDouble(current);
             else         
               total = Double.parseDouble(current);
            Calculator.userInput.setText(Double.toString(total));
            chosen = true;
            previous = next;   
            } 
            else
                 Calculator.label.setText("Operator already chosen, try again");         
       }   
    
  } 
  