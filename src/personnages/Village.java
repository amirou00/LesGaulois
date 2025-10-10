package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, Gaulois chef, final int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.chef = chef;
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
		chef.setVillage(this);
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if(nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			gaulois.setVillage(this);
		}
		else {
			System.out.println("!!!Le viallage est full chef!!!");
		}
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (1 <= numVillageois && numVillageois <= nbVillageois) {
			return villageois[numVillageois - 1];
		}
		System.out.println("“Il n’y a pas autant d’habitants dans notre village !");
		return null;
	}
	
	public void afficherVillage() {
	    System.out.println("Dans le village \"" + getNom() + "\" du chef " + getChef().getNom() + " vivent les légendaires gaulois :");
	    for (int i = 0; i < nbVillageois; i++) {
	        System.out.println("- " + villageois[i].getNom());
	    }
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1); 
		System.out.println(gaulois); 
		gaulois = village.trouverVillageois(2); 
		System.out.println(gaulois);
		village.afficherVillage();
		Gaulois obelix =  new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		Gaulois doublepolemix = new Gaulois("Doublepolemix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}

}
