package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester
{
    static int helloCount = 1;
    static int byeCount = 1;
    
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      final int FIELD_WIDTH = 20;
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      JButton helloButton = new JButton("Say Hello");

      JButton goodbyeButton = new JButton("Say Goodbye");
      goodbyeButton.setEnabled(false);

      helloButton.addActionListener(event -> {         
    	 textField.setText("Hello " + helloCount);
    	 helloCount++;
         goodbyeButton.setEnabled(true);
         helloButton.setEnabled(false);
      });
      
      goodbyeButton.addActionListener(event -> {
         textField.setText("Goodbye " + byeCount);
         byeCount++;
         helloButton.setEnabled(true);
         goodbyeButton.setEnabled(false);
      });

      frame.setLayout(new FlowLayout());

      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}