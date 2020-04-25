
import java.util.ArrayList;
import java.util.List;

public class Proiect {
    
	private String NumeProiect;
	private String DataInceputProiect;
	private String DataFinalProiect;
	private List<Etapa> Etape = new ArrayList<>();
	
public Proiect(String numeProiect, String dataInceputProiect, String dataFinalProiect, List<Etapa> etape) {
		super();
		NumeProiect = numeProiect;
		DataInceputProiect = dataInceputProiect;
		DataFinalProiect = dataFinalProiect;
		Etape = etape;
}

public Proiect() {
		// TODO Auto-generated constructor stub
	}

public void afisare() {
	System.out.println("\nNume proiect: "+NumeProiect+"\nData inceput proiect: "+DataInceputProiect+"\nData final proiect: "+DataFinalProiect+"\nEtapele sunt: ");
	   for(int i = 0; i < Etape.size(); i++) {
           Etape.get(i).afisare();
	   }
 }	
}
