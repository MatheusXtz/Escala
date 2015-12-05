package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import models.Bloco;
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
	public List<Bloco> blocos;
	
	@ManyToOne
	private Setor setor = new Setor();
	
	public static Model.Finder<Long, Funcionario> find = new Model.Finder<Long, Funcionario>(
			Long.class, Funcionario.class);
	
	
	public Long getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(Long idFunc) {
		this.idFunc = idFunc;
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
	
	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	public long getIdSetor() {
		return setor.getIdSetor();
	}

	public void setIdSetor(Long idSetor) {
		this.setor.setIdSetor(idSetor);
	}
	
	public Integer horasDeTrabalho() {
		Integer horas = 0;
		
		for (Bloco b : blocos) {
			horas = b.getHorasTrabalho();
		}
		
		return horas;
	}
}
