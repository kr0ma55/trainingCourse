package com.training.demo.model;

public class Studente extends Persona {
    private String matricola;
    public Studente(String name, String surname,String matricola) {
        super(name, surname);
        this.matricola = matricola;
    }
    public String getMatricola() {
        return this.matricola;
    }
}
