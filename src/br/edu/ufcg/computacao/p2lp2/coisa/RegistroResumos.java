package br.edu.ufcg.computacao.p2lp2.coisa;

import java.util.ArrayList;
import java.util.List;

public class RegistroResumos {

	private int limiteResumos;
	private int contadorResumos;
	private String[] temas;
	private String[] resumos;
	
	public RegistroResumos(int limiteResumos) {
		this.limiteResumos = limiteResumos;
		this.temas = new String[limiteResumos];
        this.resumos = new String[limiteResumos];
        this.contadorResumos = 0;
	}
	
	public void adiciona(String tema, String resumo) {
		if (contadorResumos < limiteResumos) {
			temas[contadorResumos] = tema;
			resumos[contadorResumos] = resumo;
			contadorResumos ++;
		} else {
        // qnd atinge o limite, substitui o primeiro
        for (int i = 0; i < limiteResumos - 1; i++) {
            temas[i] = temas[i + 1];
            resumos[i] = resumos[i + 1];
        }
        temas[limiteResumos - 1] = tema; //adiciona na ultima pos
        resumos[limiteResumos - 1] = resumo;
		}
	}
	
	public String[] pegaResumos() {
		String[] resultados = new String[contadorResumos];
        for (int i = 0; i < contadorResumos; i++) {
            resultados[i] = temas[i] + ": " + resumos[i];
        }
        return resultados;
		
	}
	
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
	
	public int conta() {
		return contadorResumos;
		
	}
	public boolean temResumo(String tema) {
		for (int i = 0; i < contadorResumos; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
		return false;
		
	}
	
	// Metodo bonus para procurar
    public String[] busca(String chaveDeBusca) {
        List<String> resultados = new ArrayList<>(); //cria a lista de resultados

        for (int i = 0; i < contadorResumos; i++) {
            if (resumos[i].toLowerCase().contains(chaveDeBusca.toLowerCase())) {
                resultados.add(temas[i]);
            }
        }
        // ordena os resultados em ordem alfabetica
        resultados.sort(String::compareToIgnoreCase);
        
        return resultados.toArray(new String[0]);
    }
    
}
