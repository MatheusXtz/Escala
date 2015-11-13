package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class TipoEscala extends Model{
	    @Id
	    @GeneratedValue
		private Long idTipoEscala;
	    
	    @OneToOne
		private Horario horario = new Horario();
	    
	    @OneToOne
		private Intervalo intervalo = new Intervalo();
	    
	    
		
		public static Model.Finder<Long, TipoEscala> find = new Model.Finder<Long, TipoEscala>(
				Long.class, TipoEscala.class);



		public Long getIdTipoEscala() {
			return idTipoEscala;
		}



		public void setIdTipoEscala(Long idTipoEscala) {
			this.idTipoEscala = idTipoEscala;
		}



		public Horario getHorario() {
			return horario;
		}



		public void setHorario(Horario horario) {
			this.horario = horario;
		}



		public Intervalo getIntervalo() {
			return intervalo;
		}



		public void setIntervalo(Intervalo intervalo) {
			this.intervalo = intervalo;
		}
		
		public long getIdHorario() {
			return horario.getIdHorario();
		}

		public void setIdHorario(Long idHora) {
			this.horario.setIdHorario(idHora);
		}
	
		public long getIdIntervalo() {
			return intervalo.getIdIntervalo();
		}

		public void setIdIntervalo(Long idInter) {
			this.intervalo.setIdIntervalo(idInter);
		}
}
