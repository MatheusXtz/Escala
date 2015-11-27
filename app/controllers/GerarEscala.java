package controllers;

import java.util.List;

import models.Funcionario;
import models.Setor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class GerarEscala extends Controller{

	
	public static Result gerarEscala() {
		
		List<Setor> setors = Setor.find.findList();
		return ok(views.html.gerarEscala.render(setors));
	}
}
