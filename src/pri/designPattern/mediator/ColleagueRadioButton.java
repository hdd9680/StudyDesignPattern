package pri.designPattern.mediator;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JRadioButton;

public class ColleagueRadioButton extends JRadioButton implements Colleague, ItemListener {

	private static final long serialVersionUID = -3854991798667373351L;
	
	private Mediator mediator;

	public ColleagueRadioButton(String caption, boolean status) {
		super(caption, status);
	}
	
	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		mediator.colleageChanged(this);
	}
}
