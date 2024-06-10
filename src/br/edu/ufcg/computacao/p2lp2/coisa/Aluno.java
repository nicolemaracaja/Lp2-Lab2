package br.edu.ufcg.computacao.p2lp2.coisa;

public class Aluno {

	private String nome;
	private int anoNascimento;

	public Aluno(String nome, int anoNascimento) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
	}

	public int getIdade() {
		return 2021 - anoNascimento;
	}

	public String toString() {
		return "Aluno - "  + this.nome;
	}

}

