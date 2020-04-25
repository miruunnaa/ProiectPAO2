
public class Departament {
	
	private String NumeDepartament;
	private Proiect P;
	
	public Departament(String numeDepartament, Proiect p) {
		super();
		NumeDepartament = numeDepartament;
		P = p;
	}
	
	public Departament() {
		// TODO Auto-generated constructor stub
	}

	public void afisare() {
		System.out.println("\nNume departament: "+NumeDepartament);
		System.out.println("\nDate proiect:");
		P.afisare();
	}

}
