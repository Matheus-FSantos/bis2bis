package br.com.Bis2Bis;

import java.util.Random;
import javax.swing.JOptionPane;

public class Bateria {
	public static void main(String[] args) {
		Integer eventos[] = registros(Integer.parseInt(JOptionPane.showInputDialog("Informe um numero")));
		
		System.out.println("\n\n---------- PORCENTAGEM FINAL DA BATERIA ----------\n");
		System.out.println("Porcentagem: " + getBattery(eventos) + "%");
		System.out.println("\n--------------------------------------------------\n");
	}
	
	public static Integer[] registros(Integer n) {
		Integer eventos[] = new Integer[n];
		
		Integer porcentagemAtual = 0;
		Integer acao = 0;
		
		for(int i = 0; i < eventos.length; i++) {
			porcentagemAtual = getBattery(eventos);
			

			//Verifica se o laptop já descarregou
			if(porcentagemAtual > 0) {
				//se nao descarregou ele pode continuar jogando ate gastar o valor atual da bateria do laptop
				acao = new Random().nextInt(100) - porcentagemAtual;
				System.out.println(acao);
				eventos[i] = acao;
			} else {
				//se descarregou ele so pode carregar
				acao = new Random().nextInt(100) + 1;
				System.out.println(acao);
				eventos[i] = acao;
			}
		}

		return eventos;
	}
	
	private static Integer getBattery(Integer eventos[]) {
		Integer cargaInicial = 50;
		
		for(int i = 0; i < eventos.length; i++) {
			if(eventos[i] != null) {
				cargaInicial += eventos[i];
				if(cargaInicial < 0)
					cargaInicial = 0;
				if(cargaInicial > 100)
					cargaInicial = 100;
			}
		}
		
		return cargaInicial;
	}
}