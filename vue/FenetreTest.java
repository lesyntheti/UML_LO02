package vue;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Carte;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FenetreTest extends JPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreTest window = new FenetreTest();
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
	public FenetreTest() {
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
		
		
		Carte carteTest = new Carte(0,0);
		CarteVue carteVue = new CarteVue(carteTest);
		carteVue.setBounds(100, 100, 82, 116);
		frame.getContentPane().add(carteVue);
		System.out.println(carteTest);
		
		
		//en dernier (background)
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(background);
		
		
		
		frame.setVisible(true);
		
	}
	
	
}
