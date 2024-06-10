package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Representação do registro do tempo online do aluno.
* 
* @author Nicole Brito Maracajá
*/
public class RegistroTempoOnline {

	/**
	* Nome da disciplina.
	*/
	private String disciplina;
	
	/**
	* Registro do tempo online que o aluno dedicou à disciplina.
	*/
	private int tempoOnline;
	
	/**
	* Meta de tempo online que o aluno deve cumprir naquela disciplina.
	*/
	private int metaTempoOnline;
		
	/**
	* Constrói a disciplina e a meta de tempo online destinada a essa disciplina.
	* @param disciplina o nome da disciplina
	* @param metaTempoOnline a meta de tempo online destinada a essa disciplina.
	*/
	public RegistroTempoOnline (String disciplina, int metaTempoOnline) {
		this.disciplina = disciplina;
		this.metaTempoOnline = metaTempoOnline;
	}
	
	/**
	* Constrói a disciplina a partir do nome dela.
	* @param disciplina o nome da disciplina.
	*/
	public RegistroTempoOnline (String disciplina) {
		this.disciplina = disciplina;
		this.metaTempoOnline = 120;
	}
	
	/**
	* Adiciona o tempo registrado ao tempo online total.
	*
	*@param valor a quantidade de tempo registrada.
	*/
	public void adicionaTempoOnline (int valor) {
		if (valor > 0) {
			tempoOnline += valor;
		}
	}
	
	/**
	* Método para saber se atingiu a meta de tempo online desejada ou não.
	*
	*@return boolean true se atingiu false se não atingiu.
	*/
	public boolean atingiuMetaTempoOnline() {
		if (tempoOnline >= metaTempoOnline) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	* Sobrescrita do toString para formatar a saída.
	*
	*@return toString saida formatada
	*/
	@Override
	public String toString() {
		return disciplina + " " + tempoOnline + "/" + metaTempoOnline;
	}
			
}