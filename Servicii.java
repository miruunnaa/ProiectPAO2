package com.company.servicii;
import com.company.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servicii {
    Scanner console = new Scanner(System.in);

    public void afisareAngajati(ArrayList Angajati) {
        Audit.getInstance().scrieAudit("afisareAngajati");
        for (int i = 0; i < Angajati.size(); i++){
            ((Angajat) Angajati.get(i)).afisare();
        }
    }

    public void afisarePersoane(ArrayList Persoane) {
        Audit.getInstance().scrieAudit("afisarePersoane");
        for (int i = 0; i < Persoane.size(); i++){
            ((Persoana) Persoane.get(i)).afisare();
        }
    }

    public void afisareDepartamente(ArrayList Departamente) {
        Audit.getInstance().scrieAudit("afisareDepartamente");
        for (int i = 0; i < Departamente.size(); i++){
            ((Departament) Departamente.get(i)).afisare();
        }
    }

    public void adaugaPersoana(ArrayList<Persoana> Persoane) {
        System.out.println("\nIntroduceti numarul de persoane ");
        int n = console.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("\nIntroduceti numele persoanei " + i);
            String nume = console.next();
            System.out.println("\nIntroduceti prenumele persoanei " + i);
            String prenume = console.next();
            System.out.println("\nIntroduceti data nasterii persoanei " + i);
            String data_nastere = console.next();
            System.out.println("\nIntroduceti CNP persoanei " + i);
            String CNP = console.next();
            Persoana P = new Persoana(nume, prenume, data_nastere, CNP);
            Persoane.add(P);
        }
        Audit.getInstance().scrieAudit("adaugaPersoana");
        this.afisarePersoane(Persoane);
    }

    public void adaugaAngajat(ArrayList<Angajat> Angajati) {
        System.out.println("\nIntroduceti numarul de angajati ");
        int n = console.nextInt();
        Intretinuti I = new Intretinuti();
        Departament D = new Departament();
        for (int i = 0; i < n; i++) {
            System.out.println("\nIntroduceti numele angajatului " + i);
            String nume = console.next();
            System.out.println("\nIntroduceti prenumele angajatului " + i);
            String prenume = console.next();
            System.out.println("\nIntroduceti data nasterii angajatului " + i);
            String data_nastere = console.next();
            System.out.println("\nIntroduceti CNP angajatului " + i);
            String CNP = console.next();
            System.out.println("\nIntroduceti salariul angajatului " + i);
            int salariu = console.nextInt();
            I = this.adaugaIntretinuti();
            D = this.adaugaDepartament();
            Angajat A = new Angajat(nume, prenume, data_nastere, CNP, salariu, I, D);
            Angajati.add(A);
        }
        Audit.getInstance().scrieAudit("adaugaAngajati");
        this.afisareAngajati(Angajati);
    }

    public Intretinuti adaugaIntretinuti() {
        System.out.println("\nIntroduceti numele intretinutului ");
        String nume = console.next();

        System.out.println("\nIntroduceti prenumele intretinutului ");
        String prenume = console.next();

        System.out.println("\nIntroduceti data nasterii intretinutului ");
        String data_nastere = console.next();

        System.out.println("\nIntroduceti CNP intretinutului ");
        String CNP = console.next();

        System.out.println("\nIntroduceti id intretinutului ");
        int id = console.nextInt();

        Intretinuti i = new Intretinuti(nume, prenume, data_nastere, CNP, id);
        Audit.getInstance().scrieAudit("adaugaIntretinuti");
        return i;
    }

    public Departament adaugaDepartament() {
        System.out.println("\nIntroduceti numele departamentului ");
        String nume = console.next();

        Proiect P1=this.adaugaProiect();
        Departament D =  new Departament(nume, P1);
        Audit.getInstance().scrieAudit("adaugaDepartament");
        return D;
    }

    public Proiect adaugaProiect() {
        System.out.println("\nIntroduceti numele proiectului ");
        String nume = console.next();
        System.out.println("\nIntroduceti data de inceput a proiectului ");
        String data_inceput = console.next();
        System.out.println("\nIntroduceti data de sfarsit a proiectului ");
        String data_sfarsit = console.next();
        System.out.println("\nCate etape?");
        int n= console.nextInt();

        List<Etapa> Etape = new ArrayList<>();
        for(int i=0;i<n;i++) {
            Etape.add(this.adaugaEtapa());
        }
        Proiect P1 = new Proiect (nume, data_inceput,data_sfarsit,Etape);
        Audit.getInstance().scrieAudit("adaugaProiect");
        return P1;
    }

    public Etapa adaugaEtapa() {
        System.out.println("\nIntroduceti denumirea etapei ");
        String denumire = console.next();
        System.out.println("\nIntroduceti luna de start a etapei ");
        String luna_start = console.next();
        System.out.println("\nIntroduceti luna de sfarsit a etapei ");
        String luna_sfarsit = console.next();
        Etapa e = new Etapa(denumire, luna_start, luna_sfarsit);
        Audit.getInstance().scrieAudit("adaugaEtapa");
        return e;
    }

    public void adaugaDepartamente(ArrayList<Departament> Departamente) {
        System.out.println("\nIntroduceti numele departamentului ");
        String nume = console.next();
        Proiect P1 = this.adaugaProiect();
        Departament D =  new Departament(nume, P1);
        Departamente.add(D);
        Audit.getInstance().scrieAudit("adaugaDepartamente");
        this.afisareDepartamente(Departamente);
    }

    public void adaugaManager(Manager M1) {
        Intretinuti I = new Intretinuti();
        Departament D = new Departament();
        System.out.println("\nIntroduceti numele managerului ");
        String nume = console.next();
        System.out.println("\nIntroduceti prenumele managerului ");
        String prenume = console.next();
        System.out.println("\nIntroduceti data nasterii managerului ");
        String data_nastere = console.next();
        System.out.println("\nIntroduceti CNP managerului ");
        String CNP = console.next();
        System.out.println("\nIntroduceti salariul managerului ");
        int salariu = console.nextInt();
        System.out.println("\nIntroduceti id managerului ");
        int id = console.nextInt();
        I = this.adaugaIntretinuti();
        D = this.adaugaDepartament();
        Manager M = new Manager(nume, prenume, data_nastere, CNP, salariu, I, D, id);
        M1 = M;
        M1.afisare();
        Audit.getInstance().scrieAudit("adaugaManager");
    }
}