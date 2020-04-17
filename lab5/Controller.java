package lab5;

import java.awt.*;
import javax.*;
import javax.swing.*;
import java.awt.event.*;

public class Controller {
	public Controller(JTextArea textArea,JTextField textField) {
		textArea.setText(textArea.getText()+textField.getText()+"\n");
		textField.setText("");
		}
}
