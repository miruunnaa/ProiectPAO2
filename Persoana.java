package com.company;
public class Persoana {

    private String nume;
    private String prenume;
    private String dataNastere;
    private String cnp;

    public Persoana(String nume, String prenume, String dataNastere, String cnp) {
        super();
        this.nume = nume;
        this.prenume = prenume;
        this.dataNastere = dataNastere;
        this.cnp = cnp;
    }

    public Persoana() {
    }

    public void afisare () {
        System.out.print("\nNume: "+nume+"\nPrenume: "+prenume+"\nData nasterii: "+dataNastere+"\nCNP: "+cnp);
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getDataNastere() {
        return dataNastere;
    }

    public String getCnp() {
        return cnp;
    }
}
