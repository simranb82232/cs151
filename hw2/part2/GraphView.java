package part2;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class GraphView extends JPanel implements Observer
{
	private static final int HEIGHT = 20;
	private DataModel dataModel;
	public GraphView(DataModel aModel) {
		dataModel = aModel;
		dataModel.addObserver(this);
		setPreferredSize(new Dimension(200, dataModel.getSize()*HEIGHT));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int index = e.getY()/HEIGHT;
				if(index >= 0 && index < dataModel.getSize()) {
					dataModel.set(index, e.getX());
				}
			}
		});
	}
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      int yPos = 0;
      g2.drawLine(10, 0, 10, dataModel.getSize() * 20);
      for (int i = 0; i < dataModel.getSize(); i++) {
    	  int width = dataModel.get(i);
    	  g2.drawRect(10, yPos*HEIGHT, width, HEIGHT);
    	  yPos ++;
      }
   }
   @Override
   public void update(Observable o, Object arg) {
	   dataModel = (DataModel) o;
	   repaint();
   }
}
