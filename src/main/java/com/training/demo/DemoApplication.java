package com.training.demo;

import com.training.demo.model.Persona;
import com.training.demo.model.Studente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class DemoApplication {

	public static void main(String[] args) {

		Studente nuovoStudente = new Studente("Agnese","Riccardi","un777890");
		Persona nuovaPersona = new Studente("Agnese","Riccardi","un777890");
		nuovoStudente.getMatricola();
		nuovoStudente.getCodiceFiscale();
		nuovoStudente.getName();
		nuovoStudente.getSurname();
	}

}
