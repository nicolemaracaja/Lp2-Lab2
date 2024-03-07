package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.ArrayList;
import java.util.List;

public class Descanso {

	private int horasDescanso;
	private int numeroSemanas;
	private String emoji;
	private List<String> historico = new ArrayList<String>();

	// metodo para definir o numero de horas de descanso por semana
	public void defineHorasDescanso(int valor) {
		if (valor >= 0) {
			this.horasDescanso = valor;
		}
	}
	
	// metodo para definir o numero de semanas
	public void defineNumeroSemanas(int valor) {
		if (valor >= 0) {
			this.numeroSemanas = valor;
	    }
	}
	
	//metodo para definir o emoji
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
	
	// metodo para obter o status geral
		public String getStatusGeral() {
		    if (verificarStatus(historico)) {
		        this.emoji = null; //remove o emoji se houver mudanca no status
		    }
			
			if (horasDescanso > 0 && numeroSemanas > 0) {
				if (emoji != null) {
					if ((horasDescanso / numeroSemanas) >= 26) {
						historico.add("d");
						return "descansado" + " - " + emoji;
					} else {
						historico.add("c");
						return "cansado" + " - " + emoji;
					}
				} else {
					if ((horasDescanso / numeroSemanas) >= 26) {
						historico.add("d");
						return "descansado";
					} else {
						historico.add("c");
						return "cansado";
					}
				}
			}
			
			//caso nao seja passado nenhum parametro
			if (emoji != null) {
				historico.add("c");
				return "cansado" + " - " + emoji;  
			} else {
				historico.add("c");
				return "cansado";
			}
		}
	
	//metodo para verificar se o status do aluno mudou
		private boolean verificarStatus(List<String> historico) {
			if (historico.size() > 1) {
				String ultimoEstado = historico.get(historico.size() - 1);
		        String penultimoEstado = historico.get(historico.size() - 2);

		        if (ultimoEstado.startsWith("c") && penultimoEstado.startsWith("d")) {
		            return true;  //ha uma mudança de estado de descansado para cansado
		        } else if (ultimoEstado.startsWith("d") && penultimoEstado.startsWith("c")) {
		            return true;  //ha uma mudança de estado de cansado para descansado
		        }
		    }
		    return false;
		}
}
	