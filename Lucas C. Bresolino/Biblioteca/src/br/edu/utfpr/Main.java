package br.edu.utfpr;

import br.edu.utfpr.model.Livro;
import br.edu.utfpr.service.LivroCrudService;

public class Main {

	public static void main(String[] args) {
		Livro livro = new Livro("The Beginning After The End","Turtle Me",2450,2018);
		
		LivroCrudService service = new LivroCrudService();
		
		service.salvarLivro(livro);
	}

}
