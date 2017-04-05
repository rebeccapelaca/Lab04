package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

public class Corso implements Comparable<Corso>{
	
	private String codice;
	private int crediti;
	private String nome;
	private int periodo;
	
	private List<Integer> matricoleIscritti;
	
	public Corso(String codice, int crediti, String nome, int periodo) {
		super();
		this.codice = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.periodo = periodo;
		this.matricoleIscritti = new LinkedList<Integer>();
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	

	public List<Integer> getMatricoleIscritti() {
		return matricoleIscritti;
	}

	public void setMatricoleIscritti(Integer m) {
		matricoleIscritti.add(m);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}

	@Override
	public int compareTo(Corso c) {
		
		return this.getNome().compareTo(c.getNome());
	}

	@Override
	public String toString() {
		return nome;
	}
	
}
