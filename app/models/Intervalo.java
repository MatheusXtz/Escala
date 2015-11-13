package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Intervalo extends Model {

	    @Id
	    @GeneratedValue
		private Long idIntervalo;
		private String horaInicial;
		private String horaFinal;
		
		public static Model.Finder<Long, Intervalo> find = new Model.Finder<Long, Intervalo>(
				Long.class, Intervalo.class);

		public Long getIdIntervalo() {
			return idIntervalo;
		}

		public void setIdIntervalo(Long idIntervalo) {
			this.idIntervalo = idIntervalo;
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
