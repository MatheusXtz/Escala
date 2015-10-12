package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Usuario extends Model {
	@Id
	@GeneratedValue
	Long idusuario;
	String login;
	String senha;
	
	@OneToOne 
	private Funcionario funcionario = new Funcionario();
	
	public static Model.Finder<Long, Funcionario> find = new Model.Finder<Long, Funcionario>(
			Long.class, Funcionario.class);
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
