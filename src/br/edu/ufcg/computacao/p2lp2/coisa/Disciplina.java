package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Arrays;

public class Disciplina {

	private String disciplina;
    private int horas;
    private double[] notas;
    private double media;
    private int qtdNotas;
    private int[] pesos;
    
	// construtor principal
	public Disciplina(String disciplina) {
		this.disciplina = disciplina;
		this.notas = new double[4];
	}
	
	// construtor bonus que recebe a qtd de notas
	public Disciplina(String disciplina, int qtdNotas) {
		this.disciplina = disciplina;
		this.qtdNotas = qtdNotas;
		this.notas = new double[qtdNotas];
	}
	
	//construtor bonus que recebe o nome da disciplina, a qtd de notas e um array de inteiros com os pesos
	public Disciplina(String disciplina, int qtdNotas, int[] pesos) {
		this.disciplina = disciplina;
		this.qtdNotas = qtdNotas;
		this.notas = new double[qtdNotas];
		this.pesos = new int[qtdNotas];
		cadastraPesos(pesos);
	}
	
	//metodo bonus para cadastrar pesos
	public void cadastraPesos(int[] pesos) {
		if (pesos != null && pesos.length == qtdNotas) {
			this.pesos = Arrays.copyOf(pesos, pesos.length);
		}
	}
	
	//metodo bonus para calcular media ponderada
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
	
	//metodo para calcular media normal
	public void calculaMedia(){
		double total = 0;
		for (double n : notas) {
			total += n;
		}
		media = total / notas.length;
	}
	
	//metodo para cadastrar o total de horas
	public void cadastraHoras(int horas) {
		if (horas > 0) {
            this.horas += horas;
		}
	}
	
	//metodo para cadastrar a nota
	public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= 4) {
        	notas[nota - 1] = valorNota;
        }
        calculaMedia();
        calculaMediaPonderada();
	}

	public boolean aprovado() {
		if (media >= 7.0) {
        return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return disciplina + " " + horas + " " + media + " " + Arrays.toString(notas);
	        
	}
}