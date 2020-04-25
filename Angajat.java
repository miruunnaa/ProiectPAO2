public class Angajat extends Persoana {

	private int Salariu;
	private Intretinuti I;
	private Departament D;
    
public Angajat(String nume, String prenume, String dataNastere, String cnp, int salariu, Intretinuti i, Departament d) {
		super(nume, prenume, dataNastere, cnp);
		Salariu = salariu;
		I = i;
		D = d;
}

public Angajat() {
		super();
}

public void afisare () {
		super.afisare();
		System.out.print("\nSalariu: "+Salariu);
		I.afisare();
		D.afisare();
	}
}
