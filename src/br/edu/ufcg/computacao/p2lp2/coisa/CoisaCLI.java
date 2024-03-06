package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Scanner;
public class CoisaCLI {

	public static void main(String[] args) {
		
		//instanciando o scanner
		Scanner sc = new Scanner(System.in);
		
		//instanciando as classes de COISA
		Descanso descanso = new Descanso();
		RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2");
		Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 2);
		RegistroResumos meusResumos = new RegistroResumos(100);
		
		//menu principal
		System.out.println("Bem vindo à linha de comando COISACLI");
		System.out.println();
		System.out.println("Escolha qual opção você quer acessar:");
		System.out.println();
		System.out.println("1) REGISTRO DE TEMPO ONLINE");
		System.out.println("2) DESCANSO");
		System.out.println("3) DISCIPLINA");
		System.out.println("4) REGISTRO DE RESUMOS");
		//menu principal
		
		System.out.println();
		System.out.println("Escolha um número entre 1 e 4: ");
		int opcao = sc.nextInt();
		
		if (opcao == 1) {
			System.out.println("------------------------");
			System.out.println("REGISTRO DE TEMPO ONLINE");
			System.out.println("------------------------\n");
			System.out.println("- Para adicionar x horas ao seu registro de tempo online, use o comando 'TEMPOONLINE HORAS x'");
			System.out.println();
			
			System.out.println("Entre com o seu comando: ");
			String comando1 = sc.nextLine();
			
			if (comando1.startsWith("TEMPOONLINE HORAS")){
				 char ultimoCaractere = comando1.charAt(comando1.length() - 1);
		         int horas = Character.getNumericValue(ultimoCaractere);
		         tempoLP2.adicionaTempoOnline(horas);
		         System.out.println("Adicionando " + horas + " horas ao registro de tempo online.");
		}
		if (opcao == 2) {
			System.out.println("--------");
			System.out.println("DESCANSO");
			System.out.println("--------\n");
			System.out.println("- Para definir a quantidade x de horas de descanso, use o comando 'DEFINEDESCANSO HORAS x");
			System.out.println("- Para definir a quantidade x de semanas, use o comando 'DEFINEDESCANSO SEMANAS x'");
			System.out.println();
			
			System.out.println("Entre com o seu comando: ");
			String comando2 = sc.nextLine();
			
			if (comando2.startsWith("DEFINEDESCANSO HORAS")){
				 char ultimoCaractere = comando2.charAt(comando2.length() - 1);
		         int horas = Character.getNumericValue(ultimoCaractere);
		         descanso.defineHorasDescanso(horas);
		         System.out.println("O aluno registrou " + horas + " horas de descanso.");		
			 }
			 if (comando2.startsWith("DEFINEDESCANSO SEMANAS")){
				 char ultimoCaractere = comando2.charAt(comando2.length() - 1);
		         int semanas = Character.getNumericValue(ultimoCaractere);
		         descanso.defineHorasDescanso(semanas);
		         System.out.println("O aluno registrou " + semanas + " semanas.");		
		}
		if (opcao == 3) {
			System.out.println("----------");
			System.out.println("DISCIPLINA");
			System.out.println("----------\n");
			System.out.println("- Para cadastar a nota x, use o comando 'DISCIPLINA NOTA x: valor da nota'");
			System.out.println("- Para cadastar a quantidade de horas x, use o comando 'DISCIPLINA HORAS x'");
			System.out.println();
			
			System.out.println("Entre com o seu comando: ");
			String comando3 = sc.nextLine();
			
			 if (comando3.startsWith("DISCIPLINA NOTA")) {
				 int qtdNotas = comando3.charAt(17);
				 char ultimoCaractere = comando3.charAt(comando3.length() - 1);
		         int nota = Character.getNumericValue(ultimoCaractere);
		         
		         for (int i = 1; i <= qtdNotas; i++) {
		        	 prog2.cadastraNota(i, nota);
		        	 System.out.println("Nota " + i + ": " + nota);
		         }	
			 }
			 if (comando3.startsWith("DISCIPLINA HORAS")){
				 char ultimoCaractere = comando3.charAt(comando3.length() - 1);
		         int horas = Character.getNumericValue(ultimoCaractere);
		         prog2.cadastraHoras(horas);
		         System.out.println("O aluno registrou " + horas + " horas dedicadas à disciplina.");
			 }
		}
		if (opcao == 4) {
			System.out.println("REGISTRO DE RESUMOS\n");
			System.out.println("- Para adicionar um resumo x ao seu registro de resumos, use o comando 'RESUMO x'");
			System.out.println();
			
			System.out.println("Entre com o seu comando: ");
			String comando = sc.nextLine();
		}	
		 }
		 
		 }
		
		 
		
	}	

}
