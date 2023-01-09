package pri.designPattern.mediator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

public class ColleaguePasswordField extends JPasswordField implements Colleague, ActionListener {
	
	private static final long serialVersionUID = -890916559700514677L;
	
	private Mediator mediator;
	
	public ColleaguePasswordField(String text, int columns) {
		super(text, columns);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
		setBackground(enabled ? Color.WHITE : Color.LIGHT_GRAY);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mediator.colleageChanged(this);
	}
	
	

}
