package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import models.Bloco;
import models.Escala;
import models.Funcionario;
import models.Semana;
import controllers.Escalador;
import controllers.Exibicao;

public class Executor {

	public static void executar(){
		// Criando os funcionários
				Funcionario f1 = new Funcionario();
				f1.setNome("Jose");
				Funcionario f2 = new Funcionario();
				f2.setNome("Matheus");
		         Funcionario f3 = new Funcionario();
		         f3.setNome("jOÃO");
		         Funcionario f4 = new Funcionario();
		         f4.setNome("Teste");
		         Funcionario f5 = new Funcionario();
				
				// Colocando os funcionários numa lista
				List<Funcionario> funcionarios = new ArrayList<Funcionario>();
				funcionarios.add(f1);
				funcionarios.add(f2);
		   funcionarios.add(f3);
		     funcionarios.add(f4);
		     
				
				// Criando os blocos da segunda-feira
				// Estou criando 4 blocos pra segunda-feira, cada bloco começa no primeiro horário definido e termina no segundo
				// Observe que os blocos tem uma propriedade "funcionario", mas ela só será preenchida depois, na hora de gerar a escala.
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
				Escalador.criarEscala(escala, funcionarios);
				
				Exibicao.mostraEscala(escala);
	}
	public static void main(String[] args) {
		executar();
	}
}
