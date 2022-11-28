package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Consulta;

public interface IConsultaDAO {

    public void adicionaConsulta(Consulta co) throws SQLException;
    public void atualizaConsulta(Consulta co) throws SQLException;
    public void excluiConsulta(Consulta co) throws SQLException;
    public Consulta buscaConsulta(Consulta co) throws SQLException;
    public List<Consulta> buscaConsultas() throws SQLException;
}
