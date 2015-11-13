package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Horario extends Model {
    @Id
    @GeneratedValue
	private Long idHorario;
	private String horaInicial;
	private String horaFinal;
	
	public static Model.Finder<Long, Horario> find = new Model.Finder<Long, Horario>(
			Long.class, Horario.class);

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	
}
