package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.ArrayList;
import java.util.List;

/**
* Representação do descanso do estudante, baseado em suas horas de descanso e a quantidade de semanas registradas por ele.
* 
* @author Nicole Brito Maracajá
*/
public class Descanso {

	private int horasDescanso;
	private int numeroSemanas;
	private String emoji;
	private List<String> historico = new ArrayList<String>();

	/**
	* Define as horas de descanso do aluno.
	* @param valor a quantidade de horas de descanso
	*/
	public void defineHorasDescanso(int valor) {
		if (valor >= 0) {
			this.horasDescanso = valor;
		}
	}
	
	/**
	* Define a quantidade de semanas.
	* @param valor a quantidade de semanas.
	*/
	public void defineNumeroSemanas(int valor) {
		if (valor >= 0) {
			this.numeroSemanas = valor;
	    }
	}
	
	/**
	* Define o emoji registrado pelo aluno.
	* @param valor o emoji registrado.
	*/
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
	
	/**
	* Verifica o estado geral do aluno, baseado em suas horas de descanso e na quantidade de semanas registrada por ele.
	* @return status do aluno.
	*/
	public String getStatusGeral() {

			if (horasDescanso > 0 && numeroSemanas > 0) {
				
				//adiciona os status ao historico
				if ((horasDescanso / numeroSemanas) >= 26) {
					historico.add("d");
				} else {
					historico.add("c");
				}
				
				//remove o emoji se houver mudanca no status
				if (verificarStatus()) { 
			        this.emoji = null;
			    }
				
				//quando o emoji eh definido, entra nesse bloco
				if (emoji != null) {
					if ((horasDescanso / numeroSemanas) >= 26) {
						return "descansado" + " - " + emoji;
					} else {
						return "cansado" + " - " + emoji;
					}
					
				//condicao para quando nao define emoji
				} else {
					if ((horasDescanso / numeroSemanas) >= 26) {
						return "descansado";
					} else {
						return "cansado";
					}
				}
			}
			
			//caso nao seja passado nenhum parametro, retorna cansado
			if (emoji != null) {
				historico.add("c");
				return "cansado" + " - " + emoji;  
			} else {
				historico.add("c");
				return "cansado";
			}
		}
	
	/**
	* Verifica se o estado do aluno mudou.
	* @return boolean verdadeiro se houver mudança no status, falso se não hoiuver.
	*/
	private boolean verificarStatus() {
		
			if (historico.size() > 1) {
				String ultimoEstado = historico.get(historico.size() - 1);
				String penultimoEstado = historico.get(historico.size() - 2);

				if (ultimoEstado.equals("c") && penultimoEstado.equals("d")) {
					return true;  //ha uma mudança de estado de descansado para cansado
				} else if (ultimoEstado.equals("d") && penultimoEstado.equals("c")) {
					return true;  //ha uma mudança de estado de cansado para descansado
				}
			}
		return false;
	}
}