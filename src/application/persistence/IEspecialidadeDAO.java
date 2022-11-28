package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Especialidade;

public interface IEspecialidadeDAO {
    public void insereEspecialidade(Especialidade e) throws SQLException;
    public void atualizaEspecialidade(Especialidade e) throws SQLException;
    public void excluiEspecialidade(Especialidade e) throws SQLException;
    public Especialidade consultaEspecialidade(Especialidade e) throws SQLException;
    public List<Especialidade> listaEspecialidade() throws SQLException;
}