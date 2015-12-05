package controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Bloco;
import models.Escala;
import models.Funcionario;

public class Escalador {
	public static void criarEscala(Escala escala, List<Funcionario> funcionarios) {
		ordenarBlocos(escala);
		
		int max = funcionarios.size();
		int current = 0;
		
		for (Bloco b : escala.blocos) {
			b.funcionario = funcionarios.get(current);
			
			current++;
			current = current % max;
		}
	}

	private static void ordenarBlocos(Escala escala) {
		Comparator<Bloco> comparator = new Comparator<Bloco>() {
			@Override
			public int compare(Bloco bloco1, Bloco bloco2) {
				return bloco1.getHorasTrabalho().compareTo(bloco2.getHorasTrabalho());
			}
			
		};
		
		Collections.sort(escala.blocos, comparator);
	}
}
