package pri.designPattern.mediator;

import javax.swing.JButton;

public class ColleagueButton extends JButton implements Colleague {

	private static final long serialVersionUID = 9139456463871802205L;
	
	private Mediator mediator;
	
	public ColleagueButton(String caption) {
		super(caption);
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}

}
