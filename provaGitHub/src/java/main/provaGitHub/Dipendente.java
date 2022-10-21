package provaGitHub;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dipendente {
	
	@Id
	private Integer idDipendente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="ruolo")
	private String ruolo;

	public Integer getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(Integer idDipendente) {
		this.idDipendente = idDipendente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public String toString() {
		return "Dipendente [idDipendente=" + idDipendente + ", nome=" + nome + ", cognome=" + cognome + ", ruolo="
				+ ruolo + "]";
	}
	
	
	
	

}
