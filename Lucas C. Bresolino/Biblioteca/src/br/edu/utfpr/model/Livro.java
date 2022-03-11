package br.edu.utfpr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Livro {
	
	private String nome;
	private String autor;
	private int numeroPaginas;
	private int anoPublicacao;
	
	
}
