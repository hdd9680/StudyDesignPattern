package pri.designPattern.command;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pri.designPattern.command.command.Command;
import pri.designPattern.command.command.MacroCommand;
import pri.designPattern.command.drawer.ColorCommand;
import pri.designPattern.command.drawer.DrawCanvas;
import pri.designPattern.command.drawer.DrawCommand;

public class Application extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -3996757206601374321L;
	private MacroCommand history = new MacroCommand();
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	private JButton clearButton = new JButton("clear");
	private JButton redButton = new JButton("red");
	private JButton greenButton = new JButton("green");
	private JButton blueButton = new JButton("blue");
	private JButton undoButton = new JButton("undo");
	
	public Application(String title) {
		super(title);
		
		this.addWindowListener(getWindowAdapter());
		canvas.addMouseMotionListener(getMouseMotionAdapter());
		clearButton.addActionListener(this);
		redButton.addActionListener(this);
		greenButton.addActionListener(this);
		blueButton.addActionListener(this);
		undoButton.addActionListener(this);
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		buttonBox.add(redButton);
		buttonBox.add(greenButton);
		buttonBox.add(blueButton);
		buttonBox.add(undoButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);
		
		pack();
		setVisible(true);
	}
	
	public WindowAdapter getWindowAdapter() {
		return new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
	}

	public MouseMotionAdapter getMouseMotionAdapter() {
		return new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Command command = new DrawCommand(canvas, e.getPoint());
				history.append(command);
				command.execute();
			}
		};
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
		} else if(e.getSource() == redButton) {
			Command command = new ColorCommand(canvas, Color.red);
			history.append(command);
			command.execute();
		} else if(e.getSource() == greenButton) {
			Command command = new ColorCommand(canvas, Color.green);
			history.append(command);
			command.execute();
		} else if(e.getSource() == blueButton) {
			Command command = new ColorCommand(canvas, Color.blue);
			history.append(command);
			command.execute();
		} else if(e.getSource() == undoButton) {
			history.undo();
			canvas.repaint();
		}
		
	}
	
	public static void main(String[] args) {
		new Application("Command Pattern Sample");
	}

}
