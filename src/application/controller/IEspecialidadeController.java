package application.controller;
import java.sql.SQLException;
import application.model.Especialidade;

public interface IEspecialidadeController {
    public void inserirEspecialidade(Especialidade e) throws ClassNotFoundException, SQLException;
    public void atualizarEspecialidade(Especialidade e) throws ClassNotFoundException, SQLException;
    public void excluirEspecialidade(Especialidade e) throws ClassNotFoundException, SQLException;
    public void buscarEspecialidade(Especialidade e) throws ClassNotFoundException, SQLException;
    public void buscarEspecialidades() throws ClassNotFoundException, SQLException;
}