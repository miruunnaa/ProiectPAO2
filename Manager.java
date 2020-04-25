
public class Manager extends Angajat{
	
   private int id;

public void afisare() {
	   super.afisare();
	   System.out.println("\nId manager: "+id);
   }

public Manager(String nume, String prenume, String dataNastere, String cnp, int salariu, Intretinuti i, Departament d,
		int id) {
	super(nume, prenume, dataNastere, cnp, salariu, i, d);
	this.id = id;
}

public Manager() {
	super();
}
}
