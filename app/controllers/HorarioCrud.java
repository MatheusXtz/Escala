package controllers;

import java.util.List;

import models.Funcionario;
import models.Horario;
import models.Setor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class HorarioCrud extends Controller{

private static final Form<Horario> horarioForm = Form.form(Horario.class);
	
	public static Result listaHorario() {
		List<Horario> horarios = Horario.find.findList();
		
		return ok(views.html.horario.render(horarios));
	}

	// Salvar o Horario
	public static Result gravar() {
		Form<Horario> form = horarioForm.bindFromRequest();
		
		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.HorarioCrud.listaHorario());
		}
		
		Horario horario = form.get();
		

		horario.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.HorarioCrud.listaHorario());
	}
	// Detalhar pra depois poder alterar
			public static Result detalhar(Long id) {
				Form<Horario> horForm = Form.form(Horario.class).fill(Horario.find.byId(id));
				return ok(views.html.alterarHorario.render(id, horForm));
			}
			
			// Alterar O Horario pelo id
			public static Result alterar(Long id) {
				Form<Horario> form = horarioForm.bindFromRequest();
				Form.form(Horario.class).fill(Horario.find.byId(id));

				Form<Horario> alterarForm = Form.form(Horario.class).bindFromRequest();
				if (alterarForm.hasErrors()) {
					return badRequest(views.html.alterarHorario.render(id, alterarForm));
				}
				
				alterarForm.get().update(id);
				flash("sucesso", " alterado com sucesso");

				return redirect(routes.HorarioCrud.listaHorario());
			}
			
			// remover o curso pelo id
			public static Result remover(Long id) {
				Horario.find.ref(id).delete();
				flash("sucesso", "Funcionario removido com sucesso");
				return listaHorario();
			}
	
}
