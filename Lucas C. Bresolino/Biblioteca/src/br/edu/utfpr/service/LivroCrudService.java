package br.edu.utfpr.service;

import java.sql.SQLException;

import br.edu.utfpr.model.Livro;
import br.edu.utfpr.repository.LivroRepository;

public class LivroCrudService {
	LivroRepository repository = new LivroRepository();
	
	public void salvarLivro(Livro livro) {
		try {
			repository.salvarLivro(livro);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
