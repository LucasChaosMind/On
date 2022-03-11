package br.edu.utfpr.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.utfpr.database.ConnectDataBase;
import br.edu.utfpr.model.Livro;

public class LivroRepository {
	
	
	public void salvarLivro(Livro livro) throws SQLException {
		Connection con = ConnectDataBase.CreateConnection();
		
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO livro VALUES (?,?,?,?)"
				);
		ps.setString(1,livro.getNome());
		ps.setString(2,livro.getAutor());
		ps.setInt(3, livro.getNumeroPaginas());
		ps.setInt(4, livro.getAnoPublicacao());
		
		ps.executeUpdate();
	}
}
