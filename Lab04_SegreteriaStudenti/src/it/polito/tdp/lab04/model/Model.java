package it.polito.tdp.lab04.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	StudenteDAO studentedao = new StudenteDAO();
	CorsoDAO corsodao = new CorsoDAO();
	
	public Studente getStudente(int matricola) {
		
		Studente s = new Studente(matricola, null, null, null);
		studentedao.getStudente(s);
		return s;
	}
	
	public Corso getCorso(String codice) {
		
		Corso c = new Corso(codice, 0, null, 0);
		corsodao.getCorso(c);
		return c;
	}
	
	public List<Corso> getCorsiStudente(int matricola) {
		
		Studente s = getStudente(matricola);
		List<Corso> corsiStudenti = new LinkedList<Corso>();
		
		for(String codice : s.getCodiciCorsi()) {	
			for(Corso c : corsodao.getTuttiICorsi())
				if(codice.compareTo(c.getCodice())==0)
					corsiStudenti.add(c);
		}
		
		return corsiStudenti;
		
	}
	
	public List<Studente> getStudentiIscritti(String codiceCorso) {
		
		Corso c = getCorso(codiceCorso);
		List<Studente> studentiIscritti = new LinkedList<Studente>();
		
		for(Integer matricola : c.getMatricoleIscritti()) {
			for(Studente s : studentedao.getTuttiGliStudenti())
				if(matricola.compareTo(s.getMatricola())==0)
					studentiIscritti.add(s);
		}
		
		return studentiIscritti;
			
	}
	
	public List<Corso> getListaCorsi() {
		
		List<Corso> corsitemp = new LinkedList<Corso>(corsodao.getTuttiICorsi());
		Collections.sort(corsitemp);
		return corsitemp;
	}

	public boolean studenteValido(Studente s) {
		
		if(studentedao.getTuttiGliStudenti().contains(s))
			return true;
		return false;
	}
}
