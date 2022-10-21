package provaGitHub;

import java.util.List;

import javax.transaction.Transactional;


@Transactional
public interface DipendenteDao {
	
	public void addDipendente(Dipendente dip);
	public  List<Dipendente> allDipendenti();
	public Dipendente findDipendente(Integer id);
	public void removeDipendente(Integer id);
	public List<Dipendente> findAllRuolo(String mansione);

}