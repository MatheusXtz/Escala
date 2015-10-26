package controllers;

import java.util.List;

import models.Empresa;
import models.Funcionario;
import models.Setor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class SetorCrud extends Controller{
	
private static final Form<Setor> setorForm = Form.form(Setor.class);
	
	public static Result listaSetores() {
		List<Setor> setores = Setor.find.findList();
		List<Empresa> empresas = Empresa.find.findList();
		return ok(views.html.setor.render(setores, empresas));
	}

	// Salvar o Setor
	public static Result gravar() {
		Form<Setor> form = setorForm.bindFromRequest();
		String idEmpre = Form.form().bindFromRequest().get("idEmpresa");
		
		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.SetorCrud.listaSetores());
		}
		Setor setor = form.get();
		
		setor.setIdEmpre(new Long(Long.parseLong(idEmpre)));

		setor.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.SetorCrud.listaSetores());
	}
	// Detalhar pra depois poder alterar
			public static Result detalhar(Long id) {
				Form<Setor> setForm = Form.form(Setor.class).fill(Setor.find.byId(id));
				List<Empresa> empresas = Empresa.find.findList();
				return ok(views.html.alterarSetor.render(id, setForm,empresas));
			}
			
			// Alterar O Setor pelo id
			public static Result alterar(Long id) {
				Form<Setor> form = setorForm.bindFromRequest();
				Form.form(Setor.class).fill(Setor.find.byId(id));
				List<Empresa> empresas = Empresa.find.findList();
				Form<Setor> alterarForm = Form.form(Setor.class).bindFromRequest();
				if (alterarForm.hasErrors()) {
					return badRequest(views.html.alterarSetor.render(id, alterarForm, empresas));
				}
				
				alterarForm.get().update(id);
				flash("sucesso", " alterado com sucesso");

				return redirect(routes.SetorCrud.listaSetores());
			}
			
			// remover o Setor pelo id
			public static Result remover(Long id) {
				Setor.find.ref(id).delete();
				flash("sucesso", "Setor removido com sucesso");
				return listaSetores();
			}

}
