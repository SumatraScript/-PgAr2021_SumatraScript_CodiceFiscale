package it.unibs.fp.codicefiscale;

public class CodiceFiscale {
	private String nome;
	private String cognome;
	private String dataDiNascita;
	private String giornoDiNAscita;
	private String comune;
	private String carattereDiControllo;
	
	public CodiceFiscale(String nome, String cognome, String dataDiNascita, String giornoDiNAscita, String comune,
			String carattereDiControllo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.giornoDiNAscita = giornoDiNAscita;
		this.comune = comune;
		this.carattereDiControllo = carattereDiControllo;
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
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getGiornoDiNAscita() {
		return giornoDiNAscita;
	}
	public void setGiornoDiNAscita(String giornoDiNAscita) {
		this.giornoDiNAscita = giornoDiNAscita;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getCarattereDiControllo() {
		return carattereDiControllo;
	}
	public void setCarattereDiControllo(String carattereDiControllo) {
		this.carattereDiControllo = carattereDiControllo;
	}
	
	
}
