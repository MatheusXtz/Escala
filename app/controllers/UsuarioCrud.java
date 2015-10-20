package controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.h2.util.New;

import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UsuarioCrud extends Controller {
	
	
	
private static final Form<Usuario> usuaForm = Form.form(Usuario.class);
	
	public static Result listaUsuarios() {
		List<Usuario> usuarios = Usuario.find.findList();
		return ok(views.html.usuario.render(usuarios));
	}

	// Salvar Usuario
	public static Result gravar() {
		Form<Usuario> form = usuaForm.bindFromRequest();

		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.UsuarioCrud.listaUsuarios());
		}
		Usuario usuario = form.get();
		
        usuario.setIdFunc(new Long(1));
		usuario.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.UsuarioCrud.listaUsuarios());
	}
	// Detalhar pra depois poder alterar
			public static Result detalhar(Long id) {
				Form<Usuario> empForm = Form.form(Usuario.class).fill(Usuario.find.byId(id));
				return ok(views.html.alterarUsuario.render(id, empForm));
			}
			
			// Alterar O curso pelo id
			public static Result alterar(Long id) {
				Form<Usuario> form = usuaForm.bindFromRequest();
				Form.form(Usuario.class).fill(Usuario.find.byId(id));

				Form<Usuario> alterarForm = Form.form(Usuario.class).bindFromRequest();
				if (alterarForm.hasErrors()) {
					return badRequest(views.html.alterarUsuario.render(id, alterarForm));
				}
				
				alterarForm.get().update(id);
				flash("sucesso", " alterado com sucesso");

				return redirect(routes.UsuarioCrud.listaUsuarios());
			}
			
			// remover o curso pelo id
			public static Result remover(Long id) {
				Usuario.find.ref(id).delete();
				flash("sucesso", "Funcionario removido com sucesso");
				return listaUsuarios();
			}
			
			public static Result logar() {
				List<Usuario> logar = Usuario.find.findList();
				HttpSession session=null;
		        session().clear();
				return ok(views.html.login.render(usuaForm));
			}
			
			public static Result login() {
				
				Form<Usuario> form = usuaForm.bindFromRequest();
				String login = Form.form().bindFromRequest().get("login");
				
				String senha = Form.form().bindFromRequest().get("senha");
				
		      
		        List<Usuario> user = Usuario.find.findList();
		       System.out.println(login);
		       System.out.println(senha);
		        System.out.println(user.size());
		       
//		        if(login.equals("ttt") && senha.equals("1234")){
//		        	 return redirect(routes.Application.index());
//		        }
//		        else{
//		        	flash("erro", "Login ou senha errados");
//					return redirect(routes.UsuarioCrud.login());
//		        }
		        for (int i = 0; i <user.size(); i++) {
		        	
					if(user.get(i).getLogin().equals(login) && user.get(i).getSenha().equals(senha)){
						return redirect(routes.Application.index());
					}
				}
		       
		        flash("erro", "Login ou senha errados");
     			return redirect(routes.UsuarioCrud.logar());

			}
			public static Result autenticar() {
				Form<Usuario> form = usuaForm.bindFromRequest();
				return ok(views.html.login.render(form));

			}

		

	}





