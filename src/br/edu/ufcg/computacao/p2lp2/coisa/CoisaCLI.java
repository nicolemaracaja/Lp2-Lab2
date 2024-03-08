package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.Scanner;
/**
 * Classe CoisaCLI, que serve para testar o Linha de Comando do Bônus.
 * 
 * @author Nicole Brito Maracajá.
 */
public class CoisaCLI {

	public static void main(String[] args) {
		
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
			
			Scanner in = new Scanner(System.in);
			System.out.println("------------------------");
			System.out.println("REGISTRO DE TEMPO ONLINE");
			System.out.println("------------------------\n");
			System.out.println("- Para adicionar x horas ao seu registro de tempo online, use o comando 'TEMPOONLINE HORAS x'");
			System.out.println("- Para saber se atingiu a meta do seu registro de tempo online, use o comando 'ATINGIUMETA'");
			System.out.println();
			
			System.out.println("Entre com o seu comando: ");
			String comando1 = in.nextLine();
			String[] comando = comando1.toUpperCase().split(" ");
			
			if(comando[0].equals("TEMPOONLINE") && comando[1].equals("HORAS")) {
		         tempoLP2.adicionaTempoOnline(Integer.parseInt(comando[2]));
		         System.out.println("Adicionando " + comando[2] + " horas ao registro de tempo online.");
		         System.out.println(tempoLP2.toString());
			}
		    if (comando[0].equals("ATINGIUMETA")) {
		    	 System.out.println(tempoLP2.atingiuMetaTempoOnline());
		    }	    
		   in.close();        
		}
		if (opcao == 2) {
			Scanner in = new Scanner(System.in);
			System.out.println("--------");
			System.out.println("DESCANSO");
			System.out.println("--------\n");
			System.out.println("- Para definir a quantidade x de horas de descanso, use o comando 'DEFINEDESCANSO HORAS x");
			System.out.println("- Para definir a quantidade x de semanas, use o comando 'DEFINEDESCANSO SEMANAS x'");
			System.out.println("- Para definir o emoji, use o comando 'EMOJI x");
			System.out.println();
			
			System.out.println("Entre com o seu comando: ");
			String comando2 = in.nextLine();
			String[] comando = comando2.toUpperCase().split(" ");
			
			if (comando[0].equals("DEFINEDESCANSO") && comando[1].equals("HORAS")){
		         descanso.defineHorasDescanso(Integer.parseInt(comando[2]));
		         System.out.println("O aluno registrou " + comando[2] + " horas de descanso.");
		         System.out.println(descanso.getStatusGeral());
			 }
			if (comando2.startsWith("DEFINEDESCANSO SEMANAS")){
				 char ultimoCaractere = comando2.charAt(comando2.length() - 1);
		         int semanas = Character.getNumericValue(ultimoCaractere);
		         descanso.defineHorasDescanso(semanas);
		         System.out.println("O aluno registrou " + semanas + " semanas.");
		         System.out.println(descanso.getStatusGeral());
			}
			if (comando2.startsWith("EMOJI")){
				descanso.definirEmoji(comando[1]);
				System.out.println(descanso.getStatusGeral());
			}
			in.close();
		}
		if (opcao == 3) {
			Scanner in = new Scanner(System.in);
			System.out.println("----------");
			System.out.println("DISCIPLINA");
			System.out.println("----------\n");
			System.out.println("- Para cadastar a nota x, use o comando 'DISCIPLINA NOTA x valor da nota'");
			System.out.println("- Para cadastar a quantidade de horas x, use o comando 'DISCIPLINA HORAS x'");
			System.out.println();
			
			System.out.println("Entre com o seu comando: ");
			String comando3 = in.nextLine();
			String[] comando = comando3.toUpperCase().split(" ");
			
			if (comando[0].equals("DISCIPLINA") && comando[1].equals("NOTA")) {
				prog2.cadastraNota(Integer.parseInt(comando[2]), Double.parseDouble(comando[3]));
				System.out.println(prog2.toString());
			}				
			if (comando[0].equals("DISCIPLINA") && comando[1].equals("HORAS")){
		        prog2.cadastraHoras(Integer.parseInt(comando[2]));
		        System.out.println("O aluno registrou " + comando[2] + " horas dedicadas à disciplina.");
			}
			in.close();
		}
		if (opcao == 4) {
			Scanner in = new Scanner(System.in);
			System.out.println("REGISTRO DE RESUMOS\n");
			System.out.println("- Para adicionar um resumo x ao seu registro de resumos, use o comando 'RESUMO x'");
			System.out.println();
			
			System.out.println("Entre com o seu comando: ");
			String comando4 = in.nextLine();
			String[] comando = comando4.toUpperCase().split(" ");
			String resumo = "";
			
			if(comando[0].equals("RESUMO")) {
				for(int i = 2; i < comando.length; i++) {
					if(i == 2) {
						resumo += comando[i];
					}else {
						resumo += " " + comando[i];
						
					}
				}
				meusResumos.adiciona(comando[1], resumo);
				
				for(int j = 0; j < meusResumos.conta(); j++) {
					System.out.println(meusResumos.pegaResumos()[j]);
				}	
			}
			in.close();
		}
		sc.close();
	}
}
