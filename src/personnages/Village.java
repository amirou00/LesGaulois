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
		
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		
	}
	
	public void afficherVillage() {
		
	}

}
