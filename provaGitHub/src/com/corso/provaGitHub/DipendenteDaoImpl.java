package provaGitHub;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;



@Transactional
public class DipendenteDaoImpl implements DipendenteDao{
	
	@PersistenceContext
	EntityManager manager;

	@Override
	@Transactional
	public void addDipendente(Dipendente dip) {
		manager.persist(dip);
		}

	@Override
	public Dipendente findDipendente(Integer id) {
		Dipendente d= manager.find(Dipendente.class, id);
		return d;
	}
	
	@Override
    public  List<Dipendente> allDipendenti() {
		
		String jpql = "from Dipendente";  
	    Query q =  manager.createQuery(jpql,Dipendente.class);
		@SuppressWarnings("unchecked")
		List<Dipendente> l = q.getResultList();
		return l;
	}
    
	@Override
    @Transactional
    public void removeDipendente(Integer id) {
		Dipendente d= manager.find(Dipendente.class, id);
    	manager.remove(d);;
    }
    
	@Override
    public List<Dipendente> findAllRuolo(String mansione){
    	if(mansione.equalsIgnoreCase("controllore")) {
    		String jpql= "from Dipendente where ruolo =: mansione";
    		Query q = manager.createQuery(jpql, Dipendente.class);
    		q.setParameter("mansione", mansione);
    		@SuppressWarnings("unchecked")
    		List<Dipendente> l = q.getResultList();
    		return l;
    	} else if(mansione.equalsIgnoreCase("macchinista")) {
    		String jpql= "from Dipendente where ruolo =: mansione";
    		Query q = manager.createQuery(jpql, Dipendente.class);
    		q.setParameter("mansione", mansione);
    		@SuppressWarnings("unchecked")
    		List<Dipendente> l = q.getResultList();
    		return l;
    	} else if(mansione.equalsIgnoreCase("cameriere")) {
    		String jpql= "from Dipendente where ruolo =: mansione";
    		Query q = manager.createQuery(jpql, Dipendente.class);
    		q.setParameter("mansione", mansione);
    		@SuppressWarnings("unchecked")
    		List<Dipendente> l = q.getResultList();
    		return l;
    	} else return null;
    	
    }
}  
