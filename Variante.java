package crazyeightBis;

import java.util.*;

public class Variante {

	Scanner sc = new Scanner(System.in);
	
	public Variante(){
		
	}
	
	//l'appel de nouvelleVariante se fait lors de l'initialisation
	
	public Pioche nouvelleVariante(Pioche pioche){
		
		int numeroVariante=0;
		
		System.out.println("\nQuelle variante voulez-vous jouer ?");
		System.out.println("tappez 1 pour la variante minimaliste");
		System.out.println("tappez 2 pour la variante \"carte et maou\"");
		System.out.println("tappez 3 pour la variante \"Monclar\"");
		
		
		while(numeroVariante<1 || numeroVariante>4){
			numeroVariante = sc.nextInt();
			if (numeroVariante<1 || numeroVariante>4)
				System.out.println("nombre doit etre entre 1 et 3 please");
		//on s'assure que le joueur rentre un nombre entre 1 et 3
		}
		
		//selon le numéro entré, la méthode appelle la variante correspondante
		
		switch (numeroVariante)
		{
		  case 1: //minimaliste
			  			//10=rejouer, 8=change-couleur
			  
			//boucle changement des effets des 10
			  	int index=0;
			  	Iterator<Carte> i1=pioche.getDeck().iterator(); // on crée un Iterator pour parcourir notre ArrayList
				while(i1.hasNext()) 
				{
					
					if (i1.next().getNumero()==9){  //si la carte est un 10
						pioche.getDeck().get(index).setEffet(1);
					}
					index++;
				}
			  
				//boucle changement des effets des 8
				index=0;
				Iterator<Carte> i2=pioche.getDeck().iterator(); 
				while(i2.hasNext()) 
				{		
					if (i2.next().getNumero()==7){  //si la carte est un 8
						pioche.getDeck().get(index).setEffet(5);
					}
					index++;
				}
			  
		    
		    break; 
		    
		  case 2:  //carte et maou
			    		//10 rejouer, 8 passe le suivant, 7 fait piocher deux cartes, valet ch.couleur
			  
			  
			  
			  
			    break; 
			    
		  case 3:  //monclar
			   			
			  
			  
			  
			    break; 
			    
		  default:
		         System.out.println("erreur : pas de variante entrée"); //message optionnel car ce cas n'est pas censé être possible
		}
		
		
		return pioche;
	}
	
}
