package controllers;

import java.util.List;

import models.Empresa;
import models.Funcionario;
import models.Setor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class FuncionarioCrud extends Controller{

	
private static final Form<Funcionario> funcionarioForm = Form.form(Funcionario.class);
	
	public static Result listaFuncionario() {
		List<Funcionario> funcionarios = Funcionario.find.findList();
		List<Setor> setors = Setor.find.findList();
		return ok(views.html.funcionario.render(funcionarios,setors));
	}

	// Salvar o Funcionario
	public static Result gravar() {
		Form<Funcionario> form = funcionarioForm.bindFromRequest();
		String idSetor = Form.form().bindFromRequest().get("idSetor");
		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.FuncionarioCrud.listaFuncionario());
		}
		
		Funcionario funcionario = form.get();
		funcionario.setIdSetor(Long.parseLong(idSetor));

		funcionario.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.FuncionarioCrud.listaFuncionario());
	}
	// Detalhar pra depois poder alterar
			public static Result detalhar(Long id) {
				Form<Funcionario> empForm = Form.form(Funcionario.class).fill(Funcionario.find.byId(id));
				return ok(views.html.alterarFuncionario.render(id, empForm));
			}
			
			// Alterar O Funcionariop pelo id
			public static Result alterar(Long id) {
				Form<Funcionario> form = funcionarioForm.bindFromRequest();
				Form.form(Funcionario.class).fill(Funcionario.find.byId(id));

				Form<Funcionario> alterarForm = Form.form(Funcionario.class).bindFromRequest();
				if (alterarForm.hasErrors()) {
					return badRequest(views.html.alterarFuncionario.render(id, alterarForm));
				}
				
				alterarForm.get().update(id);
				flash("sucesso", " alterado com sucesso");

				return redirect(routes.FuncionarioCrud.listaFuncionario());
			}
			
			// remover o curso pelo id
			public static Result remover(Long id) {
				Funcionario.find.ref(id).delete();
				flash("sucesso", "Funcionario removido com sucesso");
				return listaFuncionario();
			}
	}


