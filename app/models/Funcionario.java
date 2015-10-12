package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Funcionario extends Model {

	@Id
	@GeneratedValue
	private Long idFunc;
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	
	
	
	
	@ManyToOne
	private Empresa empresa = new Empresa();
	
	public static Model.Finder<Long, Funcionario> find = new Model.Finder<Long, Funcionario>(
			Long.class, Funcionario.class);
	
	
	public Long getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(Long idFunc) {
		this.idFunc = idFunc;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	public long getIdEmpre() {
		return empresa.getIdEmpre();
	}

	public void setIdEmpre(Long idEmpre) {
		this.empresa.setIdEmpre(idEmpre);
	}
	
}
