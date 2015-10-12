package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Endereco extends Model{
 
	@Id
	@GeneratedValue
	private Long idEnde;
	String lagradouro;
	String numero;
	String cidade;
	String estado;
	String cep;
	
	public static Model.Finder<Long, Endereco> find = new Model.Finder<Long, Endereco>(
			Long.class, Endereco.class);
	
	public String getLagradouro() {
		return lagradouro;
	}
	public void setLagradouro(String lagradouro) {
		this.lagradouro = lagradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	String Bairro;

	public Long getIdEnde() {
		return idEnde;
	}
	public void setIdEnde(Long idEnde) {
		this.idEnde = idEnde;
	}
	
}
