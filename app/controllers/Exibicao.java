package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import models.Bloco;
import models.Escala;
import models.Semana;

public class Exibicao {
	public static void mostraEscala(Escala escala) {
		HashMap<Integer, List<Bloco>> mapa = montarMapa(escala);
		
		for (Entry<Integer, List<Bloco>> entrada : mapa.entrySet()) {
			System.out.println(Semana.getDiaSemana(entrada.getKey()) + ": ");
			
			List<Bloco> blocos = ordenarBlocos(entrada);
			
			for (Bloco b : blocos) {
				System.out.println(b);
			}
		}
	}

	private static List<Bloco> ordenarBlocos(Entry<Integer, List<Bloco>> entrada) {
		Comparator<Bloco> comparator = new Comparator<Bloco>() {
			@Override
			public int compare(Bloco bloco1, Bloco bloco2) {
				return new Integer(bloco1.horaInicial).compareTo(new Integer(bloco2.horaInicial));
			}
		};
		
		List<Bloco> blocos = entrada.getValue();
		Collections.sort(blocos, comparator);
		return blocos;
	}

	private static HashMap<Integer, List<Bloco>> montarMapa(Escala escala) {
		HashMap<Integer, List<Bloco>> mapa = new HashMap<Integer, List<Bloco>>();
		
		for (Bloco bloco : escala.blocos) {
			Integer dia = bloco.diaDaSemana;
			
			if (!mapa.containsKey(dia)) {
				mapa.put(dia, new ArrayList<Bloco>());
			}
			
			mapa.get(dia).add(bloco);
		}
		
		return mapa;
	}
	
}
