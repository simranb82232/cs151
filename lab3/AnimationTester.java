package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
	static ArrayList<MoveableShape> list = new ArrayList<MoveableShape>();
	
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
      MoveableShape shape2 = new CarShape(0, 0, 200);
      
      list.add(shape);
      list.add(shape2);
      for (MoveableShape s : list) {
      ShapeIcon icon = new ShapeIcon(s,
            ICON_WIDTH, ICON_HEIGHT);

      JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, event ->
         {
            s.move();
            label.repaint();
         });
      t.start();
      }
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}

