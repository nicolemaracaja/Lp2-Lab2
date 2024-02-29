package br.edu.ufcg.computacao.p2lp2.coisa;

public class Descanso {

	private int horasDescanso;
	private int numeroSemanas;

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
	
	// metodo para obter o status geral
	public String getStatusGeral() {
		if (horasDescanso > 0 && numeroSemanas > 0) {
			if ((horasDescanso / numeroSemanas) >= 26) {
				return "descansado";
			} else {
				return "cansado";
			}
		}
		return "cansado";   
	}
	
}
