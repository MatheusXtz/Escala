package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
@Entity
public class Turno extends Model {

	    @Id
	    @GeneratedValue
		private Long idTurno;
		private String descricao;
		
		 @ManyToOne
			private Horario horario = new Horario();
		 
		 @OneToOne
			private Intervalo intervalo = new Intervalo();
		
		public static Model.Finder<Long, Turno> find = new Model.Finder<Long, Turno>(
				Long.class, Turno.class);

		public Long getIdTurno() {
			return idTurno;
		}

		public void setIdTurno(Long idTurno) {
			this.idTurno = idTurno;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
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
