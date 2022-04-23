import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GUI implements ActionListener {

	private JFrame frame;
	private JTextField wordInput;
	private JTextField numInput;
	private JButton btnRun;
	private String targetWord;
	private int numMonkeys;
	private JLabel foundBy;
	private JLabel lettersUsed;
	private JLabel time;
	private JLabel lblResults;
	private boolean stopped;
	private tester simulation;
	private JTextArea log;
	private JScrollPane scroll;
	
	private String branchtest;

	/**
	 * Launch the application.
	 */
	public void startGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize(){
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMonkeyTypewriterTester = new JLabel("Monkey Typewriter Simulator!");
		lblMonkeyTypewriterTester.setBounds(157, 6, 171, 16);
		frame.getContentPane().add(lblMonkeyTypewriterTester);
		
		JLabel lblTargetWord = new JLabel("Target word:");
		lblTargetWord.setBounds(127, 34, 84, 16);
		frame.getContentPane().add(lblTargetWord);
		
		JLabel lblNumberOfMonkeys = new JLabel("Number of monkeys:");
		lblNumberOfMonkeys.setBounds(80, 62, 144, 16);
		frame.getContentPane().add(lblNumberOfMonkeys);
		
		btnRun = new JButton("Run");
		btnRun.setBounds(175, 90, 117, 29);
		frame.getContentPane().add(btnRun);
		btnRun.addActionListener(this);
		
		wordInput = new JTextField();
		wordInput.setText("lowercase word here");
		wordInput.setBounds(236, 29, 130, 26);
		frame.getContentPane().add(wordInput);
		wordInput.setColumns(10);
		wordInput.addActionListener(this);
		
		numInput = new JTextField();
		numInput.setText("enter number here");
		numInput.setBounds(236, 57, 130, 26);
		frame.getContentPane().add(numInput);
		numInput.setColumns(10);
		numInput.addActionListener(this);
		
		lblResults = new JLabel("Results-");
		lblResults.setBounds(6, 161, 438, 16); 
		frame.getContentPane().add(lblResults);
		
		//300 161 scroll pos
		//150x150
		
		
		
		foundBy = new JLabel("Found by:");
		foundBy.setBounds(6, 189, 281, 16);
		frame.getContentPane().add(foundBy);
		
		lettersUsed = new JLabel("Number of letters used:");
		lettersUsed.setBounds(6, 216, 438, 16);
		frame.getContentPane().add(lettersUsed);
		
		time = new JLabel("Time:");
		time.setBounds(6, 244, 281, 16);
		frame.getContentPane().add(time);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnRun)
		{
			//send info to tester then monkey class
			if(targetWord != null || numMonkeys != 0)
			{
				
				simulation = new tester(targetWord,numMonkeys);
				lblResults.setText("Results- Running...");
				simulation.run();
				lblResults.setText("Results-");
				foundBy.setText("Found by: "+simulation.TgetName());
				lettersUsed.setText("Number of letters used: "+simulation.TgetStrokes());
				time.setText("Time: "+simulation.TgetTime()+" seconds");
				
			}
			
			else if(!simulation.TisFinished())
			{
				lblResults.setText("Previous simulation not finished");
			}
			
			else
				lblResults.setText("Please input a word and a number and press enter on each field :(");	
		}
		
		if(e.getSource()==wordInput)
		{
			targetWord = wordInput.getText();
		}
			
		if(e.getSource()==numInput)
		{
			numMonkeys = Integer.parseInt(numInput.getText());
		}


	}
	
	
	public boolean isStopped()
	{
		return stopped;
	}
}
