package pri.designPattern.command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import pri.designPattern.command.command.MacroCommand;

public class DrawCanvas extends Canvas implements Drawable {
	
	private static final long serialVersionUID = 4294861107131189872L;
	
	private Color color = Color.red;
	private int radius;
	private MacroCommand history;
	
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
		init();
	}
	
	public void paint(Graphics g) {
		history.execute();
	}
	
	@Override
	public void init() {
		color = Color.red;
		radius = 6;
	}
	
	public void draw(int x, int y) {
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval( x - radius, y - radius, radius * 2, radius * 2);
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	
}
