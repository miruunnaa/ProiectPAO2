package com.company.servicii;

import com.company.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Fisiere {
    private static Fisiere instance = null;

    private BufferedWriter writer;
    private BufferedReader reader;

    Fisiere() {
        writer = null;
        reader = null;
    }

    public static Fisiere getInstance() {
        if (instance == null)
            instance = new Fisiere();
        return instance;
    }


    public ArrayList<Etapa> citesteEtapa(String fisier) {
        ArrayList<Etapa> rez = new ArrayList<Etapa>();
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(fisier));
            while ( (line = reader.readLine()) != null ) {
                String[] etapa = line.split(",");
                try{
                    rez.add(new Etapa(etapa[0],etapa[1],etapa[2]));
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Linie invalid in fisier!");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Nu se poate citi din fisierul "+fisier);
        } catch (IOException e) {
            System.out.println("Eroare citire "+fisier);
        }
        return rez;
    }
    public ArrayList<Intretinuti> citesteIntretinuti(String fisier) {
        ArrayList<Intretinuti> rez = new ArrayList<Intretinuti>();
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(fisier));
            while ( (line = reader.readLine()) != null ) {
                String[] intretinuti = line.split(",");
                try{
                    rez.add(new Intretinuti(intretinuti[0],intretinuti[1],intretinuti[2],intretinuti[3],Integer.valueOf(intretinuti[4])));
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Linie invalid in fisier!");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Nu se poate citi din fisierul "+fisier);
        } catch (IOException e) {
            System.out.println("Eroare citire "+fisier);
        }
        return rez;
    }



    public ArrayList<Persoana> citestePersoane(String fisier) {
        ArrayList<Persoana> rez = new ArrayList<Persoana>();
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(fisier));
            while ( (line = reader.readLine()) != null ) {
                String[] persoana = line.split(",");
                try{
                    rez.add(new Persoana(persoana[0],persoana[1],persoana[2],persoana[3]));
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Linie invalid in fisier!");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Nu se poate citi din fisierul "+fisier);
        } catch (IOException e) {
            System.out.println("Eroare citire "+fisier);
        }
        return rez;
    }


    public void scrieFisier(String fisier, String data)
    {
        try {
            writer = new BufferedWriter(new FileWriter(fisier));
            writer.newLine();
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("Nu se poate scrie in fisierul " + fisier);
        }
    }

    public void scrieFisierPersoane(List<Persoana> persoanas, String fisier)
    {
        try (FileWriter file = new FileWriter(fisier, false)) {
            for (Persoana persoana : persoanas ) {
                String pers = persoana.getNume() + "," + persoana.getPrenume() +"," + persoana.getDataNastere() + "," + persoana.getCnp() + "\n";
                file.write(pers);
                file.flush();
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu exista");
        }
        catch (IOException e) {
            System.out.println("Eroare");
        }
    }

    /**
    Iau fiecare angajat din lista mea de angajati, adaugati de la tastatura sau cititi din fisier
    Fiecare angajat are 3 campuri mari: - informatiile angajatului
                                        - un obiect de tip Intretinuti
                                        - un obiect de tip Departament
                                        - despart aceste campuri prin ";"
    Fiecare intretinut are doar niste info, adica fara referinte sau vectori de referinta catre alte obiecte
    Fiecare departament are 2 campuri - info departament
                                      - obiect proiect
                                      - depart campurile astea prin ":"
    Fiecare proiect are 2 campuri: - info proiect
                                   - vector de referinta catre Etapa
                                   - depart campurile astea prin "-"
    Campurile astea cate un obiect de tip Etapa, le despart prin ";"
    Si fiecare etapa are info
    */
    public void scrieFisierAngajati(List<Angajat> angajati, String fisier)
    {
        try (FileWriter file = new FileWriter(fisier, false)) {
            for (Angajat angajat : angajati ) {
                String ang = angajat.getNume() + "," + angajat.getPrenume() +"," + angajat.getDataNastere() + "," + angajat.getCnp() + "," +
                        angajat.getSalariu() + ";";
                Intretinuti intretinut = angajat.getI();
                ang = ang + intretinut.getIdIntretinut() + "," + intretinut.getNume() + "," +intretinut.getPrenume() +"," + intretinut.getDataNastere() + ","
                        + intretinut.getCnp() + ";";
                Departament departament = angajat.getD();
                ang = ang + departament.getNumeDepartament() + ":";
                Proiect proiect = departament.getP();
                ang = ang + proiect.getNumeProiect() + "," + proiect.getDataInceputProiect() + "," + proiect.getDataFinalProiect() + "-";
                List<Etapa> etape = proiect.getEtape();
                for (Etapa etapa : etape) {
                    ang = ang + etapa.getDenumire() + "," + etapa.getLuna_start() + "," + etapa.getLuna_sfarsit() + ";";
                }
                ang = ang + "\n";
                file.write(ang);
                file.flush();
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu exista");
        }
        catch (IOException e) {
            System.out.println("Eroare");
        }
    }

    /**
     Despart campurile angajatului cu split(";")
                        - o sa am 3 String uri: - info angajat
                                                    - info intretinuti
                                                    - info depart
     Info departament il despart cu split(":") si o sa am 2 String uri: - primul e numele dep
                                                                         - al doilea campurile proiectului
     Campurile proiectului le despart cu split("-") si o sa am iar 2 Stringuri: - info proiect
                                                                                 - un String cu toate etapele despartite prin virgula
     Depart si Stringul de etape cu split(";") si o sa am un vector de etape
     Iau fiecare etapa din vectorul ala si iau info pt acea etapa
     Construiesc etapele, le adaug in vectorul de etape, fac si proiectul, departamentul si am angajatul pe care l adaug la lista de angajati :)
    */
    public ArrayList<Angajat> citesteAngajati(String fisier) {
        ArrayList<Angajat> rez = new ArrayList<Angajat>();
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(fisier));
            while ( (line = reader.readLine()) != null ) {
                String[] campuriAngajat = line.split(";");

                String[] infoAngajat = campuriAngajat[0].split(",");
                String numeAngajat = infoAngajat[0];
                String prenumeAngajat = infoAngajat[1];
                String dataNastereAngajat = infoAngajat[2];
                String cnpAngajat = infoAngajat[3];
                int salariuAngajat = Integer.parseInt(infoAngajat[4]);


                String[] infoIntretinuti = campuriAngajat[1].split(",");
                int idIntretinut = Integer.parseInt(infoIntretinuti[0]);
                String numeIntretinut = infoIntretinuti[1];
                String prenumeIntretinut = infoIntretinuti[2];
                String dataNastereIntretinut = infoIntretinuti[3];
                String cnpIntretinut = infoIntretinuti[4];
                Intretinuti intretinut = new Intretinuti(numeIntretinut, prenumeIntretinut, dataNastereIntretinut, cnpIntretinut, idIntretinut);


                String[] departamentCampuri = campuriAngajat[2].split(":");
                String numeDepartament = departamentCampuri[0];
                String[] proiectCampuri = departamentCampuri[1].split("-");

                String[] proiectInfo = proiectCampuri[0].split(",");
                String numeProiect = proiectInfo[0];
                String dataInceputProiect = proiectInfo[1];
                String dataSfarsitProiect = proiectInfo[2];

                List<Etapa> etape = new ArrayList<>();
                String[] etapeCampuri = proiectCampuri[1].split(";");
                for (String fiecareCampEtapa : etapeCampuri) {
                    String[] infoEtapa = fiecareCampEtapa.split(",");
                    String denumireEtapa = infoEtapa[0];
                    String lunaStartEtapa = infoEtapa[1];
                    String lunaSfarsitEtapa = infoEtapa[2];
                    Etapa etapa = new Etapa(denumireEtapa, lunaStartEtapa, lunaSfarsitEtapa);
                    etape.add(etapa);
                }

                Proiect proiect = new Proiect(numeProiect, dataInceputProiect, dataSfarsitProiect, etape);
                Departament departament = new Departament(numeDepartament, proiect);
                Angajat angajat = new Angajat(numeAngajat, prenumeAngajat, dataNastereAngajat, cnpAngajat, salariuAngajat, intretinut, departament);
                rez.add(angajat);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nu se poate citi din fisierul "+fisier);
        } catch (IOException e) {
            System.out.println("Eroare citire "+fisier);
        }
        return rez;
    }
}
