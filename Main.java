import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
        
     ArrayList<Persoana> Persoane = new ArrayList<Persoana>();
     ArrayList<Angajat> Angajati = new ArrayList<Angajat>();
     ArrayList<Departament> Departamente = new ArrayList<Departament>();
     Manager M = new Manager();
	 Servicii S =new Servicii(); 
	 
	 Scanner console = new Scanner(System.in);
		int i=0;
		while (i==0) {
		System.out.println("\nIntroduceti comanda [1/2/3/4]: ");
		int comanda = console.nextInt();
	
		switch (comanda) {
		
		case 1:{S.adaugaPersoana(Persoane); 
		break;}
		case 2: {S.adaugaAngajat(Angajati);
		break;}
		case 3: {S.adaugaDepartamente(Departamente);
		break;}
		case 4:{ S.adaugaManager(M);
		break;
		}
		default :i++;
		}
		}
	}
}
		
	