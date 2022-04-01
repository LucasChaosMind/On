package br.edu.utfpr.repository;

import br.edu.utfpr.model.Avaliacao;
import br.edu.utfpr.model.Disciplina;
import br.edu.utfpr.statement.AvaliacaoStatement;
import br.edu.utfpr.statement.DisciplinaStatement;

public class AvaliacaoRepository extends RepositoryImpl<AvaliacaoStatement, Avaliacao>{

    @Override
    public AvaliacaoStatement getInstanceOfT() { return new AvaliacaoStatement(); }
}
