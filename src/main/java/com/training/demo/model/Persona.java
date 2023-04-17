package com.training.demo.model;

import com.training.demo.interfaces.Saluto;

public class Persona implements Saluto {

    //VARIABILI DI ISTANZA
    private String name;



    private String surname;
    private String codiceFiscale;

    //CONSTRUTTORE
    public Persona(String name,String surname){
        this.name = name;
        this.surname = surname;
    }
    //METODI DI CLASSE
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public void saluta(String saluto) {
        System.out.print("CIAO");
    }

    public void urla(String parola){
        System.out.println(parola);
    }
    public void urla(String parole[]){
        for(String parola:parole){
            System.out.println(parola);
        }
    }
}
