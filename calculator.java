/*Genesis Dionisio
Section 4
Lab 09
Calculator
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener{
   static JButton[] digitButton = new JButton[10];
   static JButton[] OprButton = new JButton[5];
   static boolean newNumber = true;
   static double opnd1;
   static double opnd2;
   static double res;
   static int operator;
   static JTextField tf;
   static JButton eqButton;
   static JButton C;
   public static void main(String[] args){
      char[] Operators = {'/','*','-','+'};
      JFrame frm = new JFrame("Calculator Thing");
      Container contentPane = frm.getContentPane();
      contentPane.setLayout(new FlowLayout());
      ActionListener AL = new calculator();
      
      JPanel top = new JPanel(new BorderLayout());
      JLabel label = new JLabel("Csc 20 Lab 08",JLabel.CENTER);
      tf = new JTextField("0",29);
      tf.setHorizontalAlignment(JTextField.RIGHT);
      tf.addActionListener(AL);
      top.add(label, BorderLayout.NORTH);
      top.add(tf, BorderLayout.SOUTH);
      
      JPanel mid = new JPanel(new GridLayout(4,4,2,2));
      for (int count = 0; count <=9; count++)
      {
         digitButton[count] = new JButton("" + count);
         digitButton[count].addActionListener(AL);
      }
      for (int count = 0; count <4; count++){
         OprButton[count] = new JButton("" + Operators[count]);
         OprButton[count].addActionListener(AL);
      }
      C = new JButton("C");
      C.addActionListener(AL);
      JButton CE = new JButton ("CE");
      CE.addActionListener(AL);
      JButton sign = new JButton("      +/-     ");
      sign.addActionListener(AL);
      JButton decimal = new JButton("        .       ");
      decimal.addActionListener(AL);
      eqButton = new JButton("=");
      eqButton.addActionListener(AL);
      mid.add(C);
      mid.add(CE);
      mid.add(sign);
      mid.add(OprButton[0]);
      mid.add(digitButton[7]);
      mid.add(digitButton[8]);
      mid.add(digitButton[9]);
      mid.add(OprButton[1]);
      mid.add(digitButton[4]);
      mid.add(digitButton[5]);
      mid.add(digitButton[6]);
      mid.add(OprButton[2]);
      mid.add(digitButton[1]);
      mid.add(digitButton[2]);
      mid.add(digitButton[3]);
      mid.add(OprButton[3]);
      JPanel bot= new JPanel(new GridLayout(1,2,2,2));
      bot.add(decimal);
      bot.add(eqButton);
      JPanel zero = new JPanel(new GridLayout(1,2,2,2));
      zero.add(digitButton[0]);
      zero.add(bot);
      contentPane.add(top);
      contentPane.add(mid);
      contentPane.add(zero);
      
  frm.pack();
  frm.setSize(340,220);
  frm.setResizable(false);
  frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frm.setVisible(true);
   }
      public void actionPerformed(ActionEvent e) {
      for (int i=0; i<=9; ++i) {
         if (e.getSource() == digitButton[i]) {
            addDigit(i); return;
         }
      }
         if (e.getSource() == OprButton[0]){
               opnd1 = Double.parseDouble(tf.getText());
               newNumber = true;
               operator = '/'; return;
         }
         if (e.getSource() == OprButton[1]){
               opnd1 = Double.parseDouble(tf.getText());
               newNumber = true;
               operator = '*'; return;
         }
         if (e.getSource() == OprButton[2]){
               opnd1 = Double.parseDouble(tf.getText());
               newNumber = true;
               operator = '-'; return;
         }
         if (e.getSource() == OprButton[3]){
               opnd1 = Double.parseDouble(tf.getText());
               newNumber = true;
               operator = '+'; return;
         }
         if (e.getSource() == eqButton) {
            opnd2 = Double.parseDouble(tf.getText());
            switch (operator) {
               case '/': res = opnd1 / opnd2; break;
               case '*': res = opnd1 * opnd2; break;
               case '-': res = opnd1 - opnd2; break;
               case '+': res = opnd1 + opnd2; break;
            }
         if (e.getSource() == C) {
            tf.setText("0");
            newNumber = true;
         }
         tf.setText(""+res);
         newNumber = true;
         return;
         }
      }
      public void addDigit(int number){
         if (newNumber){
            tf.setText("" + number);
            newNumber = false;
         }
         else{
            tf.setText(tf.getText()+number);
         }
      }
         
      
}
