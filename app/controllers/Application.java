package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
    	return ok(views.html.home.render());
    }
    public static Result teste() {
    	return ok(views.html.teste.render());
    }
  
   
}
