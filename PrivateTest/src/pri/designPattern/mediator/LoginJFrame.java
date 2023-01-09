package pri.designPattern.mediator;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginJFrame extends JFrame implements Mediator, Action {
	
	private static final long serialVersionUID = -5186507756358900801L;
	
	private ColleagueRadioButton radioGuest;
	private ColleagueRadioButton radioLogin;
	private ColleagueTextField textUser;
	private ColleaguePasswordField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	public LoginJFrame(String title) {
		super(title);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(4, 2));
		createColleagues();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		add(panel);
		
		panel.add(radioGuest);
		panel.add(radioLogin);
		panel.add(new JLabel("Username : "));
		panel.add(textUser);
		panel.add(new JLabel("Passworkd : "));
		panel.add(textPass);
		panel.add(buttonOk);
		panel.add(buttonCancel);
		
		colleageChanged(radioGuest);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		panel.setVisible(true);
	}
	
	@Override
	public void createColleagues() {
		
	}
	
	@Override
	public void colleageChanged(Colleague colleague) {
		// 버튼생성
		ButtonGroup g = new ButtonGroup();
		radioGuest = new ColleagueRadioButton("Guest", true);
		radioLogin = new ColleagueRadioButton("Login", false);
		g.add(radioGuest);
		g.add(radioLogin);
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		// 텍스트, 패스워드 필드 생성
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleaguePasswordField("", 10);
		
		// Mediator 참조 설정
		radioGuest.setMediator(this);
		radioLogin.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		
		// 이벤트 리스너 세트
		radioGuest.addItemListener(radioGuest);
		radioLogin.addItemListener(radioLogin);
		textUser.addActionListener(textPass);
		textPass.addActionListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}
	
	public void colleagueChanged(Colleague colleague) {
		if(colleague == radioGuest || colleague == radioLogin) {
			if(radioGuest.isSelected()) {
				textUser.setColleagueEnabled(false);
				textPass.setColleagueEnabled(false);
				buttonOk.setColleagueEnabled(true);
			} else {
				textUser.setColleagueEnabled(true);
				userPassChanged();
			}
		} else if(colleague == textUser || colleague == textPass) {
			userPassChanged();
		} else {
			System.out.println("colleagueChanged:unkown, colleague = " + colleague);
		}
	}

	private void userPassChanged() {
		if(textUser.getText().length() > 0) {
			textPass.setColleagueEnabled(true);
			
			if(textPass.getPassword().length > 0) {
				buttonOk.setColleagueEnabled(true);
			} else {
				buttonOk.setColleagueEnabled(false);
			}
			
		} else {
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	@Override
	public Object getValue(String key) {
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("" + e);
		System.exit(0);
	}
	
}
