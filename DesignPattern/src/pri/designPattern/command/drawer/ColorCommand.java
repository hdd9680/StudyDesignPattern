package pri.designPattern.command.drawer;

import pri.designPattern.command.command.Command;

import java.awt.*;

public class ColorCommand implements Command {

	protected Drawable drawable;
	private Color color;
	
	public ColorCommand(Drawable drawble, Color color) {
		this.drawable = drawble;
		this.color = color;
	}
	
	@Override
	public void execute() {
		drawable.setColor(color);
	}
	
}
