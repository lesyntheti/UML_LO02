package crazyEight;
import java.util.ArrayList;
import java.util.Scanner;


public class Initialisation {
	
	Scanner sc = new Scanner(System.in);
	
	private CartesNonDistribuees cartesNonDistribuees;
	private CartesJouees cartesJouees;
	private Jeu jeu;
	private int nbJoueurs=0;
	
	public void initialiser(){
		creerCartesNonDistribuees();
		creerCartesJouees();
		ajouterJoueurs();
		distribuerCartes();
		
	}
			
		//création des éléments
			
			
	public void creerCartesNonDistribuees(){
		this.cartesNonDistribuees=new CartesNonDistribuees();
	       
	}
	
	public void creerCartesJouees(){
		ArrayList<Carte> deck = cartesNonDistribuees.getDeck();
		Carte carteDessus=cartesNonDistribuees.tirerCarte();
		this.cartesJouees=new CartesJouees(carteDessus);
	}
	
	public void ajouterJoueurs(){
		ArrayList<JoueurVirtuel> listeTemp = new ArrayList<JoueurVirtuel>();
		System.out.println("nombre de joueurs ? ");
		nbJoueurs = sc.nextInt();
		String nom;
		for (int i=0; i<nbJoueurs; i++){
			System.out.println("nom du joueur ?\n");
			nom = sc.nextLine();
			nom = sc.nextLine();
			JoueurVirtuel joueur = new JoueurVirtuel(nom);
			//on récupère le nom du joueur et l'envoi à la création du joueur virtuel
			listeTemp.add(joueur);
		}
		jeu.setListeJoueurs(listeTemp);
	}
	
	
	public void distribuerCartes(){
		if (nbJoueurs==0)
			System.out.println("erreur : aucun joueur adverse rentré");
		
		else if (nbJoueurs==1){ //distribuer 10 cartes à soi et au bot
			MainJoueur mainJoueurTemp=jeu.listeJoueurs.get(0).getMain();
			for (int j=0; j<10; j++) 
			{
				Carte carte = cartesNonDistribuees.tirerCarte();
				mainJoueurTemp.ajouter(carte);
			}
			jeu.listeJoueurs.get(0).setMain(mainJoueurTemp);
		}
		
		else if (nbJoueurs==2){ //distribuer 8 cartes à chacun
			MainJoueur mainJoueurTemp=jeu.listeJoueurs.get(0).getMain();
			for (int j=0; j<8; j++) 
			{
				Carte carte = cartesNonDistribuees.tirerCarte();
				mainJoueurTemp.ajouter(carte);
			}
			jeu.listeJoueurs.get(0).setMain(mainJoueurTemp);
			
			MainJoueur mainJoueurTemp2=jeu.listeJoueurs.get(1).getMain();
			for (int j=0; j<8; j++) 
			{
				Carte carte = cartesNonDistribuees.tirerCarte();
				mainJoueurTemp.ajouter(carte);
			}
			jeu.listeJoueurs.get(1).setMain(mainJoueurTemp2);
		}
		else{ //distribuer 6 cartes à chacun
			
		}
	}
	
	
	
	
}
