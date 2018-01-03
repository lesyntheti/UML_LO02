package vue;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import modele.Carte;

public class TableJeuVue {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableJeuVue window = new TableJeuVue();
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
	public TableJeuVue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		CarteCachee blank = new CarteCachee();
		blank.setBounds(52,418, 82, 116);
		frame.getContentPane().add(blank);
		
		/*
		Carte carteTest = new Carte(0,0);
		CarteVue carteVue = new CarteVue(carteTest);
		carteVue.setBounds(100, 100, 82, 116);
		frame.getContentPane().add(carteVue);
		 */
		
		
		//en dernier (background)
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(background);
		
		
		frame.setVisible(true);
	}

}
