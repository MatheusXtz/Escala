package controllers;


import java.util.List;

import models.Empresa;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class EmpresaCrud extends Controller {
	private static final Form<Empresa> empresaForm = Form.form(Empresa.class);
	
	public static Result listaEmpresa() {
		List<Empresa> empresas = Empresa.find.findList();
		return ok(views.html.empresa.render(empresas));
	}

	// Salvar o Curso
	public static Result gravar() {
		Form<Empresa> form = empresaForm.bindFromRequest();

		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.EmpresaCrud.listaEmpresa());
		}
		Empresa empresa = form.get();
	
		empresa.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.EmpresaCrud.listaEmpresa());
	}
	
	// Detalhar pra depois poder alterar
		public static Result detalhar(Long id) {
			Form<Empresa> empForm = Form.form(Empresa.class).fill(Empresa.find.byId(id));
			return ok(views.html.alterarEmpresa.render(id, empForm));
		}
		
		// Alterar O curso pelo id
		public static Result alterar(Long id) {
			Form<Empresa> form = empresaForm.bindFromRequest();
			Form.form(Empresa.class).fill(Empresa.find.byId(id));

			Form<Empresa> alterarForm = Form.form(Empresa.class).bindFromRequest();
			if (alterarForm.hasErrors()) {
				return badRequest(views.html.alterarEmpresa.render(id, alterarForm));
			}
			alterarForm.get().update(id);
			flash("sucesso", " alterado com sucesso");

			return redirect(routes.EmpresaCrud.listaEmpresa());
		}
		
		// remover o curso pelo id
		public static Result remover(Long id) {
			Empresa.find.ref(id).delete();
			flash("sucesso", "Empresa removido com sucesso");
			return listaEmpresa();
		}
}
