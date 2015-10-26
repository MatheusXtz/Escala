package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Empresa extends Model {
	
	@Id
	@GeneratedValue
	private Long idEmpre;
	String cnpj;
	String inscricaoestadual;
	String razao;
	String email;
	String telefone;
	String logradouro;
	String cidade;
	String estado;
	String cep;

	
	public static Model.Finder<Long, Empresa> find = new Model.Finder<Long, Empresa>(
			Long.class, Empresa.class);
	
	public Long getIdEmpre() {
		return idEmpre;
	}
	public void setIdEmpre(Long idEmpre) {
		this.idEmpre = idEmpre;
	}

	


public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoestadual() {
		return inscricaoestadual;
	}
	public void setInscricaoestadual(String inscricaoestadual) {
		this.inscricaoestadual = inscricaoestadual;
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
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
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String lagradouro) {
		this.logradouro = lagradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}

