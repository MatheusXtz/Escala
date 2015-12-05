package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import models.Bloco;

public class Escala {

	public List<Bloco> blocos;
	public String mes;
	
	public Escala(String mes) {
		this.mes = mes;
		this.blocos = new ArrayList<Bloco>();
	}

	public void addBloco(Bloco bloco) {
		this.blocos.add(bloco);
	}

	public void addBlocos(Collection<Bloco> blocos2) {
		this.blocos.addAll(blocos2);
	}
}
