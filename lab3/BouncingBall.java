package lab3;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class BouncingBall implements MoveableShape {
	   private int x;
	   private int y;
	   private int radius;
	   private boolean bottom = false;
	   private boolean top = true;
	public BouncingBall(int x, int y, int rad)
	   {
	      this.x = x;
	      this.y = y;
	      this.radius = rad;
	   }

	   public void move()
	   {
	      if(y==50) {
	    	  bottom = true;
	      }
	      if (bottom == true && y > 0) {
	    	  y--;
	      }
	      if (y == 0) {
	    	  bottom = false;
	      }
	      if(y<50 && bottom == false) {
	    	  y++;
	      }
	   }

	   public void draw(Graphics2D g2)
	   {
	      Ellipse2D.Double ball
	            = new Ellipse2D.Double(x + radius, y + radius, 
	                  radius, radius);
	      g2.draw(ball);
	   }
}
