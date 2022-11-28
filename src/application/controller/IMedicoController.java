package application.controller;
import java.sql.SQLException;
import application.model.Medico;

public interface IMedicoController {
    public void inserirMedico(Medico m) throws ClassNotFoundException, SQLException;
    public void atualizarMedico(Medico m) throws ClassNotFoundException, SQLException;
    public void excluirMedico(Medico m) throws ClassNotFoundException, SQLException;
    public void buscarMedico(Medico m) throws ClassNotFoundException, SQLException;
    public void buscarMedicos() throws ClassNotFoundException, SQLException;
}