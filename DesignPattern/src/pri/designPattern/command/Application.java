package pri.designPattern.command;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import pri.designPattern.command.command.Command;
import pri.designPattern.command.command.MacroCommand;
import pri.designPattern.command.drawer.DrawCanvas;
import pri.designPattern.command.drawer.DrawCommand;

public class Application extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
	
	private static final long serialVersionUID = -3996757206601374321L;
	private MacroCommand history = new MacroCommand();
	private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	private JButton clearButton = new JButton("clear");
	
	public Application(String title) {
		super(title);
		
		this.addWindowListener(this);
		canvas.addMouseMotionListener(new Mouse);
		clearButton.addActionListener(this);
		
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(canvas);
		getContentPane().add(mainBox);
		
		pack();
		setVisible(true);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Command command = new DrawCommand(canvas, e.getPoint());
		history.append(command);
		command.execute();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clearButton) {
			history.clear();
			canvas.repaint();
		}
	}
	
	public static void main(String[] args) {
		new Application("Command Pattern Sample");
	}

}
