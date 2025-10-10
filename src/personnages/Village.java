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
		
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
	}

}
