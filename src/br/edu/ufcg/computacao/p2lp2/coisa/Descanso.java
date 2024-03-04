package br.edu.ufcg.computacao.p2lp2.coisa;

public class Descanso {

	private int horasDescanso;
	private int numeroSemanas;
	private String emoji;

	// metodo para definir o numero de horas de descanso por semana
	public void defineHorasDescanso(int valor) {
		if (valor >= 0) {
			this.horasDescanso = valor;
			atualizarEmoji();
		}
	}
	
	// metodo para definir o numero de semanas
	public void defineNumeroSemanas(int valor) {
		if (valor >= 0) {
			this.numeroSemanas = valor;
			atualizarEmoji();
	    }
	}
	
	// metodo para obter o status geral
	public String getStatusGeral() {
		if (horasDescanso > 0 && numeroSemanas > 0) {
			if (emoji != null) {
				if ((horasDescanso / numeroSemanas) >= 26) {
					return "descansado" + " - " + emoji;
				}else {
					return "cansado" + " - " + emoji;
				}
			} else {
				if ((horasDescanso / numeroSemanas) >= 26) {
					return "descansado";
				}else {
					return "cansado";
				}
			}
		}
		if(emoji != null) {
			return "descansado" + " - " + emoji;
		}
		return "descansado";
	}
	
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
	
	private void atualizarEmoji() {
        //se houver uma alteracao no estado de cansaco, remover o emoji
        this.emoji = null;
		}
}