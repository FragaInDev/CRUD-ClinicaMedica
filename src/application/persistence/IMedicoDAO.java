package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Medico;

public interface IMedicoDAO {
    public void insereMedico(Medico m) throws SQLException;
    public void atualizaMedico(Medico m) throws SQLException;
    public void excluiMedico(Medico m) throws SQLException;
    public Medico consultaMedico(Medico m) throws SQLException;
    public List<Medico> listaMedico() throws SQLException;
}