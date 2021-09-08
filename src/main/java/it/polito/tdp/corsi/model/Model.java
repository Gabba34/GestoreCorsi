package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return corsoDao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso, Integer> getIscrittiByCorsoByPeriodo(Integer pd){
		return corsoDao.getIscrittiByCorsoByPeriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(String corso){
		return corsoDao.getStudentiByCorso(new Corso(corso,null,null,null));
	}

	public boolean esisteCorso(String codins) {
		return corsoDao.esisteCorso(new Corso(codins, null, null, null));
	}
	
	public Map<String, Integer> getDivisioneCDS(String codice) {
		// SOLUZIONE 1
	 	/*Map<String,Integer> divisione = new HashMap<>();
		 
		List<Studente> studenti = getStudentiByCorso(codice);
		for(Studente s: studenti) {
			if(s.getCDS()!=null && !s.getCDS().equals("")) {
				if(divisione.get(s.getCDS())==null) {
					divisione.put(s.getCDS(),1);
				} else {
					divisione.put(s.getCDS(), divisione.get(s.getCDS())+1);
				}
			}
		}
		return divisione;*/
		return corsoDao.getDivisioneStudenti(new Corso(codice, null, null, null));
		// SOLUZIONE 2 usiamo il database, migliorano le performance.
	}
}
