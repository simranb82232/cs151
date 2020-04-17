package part2;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class BoxedIcon implements Icon {
	Icon icon;
	public BoxedIcon(Icon i) {
		icon = i;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		icon.paintIcon(c, g, x+10, y+10);
		g2.drawRect(x, y, this.getIconWidth(), this.getIconHeight());
		//g2.drawLine(x, y, this.getIconWidth(), y);
		//g2.drawLine(x, y, x, this.getIconHeight());
		//g2.drawLine(x, this.getIconHeight(), this.getIconWidth(), this.getIconHeight());
		//g2.drawLine(this.getIconWidth(), this.getIconHeight(), this.getIconWidth(), y);
	}
	@Override
	public int getIconWidth() {
		return icon.getIconWidth() + 20;
	}
	@Override
	public int getIconHeight() {
		return icon.getIconHeight() + 20;
	}
}
