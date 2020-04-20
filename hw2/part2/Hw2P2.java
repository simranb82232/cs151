package part2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Hw2P2 {
	public static void main(String[] args) {
		DataModel model = new DataModel();
		File file = new File(args[0]);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextInt()) {
				model.add(scanner.nextInt());
			}
			scanner.close();
		} catch(Exception e) {
			System.out.println("File error.");
		}
		TextView tView = new TextView(model);
		GraphView gView = new GraphView(model);
		JFrame textFrame = new JFrame();
		JFrame graphFrame = new JFrame();
		textFrame.setContentPane(tView);
		graphFrame.setContentPane(gView);
		graphFrame.setBounds(205, 0, 200, 200);
		textFrame.setBounds(0, 0, 200, 200);
		graphFrame.setVisible(true);
		textFrame.setVisible(true);
		textFrame.addWindowListener(new WindowAdapter (){
				      public void windowClosing(WindowEvent event)
				      {
				    	  /**
				    	  try
				    	  {
				    	     PrintWriter writer = new PrintWriter(new FileWriter("datafile.txt", false));
				    	     BufferedReader br = new BufferedReader(new FileReader("datafile.txt"));
				    	     String line = br.readLine();
				    	     int i = 0;
				    	     String copy = "";
				    	     while(line != null) {
				    	    	 System.out.println(line);
				    	     	if(model.get(i) != Integer.parseInt(line)) {
				    	     		copy += model.get(i) + "/n";
				    	     	} else {
				    	     		copy += line + "/n";
				    	     	}
				    	     	line = br.readLine();
				    	     	i++;
				    	     }
				    	     writer.write(copy);
				    	     br.close();
				    	     writer.close();
				    	  }
				    	  catch (IOException e)
				    	  {
				    	     e.printStackTrace();
				    	  }
				    	  **/
				      }
				   });
	}
}
