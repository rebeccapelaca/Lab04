package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model();
		Studente s1 = new Studente(148072, "Vannini", "Alberto","LOP1T4");
		Studente s2 = new Studente(155793, "Barucco", "Andrea", "ORG1T4");
		Corso c1 = new Corso("02PBVPG", 8, "Analisi dei sistemi economici", 1);
		
		System.out.println(m.getCorso(c1.getCodice()));
		System.out.println(m.getStudente(s2.getMatricola()));
		System.out.println(m.getCorsiStudente(s1.getMatricola()));
	}

}
