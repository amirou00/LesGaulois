package personnages;

import objets.Equipement;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public Musee() {
		// TODO Auto-generated constructor stub
	}
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		if (nbTrophee < trophees.length) {
			Trophee newTrophee = new Trophee(gaulois, equipement);
			trophees[nbTrophee] = newTrophee;
			nbTrophee++;
		}
		else {
			System.out.println("La musee est rempli...");
		}
	}

}
