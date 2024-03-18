package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class CustomIcon implements Icon{

	public int width;
	public int height;
	public Color color;
	
	public CustomIcon(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
//		g.setColor(this.color);
		g.setColor(new Color(102, 0, 156));
		g.fillRect(x, y, width, height);
		g.setColor(this.color);
		int offset = 2;
        g.fillRect(x+offset, y+offset, width-offset-1, height-offset-1);
        
        g.drawRect(x, y, width, height);
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}
	
	

	
}
