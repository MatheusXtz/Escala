package models;

import models.Funcionario;

public class Bloco {
	public Integer diaDaSemana;
	public int horaInicial;
	public int horaFinal;
	public Funcionario funcionario;
	
	public Bloco(int diaDaSemana, int horaInicial, int horaFinal) {
		this.diaDaSemana = diaDaSemana;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}

	public Integer getHorasTrabalho() {
		return new Integer(horaFinal - horaInicial);
	}
	
	@Override
	public String toString() {
		return String.format("%02d", horaInicial) + " - " + String.format("%02d", horaFinal) + ": " + funcionario.getNome();
	}
}
