package controllers;

import java.util.List;

import models.Horario;
import models.Intervalo;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class IntervaloCrud extends Controller{
	
private static final Form<Intervalo> intervaloForm = Form.form(Intervalo.class);
	
	public static Result listaIntervalo() {
		List<Intervalo> intervalos = Intervalo.find.findList();
		
		return ok(views.html.intervalo.render(intervalos));
	}

	// Salvar o Horario
	public static Result gravar() {
		Form<Intervalo> form = intervaloForm.bindFromRequest();
		
		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.IntervaloCrud.listaIntervalo());
		}
		
		Intervalo intervalo = form.get();
		

		intervalo.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.IntervaloCrud.listaIntervalo());
	}
	// Detalhar pra depois poder alterar
			public static Result detalhar(Long id) {
				Form<Intervalo> intForm = Form.form(Intervalo.class).fill(Intervalo.find.byId(id));
				return ok(views.html.alterarIntervalo.render(id, intForm));
			}
			
			// Alterar O Intervalo pelo id
			public static Result alterar(Long id) {
				Form<Intervalo> form = intervaloForm.bindFromRequest();
				Form.form(Intervalo.class).fill(Intervalo.find.byId(id));

				Form<Intervalo> alterarForm = Form.form(Intervalo.class).bindFromRequest();
				if (alterarForm.hasErrors()) {
					return badRequest(views.html.alterarIntervalo.render(id, alterarForm));
				}
				
				alterarForm.get().update(id);
				flash("sucesso", " alterado com sucesso");

				return redirect(routes.IntervaloCrud.listaIntervalo());
			}
			
			// remover o Intervalo pelo id
			public static Result remover(Long id) {
				Intervalo.find.ref(id).delete();
				flash("sucesso", "Intervalo removido com sucesso");
				return listaIntervalo();
			}	

}
