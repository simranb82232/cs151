package part1;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.*;
import java.util.*;

public class CompositeIcon implements Icon {
	private ArrayList<Icon> list = new ArrayList<Icon>();
	public void addIcon(Icon icon) {
		list.add(icon);
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		for (Icon i : list) {
			i.paintIcon(c, g, x, y);
		}
	}
	@Override
	public int getIconWidth() {
		int width = 0;
		for (Icon i : list) {
			if (i.getIconWidth() > width) {
				width = i.getIconWidth();
			}
		}
		return width;
	}

	@Override
	public int getIconHeight() {
		int height = 0;
		for (Icon i : list) {
			if (i.getIconHeight() > height) {
				height = i.getIconHeight();
			}
		}
		return height;
	}

}
