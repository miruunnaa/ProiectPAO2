
public class Etapa {
	private String denumire;
	private String luna_start;
	private String luna_sfarsit;

public void afisare() {
		System.out.print("\nLuna start: "+luna_start);
		System.out.print("\nDenumire: "+denumire);
		System.out.print("\nLuna sfarsit: "+luna_sfarsit);
}

public Etapa(String denumire, String luna_start, String luna_sfarsit) {
		super();
		this.luna_start = luna_start;
		this.denumire = denumire;
		this.luna_sfarsit = luna_sfarsit;
}
	
public Etapa() {
		
	}
}
