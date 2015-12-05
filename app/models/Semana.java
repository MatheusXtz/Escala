package models;

public class Semana {

	public static final Integer DOMINGO = 0;
	public static final Integer SEGUNDA = 1;
	public static final Integer TERCA = 2;
	public static final Integer QUARTA = 3;
	public static final Integer QUINTA = 4;
	public static final Integer SEXTA = 5;
	public static final Integer SABADO = 6;
	
	public static String getDiaSemana(Integer diaInt) {
		switch (diaInt) {
			case 0: return "Domingo";
			case 1: return "Segunda-feira";
			case 2: return "Terça-feira";
			case 3: return "Quarta-feira";
			case 4: return "Quinta-feira";
			case 5: return "Sexta-feira";
			case 6: return "Sábado";
			default: return "";
	    }
	}
}
