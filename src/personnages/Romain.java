package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 0;
//		int forceInitiale = force;
//		force -= forceCoup;
//		if (force < 1) {
//			parler("J'abandonne !");
//		} 
//		else {
//			parler("Aïe");
//		}
//		assert forceFinale < forceInitiale;
//		assert isInvariantVerified();
//	}
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	private void sEquiperAux(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + getNom() + " s’équipe avec un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0: {
			sEquiperAux(equipement);
			break;
		}
		case 1: {
			if(equipements[0] == equipement) {
				System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement + " !");
			}
			else {
				sEquiperAux(equipement);
			}
			break;
		}
		default: System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
		}
	}
	
	
	
	
	public Equipement[] recevoirCoup(int forceCoup) { 
		  Equipement[] equipementEjecte = null; 
		 
		  forceCoup = CalculResistanceEquipement(forceCoup); 
		 
		  force -= forceCoup; 
		  switch (force) { 
		  case 0: 
		   parler("Aïe"); 
		   break; 
		 
		  default: 
		   equipementEjecte = ejecterEquipement(); 
		   parler("J'abandonne..."); 
		   break; 
		  } 
		  return equipementEjecte; 
	}
	
	
	private int CalculResistanceEquipement(int forceCoup) { 
		  texte = "Ma force est  de " + this.force + ", et la force du coup est de 
		" + forceCoup; 
		  int resistanceEquipement = 0; 
		  if (!(nbEquipement == 0)) { 
		   texte += "\nMais heureusement, grace à mon équipement sa force est 
		diminué de "; 
		   for (int i = 0; i < nbEquipement;) { 
		    if ((equipements[i] != null && 
		equipements[i].equals(Equipement.BOUCLIER)) == true) { 
		     resistanceEquipement += 8; 
		    } else { 
		     System.out.println("Equipement casque"); 
		     resistanceEquipement += 5; 
		    } 
		    i++; 
		   } 
		   texte =+ resistanceEquipement + "!"; 
		  } 
		  parler(texte); 
		  forceCoup -= resistanceEquipement; 
		  return forceCoup; 
	}
	
	
	private Equipement[] ejecterEquipement() { 
		  Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
		  System.out.println("L'équipement de " + nom.toString() + " s'envole sous 
		la force du coup."); 
		  //TODO 
		  int nbEquipementEjecte = 0; 
		  for (int i = 0; i < nbEquipement; i++) { 
		   if (equipements[i] == null) { 
		    continue; 
		   } else { 
		    equipementEjecte[nbEquipementEjecte] = equipements[i]; 
		    nbEquipementEjecte++; 
		    equipements[i] = null; 
		   } 
		  } 
		  return equipementEjecte; 
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		
		for(Equipement equipement : Equipement.values()) {
			System.out.println(equipement);
		}
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}

}
