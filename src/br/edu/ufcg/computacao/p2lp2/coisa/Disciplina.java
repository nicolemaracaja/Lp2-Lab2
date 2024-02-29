package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

public class Disciplina {

	private String disciplina;
    private int horas;
    private double[] notas = new double[4];
    private double media;
    
	// metodo principal
	public Disciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	// metodo para cadastrar o total de horas
	public void cadastraHoras(int horas) {
		if (horas > 0) {
            this.horas += horas;
		}
	}
	
	public void cadastraNota(int nota, double valorNota) {
		// notas possiveis: 1, 2, 3 e 4
        if (nota >= 1 && nota <= 4) {
        	notas[nota - 1] = valorNota;
        }
        // calcula a media
        double total = 0;
        for (double n : notas) {
            total += n;
        }
        media = total / notas.length;
	}

	public boolean aprovado() {
		if (media >= 7.0) {
        return true;
		}
		return false;
	}
	
	public String toString() {
		return disciplina + " " + horas + " " + media + " " + Arrays.toString(notas);
	        
	}

}