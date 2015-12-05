package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import models.*;
import play.mvc.Controller;
import play.mvc.Result;

public class EscalaCrud extends Controller{

	public static Result listaEscala() {
		List<Funcionario> funcionarios = Funcionario.find.findList();
		Bloco blocoSegunda1 = new Bloco(Semana.SEGUNDA, 6, 12);   // de 6h às 8h
		Bloco blocoSegunda2 = new Bloco(Semana.SEGUNDA, 12, 14);  // de 12h às 14h
		Bloco blocoSegunda3 = new Bloco(Semana.SEGUNDA, 14, 18);  // de 14h às 18h
		Bloco blocoSegunda4 = new Bloco(Semana.SEGUNDA, 18, 20);  // de 18h às 20h
		 
		// Colocando os blocos numa lista
		Collection<Bloco> blocos = new ArrayList<Bloco>();
		blocos.add(blocoSegunda1);
		blocos.add(blocoSegunda2);
		blocos.add(blocoSegunda3);
		blocos.add(blocoSegunda4);

		
		// Vamos agora criar a escala.
		// Vou colocar todos os blocos nessa escala.
		Escala escala = new Escala("Janeiro");
		escala.addBlocos(blocos);
		
		// O Escalador agora vai criara a escala
		// Ele cria a escala tentando distribuir a mesma quantidade de horas pra todos os funcionários
		Escalador escalador= new Escalador();
		escalador.criarEscala(escala, funcionarios);
		Exibicao.mostraEscala(escala);
	
		return ok(views.html.escala.render(funcionarios));
	}
}
