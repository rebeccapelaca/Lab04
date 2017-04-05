package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
	
				Studente s = new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"));
				
				studenti.add(s);
			}

			return studenti;

		} catch (SQLException e) {
			
			throw new RuntimeException("Errore Db");
		}
	}

	public void getTutteLeIscrizioni() {

		final String sql = "SELECT * FROM iscrizione";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				for(Studente s : this.getTuttiGliStudenti())
					if(s.getMatricola()==rs.getInt("matricola"))
						s.setCodiciCorsi(rs.getString("codins"));
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	public void getStudente(Studente studente) {
		
		for(Studente s : this.getTuttiGliStudenti())
			if(s.equals(studente)) {
				studente.setCognome(s.getCognome());
				studente.setNome(s.getNome());
				studente.setCDS(s.getCDS());
				return;
			}			
	}
}
		
  
