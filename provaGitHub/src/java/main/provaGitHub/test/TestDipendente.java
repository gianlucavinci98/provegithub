package provaGitHub.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import provaGitHub.Dipendente;
import provaGitHub.DipendenteDao;
import provaGitHub.beans.Beans;




public class TestDipendente {

public static void main(String[] args) {
		
		
		
//		testAddDipendenti();
		testFindDipendente();
//		testRemoveDip();
//		testStampaAllDip();
//		testTrovaDipMans();



	}
	
	@SuppressWarnings("resource")
	private static void testAddDipendenti() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		DipendenteDao dao=  factory.getBean("dipendenteDao", DipendenteDao.class);
		
		Dipendente d1 = new Dipendente();
		d1.setIdDipendente(1);
		d1.setNome("Alessio");
		d1.setCognome("Curiale");
		d1.setRuolo("macchinista");
		
		Dipendente d2 = new Dipendente();
		d2.setIdDipendente(2);
		d2.setNome("Gianluca");
		d2.setCognome("Vinci");
		d2.setRuolo("controllore");
		
		Dipendente d3 = new Dipendente();
		d3.setIdDipendente(3);
		d3.setNome("Giovanni");
		d3.setCognome("Frisenda");
		d3.setRuolo("controllore");
		
		Dipendente d4 = new Dipendente();
		d4.setIdDipendente(4);
		d4.setNome("Salvatore");
		d4.setCognome("Galati");
		d4.setRuolo("cameriere");
		
		Dipendente d5 = new Dipendente();
		d5.setIdDipendente(5);
		d5.setNome("Andrea");
		d5.setCognome("Rammazzo");
		d5.setRuolo("cameriere");
		
		
		
		dao.addDipendente(d1);
		dao.addDipendente(d2);
		dao.addDipendente(d3);
		dao.addDipendente(d4);
		dao.addDipendente(d5);
		
		
	}
	@SuppressWarnings("resource")
	private static void testFindDipendente() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		DipendenteDao dao=  factory.getBean("dipendenteDao", DipendenteDao.class);
		System.out.println(dao.findDipendente(1));
		System.out.println(dao.findDipendente(4));	
	}
	
	@SuppressWarnings("resource")
	private static void testRemoveDip() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		DipendenteDao dao=  factory.getBean("dipendenteDao", DipendenteDao.class);
		dao.removeDipendente(3);
	}
	
	@SuppressWarnings("resource")
	private static void testStampaAllDip() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		DipendenteDao dao=  factory.getBean("dipendenteDao", DipendenteDao.class);
		System.out.println(dao.allDipendenti());
	}
	
	@SuppressWarnings("resource")
	private static void testTrovaDipMans() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Beans.class);
		DipendenteDao dao=  factory.getBean("dipendenteDao", DipendenteDao.class);
		System.out.println(dao.findAllRuolo("cameriere"));
	}
	
	
}