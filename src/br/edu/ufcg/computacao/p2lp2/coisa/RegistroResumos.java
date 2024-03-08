package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.ArrayList;
import java.util.List;

/**
* Representação do registro de resumos do aluno.
* 
* @author Nicole Brito Maracajá
*/
public class RegistroResumos {

	private int limiteResumos;
	private int contadorResumos;
	private String[] temas;
	private String[] resumos;
	
	/**
	* Constrói um resumo a partir do limite da quantidade.
	* O contador de resumos começa como nulo.
	*
	* @param limiteResumos o limite de resumos aceitos.
	*/
	public RegistroResumos(int limiteResumos) {
		this.limiteResumos = limiteResumos;
		this.temas = new String[limiteResumos];
        this.resumos = new String[limiteResumos];
        this.contadorResumos = 0;
	}
	
	/**
	* Adiciona os resumos e os temas aos arrays respectivos.
	* Quando atingir o limite de resumos, o primeiro é substituido.
	*
	*@param tema o tema do resumo.
	*@param resumo o proprio resumo.
	*/
	public void adiciona(String tema, String resumo) {
		if (contadorResumos < limiteResumos) {
			temas[contadorResumos] = tema;
			resumos[contadorResumos] = resumo;
			contadorResumos ++;
		} else {
        // quando atinge o limite, substitui o primeiro
        for (int i = 0; i < limiteResumos - 1; i++) {
            temas[i] = temas[i + 1];
            resumos[i] = resumos[i + 1];
        }
        temas[limiteResumos - 1] = tema; //adiciona na ultima posicao
        resumos[limiteResumos - 1] = resumo;
		}
	}
	
	/**
	* Pega os resumos e coloca dentro do array resultados.
	* Cada elemento do array possui a formatação "tema[i]: resumo[i]".
	* 
	* @return resultados o array de resultados.
	*/
	public String[] pegaResumos() {
		String[] resultados = new String[contadorResumos];
        for (int i = 0; i < contadorResumos; i++) {
            resultados[i] = temas[i] + ": " + resumos[i];
        }
        return resultados;	
	}
	
	/**
	* Imprime a quantidade de resumos cadastrados.
	* Imprime os temas dos resumos cadastrados.
	* 
	* @return toString a saida formatada com o uso do StringBuilder.
	*/
	public String imprimeResumos() {
		 StringBuilder sb = new StringBuilder();
	        
	     sb.append("- ").append(contadorResumos).append(" resumo(s) cadastrado(s)\n");

	     for (int i = 0; i < contadorResumos; i++) {
	    	 if (i == 0) {
	    		 sb.append("- ").append(temas[i]).append(" ");
	    	 } else {
	    		 sb.append("|").append(" ").append(temas[i]);
	    	 }
	     }	
	     return sb.toString();
	}
	
	/**
	* Conta a quantidade de resumos cadastrados.
	* 
	* @return contadorResumos o contador de resumos.
	*/
	public int conta() {
		return contadorResumos;	
	}
	
	/**
	* Verifica se o resumo existe ou não no sistema.
	*
	* @param tema do resumo.
	* @return boolean true se o resumo existir false caso contrário.
	*/
	public boolean temResumo(String tema) {
		for (int i = 0; i < contadorResumos; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
		return false;	
	}	
	
	/**
	* Método bônus para procurar o resumo a partir da chave de busca.
	* 
	*
	* @param chaveDeBusca uma palavra que será usada como chave de busca.
	* @return resultados uma lista que contém os temas dos resumos encontrados.
	*/
    public String[] busca(String chaveDeBusca) {
        List<String> resultados = new ArrayList<>(); //cria a lista de resultados

        for (int i = 0; i < contadorResumos; i++) {
            if (resumos[i].toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                resultados.add(temas[i]);
            }
        }
        //ordena os resultados em ordem alfabetica
        resultados.sort(String::compareToIgnoreCase);
        
        return resultados.toArray(new String[0]);
    }
    
}
