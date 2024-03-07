package br.edu.ufcg.computacao.p2lp2.coisa;

public class RegistroTempoOnline {

	private String disciplina;
	private int tempoOnline;
	private int metaTempoOnline;
		
	// metodo principal
	public RegistroTempoOnline (String disciplina, int metaTempoOnline) {
		this.disciplina = disciplina;
		this.metaTempoOnline = metaTempoOnline;
	}
	
	public RegistroTempoOnline (String disciplina) {
		this.disciplina = disciplina;
		this.metaTempoOnline = 120;
	}
	
	// metodo para adicionar tempo
	public void adicionaTempoOnline (int valor) {
		this.tempoOnline = tempoOnline;
		if (valor > 0) {
			tempoOnline += valor;
		}
	}
	
	// metodo para saber se atingiu a meta
	public boolean atingiuMetaTempoOnline() {
		if (tempoOnline >= metaTempoOnline) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return disciplina + " " + tempoOnline + "/" + metaTempoOnline;
	}
			
}

