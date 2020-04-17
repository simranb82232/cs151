package lab5;

import java.awt.*;
import javax.*;
import javax.swing.*;
import java.awt.event.*;

public class View implements ActionListener{
	JButton addButton;
	JTextField textField;
	JTextArea textArea;
	public View() {
	JFrame frame =new JFrame("MVC Tester");
	addButton =new JButton("Add");  
	addButton.setBounds(0,0,200,50);  
	frame.add(addButton);  
	addButton.addActionListener(this);  
	textField =new JTextField();  
	textField.setBounds(0, 200, 200, 50);  
	frame.add(textField);
	textArea = new JTextArea();  
	textArea.setBounds(0,51,200,150);  
	frame.add(textArea);
	frame.setSize(200,300);
	frame.setLayout(null);  
	frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	Controller controller = new Controller(textArea,textField);
	}  
}
