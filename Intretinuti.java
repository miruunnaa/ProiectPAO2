
public class Intretinuti extends Persoana {

	 private int idIntretinut;

public Intretinuti(String nume, String prenume, String dataNastere, String cnp, int idIntretinut) {
		super(nume, prenume, dataNastere, cnp);
		this.idIntretinut = idIntretinut;
}
	
public Intretinuti() {
		super();
}

public void afisare() {
		
		System.out.println("\nId intretinut: "+idIntretinut+"\nDate intretinut: ");
		super.afisare();
	} 
}
