package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;
@Entity
public class Folga extends Model{

	  @Id
	    @GeneratedValue
		private Long idFolga;
		private String dia;
		
		public static Model.Finder<Long, Folga> find = new Model.Finder<Long, Folga>(
				Long.class, Folga.class);

		public Long getIdFolga() {
			return idFolga;
		}

		public void setIdFolga(Long idFolga) {
			this.idFolga = idFolga;
		}

		public String getDia() {
			return dia;
		}

		public void setDia(String dia) {
			this.dia = dia;
		}
		
		

}
