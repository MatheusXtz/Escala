package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Setor extends Model {
	
	@Id
	@GeneratedValue
	private Long idSetor;
	String nomeSetor;
	public static Model.Finder<Long, Setor> find = new Model.Finder<Long, Setor>(
			Long.class, Setor.class);
	
	@ManyToOne
	private Empresa empresa = new Empresa();
	
	public Long getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}
	public String getNomeSetor() {
		return nomeSetor;
	}
	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public long getIdEmpre() {
		return empresa.getIdEmpre();
	}

	public void setIdEmpre(Long idEmpre) {
		this.empresa.setIdEmpre(idEmpre);
	}
	

}
