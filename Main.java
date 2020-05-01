package com.company;
import com.company.servicii.Fisiere;
import com.company.servicii.Servicii;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Persoana> Persoane = new ArrayList<Persoana>();
        ArrayList<Angajat> Angajati = new ArrayList<Angajat>();
        ArrayList<Departament> Departamente = new ArrayList<Departament>();
        ArrayList<Etapa> Etape = new ArrayList<Etapa>();
        Manager M = new Manager();
        Servicii S = new Servicii();

        Fisiere fisiere = Fisiere.getInstance();
        Persoane = fisiere.citestePersoane("persoane.csv");
        Angajati = fisiere.citesteAngajati("angajati.csv");

        Scanner console = new Scanner(System.in);
        int i=0;
        while (i==0) {
            System.out.println("\nIntroduceti comanda [1/2/3/4/5]: ");
            int comanda = console.nextInt();

            switch (comanda) {
                case 1:
                    S.adaugaPersoana(Persoane);
                    break;
                case 2:
                    S.adaugaAngajat(Angajati);
                    break;
                case 3:
                    S.adaugaDepartamente(Departamente);
                    break;
                case 4:
                    S.adaugaManager(M);
                    break;

                case 6:
                    System.out.println("\nScrie numele fisierului cu persoane:");
                    String nume = console.next();
                    fisiere.scrieFisierPersoane(Persoane, nume);
                    break;

                case 8:
                    System.out.println("\nScrie numele fisierului cu intretinuti:");
                    String nume3 = console.next();
                    ArrayList<Intretinuti> intretinuti = Fisiere.getInstance().citesteIntretinuti(nume3);
                    S.adaugaIntretinuti();
                case 9:
                    System.out.println("\nScrie numele fisierului cu angajati:");
                    String numeAng = console.next();
                    fisiere.scrieFisierAngajati(Angajati, numeAng);
                    break;
                default :i++;
            }
        }
    }
}

