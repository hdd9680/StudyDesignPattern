package pri.designPattern.iterpreter;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import pri.designPattern.iterpreter.language.InterpreterFacade;
import pri.designPattern.iterpreter.turtle.TurtleCanvas;

public class Application extends Frame implements ActionListener {
	
	private static final long serialVersionUID = 2546234159594657237L;
	private static final String FILE_PATH = "C:\\Users\\hdd96\\git\\StudyDesignPattern\\DesignPattern\\src\\pri\\designPattern\\iterpreter\\";
	
	private String program = "program go end";
	private TurtleCanvas canvas = new TurtleCanvas(400, 400);
	private InterpreterFacade facade = new InterpreterFacade(canvas);
	private TextField programTextField = new TextField(program);
	
	public Application(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		programTextField.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		add(programTextField, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);
		pack();
		setVisible(true);
		parseAndExecute();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == programTextField) {
			parseAndExecute();
		}
	}
	
	private void parseAndExecute() {
		String programText = programTextField.getText();
		System.out.println("programText : " + programText);
		facade.parse(programText);
		repaint();
	}
	
	public void paint(Graphics g) {
		canvas.initalize();
		facade.execute();
	}
	
	public static void main(String[] args) {
		new Application("Interpreter Pattern Sample");
	}

}
