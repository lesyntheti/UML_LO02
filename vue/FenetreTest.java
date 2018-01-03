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
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FenetreTest extends JPanel {

	private JFrame frame;
	ArrayList<Carte> carteJouable;

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
		createCards();
		initialize(carteJouable);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Carte> carteJouable) {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		CarteCachee blank = new CarteCachee();
		blank.setBounds(52,418, 82, 116);
		frame.getContentPane().add(blank);
		
		this.carteJouable=carteJouable;
		int j=1;
		Iterator<Carte> i1=carteJouable.iterator(); // on crée un Iterator pour parcourir notre ArrayList
		while(i1.hasNext()) 
		{
			//System.out.println(i1.next());	//on affiche toute la main du joueur
			CarteVue carteVue = new CarteVue(i1.next());
			int start = (frame.getWidth()/2)-(carteJouable.size()*25);
			carteVue.setBounds(start+(j*50),418, 82, 116);
			frame.getContentPane().add(carteVue);
			j++;
			System.out.println(i1.toString());
		}
		
		
		/*
		Carte carteTest = new Carte(0,0);
		CarteVue carteVue = new CarteVue(carteTest);
		carteVue.setBounds(100, 100, 82, 116);
		frame.getContentPane().add(carteVue);
		System.out.println(carteTest);
		*/
		
		//en dernier (background)
		BackgroundPanel background = new BackgroundPanel();
		background.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(background);
		
		
		
		frame.setVisible(true);
		
	}
	
	public void createCards(){
		Carte carteAjoutee;
		carteJouable= new ArrayList<Carte>();
		
		for (int i=0; i<4;i++){
		carteAjoutee = new Carte(i,0);
		carteJouable.add(carteAjoutee);
		}
		for (int i=0; i<3;i++){
			carteAjoutee = new Carte(i,1);
			carteJouable.add(carteAjoutee);
			}
		for (int i=0; i<2;i++){
			carteAjoutee = new Carte(i,2);
			carteJouable.add(carteAjoutee);
			}
	}
}
