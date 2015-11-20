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
	
//	@OneToOne 
//	private Funcionario funcionario = new Funcionario();
	
	public static Model.Finder<Long, Usuario> find = new Model.Finder<Long, Usuario>(
			Long.class, Usuario.class);
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
//	
//	public long getIdFunc() {
//		return funcionario.getIdFunc();
//	}
//
//	public void setIdFunc(Long idFunc) {
//		this.funcionario.setIdFunc(idFunc);
//	}
//	public Funcionario getFuncionario() {
//		return funcionario;
//	}
//	public void setFuncionario(Funcionario funcionario) {
//		this.funcionario = funcionario;
//	}

}
