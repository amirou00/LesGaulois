package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

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

	public void recevoirCoup(int forceCoup) {
		assert precondition(forceCoup);
		int forceInitiale = force;
		force -= forceCoup;
		if (force < 1) {
			parler("J'abandonne !");
		} 
		else {
			parler("Aïe");
		}
		assert isInvariantVerified();
		assert postcondition(forceInitiale, force);
	}
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	private boolean precondition(int forceCoup) {
		return forceCoup > 0;
	}
	
	private boolean postcondition(int forceInitiale, int forceFinale) {
		return forceFinale < forceInitiale;
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
