package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

/**
* Representação do desempenho do estudante, a partir das notas de suas disciplinas.
* 
* @author Nicole Brito Maracajá
*/
public class Disciplina {

	/**
	* Nome da disciplina paga pelo estudante.
	*/
	private String disciplina;
	
	/**
	* Quantidade de horas que o aluno dedica à disciplina.
	*/
    private int horas;
    
    /**
    * Array de notas do aluno na disciplina.
    */
    private double[] notas;
    
    /**
    * Média das notas do aluno na disciplina.
    */
    private double media;
    
    /**
    * Quantidade de notas que a disciplina possui.
    */
    private int qtdNotas;
    
    /**
    * Array de pesos para as notas das disciplinas.
    */
    private int[] pesos;
    
    /**
	* Constrói a disciplina a partir do nome da disciplina.
	* @param disciplina o nome da disciplina
	*/
	public Disciplina(String disciplina) {
		this.disciplina = disciplina;
		this.notas = new double[4];
	}
	
	/**
	* Constrói a disciplina a partir do nome da disciplina e da quantidade de notas dessa disciplina..
	* @param disciplina o nome da disciplina.
	* @param qtdNotas a quantidade de notas da disciplina.
	*/
	public Disciplina(String disciplina, int qtdNotas) {
		this.disciplina = disciplina;
		this.qtdNotas = qtdNotas;
		this.notas = new double[qtdNotas];
	}
	
	/**
	* Constrói a disciplina a partir do nome da disciplina, a quantidade de notas da disciplina e um array de pesos dessas notas.
	* @param disciplina o nome da disciplina.
	* @param qtdNotas a quantidade de notas da disciplina.
	* @param pesos os pesos das notas da disciplina.
	*/
	public Disciplina(String disciplina, int qtdNotas, int[] pesos) {
		this.disciplina = disciplina;
		this.qtdNotas = qtdNotas;
		this.notas = new double[qtdNotas];
		this.pesos = new int[qtdNotas];
		cadastraPesos(pesos);
	}
	
	/**
	* Cadastra os pesos das notas.
	*
	*@param pesos os pesos das notas da disciplina.
	*/
	public void cadastraPesos(int[] pesos) {
		if (pesos != null && pesos.length == qtdNotas) {
			this.pesos = Arrays.copyOf(pesos, pesos.length);
		}
	}
	
	/**
	* Calcula a média ponderada do aluno naquela disciplina.
	*/
	public void calculaMediaPonderada() {
		if (this.pesos != null) {
			double total = 0;
			int somaPesos = 0;
			for (int i = 0; i < qtdNotas; i++) {
				total += notas[i] * (pesos[i]);
				somaPesos += pesos[i];			
			media = total / somaPesos;
			}			
		}
	}
	

	/**
	* Calcula a média simples do aluno naquela disciplina.
	*/
	public void calculaMedia(){
		double total = 0;
		for (double n : notas) {
			total += n;
		}
		media = total / notas.length;
	}

	/**
	* Cadastra as horas dedicadas à disciplina.
	*
	*@param horas as horas dedicadas à disciplina.
	*/
	public void cadastraHoras(int horas) {
		if (horas > 0) {
            this.horas += horas;
		}
	}
	
	/**
	* Cadastra as notas da disciplina.
	*
	*@param nota nota da disciplina.
	*@param valorNota valor da nota da disciplina.
	*/
	public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= 4) {
        	notas[nota - 1] = valorNota;
        }
        calculaMedia();
        calculaMediaPonderada();
	}

	/**
	* Método para verificar se o aluno foi aprovado ou não.
	*
	*@return boolean true caso ele seja aprovado false caso seja reprovado.
	*/
	public boolean aprovado() {
		if (media >= 7.0) {
        return true;
		}
		return false;
	}
	
	/**
	* Sobrescrita do toString para formatar a saída.
	*
	*@return toString saida formatada
	*/
	@Override
	public String toString() {
		return disciplina + " " + horas + " " + media + " " + Arrays.toString(notas);
	        
	}
}