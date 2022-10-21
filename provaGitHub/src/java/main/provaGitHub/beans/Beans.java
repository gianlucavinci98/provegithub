package provaGitHub.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import provaGitHub.DipendenteDao;
import provaGitHub.DipendenteDaoImpl;





@Configuration   /*qui ci cono le istanze da creare e gestire con il container di Spring DI-IoC*/
@EnableTransactionManagement
//@Profile(value = { "sviluppo" })
public class Beans {
		
	@Bean(name="dataSource")
	public DataSource getDataSource () {
		System.out.println("sono nel profilo sviluppo");
		
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("datalavoro22");
		ds.setUrl("jdbc:mariadb://localhost:3306/prova");
		return ds; 
	} 
	/*
	 
	 1- � un container
	 2- � una factory di bean 
	 3- gestisce la connessione 
	 4- 
	 * */
	
	@Bean
    public LocalContainerEntityManagerFactoryBean  getEntityManager(){
    	 LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    	 
    	// factory.setValidationMode(ValidationMode.AUTO);
    	 
    	 // JDBC
    	 factory.setDataSource(getDataSource());  
    	 
    	 // imposta il dialogo tra JPA e hibernate
    	 factory.setJpaVendorAdapter(getJpaVendorAdapter()); // imposta il dialogo tra JPA e hibernate
    	 
    	 // impostare il luogo dove si trovano i bean
    	 factory.setPackagesToScan("provaGitHub"); // "com.corso.spring"
    	 // oppure "com.corso.spring...." al posto di this.getClass().getPackage().getName()
    	 return factory; 
    } 	
	
	private HibernateJpaVendorAdapter getJpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);   // obbligatorio: serve per tradurre le query nel particolare Dialetto
		
		adapter.setGenerateDdl(true);          //facoltativo, attiva il DDL cio� hibernate creer� le strutture nel DB se non sono gi� essitenti
		adapter.setShowSql(true);              // mostra l'SQL, comodo per i corsi e per il debug ma in produzione solitamente � a false
		return adapter;
	}	
	
	/*** transazioni ***/
	@Bean
	public PlatformTransactionManager getTransactionManager(){
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(getEntityManager().getObject());
	      //transactionManager.setNestedTransactionAllowed(false);
	      return transactionManager;
	}
	
/**** sezione DAO ****/
	
	@Bean(name="dipendenteDao") 
	public DipendenteDao getDipendenteDao (){
		DipendenteDao dao = new DipendenteDaoImpl();
		return dao; 
	}
//	@Bean(name="dipendenteService") 
//	public DipendenteService getDipendenteService (){
//		DipendenteService dao = new DipendenteServiceImpl();
//		return dao; 
//	}
}