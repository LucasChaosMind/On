package br.edu.utfpr.statement;


import br.edu.utfpr.model.Avaliacao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class AvaliacaoStatement implements Statement<Avaliacao>{

    @Override
    public String sqlCreateTable() {
        return "" +
                "CREATE TABLE IF NOT EXISTS avaliacao (" +
                "id SERIAL PRIMARY KEY, " +
                "nota NUMERIC NOT NULL, " +
                "id_aluno INT8 NOT NULL, " +
                "id_disciplina INT8 NOT NULL );";
    }

    @Override
    public String sqlDropTable() {
        return "DROP TABLE IF EXISTS avaliacao";
    }

    @Override
    public PreparedStatement findAll(Connection conn) throws SQLException {
        return conn.prepareStatement(
                "SELECT * FROM avaliacao"
        );
    }

    @Override
    public PreparedStatement salvar(Connection conn, Avaliacao avaliacao) throws SQLException {
        PreparedStatement psSalvar = conn.prepareStatement(
                "INSERT INTO avaliacao(nota, id_aluno, id_disciplina) " +
                        "VALUES(?, ?, ?)", RETURN_GENERATED_KEYS
        );
        psSalvar.setDouble(1, avaliacao.getNota());
        psSalvar.setInt(2, avaliacao.getAluno().getId());
        psSalvar.setInt(3, avaliacao.getDisciplina().getId());
        return psSalvar;
    }

    @Override
    public Avaliacao convertResultToObject(ResultSet resultSet) throws SQLException {
        return Avaliacao.builder()
                .id(resultSet.getInt(1))
                .nota(resultSet.getDouble(2))
                .aluno.setId(resultSet.getInt(3))
                .idDisciplina(resultSet.getInt(4))
                .build();
    }

    @Override
    public List<Avaliacao> convertResultToObjectList(ResultSet resultSet) throws SQLException {
        List<Avaliacao> result = new ArrayList<>();
        while (resultSet.next()) {
            Avaliacao avaliacao = convertResultToObject(resultSet);
            result.add(avaliacao);
        };
        return result;
    }
}
